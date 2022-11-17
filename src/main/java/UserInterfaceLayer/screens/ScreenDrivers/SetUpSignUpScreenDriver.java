package UserInterfaceLayer.screens.ScreenDrivers;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.screens.ControllerManager;
import UserInterfaceLayer.screens.RegisterScreens.UserSignUpScreen;

public class SetUpSignUpScreenDriver {
    public void requestSignUpScreen(ScreenManager screenManager, ControllerManager controllerManager) {
        UserSignUpScreen userSignUpScreen = new UserSignUpScreen(controllerManager);
        screenManager.setSignUpScreen(userSignUpScreen);
        screenManager.updateCurrentScreen(userSignUpScreen);

    }

}
