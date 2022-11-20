package use_cases.participant_drop_study;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_general_success_message.DisplaySuccessMessageInterface;

public class ParticipantDropStudyPresenter implements ParticipantDropStudyOutputBoundary {


    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;


    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;

    /**
     * Display the error message to the user.
     *
     * @param participantId the id of the participant
     * @param message       the error message
     */
    @Override
    public void displayError(int participantId, String message) {
        String messageToDisplay = "Participant " + participantId + ": " + message;
        displayFailureMessage.presentFailureMessage(messageToDisplay);
    }

    /**
     * Display the success message to the user.
     *
     * @param participantId the id of the participant
     * @param message       the success message
     */
    @Override
    public void displaySuccess(int participantId, String message) {
        String messageToDisplay = "Participant " + participantId + ": " + message + ". \n" +
                "Thank you for your participation!";
        displaySuccessMessage.presentGeneralSuccessMessage(messageToDisplay);
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
