package user_interface_layer.user_register_screen_driver;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.register_screens.UserSignUpScreen;

public class UserSignUpScreenController implements FetchUserSignUpScreenRequest {
    private final ControllerManager controllerManager;
    private ScreenManager screenManager;

    public UserSignUpScreenController(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }
    @Override
    public void requestSignUpScreen() {
        if (screenManager.getCurrentScreen() != null) {
            screenManager.getCurrentScreen().dispose();
        }
        UserSignUpScreen screen = new UserSignUpScreen(this.controllerManager);

    }
}

