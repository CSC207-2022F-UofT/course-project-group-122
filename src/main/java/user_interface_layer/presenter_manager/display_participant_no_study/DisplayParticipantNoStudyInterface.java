package user_interface_layer.presenter_manager.display_participant_no_study;

/**
 * The interface that the presenter calls to display the screen of a participant who is not in a study.
 */
public interface DisplayParticipantNoStudyInterface {
    /**
     * @param participantId The participant's ID.
     * @param participantNames The participant's name.
     */
    void presentParticipantNoStudyScreen(int participantId, String participantNames);
}
