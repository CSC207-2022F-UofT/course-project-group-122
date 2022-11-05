package use_cases.participant_enroller;

public class ParticipantEnrollerInteractor implements ParticipantEnrollerInputBoundary {

    private ParticipantEnrollerOutputBoundary participantEnrollerPresenter;

    public ParticipantEnrollerInteractor(ParticipantEnrollerOutputBoundary presenter) {
        this.presenter = presenter;
    }

    public void enrollParticipant() {
        presenter.presentEnrollment();
    }


    /**
     * Enrolls a participant.
     * Enrolls a participant without specifying the participant's group.
     * If the type of the study is "Randomized", the participant will be assigned to a group at random.
     * If the type of the study is "General", the participant will be assigned to the default group, which is Group 1.
     * A participant can only be enrolled in a study if the study is open for enrollment.
     * A participant can only be enrolled in a study if the participant is not already enrolled in the study.
     * A participant can only be enrolled in a study if the participant is eligible for the study.
     * <p>
     * This method is overloaded.
     *
     * @param participant The participant to enroll.
     * @param study       The study to enroll the participant in.
     * @return a success or failure message to be presented to the researcher. It also contains the participant's group.
     */
    @Override
    public ParticipantEnrollerOutputBoundary enrollParticipant(Participant participant, Study study) {
        return null;
    }


    /**
     * Enrolls a participant.
     * Enrolls a participant and specifies the participant's group. This is only called when the type of the study is
     * "General". If the type of the study is "Randomized", then a failure is returned.
     * A participant can only be enrolled in a study if the study is open for enrollment.
     * A participant can only be enrolled in a study if the participant is not already enrolled in the study.
     * A participant can only be enrolled in a study if the participant is eligible for the study.
     * A participant can be enrolled only if the specified group is within the defined groups of the study.
     * <p>
     * This method is overloaded.
     *
     * @param participant The participant to enroll.
     * @param study       The study to enroll the participant in.
     * @param group       The group number to enroll the participant in.
     * @return a success or failure message to be presented to the researcher. It also contains the participant's group.
     */
    @Override
    public ParticipantEnrollerOutputBoundary enrollParticipant(Participant participant, Study study, int group) {
        return null;
    }


    private boolean isParticipantEligible(Participant participant, Study study) {

}
