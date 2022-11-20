package use_cases.eligibility_checker;

public class EligibilityCheckerPresenter implements EligibilityCheckerOutputBoundary {

    /**
     * Display the participant is not eligible to be made eligible to participate in the study.
     *
     * @param participantId The participant's id.
     * @param message       The message to display.
     */
    @Override
    public void presentFailure(int participantId, String message) {
        String errorMessage = "Participant " + participantId + " cannot be made eligible to participate in the study: "
                + message;
    }

    /**
     * Display the participant is successfully made eligible to participate in the study.
     *
     * @param participantId The participant's id.
     * @param studyId       The study's id.
     */
    @Override
    public void presentSuccess(int participantId, int studyId) {
        String successMessage = "Participant " + participantId + " is successfully made eligible to participate in " +
                "the study " + studyId;

    }
}
