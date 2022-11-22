package user_interface_layer.screens.screen_drivers;

import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.register_screens.UserSignUpScreen;

public class SetUpSignUpScreenDriver {
    public void requestSignUpScreen(ScreenManager screenManager, ControllerManager controllerManager) {
        UserSignUpScreen userSignUpScreen = new UserSignUpScreen(controllerManager);
        screenManager.setSignUpScreen(userSignUpScreen);
        screenManager.disposeCurrentScreen();
        screenManager.updateCurrentScreen(userSignUpScreen);

    }

}
