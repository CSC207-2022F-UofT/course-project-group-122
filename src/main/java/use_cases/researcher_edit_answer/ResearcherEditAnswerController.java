package use_cases.researcher_edit_answer;

import java.util.HashMap;

/**
 * The controller that the screen calls though the controller manager to edit an answer.
 */
public class ResearcherEditAnswerController {
    /**
     * The use case that this controller calls on.
     */
    ResearcherEditAnswerInputBoundary researcherEditAnswerInputBoundary;


    /**
     * The constructor for the controller.
     *
     * @param researcherID The id of the researcher editing the answer.
     * @param participantId The id of the participant who answered the question.
     * @param answerId The id of the answer to edit.
     * @param studyID The id of the study that the answer is in.
     * @param answers The new answers to the questions.
     * @param reasonForModification The reason for the modification.
     */
    public void researcherEditAnswerRequest(int researcherID, int participantId,  int answerId, int studyID, HashMap<String, String> answers, String reasonForModification) {
        ResearcherEditAnswerRequestModel researcherEditAnswerRequestModel =
                new ResearcherEditAnswerRequestModel(
                        researcherID,participantId, answerId, studyID, answers, reasonForModification);
        researcherEditAnswerInputBoundary.editAnswer(researcherEditAnswerRequestModel);
    }

    /**
     * Set the use case that this controller calls on.
     * @param researcherEditAnswerInputBoundary The use case that this controller calls on.
     */
    public void setResearcherEditAnswerInputBoundary(ResearcherEditAnswerInputBoundary researcherEditAnswerInputBoundary) {
        this.researcherEditAnswerInputBoundary = researcherEditAnswerInputBoundary;
    }
}
