package use_cases.edit_questionnaire_screen_data;

/**
 * The interface for the fetching questionnaire use case, that the presenter implements and the use case calls on.
 */
public interface FetchEditQuestionnaireDataOutBoundary {
    void presentEditQuestionnaireScreenData(EditQuestionnaireScreenInputData response);

    void presentFailureScreen(String message);
}
