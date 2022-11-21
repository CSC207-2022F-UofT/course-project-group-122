package use_cases.questionnaire_screen_data_request.questionnaire_screen_data_request;

import use_cases.questionnaire_screen_data_request.CheckQuestionnaireInputData;

public interface FetchQuestionnaireScreenOutputBoundary {
    void presentQuestionnaireScreenData(CheckQuestionnaireInputData data);
    void presentQuestionnaireScreenDataFailure(String message);
}
