package use_cases.edit_questionnaire_screen_data;

public interface FetchEditQuestionnaireDataInputBoundary {
    void fetchEditQuestionnaireData(int studyId, int researcherId, int questionnaireId);
}
