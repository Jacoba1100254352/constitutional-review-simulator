package courtsim.institution;

import courtsim.model.CaseFile;

public record CaseOutcome(
        CaseFile caseFile,
        boolean reviewed,
        boolean emergencyOrder,
        boolean meritsReview,
        boolean invalidated,
        boolean lawEffectiveAfterReview,
        boolean enBancReview,
        boolean crossChecked,
        boolean councilScreen,
        boolean overrideUsed,
        int recusedJustices,
        int participatingJustices,
        double strikeVoteShare,
        double majorityShare,
        double legalStability,
        double rightsProtection,
        double partisanAlignment,
        double shadowDocketAbuse,
        double legitimacy,
        double reversalMagnitude,
        double constitutionalConflict,
        double democraticResponsiveness,
        double independenceAccountabilityBalance,
        double concurrenceFragmentation,
        double dissentIntensity,
        double administrativeLoad
) {
}

