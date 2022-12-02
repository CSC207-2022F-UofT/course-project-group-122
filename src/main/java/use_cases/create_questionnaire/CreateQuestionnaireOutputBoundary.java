package use_cases.create_questionnaire;
/**
 * This interface is used to present the output of the CreateQuestionnaire use case.
 */
public interface CreateQuestionnaireOutputBoundary {
    /**
     * This method presents the failure output of the CreateQuestionnaire use case.
     * @param message The failure message to be displayed to the user.
     */
    void presentFailureScreen(String message);

    /** This method presents the success output of the CreateQuestionnaire use case.
     * @param researcherId The researcher ID of the researcher who created the questionnaire.
     * @param studyId The study ID of the study that the questionnaire belongs to.
     */
    void presentSuccessScreen(int researcherId, int studyId);

}
