package user_interface_layer.screens.screen_drivers;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.register_screens.UserSignUpScreen;

/**
 * This class is used to display the UserSignUpScreen.
 */
public class SetUpSignUpScreenDriver {
    /**
     * @param screenManager The screen manager.
     * @param controllerManager The controller manager.
     */
    public void requestSignUpScreen(ScreenManager screenManager, ControllerManager controllerManager) {
        UserSignUpScreen userSignUpScreen = new UserSignUpScreen(controllerManager);
        screenManager.setSignUpScreen(userSignUpScreen);
        screenManager.disposeCurrentScreen();
        screenManager.updateCurrentScreen(userSignUpScreen);

    }

}
