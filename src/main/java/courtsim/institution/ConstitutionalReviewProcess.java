package courtsim.institution;

import courtsim.model.CaseFile;
import courtsim.model.CaseType;
import courtsim.model.Jurisdiction;
import courtsim.model.Justice;
import courtsim.model.LowerCourtPath;
import courtsim.model.PolicyDomain;
import courtsim.simulation.CompositionSnapshot;
import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public final class ConstitutionalReviewProcess implements ReviewProcess {
    private final DesignConfiguration configuration;
    private final WorldSpec worldSpec;
    private final List<Justice> court;
    private final double replacementPressure;

    public ConstitutionalReviewProcess(
            DesignConfiguration configuration,
            WorldSpec worldSpec,
            List<Justice> court,
            double replacementPressure
    ) {
        this.configuration = configuration;
        this.worldSpec = worldSpec;
        this.court = court;
        this.replacementPressure = replacementPressure;
    }

    public CompositionSnapshot compositionSnapshot(int reviewPeriod) {
        double median = medianIdeology();
        double min = court.stream().mapToDouble(Justice::ideology).min().orElse(0.0);
        double max = court.stream().mapToDouble(Justice::ideology).max().orElse(0.0);
        double size = Math.max(court.size(), 1);
        double replacementEvents = reviewPeriod == 0 ? 0.0 : replacementPressure * court.size();
        return new CompositionSnapshot(
                reviewPeriod,
                court.size(),
                median,
                max - min,
                court.stream().mapToDouble(Justice::partisanAttachment).sum() / size,
                court.stream().mapToDouble(Justice::rightsSensitivity).sum() / size,
                court.stream().mapToDouble(Justice::institutionalism).sum() / size,
                reviewPeriod == 0 ? 0.0 : replacementPressure,
                replacementEvents
        );
    }

    @Override
    public CaseOutcome review(CaseFile caseFile, ReviewContext context) {
        Random random = context.random();
        ReactionState reactionState = context.reactionState();
        boolean emergency = isEmergency(caseFile, random);
        boolean reviewed = shouldReview(caseFile, emergency, random);
        IntakeEstimate intake = intakeEstimate(caseFile, emergency, reviewed);
        int recused = recusedJustices(caseFile, random);
        int participating = configuration.substitutesRecusedJustices()
                ? configuration.courtSize()
                : Math.max(3, configuration.courtSize() - recused);

        if (!reviewed) {
            return declinedOutcome(caseFile, emergency, recused, participating, reactionState, intake, random);
        }

        VoteResult primary = vote(caseFile, activeJustices(participating), emergency, random, 0.0);
        boolean enBanc = false;
        VoteResult finalVote = primary;
        if (configuration.reviewStructure() == ReviewStructure.PANEL_EN_BANC) {
            VoteResult panel = vote(caseFile, panelJustices(participating, random), emergency, random, 0.03);
            boolean closePanel = Math.abs(panel.strikeVoteShare() - configuration.invalidationThreshold()) < 0.16;
            enBanc = closePanel || caseFile.constitutionalSalience() > 0.64 || caseFile.lowerCourtConflict() > 0.62;
            finalVote = enBanc ? primary : panel;
        }

        boolean crossChecked = false;
        boolean councilScreen = configuration.reviewStructure() == ReviewStructure.CONSTITUTIONAL_COUNCIL;
        boolean meritsEligibleInvalidation = finalVote.invalidates();
        double crossCheckConflict = 0.0;
        if (configuration.reviewStructure() == ReviewStructure.DUAL_SUPREME_COURTS
                || configuration.reviewStructure() == ReviewStructure.CROSS_CHECKING_COURTS) {
            crossChecked = true;
            VoteResult secondary = vote(caseFile, mirroredCourt(participating), emergency, random, -0.03);
            crossCheckConflict = Math.abs(finalVote.strikeVoteShare() - secondary.strikeVoteShare());
            meritsEligibleInvalidation = finalVote.invalidates() && secondary.invalidates();
            finalVote = new VoteResult(
                    (finalVote.strikeVoteShare() + secondary.strikeVoteShare()) / 2.0,
                    meritsEligibleInvalidation
            );
        }

        if (configuration.reviewStructure() == ReviewStructure.CONSTITUTIONAL_COUNCIL) {
            meritsEligibleInvalidation = finalVote.invalidates() && (caseFile.rightsThreat() > 0.40 || caseFile.constitutionalSalience() > 0.56);
        }

        boolean meritsReview = meritsReview(emergency, caseFile);
        boolean emergencyReliefGranted = emergencyReliefGranted(caseFile, emergency, finalVote, random);
        boolean meritsInvalidated = meritsReview && meritsEligibleInvalidation;
        boolean overrideUsed = overrideUsed(caseFile, meritsInvalidated, random);
        boolean lawEffective = (!meritsInvalidated || overrideUsed) && !(emergencyReliefGranted && !meritsReview);
        double majorityShare = meritsInvalidated || emergencyReliefGranted
                ? finalVote.strikeVoteShare()
                : 1.0 - finalVote.strikeVoteShare();
        double dissentIntensity = Values.clamp01(1.0 - (Math.abs(finalVote.strikeVoteShare() - 0.5) * 2.0));
        double concurrenceFragmentation = Values.clamp01(
                majorityShare
                        * (1.0 - configuration.coalitionNorm())
                        * (0.45 * caseFile.legalAmbiguity() + 0.35 * caseFile.constitutionalSalience() + 0.20 * worldSpec.partisanPressure())
        );
        double reversalMagnitude = meritsInvalidated
                ? Values.clamp01(caseFile.constitutionalSalience() * (councilScreen ? 0.42 : 1.0))
                : emergencyReliefGranted
                ? Values.clamp01(caseFile.constitutionalSalience() * 0.34)
                : 0.0;
        double partisanAlignment = partisanAlignment(caseFile, finalVote.strikeVoteShare(), meritsInvalidated || emergencyReliefGranted);
        double shadowAbuse = shadowDocketAbuse(caseFile, emergency, meritsReview, emergencyReliefGranted, meritsInvalidated);
        String emergencyApplicantType = emergencyApplicantType(caseFile, emergency);
        boolean governmentEmergencyApplicant = emergency && isGovernmentApplicant(emergencyApplicantType);
        boolean governmentEmergencyWin = governmentEmergencyApplicant && emergencyReliefGranted;
        boolean reasonsGiven = !emergency || random.nextDouble() < emergencyReasonsProbability(caseFile, emergencyReliefGranted, meritsReview);
        boolean voteDisclosed = !emergency || random.nextDouble() < emergencyVoteDisclosureProbability(caseFile, emergencyReliefGranted, reasonsGiven);
        boolean publicDisagreement = emergency && random.nextDouble() < publicDisagreementProbability(caseFile, dissentIntensity, shadowAbuse, reasonsGiven);
        boolean meritsFollowUp = emergency && meritsReview;
        double rightsProtection = rightsProtection(caseFile, meritsInvalidated, emergencyReliefGranted, overrideUsed);
        double constitutionalConflict = constitutionalConflict(caseFile, meritsInvalidated, emergencyReliefGranted, overrideUsed, shadowAbuse, crossCheckConflict);
        double democraticResponsiveness = democraticResponsiveness(caseFile, meritsInvalidated, emergencyReliefGranted, overrideUsed);
        double independenceBalance = independenceAccountabilityBalance(caseFile);
        double legalStability = Values.clamp01(
                1.0
                        - reversalMagnitude * 0.32
                        - constitutionalConflict * 0.28
                        - shadowAbuse * 0.22
                        - dissentIntensity * 0.08
                        - concurrenceFragmentation * 0.06
                        + configuration.stabilityPreference() * 0.12
        );
        double legitimacy = Values.clamp01(
                caseFile.publicTrust() * 0.24
                        + reactionState.publicTrust() * 0.12
                        + configuration.transparency() * 0.18
                        + majorityShare * 0.12
                        + rightsProtection * 0.18
                        + Values.lowerIsBetter(partisanAlignment) * 0.14
                        + Values.lowerIsBetter(shadowAbuse) * 0.14
                        - constitutionalConflict * 0.18
        );
        double complianceRate = complianceRate(
                caseFile,
                legitimacy,
                constitutionalConflict,
                meritsInvalidated,
                emergencyReliefGranted,
                overrideUsed,
                reactionState
        );
        boolean complied = random.nextDouble() < complianceRate;
        boolean defied = !complied && random.nextDouble() < defianceRisk(caseFile, constitutionalConflict, reactionState);
        boolean workaround = !complied && !defied && random.nextDouble() < workaroundRisk(caseFile, meritsInvalidated, emergencyReliefGranted, reactionState);
        boolean repeatedLitigation = (!complied || workaround)
                && random.nextDouble() < repeatedLitigationRisk(caseFile, meritsInvalidated, emergencyReliefGranted);
        boolean executiveImplementation = random.nextDouble() < executiveImplementationRate(
                caseFile,
                complianceRate,
                legitimacy,
                constitutionalConflict,
                reactionState
        );
        boolean agencyNonacquiescence = !executiveImplementation
                && random.nextDouble() < agencyNonacquiescenceRisk(caseFile, meritsInvalidated, emergencyReliefGranted, reactionState);
        boolean legislativeReenactment = workaround
                && random.nextDouble() < legislativeReenactmentRisk(caseFile, meritsInvalidated, overrideUsed, reactionState);
        boolean localGovernmentCompliance = random.nextDouble() < localGovernmentComplianceRate(
                caseFile,
                complianceRate,
                constitutionalConflict,
                reactionState
        );
        reactionState.apply(
                legitimacy,
                constitutionalConflict,
                meritsInvalidated,
                emergencyReliefGranted,
                overrideUsed,
                complied,
                defied,
                workaround,
                repeatedLitigation,
                agencyNonacquiescence,
                legislativeReenactment
        );
        double administrativeLoad = administrativeLoad(caseFile, emergency, enBanc, crossChecked, councilScreen, recused);
        CostEstimate institutionalCosts = institutionalCosts(caseFile, emergency, enBanc, crossChecked, councilScreen, recused, administrativeLoad, intake);

        return new CaseOutcome(
                caseFile,
                true,
                emergency,
                emergencyReliefGranted,
                meritsReview,
                meritsInvalidated,
                meritsInvalidated,
                lawEffective,
                intake.intakeFilings(),
                intake.screenedFilings(),
                intake.acceptanceRate(),
                reasonsGiven,
                voteDisclosed,
                publicDisagreement,
                emergencyApplicantType,
                governmentEmergencyApplicant,
                governmentEmergencyWin,
                meritsFollowUp,
                enBanc,
                crossChecked,
                councilScreen,
                overrideUsed,
                recused,
                participating,
                finalVote.strikeVoteShare(),
                majorityShare,
                legalStability,
                rightsProtection,
                partisanAlignment,
                shadowAbuse,
                legitimacy,
                reversalMagnitude,
                constitutionalConflict,
                democraticResponsiveness,
                independenceBalance,
                complianceRate,
                complied,
                defied,
                workaround,
                repeatedLitigation,
                executiveImplementation,
                agencyNonacquiescence,
                legislativeReenactment,
                localGovernmentCompliance,
                reactionState.publicTrust(),
                reactionState.legislativeConflict(),
                reactionState.courtCurbingPressure(),
                reactionState.amendmentPressure(),
                concurrenceFragmentation,
                dissentIntensity,
                caseFile.reviewPeriod() == 0 ? 0.0 : replacementPressure,
                administrativeLoad,
                institutionalCosts.directCourt(),
                institutionalCosts.upstreamScreening(),
                institutionalCosts.capacityStrain(),
                institutionalCosts.budget(),
                institutionalCosts.delay(),
                institutionalCosts.complexity(),
                institutionalCosts.total()
        );
    }

    private boolean isEmergency(CaseFile caseFile, Random random) {
        double pressure = caseFile.urgency() * 0.72 + worldSpec.emergencyPressure() * 0.28;
        double threshold = switch (configuration.docketProcedure()) {
            case FAST_SHADOW_DOCKET -> 0.46;
            case REASONED_EMERGENCY_PANEL -> 0.55;
            case FULL_COURT_EMERGENCY -> 0.60;
            case MERITS_FOLLOW_UP -> 0.58;
        };
        return caseFile.type() == CaseType.EMERGENCY || pressure + random.nextDouble() * 0.18 > threshold;
    }

    private boolean shouldReview(CaseFile caseFile, boolean emergency, Random random) {
        double structuralAccess = switch (configuration.reviewStructure()) {
            case FULL_COURT -> 0.25;
            case PANEL_EN_BANC -> 0.35;
            case DUAL_SUPREME_COURTS -> 0.30;
            case CROSS_CHECKING_COURTS -> 0.34;
            case CONSTITUTIONAL_COUNCIL -> 0.48;
        };
        double reviewScore = structuralAccess
                + caseFile.rightsThreat() * 0.26
                + caseFile.constitutionalSalience() * 0.22
                + caseFile.lowerCourtConflict() * 0.16
                + caseFile.certiorariPressure() * 0.22
                + Math.abs(caseFile.lowerCourtPanelSkew()) * 0.08
                + caseFile.stateFederalTension() * 0.08
                + caseFile.intercourtConflict() * 0.12
                + caseFile.lowerCourtPath().certiorariBoost() * 0.30
                + (emergency ? 0.18 : 0.0)
                - caseFile.legalAmbiguity() * 0.05;
        return reviewScore * caseFile.jurisdiction().reviewAccessWeight() + random.nextDouble() * 0.24 > 0.48;
    }

    private IntakeEstimate intakeEstimate(CaseFile caseFile, boolean emergency, boolean reviewed) {
        double acceptance = configuration.baseIntakeAcceptanceRate()
                * (0.64
                + caseFile.certiorariPressure() * 0.52
                + caseFile.constitutionalSalience() * 0.34
                + caseFile.lowerCourtConflict() * 0.24
                + caseFile.stateFederalTension() * 0.10
                + caseFile.intercourtConflict() * 0.12
                + (emergency ? 0.55 : 0.0)
                + (configuration.preEnactmentReview() ? 0.34 : 0.0));
        if (configuration.docketControl() == DocketControl.MANDATORY_WITH_FILTERS) {
            acceptance *= 1.55;
        }
        if (configuration.docketControl() == DocketControl.COMPLAINT_ADMISSIBILITY) {
            acceptance *= 0.76 + caseFile.rightsThreat() * 0.28;
        }
        acceptance = Values.clamp(acceptance, 0.003, 0.82);
        int representedFilings = Math.max(1, (int) Math.round(1.0 / acceptance));
        int pressureFilings = (int) Math.round(
                representedFilings
                        * (1.0
                        + caseFile.legalAmbiguity() * 0.20
                        + caseFile.lowerCourtConflict() * 0.18
                        + (emergency ? 0.24 : 0.0)
                        + configuration.intakeScreeningIntensity() * 0.18)
        );
        int intakeFilings = Math.max(1, pressureFilings);
        int acceptedFilings = reviewed ? 1 : 0;
        int screenedFilings = Math.max(0, intakeFilings - acceptedFilings);
        return new IntakeEstimate(intakeFilings, screenedFilings, Values.ratio(acceptedFilings, intakeFilings));
    }

    private String emergencyApplicantType(CaseFile caseFile, boolean emergency) {
        if (!emergency) {
            return "not-emergency";
        }
        PolicyDomain domain = caseFile.policyDomain();
        if (domain == PolicyDomain.ADMINISTRATION || domain == PolicyDomain.EMERGENCY_SECURITY) {
            return caseFile.executivePressure() > 0.45 ? "federal-government" : "agency";
        }
        if (domain == PolicyDomain.FEDERALISM || domain == PolicyDomain.ELECTIONS
                || caseFile.jurisdiction() == Jurisdiction.STATE
                || caseFile.jurisdiction() == Jurisdiction.MIXED_STATE_FEDERAL) {
            return "state-government";
        }
        if (domain == PolicyDomain.CRIMINAL_JUSTICE) {
            return "criminal-defendant";
        }
        if (domain == PolicyDomain.ECONOMIC_REGULATION) {
            return caseFile.publicSupport() > 0.58 ? "federal-government" : "regulated-party";
        }
        return "private-party";
    }

    private boolean isGovernmentApplicant(String applicantType) {
        return applicantType.contains("government") || applicantType.equals("agency");
    }

    private double emergencyReasonsProbability(CaseFile caseFile, boolean emergencyReliefGranted, boolean meritsReview) {
        return Values.clamp01(
                configuration.emergencyReasonGiving() * 0.62
                        + configuration.transparency() * 0.18
                        + (meritsReview ? 0.12 : 0.0)
                        + (emergencyReliefGranted ? caseFile.constitutionalSalience() * 0.08 : 0.03)
                        - (configuration.docketProcedure() == DocketProcedure.FAST_SHADOW_DOCKET ? 0.18 : 0.0)
        );
    }

    private double emergencyVoteDisclosureProbability(CaseFile caseFile, boolean emergencyReliefGranted, boolean reasonsGiven) {
        return Values.clamp01(
                configuration.transparency() * 0.52
                        + configuration.coalitionNorm() * 0.14
                        + (reasonsGiven ? 0.14 : 0.0)
                        + (emergencyReliefGranted ? 0.08 : 0.0)
                        + caseFile.constitutionalSalience() * 0.08
        );
    }

    private double publicDisagreementProbability(
            CaseFile caseFile,
            double dissentIntensity,
            double shadowAbuse,
            boolean reasonsGiven
    ) {
        return Values.clamp01(
                shadowAbuse * 0.42
                        + dissentIntensity * 0.32
                        + caseFile.constitutionalSalience() * 0.18
                        + caseFile.executivePressure() * 0.08
                        - (reasonsGiven ? 0.12 : 0.0)
        );
    }

    private int recusedJustices(CaseFile caseFile, Random random) {
        int recused = 0;
        double pressure = caseFile.conflictOfInterestRisk() * configuration.recusalMultiplier();
        for (Justice justice : court) {
            if (random.nextDouble() < pressure * justice.recusalStrictness() * 0.35) {
                recused++;
            }
        }
        int maxRecusals = Math.max(0, configuration.courtSize() - 3);
        return Math.min(recused, maxRecusals);
    }

    private List<Justice> activeJustices(int participating) {
        if (participating >= court.size()) {
            return court;
        }
        int trim = court.size() - participating;
        int leftTrim = trim / 2;
        return court.subList(leftTrim, leftTrim + participating);
    }

    private List<Justice> panelJustices(int participating, Random random) {
        List<Justice> active = new ArrayList<>(activeJustices(participating));
        active.sort(Comparator.comparingDouble(justice -> random.nextDouble()));
        int panelSize = Math.min(active.size(), Math.max(3, Math.min(5, participating / 2)));
        return active.subList(0, panelSize);
    }

    private List<Justice> mirroredCourt(int participating) {
        List<Justice> mirrored = new ArrayList<>();
        for (Justice justice : activeJustices(participating)) {
            mirrored.add(new Justice(
                    justice.id() + "x",
                    -justice.ideology() * 0.72,
                    justice.partisanAttachment() * 0.82,
                    Values.clamp01(justice.rightsSensitivity() + 0.04),
                    Values.clamp01(justice.institutionalism() + 0.08),
                    justice.accountabilityPressure(),
                    Values.clamp01(justice.legitimacyConcern() + 0.05),
                    justice.recusalStrictness()
            ));
        }
        return mirrored;
    }

    private VoteResult vote(CaseFile caseFile, List<Justice> justices, boolean emergency, Random random, double institutionalOffset) {
        if (justices.isEmpty()) {
            return new VoteResult(0.0, false);
        }
        int strikeVotes = 0;
        for (Justice justice : justices) {
            double ideologicalOpposition = Math.max(0.0, -caseFile.policyPosition() * justice.ideology());
            double partisanPressure = ideologicalOpposition
                    * justice.partisanAttachment()
                    * worldSpec.partisanPressure()
                    * (1.0 - configuration.coalitionNorm() * 0.38);
            double rightsScore = caseFile.rightsThreat()
                    * caseFile.doctrineArea().rightsWeight()
                    * justice.rightsSensitivity()
                    * (0.62 + configuration.rightsPriority() * 0.48);
            double salienceScore = caseFile.constitutionalSalience() * 0.20
                    + caseFile.lowerCourtConflict() * 0.14
                    + caseFile.certiorariPressure() * 0.08
                    + caseFile.stateFederalTension() * 0.06
                    + caseFile.intercourtConflict() * 0.08;
            double mandateRestraint = caseFile.legislativeMandate()
                    * caseFile.doctrineArea().deferenceWeight()
                    * (configuration.accountabilityPressure() * 0.24 + justice.accountabilityPressure() * 0.18)
                    * (1.0 + worldSpec.legislativeConflict() * 0.18)
                    * (caseFile.jurisdiction() == Jurisdiction.STATE ? 1.08 : 1.0);
            double ambiguityRestraint = caseFile.legalAmbiguity()
                    * justice.institutionalism()
                    * (0.20 + configuration.stabilityPreference() * 0.14);
            double lowerCourtSignal = caseFile.lowerCourtGovernmentWin()
                    ? caseFile.rightsThreat() * 0.07
                    : -caseFile.legislativeMandate() * 0.05;
            lowerCourtSignal += caseFile.intercourtConflict() * 0.04
                    + (caseFile.lowerCourtPath() == LowerCourtPath.STATE_FEDERAL_SPLIT ? caseFile.rightsThreat() * 0.035 : 0.0);
            double emergencyShortcut = emergency && configuration.docketProcedure() == DocketProcedure.FAST_SHADOW_DOCKET
                    ? caseFile.executivePressure() * 0.14
                    : 0.0;
            double score = rightsScore
                    + salienceScore
                    + partisanPressure
                    + lowerCourtSignal
                    + emergencyShortcut
                    + institutionalOffset
                    - mandateRestraint
                    - ambiguityRestraint
                    + random.nextGaussian() * 0.10;
            if (score > 0.50) {
                strikeVotes++;
            }
        }
        double share = (double) strikeVotes / justices.size();
        return new VoteResult(share, share >= configuration.invalidationThreshold());
    }

    private boolean overrideUsed(CaseFile caseFile, boolean invalidated, Random random) {
        if (!invalidated || configuration.overrideRule() == LegislativeOverrideRule.NONE) {
            return false;
        }
        double base = switch (configuration.overrideRule()) {
            case NONE -> 0.0;
            case SUPERMAJORITY_OVERRIDE -> 0.18;
            case DELAYED_MAJORITY_OVERRIDE -> 0.32;
            case REFERENDUM_OVERRIDE -> 0.25 + caseFile.publicSupport() * 0.22;
        };
        double overrideScore = base
                + caseFile.legislativeMandate() * 0.34
                + worldSpec.legislativeConflict() * 0.10
                - caseFile.rightsThreat() * 0.22
                - configuration.independence() * 0.08;
        return overrideScore + random.nextDouble() * 0.18 > 0.55;
    }

    private boolean meritsReview(boolean emergency, CaseFile caseFile) {
        if (!emergency) {
            return true;
        }
        return switch (configuration.docketProcedure()) {
            case FAST_SHADOW_DOCKET -> false;
            case REASONED_EMERGENCY_PANEL -> caseFile.constitutionalSalience() > 0.60;
            case FULL_COURT_EMERGENCY, MERITS_FOLLOW_UP -> true;
        };
    }

    private boolean emergencyReliefGranted(CaseFile caseFile, boolean emergency, VoteResult vote, Random random) {
        if (!emergency) {
            return false;
        }
        double threshold = switch (configuration.docketProcedure()) {
            case FAST_SHADOW_DOCKET -> 0.44;
            case REASONED_EMERGENCY_PANEL -> 0.50;
            case FULL_COURT_EMERGENCY -> 0.54;
            case MERITS_FOLLOW_UP -> 0.55;
        };
        double reliefScore = vote.strikeVoteShare()
                + caseFile.urgency() * 0.14
                + caseFile.rightsThreat() * 0.08
                + caseFile.executivePressure() * 0.05
                - configuration.emergencyReasonGiving() * 0.04
                + random.nextGaussian() * 0.035;
        return reliefScore >= threshold;
    }

    private CaseOutcome declinedOutcome(
            CaseFile caseFile,
            boolean emergency,
            int recused,
            int participating,
            ReactionState reactionState,
            IntakeEstimate intake,
            Random random
    ) {
        double rightsProtection = Values.clamp01(1.0 - caseFile.rightsThreat() * 0.78);
        double democraticResponsiveness = Values.clamp01(caseFile.legislativeMandate() * 0.72 + caseFile.publicSupport() * 0.18);
        double constitutionalConflict = Values.clamp01(
                caseFile.rightsThreat() * caseFile.constitutionalSalience() * 0.42
                        + caseFile.lowerCourtConflict() * 0.16
                        + caseFile.stateFederalTension() * 0.10
                        + caseFile.intercourtConflict() * 0.08
                        + (emergency ? caseFile.urgency() * 0.10 : 0.0)
        );
        double legitimacy = Values.clamp01(
                caseFile.publicTrust() * 0.42
                        + democraticResponsiveness * 0.22
                        + rightsProtection * 0.16
                        - constitutionalConflict * 0.16
        );
        reactionState.apply(
                legitimacy,
                constitutionalConflict,
                false,
                false,
                false,
                true,
                false,
                false,
                false,
                false,
                false
        );
        double legalStability = Values.clamp01(0.82 - constitutionalConflict * 0.20 + configuration.stabilityPreference() * 0.10);
        double administrativeLoad = 0.08 + (emergency ? 0.06 : 0.0);
        CostEstimate institutionalCosts = institutionalCosts(caseFile, emergency, false, false, false, recused, administrativeLoad, intake);
        String emergencyApplicantType = emergencyApplicantType(caseFile, emergency);
        boolean governmentEmergencyApplicant = emergency && isGovernmentApplicant(emergencyApplicantType);
        boolean reasonsGiven = !emergency || random.nextDouble() < emergencyReasonsProbability(caseFile, false, false) * 0.55;
        boolean voteDisclosed = !emergency || random.nextDouble() < emergencyVoteDisclosureProbability(caseFile, false, reasonsGiven) * 0.40;
        boolean publicDisagreement = emergency && random.nextDouble() < publicDisagreementProbability(
                caseFile,
                0.0,
                shadowDocketAbuse(caseFile, true, false, false, false) * 0.45,
                reasonsGiven
        );
        return new CaseOutcome(
                caseFile,
                false,
                emergency,
                false,
                false,
                false,
                false,
                true,
                intake.intakeFilings(),
                intake.screenedFilings(),
                intake.acceptanceRate(),
                reasonsGiven,
                voteDisclosed,
                publicDisagreement,
                emergencyApplicantType,
                governmentEmergencyApplicant,
                false,
                false,
                false,
                false,
                false,
                false,
                recused,
                participating,
                0.0,
                1.0,
                legalStability,
                rightsProtection,
                0.0,
                emergency ? shadowDocketAbuse(caseFile, true, false, false, false) * 0.45 : 0.0,
                legitimacy,
                0.0,
                constitutionalConflict,
                democraticResponsiveness,
                independenceAccountabilityBalance(caseFile),
                1.0,
                true,
                false,
                false,
                false,
                true,
                false,
                false,
                true,
                reactionState.publicTrust(),
                reactionState.legislativeConflict(),
                reactionState.courtCurbingPressure(),
                reactionState.amendmentPressure(),
                0.0,
                0.0,
                caseFile.reviewPeriod() == 0 ? 0.0 : replacementPressure,
                administrativeLoad,
                institutionalCosts.directCourt(),
                institutionalCosts.upstreamScreening(),
                institutionalCosts.capacityStrain(),
                institutionalCosts.budget(),
                institutionalCosts.delay(),
                institutionalCosts.complexity(),
                institutionalCosts.total()
        );
    }

    private double partisanAlignment(CaseFile caseFile, double strikeShare, boolean invalidated) {
        double rightsJustifiedStrike = caseFile.rightsThreat();
        double partisanGap = Math.max(0.0, strikeShare - rightsJustifiedStrike);
        double lawPolarity = Math.abs(caseFile.policyPosition());
        double decisionBoost = invalidated ? 0.12 : 0.02;
        return Values.clamp01(
                partisanGap * lawPolarity * 0.70
                        + caseFile.executivePressure() * 0.15
                        + worldSpec.partisanPressure() * (1.0 - configuration.coalitionNorm()) * 0.18
                        + decisionBoost * lawPolarity
        );
    }

    private double shadowDocketAbuse(
            CaseFile caseFile,
            boolean emergency,
            boolean meritsReview,
            boolean emergencyReliefGranted,
            boolean meritsInvalidated
    ) {
        if (!emergency) {
            return 0.0;
        }
        double procedureRisk = switch (configuration.docketProcedure()) {
            case FAST_SHADOW_DOCKET -> 0.72;
            case REASONED_EMERGENCY_PANEL -> 0.34;
            case FULL_COURT_EMERGENCY -> 0.20;
            case MERITS_FOLLOW_UP -> 0.16;
        };
        double meritsPenalty = meritsReview ? 0.0 : 0.26;
        double reliefPenalty = emergencyReliefGranted && !meritsReview ? 0.18 : 0.0;
        double impact = meritsInvalidated || emergencyReliefGranted
                ? caseFile.constitutionalSalience() * 0.22
                : caseFile.rightsThreat() * 0.12;
        return Values.clamp01(
                procedureRisk * caseFile.urgency()
                        + meritsPenalty
                        + reliefPenalty
                        + impact
                        + caseFile.executivePressure() * 0.12
                        - configuration.emergencyReasonGiving() * 0.22
        );
    }

    private double rightsProtection(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            boolean overrideUsed
    ) {
        double score;
        if (meritsInvalidated) {
            score = 0.44 + caseFile.rightsThreat() * 0.54 - caseFile.legalAmbiguity() * 0.08;
        } else if (emergencyReliefGranted) {
            score = 0.38 + caseFile.rightsThreat() * 0.40 - caseFile.timeToReview() * 0.08;
        } else {
            score = 1.0 - caseFile.rightsThreat() * 0.72 + caseFile.legislativeMandate() * 0.06 - caseFile.timeToReview() * caseFile.rightsThreat() * 0.08;
        }
        if (overrideUsed && caseFile.rightsThreat() > 0.55) {
            score -= 0.24 + caseFile.rightsThreat() * 0.14;
        }
        return Values.clamp01(score);
    }

    private double constitutionalConflict(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            boolean overrideUsed,
            double shadowAbuse,
            double crossCheckConflict
    ) {
        double countermajoritarianClash = meritsInvalidated
                ? caseFile.legislativeMandate() * (0.22 + worldSpec.legislativeConflict() * 0.24)
                : emergencyReliefGranted
                ? caseFile.legislativeMandate() * 0.18
                : caseFile.rightsThreat() * caseFile.constitutionalSalience() * 0.18;
        return Values.clamp01(
                countermajoritarianClash
                        + (overrideUsed ? 0.36 : 0.0)
                        + shadowAbuse * 0.30
                        + crossCheckConflict * 0.24
                        + caseFile.executivePressure() * 0.10
                        + Math.abs(caseFile.lowerCourtPanelSkew()) * 0.05
                        + caseFile.stateFederalTension() * 0.12
                        + caseFile.intercourtConflict() * 0.10
        );
    }

    private double democraticResponsiveness(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            boolean overrideUsed
    ) {
        if (overrideUsed) {
            return Values.clamp01(0.48
                    + caseFile.legislativeMandate() * 0.34
                    - caseFile.rightsThreat() * 0.18
                    - caseFile.stateFederalTension() * 0.04);
        }
        if (meritsInvalidated) {
            return Values.clamp01(
                    (1.0 - caseFile.legislativeMandate()) * 0.26
                            + caseFile.rightsThreat() * 0.44
                            + caseFile.publicSupport() * 0.10
                            - stateDeferencePenalty(caseFile)
            );
        }
        if (emergencyReliefGranted) {
            return Values.clamp01(
                    (1.0 - caseFile.legislativeMandate()) * 0.16
                            + caseFile.rightsThreat() * 0.30
                            + caseFile.publicSupport() * 0.08
                            - stateDeferencePenalty(caseFile) * 0.55
            );
        }
        return Values.clamp01(
                caseFile.legislativeMandate() * 0.56
                        + caseFile.publicSupport() * 0.22
                        + (1.0 - caseFile.rightsThreat()) * 0.16
                        + (caseFile.jurisdiction() == Jurisdiction.STATE ? 0.04 : 0.0)
        );
    }

    private double independenceAccountabilityBalance(CaseFile caseFile) {
        double desiredIndependence = Values.clamp01(
                0.42
                        + caseFile.rightsThreat() * 0.32
                        + caseFile.constitutionalSalience() * 0.10
                        - caseFile.legislativeMandate() * 0.16
                        + caseFile.certiorariPressure() * 0.08
        );
        double desiredAccountability = 1.0 - desiredIndependence;
        return Values.clamp01(
                1.0
                        - Math.abs(configuration.independence() - desiredIndependence) * 0.62
                        - Math.abs(configuration.accountabilityPressure() - desiredAccountability) * 0.34
        );
    }

    private double administrativeLoad(
            CaseFile caseFile,
            boolean emergency,
            boolean enBanc,
            boolean crossChecked,
            boolean councilScreen,
            int recused
    ) {
        double structureCost = switch (configuration.reviewStructure()) {
            case FULL_COURT -> 0.20;
            case PANEL_EN_BANC -> 0.24 + (enBanc ? 0.20 : 0.0);
            case DUAL_SUPREME_COURTS -> 0.48;
            case CROSS_CHECKING_COURTS -> 0.42;
            case CONSTITUTIONAL_COUNCIL -> 0.34;
        };
        return Values.clamp01(
                structureCost
                        + (emergency ? 0.10 : 0.0)
                        + (crossChecked ? 0.16 : 0.0)
                        + (councilScreen ? 0.10 : 0.0)
                        + recused * 0.018
                        + caseFile.legalAmbiguity() * 0.12
                        + caseFile.timeToReview() * 0.08
                        + caseFile.lowerCourtPath().depth() * 0.025
                        + caseFile.stateFederalTension() * 0.06
                        + caseFile.intercourtConflict() * 0.05
                        + (caseFile.reviewPeriod() == 0 ? 0.0 : replacementPressure * 0.05)
        );
    }

    private CostEstimate institutionalCosts(
            CaseFile caseFile,
            boolean emergency,
            boolean enBanc,
            boolean crossChecked,
            boolean councilScreen,
            int recused,
            double administrativeLoad,
            IntakeEstimate intake
    ) {
        double sizeCost = Values.clamp01(0.10 + Math.max(0, configuration.courtSize() - 9) * 0.028);
        double structureBudget = switch (configuration.reviewStructure()) {
            case FULL_COURT -> 0.08;
            case PANEL_EN_BANC -> 0.20 + (enBanc ? 0.08 : 0.0);
            case DUAL_SUPREME_COURTS -> 0.46;
            case CROSS_CHECKING_COURTS -> 0.40;
            case CONSTITUTIONAL_COUNCIL -> 0.34;
        };
        double stylizedBudget = Values.clamp01(
                sizeCost
                        + structureBudget
                        + (configuration.substitutesRecusedJustices() ? 0.08 : 0.0)
                        + recused * 0.012
                        + (caseFile.reviewPeriod() == 0 ? 0.0 : replacementPressure * 0.08)
        );

        double structureDelay = switch (configuration.reviewStructure()) {
            case FULL_COURT -> 0.08;
            case PANEL_EN_BANC -> 0.14 + (enBanc ? 0.18 : 0.0);
            case DUAL_SUPREME_COURTS -> 0.30;
            case CROSS_CHECKING_COURTS -> 0.26;
            case CONSTITUTIONAL_COUNCIL -> 0.20;
        };
        double stylizedDelay = Values.clamp01(
                caseFile.timeToReview() * 0.42
                        + caseFile.lowerCourtPath().delayWeight() * 0.10
                        + caseFile.lowerCourtPath().depth() * 0.035
                        + structureDelay
                        + (crossChecked ? 0.14 : 0.0)
                        + (councilScreen ? 0.06 : 0.0)
                        - (emergency ? 0.08 : 0.0)
        );

        double thresholdComplexity = switch (configuration.votingThreshold()) {
            case SIMPLE_MAJORITY -> 0.06;
            case SUPERMAJORITY_TO_INVALIDATE -> 0.18;
            case CONCURRENT_MAJORITY -> 0.24;
            case HIGH_CONSTITUTIONAL_THRESHOLD -> 0.20;
        };
        double overrideComplexity = switch (configuration.overrideRule()) {
            case NONE -> 0.00;
            case SUPERMAJORITY_OVERRIDE -> 0.14;
            case DELAYED_MAJORITY_OVERRIDE -> 0.18;
            case REFERENDUM_OVERRIDE -> 0.24;
        };
        double procedureComplexity = switch (configuration.docketProcedure()) {
            case FAST_SHADOW_DOCKET -> 0.08;
            case REASONED_EMERGENCY_PANEL -> 0.14;
            case FULL_COURT_EMERGENCY -> 0.20;
            case MERITS_FOLLOW_UP -> 0.24;
        };
        double stylizedComplexity = Values.clamp01(
                administrativeLoad * 0.34
                        + thresholdComplexity
                        + overrideComplexity
                        + procedureComplexity
                        + (configuration.recusalRule() == RecusalRule.STRICT_TRANSPARENCY ? 0.08 : 0.0)
                        + (configuration.recusalRule() == RecusalRule.RANDOM_SUBSTITUTION ? 0.10 : 0.0)
                        + caseFile.legalAmbiguity() * 0.08
        );
        double directCourt = Values.clamp01(
                configuration.benchmarkedDirectCourtCost() * 0.62
                        + stylizedBudget * 0.30
                        + administrativeLoad * 0.08
        );
        double intakePressure = Values.clamp01(Math.log1p(intake.intakeFilings()) / Math.log(140.0));
        double upstreamScreening = Values.clamp01(
                configuration.intakeScreeningIntensity() * 0.38
                        + intakePressure * 0.30
                        + caseFile.lowerCourtPath().depth() * 0.035
                        + caseFile.lowerCourtConflict() * 0.10
                        + caseFile.intercourtConflict() * 0.08
                        + (configuration.preEnactmentReview() ? -0.08 : 0.0)
        );
        double capacityStrain = Values.clamp01(
                configuration.benchmarkedCapacityStrain() * 0.48
                        + intakePressure * 0.20
                        + administrativeLoad * 0.18
                        + (emergency ? 0.06 : 0.0)
                        + (crossChecked ? 0.08 : 0.0)
                        + (caseFile.reviewPeriod() == 0 ? 0.0 : replacementPressure * 0.08)
        );
        double budget = Values.clamp01(directCourt * 0.68 + upstreamScreening * 0.22 + stylizedBudget * 0.10);
        double delay = Values.clamp01(
                configuration.benchmarkedDelayCost() * 0.45
                        + stylizedDelay * 0.34
                        + upstreamScreening * 0.10
                        + capacityStrain * 0.11
        );
        double complexity = Values.clamp01(
                configuration.benchmarkedComplexityCost() * 0.42
                        + stylizedComplexity * 0.34
                        + upstreamScreening * 0.14
                        + capacityStrain * 0.10
        );
        double total = Values.clamp01(directCourt * 0.25 + upstreamScreening * 0.20 + capacityStrain * 0.20 + delay * 0.18 + complexity * 0.17);
        return new CostEstimate(directCourt, upstreamScreening, capacityStrain, budget, delay, complexity, total);
    }

    private double complianceRate(
            CaseFile caseFile,
            double legitimacy,
            double constitutionalConflict,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            boolean overrideUsed,
            ReactionState reactionState
    ) {
        double compliancePressure = 0.46
                + legitimacy * 0.24
                + reactionState.complianceNorm() * 0.22
                + configuration.independence() * 0.06
                - constitutionalConflict * 0.18
                - reactionState.legislativeConflict() * 0.12
                - reactionState.courtCurbingPressure() * 0.10
                - caseFile.stateFederalTension() * 0.04
                - caseFile.intercourtConflict() * 0.05
                - (emergencyReliefGranted && !meritsInvalidated ? 0.08 : 0.0)
                - (overrideUsed ? 0.10 : 0.0)
                - caseFile.executivePressure() * 0.08;
        return Values.clamp01(compliancePressure);
    }

    private double defianceRisk(CaseFile caseFile, double constitutionalConflict, ReactionState reactionState) {
        return Values.clamp01(
                0.08
                        + constitutionalConflict * 0.30
                        + reactionState.legislativeConflict() * 0.24
                        + caseFile.executivePressure() * 0.18
                        + caseFile.stateFederalTension() * 0.10
                        - reactionState.publicTrust() * 0.12
        );
    }

    private double workaroundRisk(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            ReactionState reactionState
    ) {
        return Values.clamp01(
                0.12
                        + (meritsInvalidated ? 0.18 : 0.0)
                        + (emergencyReliefGranted ? 0.10 : 0.0)
                        + reactionState.overridePressure() * 0.22
                        + caseFile.legislativeMandate() * 0.12
                        + caseFile.stateFederalTension() * 0.08
        );
    }

    private double repeatedLitigationRisk(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted
    ) {
        return Values.clamp01(
                0.10
                        + caseFile.legalAmbiguity() * 0.24
                        + caseFile.lowerCourtConflict() * 0.18
                        + caseFile.intercourtConflict() * 0.16
                        + (emergencyReliefGranted && !meritsInvalidated ? 0.18 : 0.0)
        );
    }

    private double executiveImplementationRate(
            CaseFile caseFile,
            double complianceRate,
            double legitimacy,
            double constitutionalConflict,
            ReactionState reactionState
    ) {
        return Values.clamp01(
                complianceRate * 0.62
                        + legitimacy * 0.16
                        + reactionState.complianceNorm() * 0.14
                        - constitutionalConflict * 0.10
                        - caseFile.executivePressure() * 0.10
        );
    }

    private double agencyNonacquiescenceRisk(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            ReactionState reactionState
    ) {
        double agencyDoctrineRisk = caseFile.doctrineArea() == courtsim.model.DoctrineArea.ADMINISTRATIVE_STATE ? 0.16 : 0.04;
        return Values.clamp01(
                agencyDoctrineRisk
                        + caseFile.executivePressure() * 0.18
                        + caseFile.legalAmbiguity() * 0.14
                        + reactionState.courtCurbingPressure() * 0.16
                        + (meritsInvalidated ? 0.08 : 0.0)
                        + (emergencyReliefGranted ? 0.06 : 0.0)
        );
    }

    private double legislativeReenactmentRisk(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean overrideUsed,
            ReactionState reactionState
    ) {
        return Values.clamp01(
                0.06
                        + caseFile.legislativeMandate() * 0.20
                        + reactionState.overridePressure() * 0.22
                        + caseFile.stateFederalTension() * 0.08
                        + (meritsInvalidated ? 0.14 : 0.0)
                        - (overrideUsed ? 0.08 : 0.0)
                        - caseFile.rightsThreat() * 0.08
        );
    }

    private double localGovernmentComplianceRate(
            CaseFile caseFile,
            double complianceRate,
            double constitutionalConflict,
            ReactionState reactionState
    ) {
        double localExposure = caseFile.jurisdiction() == Jurisdiction.FEDERAL ? 0.08 : 0.22;
        return Values.clamp01(
                complianceRate * 0.58
                        + reactionState.complianceNorm() * 0.20
                        + caseFile.publicSupport() * 0.08
                        - constitutionalConflict * 0.10
                        - caseFile.stateFederalTension() * localExposure
        );
    }

    private double stateDeferencePenalty(CaseFile caseFile) {
        return caseFile.jurisdiction() == Jurisdiction.STATE
                ? caseFile.legislativeMandate() * caseFile.doctrineArea().deferenceWeight() * 0.08
                : 0.0;
    }

    private double medianIdeology() {
        if (court.isEmpty()) {
            return 0.0;
        }
        int middle = court.size() / 2;
        if (court.size() % 2 == 1) {
            return court.get(middle).ideology();
        }
        return (court.get(middle - 1).ideology() + court.get(middle).ideology()) / 2.0;
    }

    private record VoteResult(double strikeVoteShare, boolean invalidates) {
    }

    private record IntakeEstimate(int intakeFilings, int screenedFilings, double acceptanceRate) {
    }

    private record CostEstimate(
            double directCourt,
            double upstreamScreening,
            double capacityStrain,
            double budget,
            double delay,
            double complexity,
            double total
    ) {
    }
}
