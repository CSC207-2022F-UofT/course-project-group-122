package user_interface_layer.screens.screen_drivers;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.register_screens.UserRegisterScreen;
import org.jetbrains.annotations.NotNull;

/**
 * This class is used to display the UserRegisterScreen.
 */
public class SetUpRegisterScreenDriver {
    /**
     * Displays the UserRegisterScreen.
     * @param screenManager The screen manager.
     * @param controllerManager The controller manager.
     */
    public void requestRegisterScreen(@NotNull ScreenManager screenManager, ControllerManager controllerManager) {
        UserRegisterScreen userRegisterScreen = new UserRegisterScreen(controllerManager);
        screenManager.setUserRegisterScreen(userRegisterScreen);
        screenManager.disposeCurrentScreen();
        screenManager.updateCurrentScreen(userRegisterScreen);
    }
}
