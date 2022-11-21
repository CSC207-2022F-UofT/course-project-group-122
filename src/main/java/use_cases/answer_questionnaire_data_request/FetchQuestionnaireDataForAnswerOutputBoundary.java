package use_cases.answer_questionnaire_data_request;

import use_cases.answer_questionnaire_data_request.FetchQuestionnaireDataForAnswerResponseModel;

public interface FetchQuestionnaireDataForAnswerOutputBoundary {

    void presentFailureScreen(String message);

    void presentQuestionnaireDataForAnswering(FetchQuestionnaireDataForAnswerResponseModel data);
}
