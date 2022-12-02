package use_cases.close_questionnaire;
import entities.*;

import use_cases.fetch_id.FetchId;

/**
 * The use case for closing a questionnaire
 */
public class CloseQuestionnaireInteractor implements CloseQuestionnaireInputBoundary {

    /**
     * The output boundary that the use case calls on.
     */
    private CloseQuestionnaireOutputBoundary closeQuestionnaireOutputBoundary;

    /**
     * Close the selected questionnaire from a study
     * @param studyID the study ID
     * @param questionnaireID the questionnaire ID
     * @param researcherID the researcher ID
     */
    @Override
    public void closeQuestionnaire(int questionnaireID, int studyID, int researcherID) {
        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyID);
        assert questionnaire != null;
        if (! questionnaire.isPublished()) {
            closeQuestionnaireOutputBoundary.closeFail(questionnaireID, studyID,
                    "because the questionnaire is not yet published");
        } else if (questionnaire.isClosed()) {
            closeQuestionnaireOutputBoundary.closeFail(questionnaireID, studyID,
                    "because the questionnaire is already closed");
        } else {
            questionnaire.close();
            closeQuestionnaireOutputBoundary.closePresent(questionnaireID, studyID, researcherID);
        }
    }


    /**
     * Set the output boundary
     * @param closeQuestionnaireOutputBoundary  the output boundary
     */
    public void setCloseQuestionnaireOutputBoundary(CloseQuestionnaireOutputBoundary closeQuestionnaireOutputBoundary) {
        this.closeQuestionnaireOutputBoundary = closeQuestionnaireOutputBoundary;
    }

}
