package courtsim.institution;

import courtsim.model.CaseFile;
import courtsim.model.Jurisdiction;
import courtsim.model.Justice;
import courtsim.model.LowerCourtPath;
import courtsim.simulation.CompositionSnapshot;
import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public final class ConstitutionalReviewProcess implements ReviewProcess {
    private final DesignConfiguration configuration;
    private final WorldSpec worldSpec;
    private final List<Justice> court;
    private final double replacementPressure;
    private final DecisionMechanismModel mechanismModel;
    private final IntakeModel intakeModel;
    private final EmergencyDocketModel emergencyDocketModel;
    private final PostDecisionResponseModel responseModel;
    private final ComplianceModel complianceModel;
    private final InstitutionalCostModel costModel;
    private final OutcomeScoreModel scoreModel;

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
        this.mechanismModel = new DecisionMechanismModel(configuration);
        this.intakeModel = new IntakeModel(configuration, worldSpec);
        this.emergencyDocketModel = new EmergencyDocketModel(configuration);
        this.responseModel = new PostDecisionResponseModel(configuration, worldSpec);
        this.complianceModel = new ComplianceModel(configuration, worldSpec);
        this.costModel = new InstitutionalCostModel(configuration, worldSpec, replacementPressure);
        this.scoreModel = new OutcomeScoreModel(configuration, worldSpec);
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
        boolean emergency = intakeModel.isEmergency(caseFile, random);
        boolean rightsImpactStatement = mechanismModel.rightsImpactStatementUsed(caseFile);
        boolean ombudsmanTriggered = mechanismModel.ombudsmanTriggered(caseFile);
        boolean publicDefenderParticipation = mechanismModel.publicDefenderParticipation(caseFile);
        boolean preEnactmentReview = mechanismModel.preEnactmentReview(caseFile);
        boolean abstractReview = mechanismModel.abstractReview(caseFile);
        boolean reviewed = intakeModel.shouldReview(
                caseFile,
                emergency,
                rightsImpactStatement,
                ombudsmanTriggered,
                publicDefenderParticipation,
                preEnactmentReview,
                abstractReview,
                random
        );
        String supranationalRoute = mechanismModel.supranationalRoute(caseFile, random);
        boolean preliminaryReferenceRoute = "preliminary_reference".equals(supranationalRoute);
        boolean appealRoute = "appeal".equals(supranationalRoute);
        boolean directActionRoute = "direct_action".equals(supranationalRoute);
        IntakeEstimate intake = intakeModel.estimate(
                caseFile,
                emergency,
                reviewed,
                ombudsmanTriggered,
                publicDefenderParticipation,
                abstractReview
        );
        int recused = recusedJustices(caseFile, random);
        int participating = configuration.substitutesRecusedJustices()
                ? configuration.courtSize()
                : Math.max(3, configuration.courtSize() - recused);

        if (!reviewed) {
            return declinedOutcome(
                    caseFile,
                    emergency,
                    recused,
                    participating,
                    reactionState,
                    intake,
                    random,
                    rightsImpactStatement,
                    ombudsmanTriggered,
                    publicDefenderParticipation,
                    preEnactmentReview,
                    abstractReview,
                    supranationalRoute,
                    preliminaryReferenceRoute,
                    appealRoute,
                    directActionRoute
            );
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
        finalVote = mechanismAdjustedVote(
                caseFile,
                finalVote,
                rightsImpactStatement,
                ombudsmanTriggered,
                publicDefenderParticipation,
                preEnactmentReview,
                abstractReview
        );

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

        boolean meritsReview = emergencyDocketModel.meritsReview(emergency, caseFile);
        boolean emergencyReliefGranted = emergencyDocketModel.reliefGranted(caseFile, emergency, finalVote, random);
        boolean dialogueConcernFound = (configuration.weakFormReview()
                || configuration.reviewMechanism() == ReviewMechanism.SUSPENDED_DECLARATION)
                && finalVote.strikeVoteShare() >= Math.max(0.40, configuration.invalidationThreshold() - 0.10);
        boolean constitutionalConcernFound = meritsReview && (meritsEligibleInvalidation || dialogueConcernFound);
        boolean weakFormDeclaration = configuration.reviewMechanism() == ReviewMechanism.WEAK_FORM_REVIEW
                && constitutionalConcernFound;
        boolean suspendedDeclaration = configuration.reviewMechanism() == ReviewMechanism.SUSPENDED_DECLARATION
                && constitutionalConcernFound;
        boolean meritsInvalidated = constitutionalConcernFound && !weakFormDeclaration;
        boolean overrideUsed = responseModel.overrideUsed(caseFile, meritsInvalidated, random);
        double legislativeResponseCredibility = responseModel.legislativeResponseCredibility(
                caseFile,
                weakFormDeclaration,
                suspendedDeclaration,
                meritsInvalidated,
                overrideUsed
        );
        boolean legislativeResponse = responseModel.legislativeResponse(
                caseFile,
                weakFormDeclaration,
                suspendedDeclaration,
                meritsInvalidated,
                overrideUsed,
                legislativeResponseCredibility,
                random
        );
        double legislativeResponseDeadline = responseModel.legislativeResponseDeadline(
                caseFile,
                weakFormDeclaration,
                suspendedDeclaration,
                overrideUsed,
                constitutionalConcernFound
        );
        double legislativeResponseDelay = legislativeResponse
                ? responseModel.legislativeResponseDelay(caseFile, legislativeResponseDeadline, legislativeResponseCredibility, suspendedDeclaration, random)
                : 0.0;
        boolean timelyLegislativeResponse = legislativeResponse
                && legislativeResponseDeadline > 0.0
                && legislativeResponseDelay <= legislativeResponseDeadline;
        boolean lawEffective = (!meritsInvalidated || overrideUsed) && !(emergencyReliefGranted && !meritsReview);
        if (weakFormDeclaration) {
            lawEffective = !legislativeResponse;
        }
        if (suspendedDeclaration) {
            lawEffective = !timelyLegislativeResponse;
        }
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
                ? Values.clamp01(caseFile.constitutionalSalience() * (councilScreen ? 0.42 : (suspendedDeclaration ? 0.55 : 1.0)))
                : emergencyReliefGranted
                ? Values.clamp01(caseFile.constitutionalSalience() * 0.34)
                : weakFormDeclaration
                ? Values.clamp01(caseFile.constitutionalSalience() * 0.20)
                : 0.0;
        double partisanAlignment = scoreModel.partisanAlignment(caseFile, finalVote.strikeVoteShare(), meritsInvalidated || emergencyReliefGranted);
        double shadowAbuse = emergencyDocketModel.shadowDocketAbuse(caseFile, emergency, meritsReview, emergencyReliefGranted, meritsInvalidated);
        String emergencyApplicantType = emergencyDocketModel.applicantType(caseFile, emergency);
        boolean governmentEmergencyApplicant = emergency && emergencyDocketModel.isGovernmentApplicant(emergencyApplicantType);
        boolean governmentEmergencyWin = governmentEmergencyApplicant && emergencyReliefGranted;
        boolean reasonsGiven = !emergency || random.nextDouble() < emergencyDocketModel.reasonsProbability(caseFile, emergencyReliefGranted, meritsReview);
        boolean voteDisclosed = !emergency || random.nextDouble() < emergencyDocketModel.voteDisclosureProbability(caseFile, emergencyReliefGranted, reasonsGiven);
        boolean publicDisagreement = emergency && random.nextDouble() < emergencyDocketModel.publicDisagreementProbability(caseFile, dissentIntensity, shadowAbuse, reasonsGiven);
        boolean meritsFollowUp = emergency && meritsReview;
        double rightsProtection = scoreModel.rightsProtection(
                caseFile,
                meritsInvalidated,
                emergencyReliefGranted,
                overrideUsed,
                weakFormDeclaration,
                suspendedDeclaration,
                legislativeResponse,
                legislativeResponseDelay,
                legislativeResponseDeadline,
                timelyLegislativeResponse,
                rightsImpactStatement,
                publicDefenderParticipation
        );
        double constitutionalConflict = scoreModel.constitutionalConflict(
                caseFile,
                meritsInvalidated,
                emergencyReliefGranted,
                overrideUsed,
                shadowAbuse,
                crossCheckConflict,
                weakFormDeclaration,
                suspendedDeclaration,
                legislativeResponse
        );
        double democraticResponsiveness = scoreModel.democraticResponsiveness(
                caseFile,
                meritsInvalidated,
                emergencyReliefGranted,
                overrideUsed,
                weakFormDeclaration,
                suspendedDeclaration,
                legislativeResponse
        );
        double independenceBalance = scoreModel.independenceAccountabilityBalance(caseFile);
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
                        + (legislativeResponse ? 0.06 : 0.0)
                        - constitutionalConflict * 0.18
        );
        double complianceRate = complianceModel.complianceRate(
                caseFile,
                legitimacy,
                constitutionalConflict,
                meritsInvalidated,
                emergencyReliefGranted,
                overrideUsed,
                reactionState
        );
        if (legislativeResponse) {
            complianceRate = Values.clamp01(complianceRate + (timelyLegislativeResponse ? 0.05 : -0.05));
        }
        boolean complied = random.nextDouble() < complianceRate;
        boolean defied = !complied && random.nextDouble() < complianceModel.defianceRisk(caseFile, constitutionalConflict, reactionState);
        boolean workaround = !complied && !defied && random.nextDouble() < complianceModel.workaroundRisk(caseFile, meritsInvalidated, emergencyReliefGranted, reactionState);
        boolean repeatedLitigation = (!complied || workaround)
                && random.nextDouble() < complianceModel.repeatedLitigationRisk(caseFile, meritsInvalidated, emergencyReliefGranted);
        boolean executiveImplementation = random.nextDouble() < complianceModel.executiveImplementationRate(
                caseFile,
                complianceRate,
                legitimacy,
                constitutionalConflict,
                reactionState
        );
        boolean agencyNonacquiescence = !executiveImplementation
                && random.nextDouble() < complianceModel.agencyNonacquiescenceRisk(caseFile, meritsInvalidated, emergencyReliefGranted, reactionState);
        boolean legislativeReenactment = workaround
                && random.nextDouble() < complianceModel.legislativeReenactmentRisk(caseFile, meritsInvalidated, overrideUsed, reactionState);
        boolean localGovernmentCompliance = random.nextDouble() < complianceModel.localGovernmentComplianceRate(
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
        double administrativeLoad = costModel.administrativeLoad(caseFile, emergency, enBanc, crossChecked, councilScreen, recused);
        CostEstimate institutionalCosts = costModel.institutionalCosts(
                caseFile,
                emergency,
                enBanc,
                crossChecked,
                councilScreen,
                recused,
                administrativeLoad,
                intake,
                rightsImpactStatement,
                ombudsmanTriggered,
                publicDefenderParticipation,
                preEnactmentReview,
                abstractReview,
                legislativeResponse
        );
        double caseSelectionAccess = intakeModel.caseSelectionAccess(caseFile, intake);
        double implementationCapacity = costModel.implementationCapacity(caseFile, constitutionalConflict, institutionalCosts);
        double legalTransplantFeasibility = costModel.legalTransplantFeasibility(caseFile, institutionalCosts);
        double politicalCultureSensitivity = costModel.politicalCultureSensitivity(caseFile, constitutionalConflict, institutionalCosts);
        double vetoRelocationRisk = scoreModel.vetoRelocationRisk(
                caseFile,
                meritsInvalidated,
                weakFormDeclaration,
                suspendedDeclaration,
                legislativeResponse,
                councilScreen,
                crossChecked,
                intake,
                institutionalCosts,
                caseSelectionAccess
        );
        double democraticConstitutionalism = scoreModel.democraticConstitutionalism(
                legalStability,
                rightsProtection,
                legitimacy,
                democraticResponsiveness,
                complianceRate,
                constitutionalConflict,
                vetoRelocationRisk,
                legalTransplantFeasibility,
                politicalCultureSensitivity,
                legislativeResponseCredibility,
                caseSelectionAccess,
                caseFile.governmentRepeatPlayerAdvantage(),
                implementationCapacity
        );

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
                institutionalCosts.total(),
                weakFormDeclaration,
                suspendedDeclaration,
                legislativeResponse,
                legislativeResponseDelay,
                legislativeResponseDeadline,
                timelyLegislativeResponse,
                rightsImpactStatement,
                ombudsmanTriggered,
                publicDefenderParticipation,
                preEnactmentReview,
                abstractReview,
                supranationalRoute,
                preliminaryReferenceRoute,
                appealRoute,
                directActionRoute,
                legislativeResponseCredibility,
                caseSelectionAccess,
                caseFile.governmentRepeatPlayerAdvantage(),
                implementationCapacity,
                vetoRelocationRisk,
                legalTransplantFeasibility,
                politicalCultureSensitivity,
                democraticConstitutionalism
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
        Collections.shuffle(active, random);
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

    private VoteResult mechanismAdjustedVote(
            CaseFile caseFile,
            VoteResult vote,
            boolean rightsImpactStatement,
            boolean ombudsmanTriggered,
            boolean publicDefenderParticipation,
            boolean preEnactmentReview,
            boolean abstractReview
    ) {
        double adjustment = 0.0;
        if (rightsImpactStatement) {
            adjustment -= 0.035 + caseFile.legislativeMandate() * 0.025;
            adjustment += caseFile.rightsThreat() * 0.030;
        }
        if (ombudsmanTriggered) {
            adjustment += caseFile.rightsThreat() * 0.060 + caseFile.constitutionalSalience() * 0.020;
        }
        if (publicDefenderParticipation) {
            adjustment += caseFile.rightsThreat() * 0.075 - caseFile.publicSupport() * 0.015;
        }
        if (preEnactmentReview) {
            adjustment -= caseFile.legalAmbiguity() * 0.025;
            adjustment += caseFile.constitutionalSalience() * 0.030;
        }
        if (abstractReview) {
            adjustment += caseFile.constitutionalSalience() * 0.035 + caseFile.stateFederalTension() * 0.025;
        }
        if (configuration.weakFormReview()) {
            adjustment += caseFile.rightsThreat() * 0.025 - caseFile.legislativeMandate() * 0.018;
        }
        double share = Values.clamp01(vote.strikeVoteShare() + adjustment);
        return new VoteResult(share, share >= configuration.invalidationThreshold());
    }

    private CaseOutcome declinedOutcome(
            CaseFile caseFile,
            boolean emergency,
            int recused,
            int participating,
            ReactionState reactionState,
            IntakeEstimate intake,
            Random random,
            boolean rightsImpactStatement,
            boolean ombudsmanTriggered,
            boolean publicDefenderParticipation,
            boolean preEnactmentReview,
            boolean abstractReview,
            String supranationalRoute,
            boolean preliminaryReferenceRoute,
            boolean appealRoute,
            boolean directActionRoute
    ) {
        double rightsProtection = Values.clamp01(
                1.0
                        - caseFile.rightsThreat() * 0.78
                        + (rightsImpactStatement ? 0.06 : 0.0)
                        + (publicDefenderParticipation ? 0.04 : 0.0)
        );
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
        CostEstimate institutionalCosts = costModel.institutionalCosts(
                caseFile,
                emergency,
                false,
                false,
                false,
                recused,
                administrativeLoad,
                intake,
                rightsImpactStatement,
                ombudsmanTriggered,
                publicDefenderParticipation,
                preEnactmentReview,
                abstractReview,
                false
        );
        double legislativeResponseCredibility = responseModel.legislativeResponseCredibility(caseFile, false, false, false, false);
        double caseSelectionAccess = intakeModel.caseSelectionAccess(caseFile, intake);
        double implementationCapacity = costModel.implementationCapacity(caseFile, constitutionalConflict, institutionalCosts);
        double legalTransplantFeasibility = costModel.legalTransplantFeasibility(caseFile, institutionalCosts);
        double politicalCultureSensitivity = costModel.politicalCultureSensitivity(caseFile, constitutionalConflict, institutionalCosts);
        double vetoRelocationRisk = scoreModel.vetoRelocationRisk(
                caseFile,
                false,
                false,
                false,
                false,
                false,
                false,
                intake,
                institutionalCosts,
                caseSelectionAccess
        );
        double democraticConstitutionalism = scoreModel.democraticConstitutionalism(
                legalStability,
                rightsProtection,
                legitimacy,
                democraticResponsiveness,
                1.0,
                constitutionalConflict,
                vetoRelocationRisk,
                legalTransplantFeasibility,
                politicalCultureSensitivity,
                legislativeResponseCredibility,
                caseSelectionAccess,
                caseFile.governmentRepeatPlayerAdvantage(),
                implementationCapacity
        );
        String emergencyApplicantType = emergencyDocketModel.applicantType(caseFile, emergency);
        boolean governmentEmergencyApplicant = emergency && emergencyDocketModel.isGovernmentApplicant(emergencyApplicantType);
        boolean reasonsGiven = !emergency || random.nextDouble() < emergencyDocketModel.reasonsProbability(caseFile, false, false) * 0.55;
        boolean voteDisclosed = !emergency || random.nextDouble() < emergencyDocketModel.voteDisclosureProbability(caseFile, false, reasonsGiven) * 0.40;
        boolean publicDisagreement = emergency && random.nextDouble() < emergencyDocketModel.publicDisagreementProbability(
                caseFile,
                0.0,
                emergencyDocketModel.shadowDocketAbuse(caseFile, true, false, false, false) * 0.45,
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
                emergency ? emergencyDocketModel.shadowDocketAbuse(caseFile, true, false, false, false) * 0.45 : 0.0,
                legitimacy,
                0.0,
                constitutionalConflict,
                democraticResponsiveness,
                scoreModel.independenceAccountabilityBalance(caseFile),
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
                institutionalCosts.total(),
                false,
                false,
                false,
                0.0,
                0.0,
                false,
                rightsImpactStatement,
                ombudsmanTriggered,
                publicDefenderParticipation,
                preEnactmentReview,
                abstractReview,
                supranationalRoute,
                preliminaryReferenceRoute,
                appealRoute,
                directActionRoute,
                legislativeResponseCredibility,
                caseSelectionAccess,
                caseFile.governmentRepeatPlayerAdvantage(),
                implementationCapacity,
                vetoRelocationRisk,
                legalTransplantFeasibility,
                politicalCultureSensitivity,
                democraticConstitutionalism
        );
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

}
