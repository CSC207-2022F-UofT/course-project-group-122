package user_interface_layer.presenter_manager.display_participant_info;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.showParticipantInfo.ShowParticipantInfoScreen;
import user_interface_layer.screens.showParticipantInfo.ShowParticipantInputData;

public class DisplayParticipantInfo implements DisplayParticipantInfoInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;
    public void displayParticipantInfo(ShowParticipantInputData data) {
        ShowParticipantInfoScreen screen = new ShowParticipantInfoScreen(data, controllerManager);
        screenManager.setShowParticipantInfoScreen(screen);
        screenManager.updateCurrentScreen(screen);

    }
}
