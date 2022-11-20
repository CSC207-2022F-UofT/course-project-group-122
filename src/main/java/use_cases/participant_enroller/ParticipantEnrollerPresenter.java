package use_cases.participant_enroller;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_general_success_message.DisplaySuccessMessageInterface;

public class ParticipantEnrollerPresenter implements ParticipantEnrollerOutputBoundary {

    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;


    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;


    /**
     * Presents the enrollment failure.
     *
     * @param participantId The participant id.
     */
    @Override
    public void presentEnrollmentFailure(int participantId) {
        String failureMessage = "Participant " + participantId + " cannot be enrolled. Please check that the " +
                "participant is eligible to enroll in the study.";
        displayFailureMessage.presentFailureMessage(failureMessage);
    }

    /**
     * Presents the enrollment success.
     *
     * @param participantId The participant id.
     * @param groupNumber   The group number.
     */
    @Override
    public void presentEnrollmentSuccess(int participantId, int groupNumber) {
        String successMessage = "Participant " + participantId + " has been enrolled in group " + groupNumber + ".";
        displaySuccessMessage.presentGeneralSuccessMessage(successMessage);
    }

    /**
     * Presents that the ID is not associated with a participant.
     *
     * @param participantId The participant id.
     */
    @Override
    public void displayParticipantIdIsNotParticipant(int participantId) {
        String failureMessage = "Participant " + participantId + " is not a participant. Please check that the " +
                "ID is correct.";
        displayFailureMessage.presentFailureMessage(failureMessage);
    }

    /**
     * Presents that the ID does not exist.
     *
     * @param participantId The participant id.
     */
    @Override
    public void displayParticipantIdDoesNotExist(int participantId) {
        String failureMessage = "Participant " + participantId + " does not exist. Please check that the " +
                "ID is correct.";
        displayFailureMessage.presentFailureMessage(failureMessage);
    }

    /**
     * Presents the information of a participant
     *
     * @param id   The participant's id.
     * @param name The participant's name.
     */
    @Override
    public void presentParticipantInformation(int id, String name) {
        //TODO: implement the screen to display the participant information.
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
