package UserInterfaceLayer.screens.ScreenDrivers;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.screens.ControllerManager;
import UserInterfaceLayer.screens.RegisterScreens.UserLogInScreen;

public class SetUpLogInScreenDriver {
    public void requestLogInScreen(ScreenManager screenManager, ControllerManager controllerManager) {
        UserLogInScreen userLogInScreen = new UserLogInScreen(controllerManager);
        screenManager.setLogInScreen(userLogInScreen);
        screenManager.updateCurrentScreen(userLogInScreen);
    }
}
