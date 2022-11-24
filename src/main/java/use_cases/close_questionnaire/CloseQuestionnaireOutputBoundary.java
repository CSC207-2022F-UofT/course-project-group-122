package use_cases.close_questionnaire;

public interface CloseQuestionnaireOutputBoundary {

    void closePresent(int questionnaireID, int studyID, int researcherID);

    void closeFail(int questionnaireID, int studyID, String message);
}
