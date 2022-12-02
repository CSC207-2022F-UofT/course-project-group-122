package use_cases.participant_enroller;

import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class ParticipantEnrollerPresenter implements ParticipantEnrollerOutputBoundary {



    /**
     * The controller for study log display.
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
    public void presentEnrollmentSuccess(int participantId, int groupNumber, int studyId, int userId) {
        String successMessage = "Participant " + participantId + " has been enrolled in group " + groupNumber + ".";
        fetchStudyLogController.fetchStudyLog(studyId, userId);
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
     * Sets the controller for study log display.
     *
     * @param fetchStudyLogController The controller.
     */
    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }
}
