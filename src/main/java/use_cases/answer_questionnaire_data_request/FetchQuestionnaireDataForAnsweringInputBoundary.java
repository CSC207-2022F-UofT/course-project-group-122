package use_cases.answer_questionnaire_data_request;

/*
 * This the interface that the use case implements and the controller calls on.
 */
public interface FetchQuestionnaireDataForAnsweringInputBoundary {
    void questionnaireRequestData(int modifier, int participantID, int studyId, int questionnaireId);
}