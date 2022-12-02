package use_cases.fetch_versioned_answer;

/**
 * The controller that the screen calls to fetch a versioned answer.
 */
public class FetchVersionedAnswerController {
    /**
     * The interface that the use case implements and the controller calls on.
     */
    FetchVersionedAnswerInputBoundary fetchVersionedAnswerInputBoundary;

    /**
     * The use case that fetches a versioned answer.
     * @param studyId          The study ID.
     * @param participantId    The participant ID.
     * @param questionnaireID The questionnaire ID.
     * @param answerID        The answer ID.
     * @param version        The version of the answer.
     */
    public void fetchVersionedAnswer(int studyId, int participantId, int questionnaireID, int answerID, int version) {
        fetchVersionedAnswerInputBoundary.fetchVersionedAnswer(studyId, participantId, questionnaireID, answerID, version);
    }

    /**
     * Sets the Input Boundary of the controller.
     * @param fetchVersionedAnswerInputBoundary The interface that the use case implements and the controller calls on.
     */
    public void setFetchVersionedAnswerInputBoundary(FetchVersionedAnswerInputBoundary fetchVersionedAnswerInputBoundary) {
        this.fetchVersionedAnswerInputBoundary = fetchVersionedAnswerInputBoundary;
    }


}
