package use_cases.edit_questionnaire;

/**
 * The controller for the edit questionnaire use case interface, that the use case implements.
 */
public class EditQuestionnaireController {
    /**
     * The use case that the controller calls on.
     */
    private EditQuestionnaireInteractor inputBoundary;

    /**
     * This method calls on the use case that edits a questionnaire.
     * @param data The data that the use case needs to edit the questionnaire.
     */
    public void editQuestionnaire(EditQuestionnaireRequestModel data) {
        inputBoundary.editQuestionnaire(data);
    }

    /**
     * This method sets the Input Boundary of the controller.
     * @param inputBoundary The use case that the controller calls on.
     */
    public void setInputBoundary(EditQuestionnaireInteractor inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}

