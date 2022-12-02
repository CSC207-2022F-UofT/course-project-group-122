package user_interface_layer.presenter_manager.display_general_success_message;

import user_interface_layer.screens.GeneralSuccessScreen;

public class DisplayGeneralSuccessMessage implements DisplayGeneralSuccessMessageInterface {
    @Override
    public void presentGeneralSuccessMessage(String message) {
        GeneralSuccessScreen screen = new GeneralSuccessScreen(message);
    }


}
