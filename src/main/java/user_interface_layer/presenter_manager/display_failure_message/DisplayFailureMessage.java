package user_interface_layer.presenter_manager.display_failure_message;

import user_interface_layer.screens.GeneralFailureScreen;

/**
 * The class that displays the failure message screen.
 */
public class DisplayFailureMessage implements DisplayFailureMessageInterface {

    @Override
    public void presentFailureMessage(String message) {
        GeneralFailureScreen screen = new GeneralFailureScreen(message);
    }

}
