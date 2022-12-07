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
     * Enrolls a participant in a study, where the study is a ranomized study
     * @param participantId the participant's id
     * @param studyId       the study's id
     */
    public void enrollRandomizedParticipant(int participantId, int studyId, int userId) {
        participantEnrollerInteractor.enroll(participantId, studyId, userId);
    }



    /**
     * Enrolls a participant in a study, where the study is a general study
     * @param participantId the participant's id
     * @param studyId       the study's id
     * @param group         the group number
     * @param userId        the user's id
     */
    public void enrollGeneralParticipant(int participantId, int studyId, int group, int userId) {
        participantEnrollerInteractor.enroll(participantId, studyId, group, userId);
    }




    /**
     * Sets the interactor for this controller
     * @param participantEnrollerInteractor the interactor for this controller
     */
    public void setParticipantEnrollerInteractor(ParticipantEnrollerInputBoundary participantEnrollerInteractor) {
        this.participantEnrollerInteractor = participantEnrollerInteractor;
    }



}
