package user_interface_layer.presenter_manager.display_participant_no_study;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.participant_no_study_screen.ParticipantNoStudyScreen;

public class DisplayParticipantNoStudy implements DisplayParticipantNoStudyInterface {

    ScreenManager screenManager;

    ControllerManager controllerManager;

    public void presentParticipantNoStudyScreen(int participantID, String participantName) {
        ParticipantNoStudyScreen participantNoStudyScreen = new ParticipantNoStudyScreen(participantID, participantName,
                controllerManager);
        screenManager.setParticipantNoStudyScreen(participantNoStudyScreen);
        screenManager.updateCurrentScreen(participantNoStudyScreen);
    }
}