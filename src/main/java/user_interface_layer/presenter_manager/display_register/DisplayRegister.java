package user_interface_layer.presenter_manager.display_register;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.register_screens.UserRegisterScreen;

public class DisplayRegister implements DisplayRegisterInterface {

    ScreenManager screenManager;

    ControllerManager controllerManager;

    /**
     * Presents the register screen.
     */
    @Override
    public void displayRegisterScreen() {
        UserRegisterScreen screen = new UserRegisterScreen(controllerManager);
        screenManager.setUserRegisterScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }
}
