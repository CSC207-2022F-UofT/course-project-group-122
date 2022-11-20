package use_cases.eligibility_checker;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_general_success_message.DisplaySuccessMessageInterface;

public class EligibilityCheckerPresenter implements EligibilityCheckerOutputBoundary {

    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;


    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;

    /**
     * Display the participant is not eligible to be made eligible to participate in the study.
     *
     * @param participantId The participant's id.
     * @param message       The message to display.
     */
    @Override
    public void presentFailure(int participantId, String message) {
        String errorMessage = "Participant " + participantId + " cannot be made eligible to participate in the study: "
                + message;
        displayFailureMessage.presentFailureMessage(errorMessage);
    }

    /**
     * Display the participant is successfully made eligible to participate in the study.
     *
     * @param participantId The participant's id.
     * @param studyId       The study's id.
     */
    @Override
    public void presentSuccess(int participantId, int studyId) {
        String successMessage = "Participant " + participantId + " is successfully made eligible to participate in " +
                "the study " + studyId;
        displaySuccessMessage.presentGeneralSuccessMessage(successMessage);
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
