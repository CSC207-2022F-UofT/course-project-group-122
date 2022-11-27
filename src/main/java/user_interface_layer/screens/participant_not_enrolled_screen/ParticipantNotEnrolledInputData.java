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
    private final String participantName;

    /*
     * The constructor of the class.
     */
    public ParticipantNotEnrolledInputData(int participantID, String participantName) {
        this.participantID = participantID;
        this.participantName = participantName;
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

}
