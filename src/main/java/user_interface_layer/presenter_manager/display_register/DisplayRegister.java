package user_interface_layer.presenter_manager.display_register;

import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.register_screens.UserRegisterScreen;

/**
 * The class that displays the register screen.
 */
public class DisplayRegister implements DisplayRegisterInterface {

    ScreenManager screenManager;

    ControllerManager controllerManager;


    /**
     * The constructor of the class.
     *
     * @param screenManager         The screen manager.
     * @param controllerManager     The controller manager.
     */
    public DisplayRegister(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }



    /**
     * Presents the register screen.
     */
    @Override
    public void displayRegisterScreen() {
        UserRegisterScreen screen = new UserRegisterScreen(controllerManager);
        screenManager.setUserRegisterScreen(screen);
        screenManager.disposeCurrentScreen();
        screenManager.updateCurrentScreen(screen);
    }
}
