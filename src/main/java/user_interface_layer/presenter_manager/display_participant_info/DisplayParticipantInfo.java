package user_interface_layer.presenter_manager.display_participant_info;

import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.show_participant_info.ShowParticipantInfoScreen;

/**
 * This class is responsible for displaying the participant info screen (a name and a id) when the
 * researcher inputs an id.
 */
public class DisplayParticipantInfo implements DisplayParticipantInfoInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;


    /**
     * The constructor of the class.
     *
     * @param screenManager     The screen manager.
     * @param controllerManager The controller manager.
     */
    public DisplayParticipantInfo(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }


    public void displayParticipantInfo(int participantId, String name, int studyId) {
        ShowParticipantInfoScreen screen = new ShowParticipantInfoScreen(participantId, name, studyId, controllerManager);
        screenManager.setShowParticipantInfoScreen(screen);
        screenManager.updateCurrentScreen(screen);

    }
}
