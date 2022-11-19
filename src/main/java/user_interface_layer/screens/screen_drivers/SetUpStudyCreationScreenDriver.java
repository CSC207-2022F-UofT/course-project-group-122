package user_interface_layer.screens.screen_drivers;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.create_study_inputs_screen.CreateStudyInputInputData;
import user_interface_layer.screens.create_study_inputs_screen.CreateStudyInputScreen;

public class SetUpStudyCreationScreenDriver {
    public void requestStudyCreationScreen(@NotNull ScreenManager screenManager, ControllerManager controllerManager, int userId) {
        CreateStudyInputInputData data = new CreateStudyInputInputData(userId, controllerManager);
        CreateStudyInputScreen screen = new CreateStudyInputScreen(data);
        screenManager.setCreateStudyInputScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }
}
