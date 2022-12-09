package use_cases.researcher_edit_answer;

import java.util.Map;

/**
 * The request model for the use case.
 */
public class ResearcherEditAnswerRequestModel {

    /**
     * The id of the researcher editing the answer.
     */
    private int researcherID;

    /**
     * The id of the answer to edit.
     */
    private final int answerID;

    /**
     * The id of the participant who answered the question.
     */
    private int participantID;

    /**
     * The id of the study that the answer is in.
     */
    private final int studyID;

    /**
     * The new answers to the questions.
     */
    private Map<String, String> answers;

    /**
     * The reason for the modification.
     */
    private final String reason;

    /**
     * The constructor for the request model.
     * @param researcherID The id of the researcher editing the answer.
     * @param participantID The id of the participant who answered the question.
     * @param answerID The id of the answer to edit.
     * @param studyId The id of the study that the answer is in.
     * @param answers The new answers to the questions.
     * @param reason The reason for the modification.
     */
    public ResearcherEditAnswerRequestModel(int researcherID, int participantID, int answerID, int studyId,
                                            Map<String, String> answers, String reason) {
        this.researcherID = researcherID;
        this.answerID = answerID;
        this.participantID = participantID;
        this.studyID = studyId;
        this.answers = answers;
        this.reason = reason;
    }


    /**
     * @param answers The new answers to the questions.
     */
    public void setAnswers(Map<String, String> answers) {
        this.answers = answers;
    }

    /**
     * @param researcherID The id of the researcher editing the answer.
     */
    public void setResearcherID(int researcherID) {
        this.researcherID = researcherID;
    }

    /**
     * @param participantID The id of the participant who answered the question.
     */
    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    /**
     * @return the answers.
     */
    public Map<String, String> getAnswers() {
        return answers;
    }

    /**
     * @return The id of the researcher editing the answer.
     */
    public int getResearcherID() {
        return researcherID;
    }

    /**
     * @return The id of the answer to edit.
     */
    public int getAnswerID() {
        return answerID;
    }

    /**
     * @return The id of the participant who answered the question.
     */
    public int getParticipantID() {
        return participantID;
    }

    /**
     * @return The reason for the modification.
     */
    public String getReason() {
        return reason;
    }

    /**
     * @return The id of the study that the answer is in.
     */
    public int getStudyID() {
        return studyID;
    }
}
