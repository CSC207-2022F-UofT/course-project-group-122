package use_cases.user_log_out;

import user_interface_layer.presenter_manager.display_register.DisplayRegisterInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

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
     * Log out the user
     */
    @Override
    public void logOut() {
        String message = "You have successfully logged out";
        displaySuccessMessage.presentGeneralSuccessMessage(message);
        displayRegisterInterface.displayRegisterScreen();
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

}
