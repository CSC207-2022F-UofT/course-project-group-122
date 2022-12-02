package user_interface_layer.screens.screen_drivers;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.create_questionnaire_inputs_screen.CreateQuestionnaireInputsScreen;
import user_interface_layer.screens.create_questionnaire_inputs_screen.CreateQuestionnaireInputsScreenInputData;

import java.util.List;

/**
 * This class is used to display the CreateQuestionnaireInputsScreen.
 */
public class SetUpQuestionnaireCreationScreenDriver {
    /**
     * Displays the CreateQuestionnaireInputsScreen.
     * @param screenManager The screen manager.
     * @param controllerManager The controller manager.
     * @param researchId The ID of the researcher.
     * @param studyId The ID of the study.
     * @param groups The groups of the study.
     */
    public void requestQuestionnaireCreationScreen(@NotNull ScreenManager screenManager,
                                                   ControllerManager controllerManager,
                                                   int researchId,
                                                   int studyId,
                                                   List<String> groups) {
        CreateQuestionnaireInputsScreenInputData data = new CreateQuestionnaireInputsScreenInputData(studyId, groups, researchId);
        CreateQuestionnaireInputsScreen screen = new CreateQuestionnaireInputsScreen(data, controllerManager);
        screenManager.setCreateQuestionnaireInputsScreen(screen);
    }
}
