package use_cases.edit_questionnaire;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class EditQuestionnairePresenter implements EditQuestionnaireOutputBoundary {
    DisplayFailureMessageInterface displayFailureMessageInterface;
    DisplaySuccessMessageInterface displaySuccessMessageInterface;
    public void presentFailureScreen(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    public void presentSuccessScreen(int researcherID, int studyID) {
        displaySuccessMessageInterface.presentGeneralSuccessMessage("Questionnaire edited successfully");
    }
}

