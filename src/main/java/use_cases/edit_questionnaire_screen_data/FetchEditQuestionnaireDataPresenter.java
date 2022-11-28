package use_cases.edit_questionnaire_screen_data;

import user_interface_layer.presenter_manager.display_edit_questionnaire.DisplayEditQuestionnaireInterface;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;

public class FetchEditQuestionnaireDataPresenter implements FetchEditQuestionnaireDataOutBoundary{
    DisplayEditQuestionnaireInterface displayEditQuestionnaireInterface;
    DisplayFailureMessageInterface displayFailureMessageInterface;
    @Override
    public void presentEditQuestionnaireScreenData(EditQuestionnaireScreenInputData response) {
        displayEditQuestionnaireInterface.presentEditQuestionnaireScreen(response);
    }

    @Override
    public void presentFailureScreen(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    public void setDisplayEditQuestionnaireInterface(DisplayEditQuestionnaireInterface displayEditQuestionnaireInterface) {
        this.displayEditQuestionnaireInterface = displayEditQuestionnaireInterface;
    }

    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }
}
