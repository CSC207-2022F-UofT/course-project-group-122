package use_cases.participant_drop_study;

public class ParticipantDropStudyController {

    private final ParticipantDropStudyInputBoundary participantDropStudyInteractor = new ParticipantDropStudyInteractor();

    /**
     * This method is called when a participant wants to drop a study.
     * @param participantId the id of the participant
     * @param studyId       the id of the study
     */
    public void userDropStudyRequest(int participantId, int studyId) {
        participantDropStudyInteractor.participantDropStudyRequest(participantId, studyId);
    }
}
