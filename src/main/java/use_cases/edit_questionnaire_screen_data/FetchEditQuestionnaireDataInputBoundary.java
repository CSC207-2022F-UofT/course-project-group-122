package use_cases.edit_questionnaire_screen_data;

/**
 * The interface for the fetching questionnaire use case.
 */
public interface FetchEditQuestionnaireDataInputBoundary {
    /**
     * The method that calls on the use case.
     * @param studyId The study ID of the study that the questionnaire belongs to.
     * @param researcherId The researcher ID of the researcher that is editing the questionnaire.
     * @param questionnaireId The questionnaire ID of the questionnaire that the researcher is editing.
     */
    void fetchEditQuestionnaireData(int studyId, int researcherId, int questionnaireId);
}
