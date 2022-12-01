package use_cases.edit_questionnaire_screen_data;

/**
 * The controller for the fethcing questionnaire information for editing use case.
 */
public class FetchEditQuestionnaireDataController {
    /**
     * The input boundary of the use case.
     */
    FetchEditQuestionnaireDataInputBoundary fetchEditQuestionnaireDataInputBoundary = new FetchEditQuestionnaireDataInteractor();

    /**
     * The method that calls on the use case through the input boundary.
     * @param researchId The researcher ID of the researcher that is editing the questionnaire.
     * @param studyId The study ID of the study that the questionnaire belongs to.
     * @param questionnaireId The questionnaire ID of the questionnaire that the researcher is editing.
     */
    public void fetchQuestionnaireDataForEditing(int researchId, int studyId, int questionnaireId) {
        fetchEditQuestionnaireDataInputBoundary.fetchEditQuestionnaireData(studyId, researchId, questionnaireId);

    }

    /**
     * The method that sets the input boundary of the controller.
     * @param fetchEditQuestionnaireDataInteractor The input boundary that the use implements.
     */
    public void setFetchEditQuestionnaireDataInteractor(FetchEditQuestionnaireDataInteractor fetchEditQuestionnaireDataInteractor) {
        this.fetchEditQuestionnaireDataInputBoundary = fetchEditQuestionnaireDataInteractor;
    }
}
