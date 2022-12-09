package user_interface_layer.screens.screen_drivers;

import user_interface_layer.presenter_manager.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.register_screens.UserLogInScreen;
import org.jetbrains.annotations.NotNull;

/**
 * This class is used to display the UserLogInScreen.
 */
public class SetUpLogInScreenDriver {
    /**
     * @param screenManager The screen manager.
     * @param controllerManager The controller manager.
     */
    public void requestLogInScreen(@NotNull ScreenManager screenManager, ControllerManager controllerManager) {
        UserLogInScreen userLogInScreen = new UserLogInScreen(controllerManager);
        screenManager.setLogInScreen(userLogInScreen);
        screenManager.disposeCurrentScreen();
        screenManager.updateCurrentScreen(userLogInScreen);
    }
}
