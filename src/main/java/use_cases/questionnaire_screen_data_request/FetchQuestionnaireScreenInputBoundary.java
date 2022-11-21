package use_cases.questionnaire_screen_data_request;

public interface FetchQuestionnaireScreenInputBoundary {
    void fetchQuestionnaireData(int researchId, int studyId, int questionnaireId);

}
