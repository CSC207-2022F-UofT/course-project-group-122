package use_cases.create_questionnaire;

import java.util.ArrayList;
import java.util.List;

public class CreateQuestionnaireController {
    private CreateQuestionnaireInputBoundary inputBoundary;
    public void createQuestionnaire(CreateQuestionnaireRequestModel createQuestionnaireRequestModel) {
        inputBoundary.createQuestionnaire(createQuestionnaireRequestModel);

    }

    public void setInputBoundary(CreateQuestionnaireInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
