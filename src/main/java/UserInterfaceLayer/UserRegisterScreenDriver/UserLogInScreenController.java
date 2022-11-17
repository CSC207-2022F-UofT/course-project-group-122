package UserInterfaceLayer.UserRegisterScreenDriver;

import UserInterfaceLayer.ScreenManager;

public class UserLogInScreenController implements FetchUserLogInScreenRequest {

    private ScreenManager screenManager;

    public UserLogInScreenController(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }
    @Override
    public void requestLogInScreen() {
    }
}
