package use_cases.user_log_out;

import user_interface_layer.presenter_manager.display_register.DisplayRegisterInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;
import user_interface_layer.screens.ControllerManager;

/**
 * The presenter that the use case calls on.
 */
public class UserLogOutPresenter implements UserLogOutOutputBoundary {


    /**
     * The display register interface.
     */
    DisplayRegisterInterface displayRegisterInterface;

    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;


    /**
     * Controller manager
     */
    private ControllerManager controllerManager;

    /**
     * Log out the user
     */
    @Override
    public void logOut() {
        String message = "You have successfully logged out";
        controllerManager.setCurrentUserId(-1);
        displayRegisterInterface.displayRegisterScreen();
        displaySuccessMessage.presentGeneralSuccessMessage(message);
    }


    /**
     * Presents the success to add a potential participant to a study.
     * @param displaySuccessMessage The presenter to display the success message.
     */
    public void setDisplaySuccessMessage(DisplaySuccessMessageInterface displaySuccessMessage) {
        this.displaySuccessMessage = displaySuccessMessage;
    }


    /**
     * Presents the register screen.
     * @param displayRegisterInterface  The presenter to display the register screen.
     */
    public void setDisplayRegisterInterface(DisplayRegisterInterface displayRegisterInterface) {
        this.displayRegisterInterface = displayRegisterInterface;
    }


    /**
     * Set the controller manager.
     * @param controllerManager The controller manager.
     */
    public void setControllerManager(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

}
