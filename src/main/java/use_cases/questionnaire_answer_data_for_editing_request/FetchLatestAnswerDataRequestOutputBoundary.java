package use_cases.questionnaire_answer_data_for_editing_request;

/**
 * The interface that the presenter implements and the use case calls on.
 */
public interface FetchLatestAnswerDataRequestOutputBoundary {
    /**
     * @param data The data that the use case fetched.
     */
    void presentLatestAnswerDataRequest(ResearcherEditQuestionnaireScreenAnswersInputData data);

    /**
     * the method that the use case calls on when the questionnaire has not been answered.
     * @param message The failure message that the use case presents.
     */
    void presentQuestionnaireNotAnswered(String message);
}
