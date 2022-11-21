package user_interface_layer.screens.screen_drivers;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.create_questionnaire_inputs_screen.CreateQuestionnaireInputsScreen;
import user_interface_layer.screens.create_questionnaire_inputs_screen.CreateQuestionnaireInputsScreenInputData;

import java.util.List;

public class SetUpQuestionnaireCreationScreenDriver {
    public void requestQuestionnaireCreationScreen(@NotNull ScreenManager screenManager, ControllerManager controllerManager, int researchId, int studyId, List<String> groups) {
        CreateQuestionnaireInputsScreenInputData data = new CreateQuestionnaireInputsScreenInputData(studyId, groups, researchId);
        CreateQuestionnaireInputsScreen screen = new CreateQuestionnaireInputsScreen(data, controllerManager);
        screenManager.setCreateQuestionnaireInputsScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }
}
