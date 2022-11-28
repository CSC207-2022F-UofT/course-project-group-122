package use_cases.edit_questionnaire;

import use_cases.create_questionnaire.CreateQuestionnaireInteractor;

public class EditQuestionnaireController {
    private EditQuestionnaireInputBoundary inputBoundary;
    public void editQuestionnaire(EditQuestionnaireRequestModel data) {
        inputBoundary.editQuestionnaire(data);
    }

    public void setInputBoundary(CreateQuestionnaireInteractor createQuestionnaireInteractor) {
        this.inputBoundary = createQuestionnaireInteractor;
    }
}

