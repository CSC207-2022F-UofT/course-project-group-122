package use_cases.fetch_versioned_answer;

/**
 * The input boundary for the FetchVersionedAnswer use case.
 */
public interface FetchVersionedAnswerInputBoundary {
    /**
     * Fetch the versioned answer.
     * @param study The study ID.
     * @param participantId The participant ID.
     * @param questionnaireID The questionnaire ID.
     * @param answerID The answer ID.
     * @param version The version of the answer.
     */
    void fetchVersionedAnswer(int study ,int participantId, int questionnaireID, int answerID, int version);
}
