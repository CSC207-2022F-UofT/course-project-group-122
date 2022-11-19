package user_interface_layer.presenter_manager.display_edit_questionnaire;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.edit_questionnaire.EditQuestionnaireScreen;
import user_interface_layer.screens.edit_questionnaire.EditQuestionnaireScreenInputData;

public class DisplayEditQuestionnaire implements DisplayEditQuestionnaireInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;
    public void presentEditQuestionnaireScreen(EditQuestionnaireScreenInputData data){
        EditQuestionnaireScreen screen = new EditQuestionnaireScreen(data, controllerManager);
        screenManager.setEditQuestionnaireScreen(screen);
        screenManager.updateCurrentScreen(screen);

}
}
