package user_interface_layer.screens.screen_drivers;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.register_screens.UserRegisterScreen;
import org.jetbrains.annotations.NotNull;

public class SetUpRegisterScreenDriver {
    public void requestRegisterScreen(@NotNull ScreenManager screenManager, ControllerManager controllerManager) {
        UserRegisterScreen userRegisterScreen = new UserRegisterScreen(controllerManager);
        screenManager.setUserRegisterScreen(userRegisterScreen);
        screenManager.updateCurrentScreen(userRegisterScreen);
    }
}
