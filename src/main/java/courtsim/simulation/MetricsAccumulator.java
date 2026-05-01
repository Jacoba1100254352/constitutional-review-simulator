package courtsim.simulation;

import courtsim.institution.CaseOutcome;
import courtsim.model.DoctrineArea;
import courtsim.model.Jurisdiction;
import courtsim.model.PolicyDomain;
import courtsim.util.Values;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class MetricsAccumulator {
    private int totalCases;
    private int reviewedCases;
    private int invalidations;
    private int emergencyOrders;
    private int emergencyReliefs;
    private int meritsReviews;
    private int meritsInvalidations;
    private int overrides;
    private int enBancReviews;
    private int crossChecks;
    private int councilScreens;
    private int possibleJusticeCases;
    private int recusals;
    private double legalStabilitySum;
    private double rightsProtectionSum;
    private double partisanAlignmentSum;
    private double shadowDocketAbuseSum;
    private double legitimacySum;
    private double constitutionalConflictSum;
    private double democraticResponsivenessSum;
    private double independenceAccountabilityBalanceSum;
    private double concurrenceFragmentationSum;
    private double dissentIntensitySum;
    private double lowerCourtConflictSum;
    private double timeToReviewSum;
    private double replacementPressureSum;
    private int stateCases;
    private int mixedJurisdictionCases;
    private double lowerCourtDepthSum;
    private double stateFederalTensionSum;
    private double intercourtConflictSum;
    private int compliedCases;
    private int defiedCases;
    private int workaroundCases;
    private int repeatedLitigationCases;
    private int executiveImplementationCases;
    private int agencyNonacquiescenceCases;
    private int legislativeReenactmentCases;
    private int localGovernmentComplianceCases;
    private double publicTrustSum;
    private double legislativeConflictSum;
    private double courtCurbingPressureSum;
    private double amendmentPressureSum;
    private double administrativeLoadSum;
    private double institutionalBudgetCostSum;
    private double institutionalDelayCostSum;
    private double implementationComplexitySum;
    private double totalInstitutionalCostSum;
    private final Map<Integer, SegmentAccumulator> periodAccumulators = new HashMap<>();
    private final Map<DoctrineArea, SegmentAccumulator> doctrineAccumulators = new EnumMap<>(DoctrineArea.class);
    private final Map<String, SegmentAccumulator> pipelineAccumulators = new HashMap<>();
    private final Map<PolicyDomain, SegmentAccumulator> policyDomainAccumulators = new EnumMap<>(PolicyDomain.class);
    private final Map<Integer, CompositionAccumulator> compositionAccumulators = new HashMap<>();

    void add(CaseOutcome outcome) {
        totalCases++;
        if (outcome.reviewed()) {
            reviewedCases++;
        }
        if (outcome.invalidated()) {
            invalidations++;
        }
        if (outcome.emergencyOrder()) {
            emergencyOrders++;
        }
        if (outcome.emergencyReliefGranted()) {
            emergencyReliefs++;
        }
        if (outcome.meritsReview()) {
            meritsReviews++;
        }
        if (outcome.meritsInvalidated()) {
            meritsInvalidations++;
        }
        if (outcome.overrideUsed()) {
            overrides++;
        }
        if (outcome.enBancReview()) {
            enBancReviews++;
        }
        if (outcome.crossChecked()) {
            crossChecks++;
        }
        if (outcome.councilScreen()) {
            councilScreens++;
        }
        possibleJusticeCases += Math.max(outcome.participatingJustices() + outcome.recusedJustices(), 1);
        recusals += outcome.recusedJustices();
        legalStabilitySum += outcome.legalStability();
        rightsProtectionSum += outcome.rightsProtection();
        partisanAlignmentSum += outcome.partisanAlignment();
        shadowDocketAbuseSum += outcome.shadowDocketAbuse();
        legitimacySum += outcome.legitimacy();
        constitutionalConflictSum += outcome.constitutionalConflict();
        democraticResponsivenessSum += outcome.democraticResponsiveness();
        independenceAccountabilityBalanceSum += outcome.independenceAccountabilityBalance();
        concurrenceFragmentationSum += outcome.concurrenceFragmentation();
        dissentIntensitySum += outcome.dissentIntensity();
        lowerCourtConflictSum += outcome.caseFile().lowerCourtConflict();
        timeToReviewSum += outcome.caseFile().timeToReview();
        replacementPressureSum += outcome.replacementPressure();
        if (outcome.caseFile().jurisdiction() == Jurisdiction.STATE) {
            stateCases++;
        }
        if (outcome.caseFile().jurisdiction() == Jurisdiction.MIXED_STATE_FEDERAL) {
            mixedJurisdictionCases++;
        }
        lowerCourtDepthSum += outcome.caseFile().lowerCourtPath().depth();
        stateFederalTensionSum += outcome.caseFile().stateFederalTension();
        intercourtConflictSum += outcome.caseFile().intercourtConflict();
        if (outcome.complied()) {
            compliedCases++;
        }
        if (outcome.defied()) {
            defiedCases++;
        }
        if (outcome.workaround()) {
            workaroundCases++;
        }
        if (outcome.repeatedLitigation()) {
            repeatedLitigationCases++;
        }
        if (outcome.executiveImplementation()) {
            executiveImplementationCases++;
        }
        if (outcome.agencyNonacquiescence()) {
            agencyNonacquiescenceCases++;
        }
        if (outcome.legislativeReenactment()) {
            legislativeReenactmentCases++;
        }
        if (outcome.localGovernmentCompliance()) {
            localGovernmentComplianceCases++;
        }
        publicTrustSum += outcome.publicTrustAfter();
        legislativeConflictSum += outcome.legislativeConflictAfter();
        courtCurbingPressureSum += outcome.courtCurbingPressure();
        amendmentPressureSum += outcome.amendmentPressure();
        administrativeLoadSum += outcome.administrativeLoad();
        institutionalBudgetCostSum += outcome.institutionalBudgetCost();
        institutionalDelayCostSum += outcome.institutionalDelayCost();
        implementationComplexitySum += outcome.implementationComplexity();
        totalInstitutionalCostSum += outcome.totalInstitutionalCost();
        periodAccumulators
                .computeIfAbsent(outcome.caseFile().reviewPeriod(), period -> new SegmentAccumulator("period", Integer.toString(period + 1)))
                .add(outcome);
        doctrineAccumulators
                .computeIfAbsent(outcome.caseFile().doctrineArea(), doctrine -> new SegmentAccumulator("doctrine", doctrine.name().toLowerCase()))
                .add(outcome);
        pipelineAccumulators
                .computeIfAbsent(pipelineKey(outcome), key -> new SegmentAccumulator("pipeline", key))
                .add(outcome);
        policyDomainAccumulators
                .computeIfAbsent(outcome.caseFile().policyDomain(), domain -> new SegmentAccumulator("policy-domain", domain.key()))
                .add(outcome);
    }

    void addComposition(CompositionSnapshot snapshot) {
        compositionAccumulators
                .computeIfAbsent(snapshot.reviewPeriod(), period -> new CompositionAccumulator("period", Integer.toString(period + 1)))
                .add(snapshot);
    }

    ScenarioReport toReport(String scenarioKey, String scenarioName) {
        return new ScenarioReport(
                scenarioKey,
                scenarioName,
                totalCases,
                reviewedCases,
                invalidations,
                emergencyOrders,
                emergencyReliefs,
                meritsReviews,
                meritsInvalidations,
                overrides,
                Values.ratio(reviewedCases, totalCases),
                Values.ratio(emergencyReliefs, emergencyOrders),
                Values.ratio(meritsReviews, reviewedCases),
                Values.ratio(meritsInvalidations, Math.max(meritsReviews, 1)),
                average(legalStabilitySum),
                average(rightsProtectionSum),
                average(partisanAlignmentSum),
                average(shadowDocketAbuseSum),
                average(legitimacySum),
                Values.ratio(invalidations, Math.max(reviewedCases, 1)),
                average(constitutionalConflictSum),
                average(democraticResponsivenessSum),
                average(independenceAccountabilityBalanceSum),
                average(concurrenceFragmentationSum),
                average(dissentIntensitySum),
                Values.ratio(recusals, possibleJusticeCases),
                Values.ratio(enBancReviews, reviewedCases),
                Values.ratio(crossChecks, reviewedCases),
                Values.ratio(councilScreens, reviewedCases),
                Values.ratio(overrides, Math.max(invalidations, 1)),
                average(lowerCourtConflictSum),
                average(timeToReviewSum),
                average(replacementPressureSum),
                Values.ratio(stateCases, totalCases),
                Values.ratio(mixedJurisdictionCases, totalCases),
                average(lowerCourtDepthSum),
                average(stateFederalTensionSum),
                average(intercourtConflictSum),
                Values.ratio(compliedCases, totalCases),
                Values.ratio(defiedCases, totalCases),
                Values.ratio(workaroundCases, totalCases),
                Values.ratio(repeatedLitigationCases, totalCases),
                Values.ratio(executiveImplementationCases, totalCases),
                Values.ratio(agencyNonacquiescenceCases, totalCases),
                Values.ratio(legislativeReenactmentCases, totalCases),
                Values.ratio(localGovernmentComplianceCases, totalCases),
                average(publicTrustSum),
                average(legislativeConflictSum),
                average(courtCurbingPressureSum),
                average(amendmentPressureSum),
                average(institutionalBudgetCostSum),
                average(institutionalDelayCostSum),
                average(implementationComplexitySum),
                average(totalInstitutionalCostSum),
                periodReports(),
                doctrineReports(),
                pipelineReports(),
                policyDomainReports(),
                compositionReports(),
                average(administrativeLoadSum)
        );
    }

    private List<SegmentReport> periodReports() {
        return periodAccumulators.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getValue().toReport())
                .toList();
    }

    private List<SegmentReport> doctrineReports() {
        return doctrineAccumulators.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().name()))
                .map(entry -> entry.getValue().toReport())
                .toList();
    }

    private List<SegmentReport> pipelineReports() {
        return pipelineAccumulators.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getValue().toReport())
                .toList();
    }

    private List<SegmentReport> policyDomainReports() {
        return policyDomainAccumulators.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().key()))
                .map(entry -> entry.getValue().toReport())
                .toList();
    }

    private List<CompositionReport> compositionReports() {
        return compositionAccumulators.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getValue().toReport())
                .toList();
    }

    private static String pipelineKey(CaseOutcome outcome) {
        return outcome.caseFile().jurisdiction().key() + "/" + outcome.caseFile().lowerCourtPath().key();
    }

    private double average(double sum) {
        if (totalCases == 0) {
            return 0.0;
        }
        return sum / totalCases;
    }

    private static final class SegmentAccumulator {
        private final String segmentType;
        private final String segmentKey;
        private int totalCases;
        private int reviewedCases;
        private int emergencyOrders;
        private int emergencyReliefs;
        private int meritsReviews;
        private int meritsInvalidations;
        private int compliedCases;
        private int defiedCases;
        private int workaroundCases;
        private int repeatedLitigationCases;
        private int executiveImplementationCases;
        private int agencyNonacquiescenceCases;
        private int legislativeReenactmentCases;
        private int localGovernmentComplianceCases;
        private double legalStabilitySum;
        private double rightsProtectionSum;
        private double shadowDocketAbuseSum;
        private double lowerCourtConflictSum;
        private double timeToReviewSum;
        private double lowerCourtDepthSum;
        private double stateFederalTensionSum;
        private double intercourtConflictSum;
        private double legitimacySum;
        private double constitutionalConflictSum;
        private double democraticResponsivenessSum;
        private double publicTrustSum;
        private double legislativeConflictSum;
        private double courtCurbingPressureSum;
        private double amendmentPressureSum;
        private double institutionalBudgetCostSum;
        private double institutionalDelayCostSum;
        private double implementationComplexitySum;
        private double totalInstitutionalCostSum;

        private SegmentAccumulator(String segmentType, String segmentKey) {
            this.segmentType = segmentType;
            this.segmentKey = segmentKey;
        }

        private void add(CaseOutcome outcome) {
            totalCases++;
            if (outcome.reviewed()) {
                reviewedCases++;
            }
            if (outcome.emergencyOrder()) {
                emergencyOrders++;
            }
            if (outcome.emergencyReliefGranted()) {
                emergencyReliefs++;
            }
            if (outcome.meritsReview()) {
                meritsReviews++;
            }
            if (outcome.meritsInvalidated()) {
                meritsInvalidations++;
            }
            if (outcome.complied()) {
                compliedCases++;
            }
            if (outcome.defied()) {
                defiedCases++;
            }
            if (outcome.workaround()) {
                workaroundCases++;
            }
            if (outcome.repeatedLitigation()) {
                repeatedLitigationCases++;
            }
            if (outcome.executiveImplementation()) {
                executiveImplementationCases++;
            }
            if (outcome.agencyNonacquiescence()) {
                agencyNonacquiescenceCases++;
            }
            if (outcome.legislativeReenactment()) {
                legislativeReenactmentCases++;
            }
            if (outcome.localGovernmentCompliance()) {
                localGovernmentComplianceCases++;
            }
            legalStabilitySum += outcome.legalStability();
            rightsProtectionSum += outcome.rightsProtection();
            shadowDocketAbuseSum += outcome.shadowDocketAbuse();
            lowerCourtConflictSum += outcome.caseFile().lowerCourtConflict();
            timeToReviewSum += outcome.caseFile().timeToReview();
            lowerCourtDepthSum += outcome.caseFile().lowerCourtPath().depth();
            stateFederalTensionSum += outcome.caseFile().stateFederalTension();
            intercourtConflictSum += outcome.caseFile().intercourtConflict();
            legitimacySum += outcome.legitimacy();
            constitutionalConflictSum += outcome.constitutionalConflict();
            democraticResponsivenessSum += outcome.democraticResponsiveness();
            publicTrustSum += outcome.publicTrustAfter();
            legislativeConflictSum += outcome.legislativeConflictAfter();
            courtCurbingPressureSum += outcome.courtCurbingPressure();
            amendmentPressureSum += outcome.amendmentPressure();
            institutionalBudgetCostSum += outcome.institutionalBudgetCost();
            institutionalDelayCostSum += outcome.institutionalDelayCost();
            implementationComplexitySum += outcome.implementationComplexity();
            totalInstitutionalCostSum += outcome.totalInstitutionalCost();
        }

        private SegmentReport toReport() {
            return new SegmentReport(
                    segmentType,
                    segmentKey,
                    totalCases,
                    reviewedCases,
                    Values.ratio(reviewedCases, totalCases),
                    average(legalStabilitySum),
                    average(rightsProtectionSum),
                    average(shadowDocketAbuseSum),
                    Values.ratio(emergencyReliefs, emergencyOrders),
                    Values.ratio(meritsInvalidations, Math.max(meritsReviews, 1)),
                    average(lowerCourtConflictSum),
                    average(timeToReviewSum),
                    average(lowerCourtDepthSum),
                    average(stateFederalTensionSum),
                    average(intercourtConflictSum),
                    average(legitimacySum),
                    average(constitutionalConflictSum),
                    average(democraticResponsivenessSum),
                    Values.ratio(compliedCases, totalCases),
                    Values.ratio(defiedCases, totalCases),
                    Values.ratio(workaroundCases, totalCases),
                    Values.ratio(repeatedLitigationCases, totalCases),
                    Values.ratio(executiveImplementationCases, totalCases),
                    Values.ratio(agencyNonacquiescenceCases, totalCases),
                    Values.ratio(legislativeReenactmentCases, totalCases),
                    Values.ratio(localGovernmentComplianceCases, totalCases),
                    average(publicTrustSum),
                    average(legislativeConflictSum),
                    average(courtCurbingPressureSum),
                    average(amendmentPressureSum),
                    average(institutionalBudgetCostSum),
                    average(institutionalDelayCostSum),
                    average(implementationComplexitySum),
                    average(totalInstitutionalCostSum)
            );
        }

        private double average(double sum) {
            if (totalCases == 0) {
                return 0.0;
            }
            return sum / totalCases;
        }
    }

    private static final class CompositionAccumulator {
        private final String segmentType;
        private final String segmentKey;
        private int observations;
        private double courtSizeSum;
        private double medianIdeologySum;
        private double ideologicalSpreadSum;
        private double meanPartisanAttachmentSum;
        private double meanRightsSensitivitySum;
        private double meanInstitutionalismSum;
        private double replacementPressureSum;
        private double estimatedReplacementEventsSum;

        private CompositionAccumulator(String segmentType, String segmentKey) {
            this.segmentType = segmentType;
            this.segmentKey = segmentKey;
        }

        private void add(CompositionSnapshot snapshot) {
            observations++;
            courtSizeSum += snapshot.courtSize();
            medianIdeologySum += snapshot.medianIdeology();
            ideologicalSpreadSum += snapshot.ideologicalSpread();
            meanPartisanAttachmentSum += snapshot.meanPartisanAttachment();
            meanRightsSensitivitySum += snapshot.meanRightsSensitivity();
            meanInstitutionalismSum += snapshot.meanInstitutionalism();
            replacementPressureSum += snapshot.replacementPressure();
            estimatedReplacementEventsSum += snapshot.estimatedReplacementEvents();
        }

        private CompositionReport toReport() {
            return new CompositionReport(
                    segmentType,
                    segmentKey,
                    observations,
                    average(courtSizeSum),
                    average(medianIdeologySum),
                    average(ideologicalSpreadSum),
                    average(meanPartisanAttachmentSum),
                    average(meanRightsSensitivitySum),
                    average(meanInstitutionalismSum),
                    average(replacementPressureSum),
                    average(estimatedReplacementEventsSum)
            );
        }

        private double average(double sum) {
            if (observations == 0) {
                return 0.0;
            }
            return sum / observations;
        }
    }
}
