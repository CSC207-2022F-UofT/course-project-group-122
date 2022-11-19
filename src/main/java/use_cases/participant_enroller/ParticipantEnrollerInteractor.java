package use_cases.participant_enroller;

import entities.*;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

import java.util.List;


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

    /**
     * The presenter to send the output to.
     */
    private final ParticipantEnrollerOutputBoundary participantEnrollerPresenter = new ParticipantEnrollerPresenter();

    /**
     * The manager of the random group generator
     */
    private final RandomGroupGeneratorManager randomGroupGeneratorManager = new RandomGroupGeneratorManager();


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
     * @param participantId The participant to enroll.
     * @param studyId       The study to enroll the participant in.
     */
    @Override
    public void enroll(int participantId, int studyId) {
        Participant participant = checkParticipantIdIsValid(participantId);
        Study study = (Study) FetchId.getStudy(studyId);
        if (enrollParticipant(participant, study)) {
            assignQuestionnaires(participant, study);
            participantEnrollerPresenter.presentEnrollmentSuccess(participantId, participant.getGroup());
        } else {
            participantEnrollerPresenter.presentEnrollmentFailure(participantId);
        }
    }


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
     * @param participantId The participant to enroll.
     * @param studyId       The study to enroll the participant in.
     * @param group         The group number to enroll the participant in.
     */
    @Override
    public void enroll(int participantId, int studyId, int group) {
        Participant participant = checkParticipantIdIsValid(participantId);
        Study study = (Study) FetchId.getStudy(studyId);
        if (enrollParticipant(participant, study, group)) {
            assignQuestionnaires(participant, study);
            participantEnrollerPresenter.presentEnrollmentSuccess(participantId, participant.getGroup());
        } else {
            participantEnrollerPresenter.presentEnrollmentFailure(participantId);
        }
    }

    /**
     * Fetches the participant's information from the database and returns it to the presenter.
     *
     * @param participantId The participant's id.
     */
    @Override
    public void fetchParticipantInfomration(int participantId) {
        Participant participant = checkParticipantIdIsValid(participantId);
        participantEnrollerPresenter.presentParticipantInformation(participant.getId(), participant.getName());
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
     * @return true if the participant is successfully enrolled in the study, false otherwise.
     */
    private boolean enrollParticipant(Participant participant, Study study) {
        if (enrollable(participant, study)) {
            if (study.getStudyType().equals("Randomized")) {
                RandomGroupGenerator randomGroupGenerator = fetchRandomGroupGenerator(study);
                int group = randomGroupGenerator.generateRandomGroup(study, participant);
                participant.setGroup(group);
            } else {
                participant.setGroup(1);
            }
            study.removePotentialParticipant(participant);
            study.addParticipant(participant);
            participant.enroll();
            return true;
        } else {
            return false;
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
     * @return true if the participant is successfully enrolled, false otherwise.
     */
    private boolean enrollParticipant(Participant participant, @NotNull Study study, int group) {
        if (study.getStudyType().equals("Randomized")) {
            return false;
        } else {
            if (enrollable(participant, study)) {
                if (1 <= group && group <= study.getNumGroups()) {
                    participant.setGroup(group);
                    study.removePotentialParticipant(participant);
                    study.addParticipant(participant);
                    participant.enroll();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
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


    /**
     * Fetch the random group generator of this study.
     * Preconditions:
     * The study is open for enrollment.
     * The study is a randomized study.
     * @param study     The study to fetch the random group generator of.
     * @return the random group generator of the study.
     */
    private @NotNull RandomGroupGenerator fetchRandomGroupGenerator(Study study) {
        if (randomGroupGeneratorManager.studyGeneratorExists(study)) {
            return randomGroupGeneratorManager.getStudyGenerator(study);
        } else {
            String type = study.getRandomizationMethod();
            if (type.equals("Block")) {
                RandomGroupGenerator generator = new BlockRandomGroupGenerator(study);
                randomGroupGeneratorManager.addStudyGenerator(study, generator);
                return generator;
            } else if (type.equals("Stratified")) {
                RandomGroupGenerator generator =  new StratifiedRandomGroupGenerator(study);
                randomGroupGeneratorManager.addStudyGenerator(study, generator);
                return generator;
            } else {
                RandomGroupGenerator generator =  new SimpleRandomGroupGenerator(study);
                randomGroupGeneratorManager.addStudyGenerator(study, generator);
                return generator;
            }
        }
    }


    /**
     * Automatically assigns the required questionnaires to the participant.
     *
     * @param participant   The participant to assign the questionnaires to.
     * @param study         The study to assign the questionnaires to the participant for.
     */
    private void assignQuestionnaires(@NotNull Participant participant, @NotNull Study study) {
        List<Questionnaire> questionnaires = study.getQuestionnaires();
        int group = participant.getGroup();
        for (Questionnaire questionnaire : questionnaires) {
            if (questionnaire.getTargetGroups().contains(group)) {
                participant.assignQuestionnaire(questionnaire);
            }
        }
    }


    private @NotNull Participant checkParticipantIdIsValid(int participantId) {
        if (FetchId.checkUserExists(participantId)) {
            User user = FetchId.getUser(participantId);
            if (user instanceof Participant) {
                return (Participant) user;
            } else {
                participantEnrollerPresenter.displayParticipantIdIsNotParticipant(participantId);
            }
        } else {
            participantEnrollerPresenter.displayParticipantIdDoesNotExist(participantId);
        }
        throw new IllegalArgumentException("The participant ID is invalid.");
    }
}


