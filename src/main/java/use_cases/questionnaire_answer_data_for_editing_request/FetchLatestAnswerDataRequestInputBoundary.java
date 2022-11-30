package use_cases.questionnaire_answer_data_for_editing_request;

public interface FetchLatestAnswerDataRequestInputBoundary {

    void fetchLatestAnswerDataRequest(int researcherId, int studyId, int participantId, int questionnaireID);
}
