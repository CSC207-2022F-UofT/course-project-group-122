package use_cases.fetch_versioned_answer;

public class FetchVersionedAnswerController {
    FetchVersionedAnswerInputBoundary fetchVersionedAnswerInputBoundary;
    public void fetchVersionedAnswer(int studyId, int participantId, int questionnaireID, int answerID, int version) {
        fetchVersionedAnswerInputBoundary.fetchVersionedAnswer(studyId, participantId, questionnaireID, answerID, version);
    }

    public void setFetchVersionedAnswerInputBoundary(FetchVersionedAnswerInputBoundary fetchVersionedAnswerInputBoundary) {
        this.fetchVersionedAnswerInputBoundary = fetchVersionedAnswerInputBoundary;
    }


}
