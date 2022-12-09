package user_interface_layer.presenter_manager.display_participant_info;

/**
 * The interface that the presenter calls to display the participant info screen.
 */
public interface DisplayParticipantInfoInterface {
    /**
     * @param participantId The participant's ID.
     * @param name The participant's name.
     * @param studyId The study ID.
     */
    void displayParticipantInfo(int participantId, String name, int studyId);

    /**
     * @param participantId The participant's ID.
     * @param name The participant's name.
     * @param studyId The study ID.
     * @param questionnaireId The questionnaire ID.
     */
    void displayParticipantInfoForQAssignment(int participantId, String name, int studyId, int questionnaireId);
}
