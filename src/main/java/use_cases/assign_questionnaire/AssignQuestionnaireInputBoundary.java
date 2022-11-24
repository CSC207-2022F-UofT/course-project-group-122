package use_cases.assign_questionnaire;


public interface AssignQuestionnaireInputBoundary {

    void assigntoall(int questionnaireID, int studyID);

    void assignToGroup(int questionnaireID, String group, int studyID);

    void assigntoParticipant(int questionnaireID, int participantID, int studyID);
}
