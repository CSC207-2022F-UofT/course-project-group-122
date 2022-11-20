package use_cases.participant_drop_study;

public interface ParticipantDropStudyOutputBoundary {

    /**
     * Display the error message to the user.
     * @param participantId the id of the participant
     * @param message       the error message
     */
    void displayError(int participantId, String message);


    /**
     * Display the success message to the user.
     * @param participantId the id of the participant
     * @param message       the success message
     */
    void displaySuccess(int participantId, String message);


    void showParticipantDroppedOffStudy(int participantId, int userId);
}
