package user_interface_layer.presenter_manager.display_participant_info;

/**
 * The interface that the presenter calls to display the participant info screen.
 */
public interface DisplayParticipantInfoInterface {
    void displayParticipantInfo(int participantId, String name, int studyId);

    void displayParticipantInfoForQAssignment(int participantId, String name, int studyId, int questionnaireId);
}
