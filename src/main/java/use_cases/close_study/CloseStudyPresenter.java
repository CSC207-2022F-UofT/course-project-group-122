package use_cases.close_study;

import entities.Study;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

/**
 * The presenter for the close study use case.
 */
public class CloseStudyPresenter implements CloseStudyOutputBoundary {


    /**
     * The fetch study log controller to call on the fetch study log use case. This is used to update the study log.
     */
    private FetchStudyLogController fetchStudyLogController;

    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;

    /**
     * Present the result of closing or reopening a study
     *
     * @param study   The study that was closed or reopened
     * @param message The message to display to the user
     * @param researcherId The researcher who closed or reopened the study
     */
    @Override
    public void displayMessage(@NotNull Study study, String message, int researcherId) {
        String displayMessage = "Study " + "(" + study.getId() + ") " + study.getStudyName() + ":\n" + message;
        fetchStudyLogController.fetchStudyLog(study.getId(), researcherId);
        displaySuccessMessage.presentGeneralSuccessMessage(displayMessage);
    }

    /**
     * Presents the success to add a potential participant to a study.
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
