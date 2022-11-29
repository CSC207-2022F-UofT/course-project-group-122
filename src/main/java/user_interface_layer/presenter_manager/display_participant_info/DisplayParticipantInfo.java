package user_interface_layer.presenter_manager.display_participant_info;

import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.show_participant_info.ShowParticipantInfoForQAssignment;
import user_interface_layer.screens.show_participant_info.ShowParticipantInfoScreen;

/**
 * This class is responsible for displaying the participant info screen (a name and an id) when the
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



    @Override
    public void displayParticipantInfo(int participantId, String name, int studyId) {
        ShowParticipantInfoScreen screen = new ShowParticipantInfoScreen(participantId, name, studyId, controllerManager);
        screenManager.setShowParticipantInfoScreen(screen);

    }

    /**
     * Displays the participant info screen for the researcher to confirm the participant.
     * @param participantId     The participant id.
     * @param name              The participant name.
     * @param studyId           The study id.
     * @param questionnaireId   The questionnaire id.
     */
    @Override
    public void displayParticipantInfoForQAssignment(int participantId, String name, int studyId, int questionnaireId) {
        ShowParticipantInfoForQAssignment screen = new ShowParticipantInfoForQAssignment(participantId, name, studyId,
                questionnaireId, controllerManager);
        screenManager.setShowParticipantInfoForQAssignmentScreen(screen);
    }


}
