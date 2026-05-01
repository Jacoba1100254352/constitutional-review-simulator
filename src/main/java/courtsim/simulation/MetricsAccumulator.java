package courtsim.simulation;

import courtsim.institution.CaseOutcome;
import courtsim.model.DoctrineArea;
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
    private int compliedCases;
    private int defiedCases;
    private int workaroundCases;
    private int repeatedLitigationCases;
    private double publicTrustSum;
    private double legislativeConflictSum;
    private double courtCurbingPressureSum;
    private double amendmentPressureSum;
    private double administrativeLoadSum;
    private final Map<Integer, SegmentAccumulator> periodAccumulators = new HashMap<>();
    private final Map<DoctrineArea, SegmentAccumulator> doctrineAccumulators = new EnumMap<>(DoctrineArea.class);

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
        publicTrustSum += outcome.publicTrustAfter();
        legislativeConflictSum += outcome.legislativeConflictAfter();
        courtCurbingPressureSum += outcome.courtCurbingPressure();
        amendmentPressureSum += outcome.amendmentPressure();
        administrativeLoadSum += outcome.administrativeLoad();
        periodAccumulators
                .computeIfAbsent(outcome.caseFile().reviewPeriod(), period -> new SegmentAccumulator("period", Integer.toString(period + 1)))
                .add(outcome);
        doctrineAccumulators
                .computeIfAbsent(outcome.caseFile().doctrineArea(), doctrine -> new SegmentAccumulator("doctrine", doctrine.name().toLowerCase()))
                .add(outcome);
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
                Values.ratio(compliedCases, totalCases),
                Values.ratio(defiedCases, totalCases),
                Values.ratio(workaroundCases, totalCases),
                Values.ratio(repeatedLitigationCases, totalCases),
                average(publicTrustSum),
                average(legislativeConflictSum),
                average(courtCurbingPressureSum),
                average(amendmentPressureSum),
                periodReports(),
                doctrineReports(),
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
        private double legalStabilitySum;
        private double rightsProtectionSum;
        private double shadowDocketAbuseSum;
        private double legitimacySum;
        private double constitutionalConflictSum;
        private double democraticResponsivenessSum;
        private double publicTrustSum;
        private double legislativeConflictSum;
        private double courtCurbingPressureSum;
        private double amendmentPressureSum;

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
            legalStabilitySum += outcome.legalStability();
            rightsProtectionSum += outcome.rightsProtection();
            shadowDocketAbuseSum += outcome.shadowDocketAbuse();
            legitimacySum += outcome.legitimacy();
            constitutionalConflictSum += outcome.constitutionalConflict();
            democraticResponsivenessSum += outcome.democraticResponsiveness();
            publicTrustSum += outcome.publicTrustAfter();
            legislativeConflictSum += outcome.legislativeConflictAfter();
            courtCurbingPressureSum += outcome.courtCurbingPressure();
            amendmentPressureSum += outcome.amendmentPressure();
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
                    average(legitimacySum),
                    average(constitutionalConflictSum),
                    average(democraticResponsivenessSum),
                    Values.ratio(compliedCases, totalCases),
                    Values.ratio(defiedCases, totalCases),
                    Values.ratio(workaroundCases, totalCases),
                    Values.ratio(repeatedLitigationCases, totalCases),
                    average(publicTrustSum),
                    average(legislativeConflictSum),
                    average(courtCurbingPressureSum),
                    average(amendmentPressureSum)
            );
        }

        private double average(double sum) {
            if (totalCases == 0) {
                return 0.0;
            }
            return sum / totalCases;
        }
    }
}
