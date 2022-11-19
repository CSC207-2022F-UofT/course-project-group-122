package user_interface_layer.user_register_screen_driver;

import user_interface_layer.ScreenManager;

public class UserLogInScreenController implements FetchUserLogInScreenRequest {

    private ScreenManager screenManager;

    public UserLogInScreenController(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }
    @Override
    public void requestLogInScreen() {
    }
}
