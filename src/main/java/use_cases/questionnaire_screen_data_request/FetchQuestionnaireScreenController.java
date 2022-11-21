package use_cases.questionnaire_screen_data_request;

public class FetchQuestionnaireScreenController {
    private FetchQuestionnaireScreenInputBoundary inputBoundary;
    public void fetchQuestionnaireData(int researchId, int studyId, int questionnaireId) {
        inputBoundary.fetchQuestionnaireData(researchId, studyId, questionnaireId);

    }

    public void setFetchQuestionnaireScreenInteractor(FetchQuestionnaireScreenInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
