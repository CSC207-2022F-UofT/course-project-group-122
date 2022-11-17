package UserInterfaceLayer.screens.ScreenDrivers;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.screens.ControllerManager;
import UserInterfaceLayer.screens.RegisterScreens.UserRegisterScreen;

public class SetUpRegisterScreenDriver {
    public void requestRegisterScreen(ScreenManager screenManager, ControllerManager controllerManager) {
        UserRegisterScreen userRegisterScreen = new UserRegisterScreen(controllerManager);
        screenManager.setUserRegisterScreen(userRegisterScreen);
        screenManager.updateCurrentScreen(userRegisterScreen);
    }
}
