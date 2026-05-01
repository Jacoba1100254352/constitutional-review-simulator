package courtsim.simulation;

import courtsim.institution.CaseOutcome;
import courtsim.util.Values;

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
    private double administrativeLoadSum;

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
        administrativeLoadSum += outcome.administrativeLoad();
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
                average(administrativeLoadSum)
        );
    }

    private double average(double sum) {
        if (totalCases == 0) {
            return 0.0;
        }
        return sum / totalCases;
    }
}
