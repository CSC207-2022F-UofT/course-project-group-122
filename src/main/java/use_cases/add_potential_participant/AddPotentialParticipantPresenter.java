package use_cases.add_potential_participant;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_general_success_message.DisplaySuccessMessageInterface;

public class AddPotentialParticipantPresenter implements AddPotentialParticipantOutputBoundary {

    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;


    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;

    /**
     * Presents the success to add a potential participant to a study.
     * @param participantID The ID of the participant to add.
     * @param studyId       The ID of the study to add the participant to.
     */
    @Override
    public void presentSuccess(int participantID, int studyId) {
        String successMessage = "Participant " + participantID + " has been added to study " + studyId + " as a " +
                "potential participant.";
        displaySuccessMessage.presentGeneralSuccessMessage(successMessage);
    }

    /**
     * Presents the failure to add a potential participant to a study.
     * @param participantID The ID of the participant to add.
     * @param studyId       The ID of the study to add the participant to.
     */
    @Override
    public void presentFailure(int participantID, int studyId) {
        String failureMessage = "Participant " + participantID + " cannot be added to study " + studyId + ". Please " +
                "check that the participant is not already enrolled in any study.";
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
}
