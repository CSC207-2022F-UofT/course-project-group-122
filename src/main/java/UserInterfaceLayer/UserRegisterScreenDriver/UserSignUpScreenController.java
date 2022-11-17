package UserInterfaceLayer.UserRegisterScreenDriver;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.screens.ControllerManager;
import UserInterfaceLayer.screens.RegisterScreens.UserSignUpScreen;

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

