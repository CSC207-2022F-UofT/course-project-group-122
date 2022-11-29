package use_cases.assign_questionnaire;

public interface AssignQuestionnaireOutputBoundary {

    void assignToAllPresent(int questionnaireID, int studyID, int researcherId);

    void assignToAllFail(int questionnaireID, int studyID, String message);

    void assignToGroupPresent(int questionnaireID, int studyID, String groupName, int researcherId);

    void assignToGroupFail(int questionnaireID, int studyID, String groupName, String message);

    void assignToParticipantPresent(int questionnaireID, int studyID, int participantID, int researcherId);

    void assignToParticipantFail(int questionnaireID, int studyID, int participantID, String message);

    void fetchParticipantInfoConfirmation(int participantId, String name, int studyId, int questionnaireId);
}
