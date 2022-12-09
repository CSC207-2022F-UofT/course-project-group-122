package use_cases.researcher_edit_answer;

import java.util.HashMap;

public class ResearcherEditAnswerRequestModel {

    private int researcherID;
    private int answerID;
    private int participantID;
    private final int studyID;
    private HashMap<String, String> answers;

    private String reason;

    public ResearcherEditAnswerRequestModel(int researcherID, int participantID, int answerID, int studyId,
                                            HashMap<String, String> answers, String reason) {
        this.researcherID = researcherID;
        this.answerID = answerID;
        this.participantID = participantID;
        this.studyID = studyId;
        this.answers = answers;
        this.reason = reason;
    }

    public void setAnswers(HashMap<String, String> answers) {
        this.answers = answers;
    }

    public void setResearcherID(int researcherID) {
        this.researcherID = researcherID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public HashMap<String, String> getAnswers() {
        return answers;
    }

    public int getResearcherID() {
        return researcherID;
    }

    public int getAnswerID() {
        return answerID;
    }

    public int getParticipantID() {
        return participantID;
    }

    public String getReason() {
        return reason;
    }

    public int getStudyID() {
        return studyID;
    }
}
