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
     * @param groupName     the group name
     * @param userId        the user's id
     */
    public void enrollGeneralParticipant(int participantId, int studyId, String groupName, int userId) {
        participantEnrollerInteractor.enroll(participantId, studyId, groupName, userId);
    }




    /**
     * Sets the interactor for this controller
     * @param participantEnrollerInteractor the interactor for this controller
     */
    public void setParticipantEnrollerInteractor(ParticipantEnrollerInputBoundary participantEnrollerInteractor) {
        this.participantEnrollerInteractor = participantEnrollerInteractor;
    }



}
