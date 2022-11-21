package use_cases.answer_questionnaire_data_request.answer_questionnaire_data_request;

/*
 * This the interface that the use case implements and the controller calls on.
 */
public interface FetchQuestionnaireDataForAnsweringInputBoundary {

    /**
     * @param studyId
     * @param participantID
     * @param questionnaireId
     */
    void fetchQuestionnaireDataForAnswering(int studyId, int participantID, int questionnaireId);

}
