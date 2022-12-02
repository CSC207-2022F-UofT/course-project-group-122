package use_cases.create_questionnaire;

import java.util.ArrayList;
import java.util.List;

/**
 * The controller for the create questionnaire use case, that the screen calls on.
 */
public class CreateQuestionnaireController {
    private CreateQuestionnaireInputBoundary inputBoundary;
    public void createQuestionnaire(CreateQuestionnaireRequestModel createQuestionnaireRequestModel) {
        inputBoundary.createQuestionnaire(createQuestionnaireRequestModel);

    }

    public void setInputBoundary(CreateQuestionnaireInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
