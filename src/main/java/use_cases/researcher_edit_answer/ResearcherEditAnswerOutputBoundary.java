package use_cases.researcher_edit_answer;

/**
 * The interface that the presenter implements and the use case calls on.
 */
public interface ResearcherEditAnswerOutputBoundary {
    /**
     * Display that the answer was successfully edited.
     * @param researcherID The id of the researcher editing the answer.
     * @param participantID The id of the participant who answered the question.
     * @param studyId The id of the study that the answer is in.
     * @param answerID The id of the answer to edit.
     */
    void presentAnswerEditedSuccessfully(int researcherID, int participantID, int studyId, int answerID);

    /**
     * @param message The failure message to display.
     */
    void presentDisplayFailureMessage(String message);
}
