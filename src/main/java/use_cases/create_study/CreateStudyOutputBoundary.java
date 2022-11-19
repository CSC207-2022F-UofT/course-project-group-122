package use_cases.create_study;

public interface CreateStudyOutputBoundary {
    void displayFailureMessage(String s);

    void presentCreateStudySuccess(int studyId);
}
