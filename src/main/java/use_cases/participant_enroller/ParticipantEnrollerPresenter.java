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
}
