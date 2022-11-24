package use_cases.close_questionnaire;

public interface CloseQuestionnaireOutputBoundary {

    void closepresent(int questionnaireID, int studyID);

    void closefail(int questionnaireID, int studyID, String message);
}
