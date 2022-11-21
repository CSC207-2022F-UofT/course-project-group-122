package user_interface_layer.presenter_manager.display_participant_info;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.showParticipantInfo.ShowParticipantInfoScreen;

public class DisplayParticipantInfo implements DisplayParticipantInfoInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;
    public void displayParticipantInfo(int participantId, String name) {
        ShowParticipantInfoScreen screen = new ShowParticipantInfoScreen(data, controllerManager);
        screenManager.setShowParticipantInfoScreen(screen);
        screenManager.updateCurrentScreen(screen);

    }
}
