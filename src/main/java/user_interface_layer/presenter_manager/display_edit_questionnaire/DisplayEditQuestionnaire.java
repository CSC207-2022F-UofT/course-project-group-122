package user_interface_layer.presenter_manager.display_edit_questionnaire;

import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.edit_questionnaire.EditQuestionnaireScreen;
import use_cases.edit_questionnaire_screen_data.EditQuestionnaireScreenInputData;

public class DisplayEditQuestionnaire implements DisplayEditQuestionnaireInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;


    /**
     * The constructor of the class.
     *
     * @param screenManager    The screen manager.
     * @param controllerManager The controller manager.
     */
    public DisplayEditQuestionnaire(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }

    public void presentEditQuestionnaireScreen(EditQuestionnaireScreenInputData data){
        EditQuestionnaireScreen screen = new EditQuestionnaireScreen(data, controllerManager);
        screenManager.setEditQuestionnaireScreen(screen);
        screenManager.updateCurrentScreen(screen);

}
}
