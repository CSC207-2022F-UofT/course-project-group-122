package user_interface_layer.screens.screen_drivers;

import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.register_screens.UserLogInScreen;
import org.jetbrains.annotations.NotNull;

public class SetUpLogInScreenDriver {
    public void requestLogInScreen(@NotNull ScreenManager screenManager, ControllerManager controllerManager) {
        UserLogInScreen userLogInScreen = new UserLogInScreen(controllerManager);
        screenManager.setLogInScreen(userLogInScreen);
        screenManager.disposeCurrentScreen();
        screenManager.updateCurrentScreen(userLogInScreen);
    }
}
