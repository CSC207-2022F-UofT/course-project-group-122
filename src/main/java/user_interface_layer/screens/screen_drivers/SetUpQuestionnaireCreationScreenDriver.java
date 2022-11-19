package user_interface_layer.screens.screen_drivers;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.create_questionnaire_inputs_screen.CreateQuestionnaireInputsScreen;
import user_interface_layer.screens.create_questionnaire_inputs_screen.CreateQuestionnaireInputsScreenInputData;

public class SetUpQuestionnaireCreationScreenDriver {
    public void requestQuestionnaireCreationScreen(ScreenManager screenManager, ControllerManager controllerManager, int researchId, int studyId) {
        CreateQuestionnaireInputsScreenInputData data = new CreateQuestionnaireInputsScreenInputData(studyId, controllerManager);
        CreateQuestionnaireInputsScreen screen = new CreateQuestionnaireInputsScreen(data);
        screenManager.setCreateQuestionnaireInputsScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }
}
