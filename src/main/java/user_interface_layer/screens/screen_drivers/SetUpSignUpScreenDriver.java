package user_interface_layer.screens.screen_drivers;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.register_screens.UserSignUpScreen;

public class SetUpSignUpScreenDriver {
    public void requestSignUpScreen(ScreenManager screenManager, ControllerManager controllerManager) {
        UserSignUpScreen userSignUpScreen = new UserSignUpScreen(controllerManager);
        screenManager.setSignUpScreen(userSignUpScreen);
        screenManager.updateCurrentScreen(userSignUpScreen);

    }

}
