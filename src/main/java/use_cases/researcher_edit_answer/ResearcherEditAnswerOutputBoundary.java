package use_cases.researcher_edit_answer;

public interface ResearcherEditAnswerOutputBoundary {
    void presentAnswerEditedSuccessfully(int researcherID, int participantID, int studyId, int answerID);

    void presentDisplayFailureMessage(String message);
}
