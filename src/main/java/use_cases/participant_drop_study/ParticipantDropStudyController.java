package use_cases.participant_drop_study;

/**
 * The screen calls on this controller to drop a participant from a study.
 * This the controller that calls on the use case that drops a participant from a study.
 */
public class ParticipantDropStudyController {

    private ParticipantDropStudyInputBoundary participantDropStudyInteractor;

    /**
     * This method is called when a participant wants to drop a study.
     * @param participantId the id of the participant
     * @param studyId       the id of the study
     */
    public void userDropStudyRequest(int participantId, int studyId) {
        participantDropStudyInteractor.participantDropStudyRequest(participantId, studyId);
    }


    /**
     * Sets the interactor for the controller.
     * @param participantDropStudyInteractor    The interactor for the controller.
     */
    public void setParticipantDropStudyInteractor(ParticipantDropStudyInputBoundary participantDropStudyInteractor) {
        this.participantDropStudyInteractor = participantDropStudyInteractor;
    }
}
