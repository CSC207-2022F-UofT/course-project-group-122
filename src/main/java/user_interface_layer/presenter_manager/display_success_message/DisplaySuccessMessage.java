package user_interface_layer.presenter_manager.display_success_message;

import user_interface_layer.screens.GeneralSuccessScreen;

/**
 * The class that displays a success message.
 */
public class DisplaySuccessMessage implements DisplaySuccessMessageInterface {
    @Override
    public void presentGeneralSuccessMessage(String message) {
        GeneralSuccessScreen screen = new GeneralSuccessScreen(message);
    }


}
