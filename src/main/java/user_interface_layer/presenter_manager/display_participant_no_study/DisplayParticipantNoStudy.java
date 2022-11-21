package user_interface_layer.presenter_manager.display_participant_no_study;

import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.participant_no_study_screen.ParticipantNoStudyScreen;

/**
 * The displays the screen of a participant who is not in a study.
 */
public class DisplayParticipantNoStudy implements DisplayParticipantNoStudyInterface {

    ScreenManager screenManager;

    ControllerManager controllerManager;


    /**
     * The constructor of the class.
     *
     * @param screenManager         The screen manager.
     * @param controllerManager     The controller manager.
     */
    public DisplayParticipantNoStudy(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }


    public void presentParticipantNoStudyScreen(int participantID, String participantName) {
        ParticipantNoStudyScreen participantNoStudyScreen = new ParticipantNoStudyScreen(participantID, participantName,
                controllerManager);
        screenManager.setParticipantNoStudyScreen(participantNoStudyScreen);
        screenManager.updateCurrentScreen(participantNoStudyScreen);
    }
}