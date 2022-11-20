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
    void presentEnrollmentSuccess(int participantId, int groupNumber, int studyId, int userId);

    /**
     * Presents that the ID is not associated with a participant.
     * @param participantId The participant id.
     */
    void displayParticipantIdIsNotParticipant(int participantId);


    /**
     * Presents that the ID does not exist.
     * @param participantId The participant id.
     */
    void displayParticipantIdDoesNotExist(int participantId);


    /**
     * Presents the information of a participant
     *
     * @param id        The participant's id.
     * @param name      The participant's name.
     */
    void presentParticipantInformation(int id, String name);
}
