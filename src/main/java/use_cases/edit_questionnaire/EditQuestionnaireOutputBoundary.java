package use_cases.edit_questionnaire;

public interface EditQuestionnaireOutputBoundary {
    void presentFailureScreen(String message);
    void presentSuccessScreen(int researcherID, int studyID);
}
