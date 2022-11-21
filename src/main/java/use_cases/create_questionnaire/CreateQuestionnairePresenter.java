package use_cases.create_questionnaire;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessage;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class CreateQuestionnairePresenter implements CreateQuestionnaireOutputBoundary{
    DisplayFailureMessageInterface displayFailureMessageInterface;
    DisplaySuccessMessageInterface displaySuccessMessageInterface;
    @Override
    public void presentFailureScreen(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    @Override
    public void presentSuccessScreen() {
        displaySuccessMessageInterface.presentGeneralSuccessMessage("Questionnaire created successfully");

    }
}
