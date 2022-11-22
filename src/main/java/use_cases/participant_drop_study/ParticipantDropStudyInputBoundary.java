package use_cases.participant_drop_study;

public interface ParticipantDropStudyInputBoundary {

    /**
     * This method is called when a participant wants to drop a study.
     * @param participantId the id of the participant
     * @param studyId       the id of the study
     */
    void participantDropStudyRequest(int participantId, int studyId);
}
