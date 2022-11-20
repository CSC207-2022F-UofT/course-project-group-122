package use_cases.participant_drop_study;

public class ParticipantDropStudyPresenter implements ParticipantDropStudyOutputBoundary {

    /**
     * Display the error message to the user.
     *
     * @param participantId the id of the participant
     * @param message       the error message
     */
    @Override
    public void displayError(int participantId, String message) {
        String messageToDisplay = "Participant " + participantId + ": " + message;
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

    }
}
