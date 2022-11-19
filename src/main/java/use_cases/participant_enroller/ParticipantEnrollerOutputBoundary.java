package use_cases.participant_enroller;

/**
 * The output boundary for the participant enroller.
 */
public interface ParticipantEnrollerOutputBoundary {

    /**
     * Presents the enrollment failure.
     * @param participantId The participant id.
     */
    void presentEnrollmentFailure(int participantId);


    /**
     * Presents the enrollment success.
     * @param participantId The participant id.
     * @param groupNumber The group number.
     *
     */
    void presentEnrollmentSuccess(int participantId, int groupNumber);
}
