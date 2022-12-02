package use_cases.edit_questionnaire_screen_data;

/**
 * The interface for the fetching questionnaire use case, that the presenter implements and the use case calls on.
 */
public interface FetchEditQuestionnaireDataOutBoundary {
    /**
     * @param response The response that the use case sends to the presenter.
     */
    void presentEditQuestionnaireScreenData(EditQuestionnaireScreenInputData response);

    /**
     * @param message The failure message that the use case sends to the presenter.
     */
    void presentFailureScreen(String message);
}
