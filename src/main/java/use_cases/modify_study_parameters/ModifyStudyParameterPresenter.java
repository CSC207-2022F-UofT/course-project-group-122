package use_cases.modify_study_parameters;

import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

import java.util.List;

public class ModifyStudyParameterPresenter implements ModifyStudyParameterOutputBoundary {


    /**
     * The controller for fetching the study log.
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
     * Displays the list of potential stratification variables for the study.
     *
     * @param variableNames The list of potential stratification variables for the study.
     */
    @Override
    public void displayPotentialStratificationVariables(List<String> variableNames) {
        //TODO: displayPotentialStratificationVariables
    }

    /**
     * Displays the success message.
     *
     * @param studyId The ID of the study.
     * @param message The success message.
     */
    @Override
    public void displaySuccessMessage(int studyId, String message, int researcherId) {
        String successMessage = "Study: " + studyId + "\n" + message;
        displaySuccessMessage.presentGeneralSuccessMessage(successMessage);
        fetchStudyLogController.fetchStudyLog(studyId, researcherId);
    }


    /**
     * Displays the failure message.
     *
     * @param message The failure message.
     */
    @Override
    public void displayFailureMessage(String message) {
        String failureMessage = "Error: " + message;
        displayFailureMessage.presentFailureMessage(failureMessage);
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


    /**
     * Sets the controller for fetching the study log.
     *
     * @param fetchStudyLogController The controller for fetching the study log.
     */
    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }
}
