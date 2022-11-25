package use_cases.edit_questionnaire_screen_data;

import user_interface_layer.presenter_manager.display_edit_questionnaire.DisplayEditQuestionnaireInterface;

public class FetchEditQuestionnaireDataPresenter implements FetchEditQuestionnaireDataOutBoundary{
    DisplayEditQuestionnaireInterface displayEditQuestionnaireInterface;
    @Override
    public void presentEditQuestionnaireScreenData(EditQuestionnaireScreenInputData response) {
        displayEditQuestionnaireInterface.presentEditQuestionnaireScreen(response);
    }
}
