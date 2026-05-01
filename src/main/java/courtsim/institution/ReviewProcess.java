package courtsim.institution;

import courtsim.model.CaseFile;

public interface ReviewProcess {
    CaseOutcome review(CaseFile caseFile, ReviewContext context);
}

