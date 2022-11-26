package use_cases.close_questionnaire;

import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class CloseQuestionnairePresenter implements CloseQuestionnaireOutputBoundary {


    /**
     * The fetch study log controller
     */
    private FetchStudyLogController fetchStudyLogController;

    /**
     * The display failure message interface
     */

    private DisplayFailureMessageInterface displayFailureMessage;

    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;

    /**
     * Presents that the questionnaire has closed
     * @param questionnaireID The ID of the questionnaire that has been closed.
     * @param studyID The ID of the study that the questionnaire has been closed to.
     */

    @Override
    public void closePresent(int questionnaireID, int studyID, int researcherID) {
        fetchStudyLogController.fetchStudyLog(studyID, researcherID);
        displaySuccessMessage.presentGeneralSuccessMessage("Questionnaire " + questionnaireID +
                " has been closed for study " + studyID);
    }

    /**
     * Presents that the questionnaire has fail to close
     * @param questionnaireID The ID of the questionnaire that cannot be closed.
     * @param studyID The ID of the study that the questionnaire has been closed to.
     * @param message The message to present.
     */
    @Override
    public void closeFail(int questionnaireID, int studyID, String message) {
        displayFailureMessage.presentFailureMessage("Questionnaire " + questionnaireID + " cannot be closed for study "
                + studyID + " " + message);
    }

    /**
     * Sets the display failure message interface
     * @param displayFailureMessage The display failure message interface
     */

    public void setDisplayFailureMessage(DisplayFailureMessageInterface displayFailureMessage) {
        this.displayFailureMessage = displayFailureMessage;


    }

    /**
     * Sets the display success message interface
     * @param displaySuccessMessage The presenter to display the success message.
     */
    public void setDisplaySuccessMessage(DisplaySuccessMessageInterface displaySuccessMessage) {
        this.displaySuccessMessage = displaySuccessMessage;
    }


    /**
     * Sets the fetch study log controller
     * @param fetchStudyLogController   The fetch study log controller
     */
    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }

}



