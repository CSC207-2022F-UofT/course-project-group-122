package use_cases.participant_enroller;

public class ParticipantEnrollerPresenter implements ParticipantEnrollerOutputBoundary {


    /**
     * Presents the enrollment failure.
     *
     * @param participantId The participant id.
     */
    @Override
    public void presentEnrollmentFailure(int participantId) {
        String failureMessage = "Participant " + participantId + " cannot be enrolled. Please check that the " +
                "participant is eligible to enroll in the study.";

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
    }

    /**
     * Presents the information of a participant
     *
     * @param id   The participant's id.
     * @param name The participant's name.
     */
    @Override
    public void presentParticipantInformation(int id, String name) {

    }
}
