package use_cases.edit_questionnaire;

/**
 * The controller for the edit questionnaire use case interface, that the use case implements.
 */
public interface EditQuestionnaireInputBoundary {
    /**
     * This method calls on the use case that edits a questionnaire.
     * @param data The data that the use case needs to edit the questionnaire.
     */
    void editQuestionnaire(EditQuestionnaireRequestModel data);
}
