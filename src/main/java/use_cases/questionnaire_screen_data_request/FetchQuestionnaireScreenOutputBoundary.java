package use_cases.questionnaire_screen_data_request;

/**
 * The interface that the presenter implements and the use case calls on.
 */
public interface FetchQuestionnaireScreenOutputBoundary {
    /**
     * The method that presents the data to the screen.
     * @param data The data that the use case fetched.
     */
    void presentQuestionnaireScreenData(CheckQuestionnaireInputData data);

    /**
     * The method that presents the failure message to the screen.
     * @param message The failure message that the use case presents.
     */
    void presentQuestionnaireScreenDataFailure(String message);
}
