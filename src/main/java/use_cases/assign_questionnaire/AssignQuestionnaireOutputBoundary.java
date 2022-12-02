package use_cases.assign_questionnaire;

public interface AssignQuestionnaireOutputBoundary {

    /**
     * Assign questionnaire to all participants that are enrolled in a study.
     * @param questionnaireID The questionnaire ID.
     * @param studyID The study ID.
     * @param researcherId The researcher ID.
     */
    void assignToAllPresent(int questionnaireID, int studyID, int researcherId);

    /**
     * Present failure message.
     * @param questionnaireID The questionnaire ID.
     * @param studyID The study ID.
     * @param message The failure message.
     */
    void assignToAllFail(int questionnaireID, int studyID, String message);

    /**
     * Assign questionnaire to a group of participants that are enrolled in a study.
     * @param questionnaireID The questionnaire ID.
     * @param studyID The study ID.
     * @param groupName The group name.
     * @param researcherId The researcher ID.
     */
    void assignToGroupPresent(int questionnaireID, int studyID, String groupName, int researcherId);

    /**
     * Present failure to assign to group message.
     * @param questionnaireID The questionnaire ID.
     * @param studyID The study ID.
     * @param groupName The group name.
     * @param message The failure message.
     */
    void assignToGroupFail(int questionnaireID, int studyID, String groupName, String message);

    /**
     * Present the success message of assigning questionnaire to a participant.
     * @param questionnaireID The questionnaire ID.
     * @param studyID The study ID.
     * @param participantID The participant ID.
     * @param researcherId The researcher ID.
     */
    void assignToParticipantPresent(int questionnaireID, int studyID, int participantID, int researcherId);

    /**
     * Present the failure message of assigning questionnaire to a participant.
     * @param questionnaireID The questionnaire ID.
     * @param studyID The study ID.
     * @param participantID The participant ID.
     * @param message The failure message.
     */
    void assignToParticipantFail(int questionnaireID, int studyID, int participantID, String message);

    /**
     * Fetch the participant info to confirm the assignment.
     * @param name              The name of the participant.
     * @param studyId           The ID of the study that the questionnaire has been published to.
     * @param participantId     The ID of the participant that the questionnaire should assign to.
     * @param questionnaireId   The ID of the questionnaire that has been published.
     */
    void fetchParticipantInfoConfirmation(int participantId, String name, int studyId, int questionnaireId);
}
