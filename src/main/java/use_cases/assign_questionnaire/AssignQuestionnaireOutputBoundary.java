package use_cases.assign_questionnaire;

public interface AssignQuestionnaireOutputBoundary {

    void assignToAllPresent(int questionnaireID, int studyID);

    void assignToAllFail(int questionnaireID, int studyID, String message);

    void assignToGroupPresent(int questionnaireID, int studyID, String groupName);

    void assignToGroupFail(int questionnaireID, int studyID, String groupName, String message);

    void assignToParticipantPresent(int questionnaireID, int studyID, int participantID);

    void assignToParticipantFail(int questionnaireID, int studyID, int participantID, String message);

}
