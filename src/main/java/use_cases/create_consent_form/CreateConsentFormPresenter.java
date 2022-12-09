package use_cases.create_consent_form;

import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessage;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessage;

/**
 * The presenter for the create consent form use case.
 */
public class CreateConsentFormPresenter implements CreateConsentFormOutputBoundary {
    /**
     * Display the success message.
     */
    private DisplaySuccessMessage displaySuccessMessage;

    /**
     * Display the failure message.
     */
    private DisplayFailureMessage displayFailureMessage;

    /**
     * Fetch study log controller.
     */
    private FetchStudyLogController fetchStudyLogController;


    /**
     * The consent form has failed to be created
     *
     * @param message the message to be displayed to the user
     */
    @Override
    public void presentFailure(String message) {
        displayFailureMessage.presentFailureMessage(message);
    }

    /**
     * The consent form has been created successfully
     *
     * @param researcherId the ID of the researcher who created the consent form
     * @param message      the message to be displayed to the user
     */
    @Override
    public void presentSuccess(int studyId, int researcherId, String message) {
        fetchStudyLogController.fetchStudyLog(studyId, researcherId);
        displaySuccessMessage.presentGeneralSuccessMessage(message);
    }

    /**
     * Set the display success message.
     *
     * @param displaySuccessMessage the display success message.
     */
    public void setDisplaySuccessMessage(DisplaySuccessMessage displaySuccessMessage) {
        this.displaySuccessMessage = displaySuccessMessage;
    }

    /**
     * Set the display failure message.
     *
     * @param displayFailureMessage the display failure message.
     */
    public void setDisplayFailureMessage(DisplayFailureMessage displayFailureMessage) {
        this.displayFailureMessage = displayFailureMessage;
    }

    /**
     * Set the fetch study log controller.
     *
     * @param fetchStudyLogController the fetch study log controller.
     */
    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }
}
