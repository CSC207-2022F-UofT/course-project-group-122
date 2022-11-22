package use_cases.questionnaire_screen_data_request;

public interface FetchQuestionnaireScreenOutputBoundary {
    void presentQuestionnaireScreenData(CheckQuestionnaireInputData data);
    void presentQuestionnaireScreenDataFailure(String message);
}
