package use_cases.eligibility_checker;

public interface EligibilityCheckerOutputBoundary {

    /**
     * Display the participant is not eligible to be made eligible to participate in the study.
     * @param participantId     The participant's id.
     * @param message           The message to display.
     */
    void presentFailure(int participantId, String message);


    /**
     * Display the participant is successfully made eligible to participate in the study.
     * @param participantId     The participant's id.
     * @param studyId           The study's id.
     */
    void presentSuccess(int participantId, int studyId);
}
