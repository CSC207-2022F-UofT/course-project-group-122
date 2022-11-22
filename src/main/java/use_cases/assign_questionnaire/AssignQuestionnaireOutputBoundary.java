package use_cases.assign_questionnaire;

public interface AssignQuestionnaireOutputBoundary {

    void assigntoallpresent(int questionnaireID, int studyID);

    void assigntoallfail(int questionnaireID, int studyID, String message);

    void assigntogrouppresent(int questionnaireID, int studyID, String groupName);

    void assigntogroupfail(int questionnaireID, int studyID, String groupName, String message);

    void assigntoparticipantpresent(int questionnaireID, int studyID, int participantID);

    void assigntoparticipantfail(int questionnaireID, int studyID, int participantID, String message);

}
