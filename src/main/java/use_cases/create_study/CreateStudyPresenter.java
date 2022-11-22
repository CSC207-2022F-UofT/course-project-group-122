package use_cases.create_study;

import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class CreateStudyPresenter implements CreateStudyOutputBoundary {

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
     * Present the failure to create a study.
     *
     * @param message The message to present.
     */
    @Override
    public void displayFailureMessage(String message) {
        displayFailureMessage.presentFailureMessage(message);
    }

    /**
     * Present the success of creating a study.
     *
     * @param studyId   The study ID.
     * @param studyName The study name.
     */
    @Override
    public void presentStudyCreatedSuccessfully(int studyId, String studyName, int researcherId) {
        String successMessage = "Study " + studyId + " (" + studyName + ") has been created successfully.";
        displaySuccessMessage.presentGeneralSuccessMessage(successMessage);
        fetchStudyLogController.fetchStudyLog(studyId, researcherId);
    }


    /**
     * Set the study log controller.
     * @param fetchStudyLogController   The study log controller.
     */
    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }

    /**
     * Presents the failure to add a potential participant to a study.
     * @param displayFailureMessage The presenter to display the failure message.
     */
    public void setDisplayFailureMessage(DisplayFailureMessageInterface displayFailureMessage) {
        this.displayFailureMessage = displayFailureMessage;
    }


    /**
     * Presents the success to add a potential participant to a study.
     * @param displaySuccessMessage The presenter to display the success message.
     */
    public void setDisplaySuccessMessage(DisplaySuccessMessageInterface displaySuccessMessage) {
        this.displaySuccessMessage = displaySuccessMessage;
    }
}
