package user_interface_layer.screens.participant_not_enrolled_screen;

import user_interface_layer.screens.ControllerManager;

public class ParticipantNotEnrolledInputData {

    /*
     * The participant ID.
     */
    private final int participantID;

    /*
     * The participant name.
     */
    private String participantName;

    /*
     * The controller manager.
     */
    private ControllerManager controllerManager;

    /*
     * The constructor of the class.
     */
    public ParticipantNotEnrolledInputData(int participantID, String participantName, ControllerManager controllerManager) {
        this.participantID = participantID;
        this.participantName = participantName;
        this.controllerManager = controllerManager;
    }

    /*
     * Returns the participant ID.
     */
    public int getParticipantID() {
        return participantID;
    }

    /*
     * Returns the participant name.
     */
    public String getParticipantName() {
        return participantName;
    }

    /*
     * Returns the controller manager.
     */
    public ControllerManager getController() {
        return controllerManager;

    }
}
