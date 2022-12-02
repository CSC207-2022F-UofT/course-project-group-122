package use_cases.fetch_participant_study_data;

/**
 * The interface that the use case implements and the controller calls on.
 */
interface FetchParticipantStudyDataInputBoundary {


    /**
     * Fetches the study data for a participant.
     * Precondition: the participant is associated with a study.
     * It retrieves a comprehensive list of all the data for the participant, including:
     * - the participant's personal information (name, id etc.)
     * - the participant's study data (study id, study name, study description, group assignment, etc.)
     * - the participant's status in the study (eligibility, enrollment, dropped out)
     * - the questionnaires associated with the participant
     * - the status of the questionnaires (active or closed)
     * - the answers to the questionnaires
     * @param participantId The participant to fetch the study data for.
     * @param userId        The current user.
     */
    void fetchParticipantStudyData(int participantId, int userId);
}
