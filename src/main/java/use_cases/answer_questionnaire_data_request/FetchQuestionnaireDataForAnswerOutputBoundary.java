package use_cases.answer_questionnaire_data_request;

public interface FetchQuestionnaireDataForAnswerOutputBoundary {

    /**
     * The method that the use case calls on to present a failure message to the user.
     *
     * @param message The failure message.
     */
    void presentFailureScreen(String message);

    /**
     * This method is called on by the use case to present the data to the user.
     * @param data The data that the use case fetched from the database.
     */

    void presentQuestionnaireDataForAnswering(FetchQuestionnaireDataForAnswerResponseModel data, String type);
}
