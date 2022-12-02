package use_cases.questionnaire_screen_data_request;

/**
 * The class that the screen calls on to fetch the data of a questionnaire.
 */
public class FetchQuestionnaireScreenController {
    /**
     * The use case that the controller calls on to fetch the data of a questionnaire.
     */
    private FetchQuestionnaireScreenInputBoundary inputBoundary;

    /**
     * Calls on the method in the use case to fetch the data of a questionnaire.
     * @param researchId The researcher ID of the researcher that is requesting the data of a questionnaire.
     * @param studyId The study ID of the study that the questionnaire belongs to.
     * @param questionnaireId The questionnaire ID of the questionnaire that the researcher is requesting the data of.
     */
    public void fetchQuestionnaireData(int researchId, int studyId, int questionnaireId) {
        inputBoundary.fetchQuestionnaireData(researchId, studyId, questionnaireId);

    }

    /**
     * Sets the Input Boundary of the controller.
     * @param inputBoundary The use case that the controller calls on to fetch the data of a questionnaire.
     */
    public void setFetchQuestionnaireScreenInteractor(FetchQuestionnaireScreenInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
