package use_cases.questionnaire_screen_data_request;

/**
 * The interface that the use case implements and the controller calls on
 */
public interface FetchQuestionnaireScreenInputBoundary {
    /**
     * The method in the use case that fetches the data of a questionnaire.
     * @param researchId The researcher ID of the researcher that is requesting the data of a questionnaire.
     * @param studyId The study ID of the study that the questionnaire belongs to.
     * @param questionnaireId The questionnaire ID of the questionnaire that the researcher is requesting the data of.
     */
    void fetchQuestionnaireData(int researchId, int studyId, int questionnaireId);

}
