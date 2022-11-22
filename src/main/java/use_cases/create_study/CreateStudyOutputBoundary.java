package use_cases.create_study;

public interface CreateStudyOutputBoundary {

    /**
     * Present the failure to create a study.
     * @param message   The message to present.
     */
    void displayFailureMessage(String message);


    /**
     * Present the success of creating a study.
     * @param studyId   The study ID.
     *
     * @param studyName The study name.
     */
    void presentStudyCreatedSuccessfully(int studyId, String studyName, int researcherId);
}
