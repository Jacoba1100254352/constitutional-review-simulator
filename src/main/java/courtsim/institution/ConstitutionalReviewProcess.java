package courtsim.institution;

import courtsim.model.CaseFile;
import courtsim.model.CaseType;
import courtsim.model.Justice;
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

    @Override
    public CaseOutcome review(CaseFile caseFile, ReviewContext context) {
        Random random = context.random();
        boolean emergency = isEmergency(caseFile, random);
        boolean reviewed = shouldReview(caseFile, emergency, random);
        int recused = recusedJustices(caseFile, random);
        int participating = configuration.substitutesRecusedJustices()
                ? configuration.courtSize()
                : Math.max(3, configuration.courtSize() - recused);

        if (!reviewed) {
            return declinedOutcome(caseFile, emergency, recused, participating);
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
                        + configuration.transparency() * 0.18
                        + majorityShare * 0.12
                        + rightsProtection * 0.18
                        + Values.lowerIsBetter(partisanAlignment) * 0.14
                        + Values.lowerIsBetter(shadowAbuse) * 0.14
                        - constitutionalConflict * 0.18
        );
        double administrativeLoad = administrativeLoad(caseFile, emergency, enBanc, crossChecked, councilScreen, recused);

        return new CaseOutcome(
                caseFile,
                true,
                emergency,
                emergencyReliefGranted,
                meritsReview,
                meritsInvalidated,
                meritsInvalidated,
                lawEffective,
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
                concurrenceFragmentation,
                dissentIntensity,
                caseFile.reviewPeriod() == 0 ? 0.0 : replacementPressure,
                administrativeLoad
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
                + (emergency ? 0.18 : 0.0)
                - caseFile.legalAmbiguity() * 0.05;
        return reviewScore + random.nextDouble() * 0.24 > 0.48;
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
                    + caseFile.certiorariPressure() * 0.08;
            double mandateRestraint = caseFile.legislativeMandate()
                    * caseFile.doctrineArea().deferenceWeight()
                    * (configuration.accountabilityPressure() * 0.24 + justice.accountabilityPressure() * 0.18);
            double ambiguityRestraint = caseFile.legalAmbiguity()
                    * justice.institutionalism()
                    * (0.20 + configuration.stabilityPreference() * 0.14);
            double lowerCourtSignal = caseFile.lowerCourtGovernmentWin()
                    ? caseFile.rightsThreat() * 0.07
                    : -caseFile.legislativeMandate() * 0.05;
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

    private CaseOutcome declinedOutcome(CaseFile caseFile, boolean emergency, int recused, int participating) {
        double rightsProtection = Values.clamp01(1.0 - caseFile.rightsThreat() * 0.78);
        double democraticResponsiveness = Values.clamp01(caseFile.legislativeMandate() * 0.72 + caseFile.publicSupport() * 0.18);
        double constitutionalConflict = Values.clamp01(
                caseFile.rightsThreat() * caseFile.constitutionalSalience() * 0.42
                        + caseFile.lowerCourtConflict() * 0.16
                        + (emergency ? caseFile.urgency() * 0.10 : 0.0)
        );
        double legitimacy = Values.clamp01(
                caseFile.publicTrust() * 0.42
                        + democraticResponsiveness * 0.22
                        + rightsProtection * 0.16
                        - constitutionalConflict * 0.16
        );
        double legalStability = Values.clamp01(0.82 - constitutionalConflict * 0.20 + configuration.stabilityPreference() * 0.10);
        return new CaseOutcome(
                caseFile,
                false,
                emergency,
                false,
                false,
                false,
                false,
                true,
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
                0.0,
                0.0,
                caseFile.reviewPeriod() == 0 ? 0.0 : replacementPressure,
                0.08 + (emergency ? 0.06 : 0.0)
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
        );
    }

    private double democraticResponsiveness(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            boolean overrideUsed
    ) {
        if (overrideUsed) {
            return Values.clamp01(0.48 + caseFile.legislativeMandate() * 0.34 - caseFile.rightsThreat() * 0.18);
        }
        if (meritsInvalidated) {
            return Values.clamp01(
                    (1.0 - caseFile.legislativeMandate()) * 0.26
                            + caseFile.rightsThreat() * 0.44
                            + caseFile.publicSupport() * 0.10
            );
        }
        if (emergencyReliefGranted) {
            return Values.clamp01(
                    (1.0 - caseFile.legislativeMandate()) * 0.16
                            + caseFile.rightsThreat() * 0.30
                            + caseFile.publicSupport() * 0.08
            );
        }
        return Values.clamp01(
                caseFile.legislativeMandate() * 0.56
                        + caseFile.publicSupport() * 0.22
                        + (1.0 - caseFile.rightsThreat()) * 0.16
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
                        + (caseFile.reviewPeriod() == 0 ? 0.0 : replacementPressure * 0.05)
        );
    }

    private record VoteResult(double strikeVoteShare, boolean invalidates) {
    }
}
