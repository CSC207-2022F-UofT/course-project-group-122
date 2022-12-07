package use_cases.researcher_edit_answer;

import java.util.HashMap;

public class ResearcherEditAnswerController {
    ResearcherEditAnswerInputBoundary researcherEditAnswerInputBoundary;
    public void researcherEditAnswerRequest(int researcherID, int participantId,  int answerId, int studyID, HashMap<String, String> answers, String reasonForModification) {
        ResearcherEditAnswerRequestModel researcherEditAnswerRequestModel =
                new ResearcherEditAnswerRequestModel(
                        researcherID,participantId, answerId, studyID, answers, reasonForModification);
        researcherEditAnswerInputBoundary.editAnswer(researcherEditAnswerRequestModel);
    }

    public void setResearcherEditAnswerInputBoundary(ResearcherEditAnswerInputBoundary researcherEditAnswerInputBoundary) {
        this.researcherEditAnswerInputBoundary = researcherEditAnswerInputBoundary;
    }
}
