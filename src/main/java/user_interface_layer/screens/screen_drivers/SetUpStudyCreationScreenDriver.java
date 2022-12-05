package user_interface_layer.screens.screen_drivers;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.presenter_manager.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.create_study_inputs_screen.CreateStudyInputInputData;
import user_interface_layer.screens.create_study_inputs_screen.CreateStudyInputScreen;

/**
 * This class is used to display the CreateStudyInputScreen.
 */
public class SetUpStudyCreationScreenDriver {
    /**
     * Displays the CreateStudyInputScreen.
     * @param screenManager The screen manager.
     * @param controllerManager The controller manager.
     * @param userId The ID of the user.
     */
    public void requestStudyCreationScreen(@NotNull ScreenManager screenManager, ControllerManager controllerManager, int userId) {
        CreateStudyInputInputData data = new CreateStudyInputInputData(userId);
        CreateStudyInputScreen screen = new CreateStudyInputScreen(data, controllerManager);
        screenManager.setCreateStudyInputScreen(screen);

    }
}
