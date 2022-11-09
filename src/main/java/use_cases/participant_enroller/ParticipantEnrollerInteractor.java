package use_cases.participant_enroller;

import org.jetbrains.annotations.NotNull;


/**
 * Use case layer.
 * <p>
 * This is the ParticipantEnroller use case interactor. The interactor enrolls a participant in a study based on the
 * eligibility of the participant to the particular study and the type of study to assign the participant to a certain
 * group. The group is either automatically assigned in a Randomized Study or manually assigned by the researcher in a
 * General study.
 * <p>
 * The interactor does not manipulate the eligibility of the participant to the study. It uses the eligibility of the
 * participant to the study to determine if a participant is able to be enrolled in a study.
 */
public class ParticipantEnrollerInteractor implements ParticipantEnrollerInputBoundary {

    private final ParticipantEnrollerOutputBoundary participantEnrollerPresenter;

    public ParticipantEnrollerInteractor(ParticipantEnrollerOutputBoundary participantEnrollerPresenter) {
        this.participantEnrollerPresenter = participantEnrollerPresenter;
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
        if (enrollable(participant, study)) {
            if (study.getType().equals("Randomized")) {
                int group = RandomGroupGenerator.generateRandomGroup(study, participant);
                participant.setGroup(group);
            } else {
                participant.setGroup(1);
            }
            study.removePotentialParticipant(participant);
            study.addParticipant(participant);
            participant.enroll();
            return participantEnrollerPresenter.presentSuccess("Successfully enrolled participant to " +
                    "(" + String.valueOf(study.getId) + ") " + study.getStudyName(), 
                    participant.getId(),
                    participant.getGroup());
        } else {
            return participantEnrollerPresenter.presentFailure("Cannot enroll the participant into the study. " +
                    "Please ensure that the study is open for enrollment, the participant is eligible for the study, " +
                    "and the participant is not already enrolled in another study.", participant.getId());
        }
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
     * TODO: Implement this method.
     */
    @Override
    public ParticipantEnrollerOutputBoundary enrollParticipant(Participant participant,
                                                               @NotNull Study study,
                                                               int group) {
        if (study.getType().equals("Randomized")) {
            return participantEnrollerPresenter.presentFailure();
        } else {
            if (enrollable(participant, study)) {
                if (1 <= group && group <= study.getNumGroups()) {
                    participant.setGroup(group);
                    study.removePotentialParticipant(participant);
                    study.addParticipant(participant);
                    participant.enroll();
                    return participantEnrollerPresenter.presentSuccess();
                } else {
                    return participantEnrollerPresenter.presentFailure();
                }
            } else {
                return participantEnrollerPresenter.presentFailure();
            }
        }
    }


    /**
     * Checks the eligibility of a participant for this study.
     * This is a private helper method.
     *
     * @param participant   The participant to check the eligibility of.
     * @param study         The study to check the eligibility of the participant for.
     * @return true if the participant is eligible for the study, false otherwise.
     */
    private boolean isParticipantEligible(@NotNull Participant participant, Study study) {
        return participant.getStudy() == study && participant.isEligible();
    }


    /**
     * Checks if the participant is able to be enrolled in the study.
     * This is a private helper method.
     * <p>
     * A participant can only be enrolled if and only if:
     * - the study is open for enrollment, i.e. the study is active
     * - the participant is not already enrolled in the study
     * - the participant is included in the collection of potential participants of the study
     * - the participant is eligible for the study
     *
     * @param participant   The participant to check if they are enrolled in the study.
     * @param study         The study to check if the participant is able to be enrolled in.
     * @return true if the participant can be enrolled in the study, false otherwise.
     */
    private boolean enrollable(Participant participant, @NotNull Study study) {
        return study.isActive() &&
                !study.getParticipants().contains(participant) &&
                !participant.isEnrolled() &&
                study.getPotentialParticipants().contains(participant) &&
                isParticipantEligible(participant, study);
    }


}
