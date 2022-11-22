package use_cases.fetch_versioned_answer;

public interface FetchVersionedAnswerInputBoundary {
    void fetchVersionedAnswer(int study ,int participantId, int questionnaireID, int answerID, int version);
}
