package use_cases.edit_questionnaire;

/**
 * The controller for the edit questionnaire use case.
 */
public interface EditQuestionnaireOutputBoundary {
    /**
     * Shows the failure screen of the use case.
     * @param message The failure message that the use case presents to the user.
     */
    void presentFailureScreen(String message);

    /**
     * Shows the success screen to the user.
     * @param researcherID The researcher ID of the researcher that edited the questionnaire.
     * @param studyID The study ID of the study that the questionnaire belongs to.
     */
    void presentSuccessScreen(int researcherID, int studyID);
}
