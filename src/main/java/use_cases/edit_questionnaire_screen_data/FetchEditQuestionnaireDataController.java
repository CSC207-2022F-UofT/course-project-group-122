package use_cases.edit_questionnaire_screen_data;

public class FetchEditQuestionnaireDataController {
    FetchEditQuestionnaireDataInputBoundary fetchEditQuestionnaireDataInputBoundary = new FetchEditQuestionnaireDataInteractor();
    public void fetchQuestionnaireDataForEditing(int researchId, int studyId, int questionnaireId) {
        fetchEditQuestionnaireDataInputBoundary.fetchEditQuestionnaireData(studyId, researchId, questionnaireId);

    }

}
