package UserInterfaceLayer.screens.ParticipantNotEnrolledScreen;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.screens.ControllerManager;

public class ParticipantNotEnrolledInputData {
    private final int participantID;
    private String participantName;
    private ControllerManager controllerManager;

    public ParticipantNotEnrolledInputData(int participantID, String participantName, ControllerManager controllerManager) {
        this.participantID = participantID;
        this.participantName = participantName;
        this.controllerManager = controllerManager;
    }

    public int getParticipantID() {
        return participantID;
    }

    public String getParticipantName() {
        return participantName;
    }

    public ControllerManager getController() {
        return controllerManager;

    }
}
