package use_cases.close_questionnaire;


/**
 * Controls the process of closing a questionnaire
 */

public class CloseQuestionnaireController {

    /**
     * The input boundary that the use case implements and the controller calls on.
     */
    private CloseQuestionnaireInputBoundary closeQuestionnaireInputBoundary;

    /**
     * Close the selected questionnaire from a study
     *
     * @param questionnaireID the id of the questionnaire
     * @param studyID         the id of the study
     * @param researcherID    the id of the researcher
     */
    public void closeQuestionnaire(int questionnaireID, int studyID, int researcherID) {
        closeQuestionnaireInputBoundary.closeQuestionnaire(questionnaireID, studyID, researcherID);
    }

    /**
     * Set the input boundary
     *
     * @param closeQuestionnaireInputBoundary the input boundary
     */
    public void setCloseQuestionnaireInputBoundary(CloseQuestionnaireInputBoundary closeQuestionnaireInputBoundary) {
        this.closeQuestionnaireInputBoundary = closeQuestionnaireInputBoundary;
    }

}
