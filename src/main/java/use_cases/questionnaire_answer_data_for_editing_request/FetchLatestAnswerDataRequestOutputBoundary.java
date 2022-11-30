package use_cases.questionnaire_answer_data_for_editing_request;

public interface FetchLatestAnswerDataRequestOutputBoundary {
    void presentLatestAnswerDataRequest(ResearcherEditQuestionnaireScreenAnswersInputData data);
    void presentQuestionnaireNotAnswered(String message);
}
