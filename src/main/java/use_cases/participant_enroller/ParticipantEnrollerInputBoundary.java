package use_cases.participant_enroller;

/**
 * The input boundary for the participant enroller use case.
 * Defines the input interface for the participant enroller use case.
 */
public interface ParticipantEnrollerInputBoundary {

    /**
     * Enrolls a participant.
     * Automatically assigns the participant to the questionnaires that is designed for this group.
     * Enrolls a participant without specifying the participant's group.
     * If the type of the study is "Randomized", the participant will be assigned to a group at random.
     * If the type of the study is "General", the participant will be assigned to the default group, which is Group 1.
     * A participant can only be enrolled in a study if the study is open for enrollment.
     * A participant can only be enrolled in a study if the participant is not already enrolled in the study.
     * A participant can only be enrolled in a study if the participant is eligible for the study.
     * <p>
     * This method is overloaded.
     *
     * @param participantId   The participant to enroll.
     * @param studyId         The study to enroll the participant in.
     */
    void enroll(int participantId, int studyId);


    /**
     * Enrolls a participant.
     * Automatically assigns the participant to the questionnaires that is designed for this group.
     * Enrolls a participant and specifies the participant's group. This is only called when the type of the study is
     * "General". If the type of the study is "Randomized", then a failure is returned.
     * A participant can only be enrolled in a study if the study is open for enrollment.
     * A participant can only be enrolled in a study if the participant is not already enrolled in the study.
     * A participant can only be enrolled in a study if the participant is eligible for the study.
     * A participant can be enrolled only if the specified group is within the defined groups of the study.
     * <p>
     * This method is overloaded.
     *
     * @param participantId   The participant to enroll.
     * @param studyId         The study to enroll the participant in.
     * @param group         The group number to enroll the participant in.
     */
    void enroll(int participantId, int studyId, int group);

}
