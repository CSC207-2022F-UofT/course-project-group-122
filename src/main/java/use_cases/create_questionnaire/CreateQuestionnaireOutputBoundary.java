package use_cases.create_questionnaire;

public interface CreateQuestionnaireOutputBoundary {
    void presentFailureScreen(String message);

    void presentSuccessScreen();
}
