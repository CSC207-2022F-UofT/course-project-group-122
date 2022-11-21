package use_cases.answer_questionnaire_data_request.answer_questionnaire_data_request;

public interface FetchQuestionnaireDataForAnswerOutputBoundary {

    void presentFailureScreen(String message);

    void presentQuestionnaireDataForAnswering(ParticipantAnswerQuestionnairePanelInputData data);
}
