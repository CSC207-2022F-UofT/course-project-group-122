package use_cases.participant_enroller;

/**
 * The class that the screen calls on to enroll a participant in a study.
 */
public class ParticipantEnrollerController {

    /**
     * The interactor for the use case.
     */
    private ParticipantEnrollerInputBoundary participantEnrollerInteractor;

    /**
     * Enrolls a participant in a study
     * @param participantId the participant's id
     * @param studyId       the study's id
     */
    public void enrollParticipant(int participantId, int studyId, int userId) {
        participantEnrollerInteractor.enroll(participantId, studyId, userId);
    }

    /**
     * Sets the interactor for this controller
     * @param participantEnrollerInteractor the interactor for this controller
     */
    public void setParticipantEnrollerInteractor(ParticipantEnrollerInputBoundary participantEnrollerInteractor) {
        this.participantEnrollerInteractor = participantEnrollerInteractor;
    }



}
