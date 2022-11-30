package use_cases.questionnaire_answer_data_for_editing_request;

public class FetchLatestAnswerDataRequestController {

    FetchLatestAnswerDataRequestInputBoundary inputBoundary;
    public void fetchQuestionnaireAnswerData(int researcherId, int studyId, int participantId, int questionnaireID) {
        inputBoundary.fetchLatestAnswerDataRequest(researcherId, studyId, participantId, questionnaireID);
    }

    public void setInputBoundary(FetchLatestAnswerDataRequestInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
