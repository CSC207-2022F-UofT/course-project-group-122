package use_cases.participant_enroller;

public class ParticipantEnrollerController {

    private ParticipantEnrollerInputBoundary participantEnrollerInteractor;

    /**
     * Enrolls a participant in a study
     * @param participantId the participant's id
     * @param studyId       the study's id
     */
    public void enrollParticipant(int participantId, int studyId) {
        participantEnrollerInteractor.enroll(participantId, studyId);
    }

    /**
     * Sets the interactor for this controller
     * @param participantEnrollerInteractor the interactor for this controller
     */
    public void setParticipantEnrollerInteractor(ParticipantEnrollerInputBoundary participantEnrollerInteractor) {
        this.participantEnrollerInteractor = participantEnrollerInteractor;
    }



}
