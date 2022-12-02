package use_cases.questionnaire_answer_data_for_editing_request;

/**
 * The interface that the use case implements and the controller calls on.
 */
public interface FetchLatestAnswerDataRequestInputBoundary {

    /**
     * The method in the use case that fetches the latest answer data for the researcher to edit.
     * @param researcherId The researcher ID of the researcher that is fetching the latest answer data of a questionnaire.
     * @param studyId The study ID of the study that the questionnaire belongs to.
     * @param participantId The participant ID of the participant that answered the questionnaire.
     * @param questionnaireID The questionnaire ID of the questionnaire that the participant answered.
     */
    void fetchLatestAnswerDataRequest(int researcherId, int studyId, int participantId, int questionnaireID);
}
