package use_cases.close_questionnaire;

/**
 * This the interface that the presenter implements and the interactor calls on.
 */
public interface CloseQuestionnaireOutputBoundary {

    /**
     * This method presents the result of the use case.
     * @param questionnaireID the id of the questionnaire
     * @param studyID        the id of the study
     * @param researcherID  the id of the researcher
     */
    void closePresent(int questionnaireID, int studyID, int researcherID);

    /**
     * This method a failure message to the presenter.
     * @param questionnaireID the id of the questionnaire
     * @param studyID        the id of the study
     * @param message         the reason why the questionnaire cannot be closed
     */
    void closeFail(int questionnaireID, int studyID, String message);
}
