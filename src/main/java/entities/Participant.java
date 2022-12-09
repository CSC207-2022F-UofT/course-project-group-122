package entities;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * A participant class. A participant is a user who is participating in a study. Each participant object is associated
 * with only one study.
 */
public class Participant extends User implements Serializable {

    /**
     * The Study object this Participant belongs to.
     * A Participant can only belong to one Study. A participant is associated with a study when he or she is considered
     * as a potential participant in the study. The participant is not considered as a participant in the study until he
     * or she is enrolled in the study.
     * <p>
     * The process of enrolling a participant in a study is called "Participant Enrollment", with the process defined as
     * follows: considered as a potential participant -> checked eligibility -> enrolled as a participant.
     * <p>
     * There are several statuses a participant can have in a study, including:
     * - considered as a potential participant and/or is enrolled in the study, i.e. this.study != null
     * - checked eligibility
     * - enrolled as a participant
     * - withdrawn from the study
     */
    private Study study = null;

    /**
     * The data manager for this participant.
     */
    private final ParticipantDataManager dataManager;

    /**
     * The group this Participant belongs to.
     */
    private int group = 1;

    /**
     * Whether the participant is eligible to participate in the study.
     */
    private boolean eligible = false;

    /**
     * Whether the participant has enrolled in the study.
     */
    private boolean enrolled = false;

    /**
     * Whether the participant has dropped off the study.
     */
    private boolean droppedOff = false;


    /**
     * @param username    the username of this Participant.
     * @param name        the name of this Participant.
     */
    public Participant(int id, String username, String name) {
        super(id, username, name);
        this.dataManager = new ParticipantDataManager(this);
    }

    /**
     * @return the Study object this Participant belongs to.
     */
    public Study getStudy() {
        return study;
    }

    /**
     * @param study Set this participant to a study, i.e. associating a participant to a study. The participant is
     *              considered to be associated with the study if the participant is considered as a potentially
     *              eligible participant. The associated study can be changed if and only if the participant is not
     *              enrolled. If the participant is enrolled, the associated study cannot be changed.
     */
    public void setStudy(Study study) {
        if (!this.enrolled) {
            this.study = study;
        }
    }


    /**
     * @return the group this Participant belongs to.
     */
    public int getGroup() {
        return group;
    }


    /**
     * @param group the group this Participant belongs to.
     */
    public void setGroup(int group) {
        this.group = group;
    }


    /**
     * @return whether the participant is eligible to participate in the study.
     */
    public boolean isEligible() {
        return eligible;
    }


    /**
     * Make a participant eligible to participate in the study. The participant can be made eligible if and only if he
     * or she has been associated with a study as a potential participant.
     *
     * @return true if the eligibility has been set for a participant, false otherwise.
     */
    public boolean makeEligible() {
        if (this.study != null) {
            this.eligible = true;
            return true;
        }
        return false;
    }


    /**
     * @return whether the participant has enrolled in the study.
     */
    public boolean isEnrolled() {
        return enrolled;
    }


    /**
     * Enroll a participant in the study. The participant can be enrolled if and only if he or she has been associated
     * with a study as a potential participant and is eligible to participate in the study.
     *
     * @return true if the participant has been enrolled in the study, false otherwise.
     */
    public boolean enroll() {
        if (this.eligible) {
            this.enrolled = true;
            return true;
        }
        return false;
    }


    /**
     * @return whether the participant has dropped off the study.
     */
    public boolean isDroppedOff() {
        return droppedOff;
    }


    /**
     * Drop off a participant from the study. The participant can be dropped off if and only if he or she has been
     * enrolled in the study.
     *
     * @return true if the participant has been dropped off from the study, false otherwise.
     */
    public boolean dropOff() {
        if (this.enrolled) {
            this.droppedOff = true;
            return true;
        }
        return false;
    }


    /**
     * @return the assigned eligibility questionnaire for this participant.
     */
    public Questionnaire getEligibilityQuestionnaire() {
        return this.dataManager.getEligibilityQuestionnaire();
    }


    /**
     * @param eligibilityQuestionnaire the assigned eligibility questionnaire for this participant.
     */
    public void setEligibilityQuestionnaire(Questionnaire eligibilityQuestionnaire) {
        this.dataManager.setEligibilityQuestionnaire(eligibilityQuestionnaire);
    }


    /**
     * @return the assigned questionnaires for this participant.
     */
    public List<Questionnaire> getAssignedQuestionnaires() {
        return this.dataManager.getAssignedQuestionnaires();
    }


    /**
     * @return the completed questionnaires for this participant.
     */
    public List<Questionnaire> getCompletedQuestionnaires() {
        return this.dataManager.getCompletedQuestionnaires();
    }


    /**
     * Assign a questionnaire to a participant.
     * <p>
     * Conditions:
     * - the participant and the questionnaire are associated with the same study
     * - the questionnaire has not been assigned to the participant
     * - the questionnaire has not been completed by the participant
     * - the questionnaire is not the eligibility questionnaire of the participant
     *
     * @param questionnaire the questionnaire to be assigned to the participant.
     * @return true if the questionnaire has been assigned to the participant, false otherwise.
     */
    public boolean assignQuestionnaire(Questionnaire questionnaire) {
        return this.dataManager.assignQuestionnaire(questionnaire);
    }


    /**
     * Complete a questionnaire assigned to a participant.
     * This method only deals with the storage of the questionnaire associated with the participant. It does not
     * deal with the storage of the answers to the questionnaire.
     * <p>
     * Conditions:
     * - the questionnaire has been assigned to the participant
     * - the questionnaire has not been completed by the participant
     *
     * @param questionnaire the questionnaire to be completed by the participant.
     */
    public boolean completeQuestionnaire(Questionnaire questionnaire) {
        return this.dataManager.completeQuestionnaire(questionnaire);
    }


    /**
     * @return the answer to the eligibility questionnaire of this participant in this study.
     */
    public Answer getEligibilityQuestionnaireAnswer() {
        return this.dataManager.getEligibilityQuestionnaireAnswer();
    }


    /**
     * @return the answer content of the most recent version of the eligibility questionnaire.
     */
    public Map<String, String> getCurrEligibilityAnswerContent() {
        return this.dataManager.getCurrEligibilityAnswerContent();
    }


    /**
     * @return if the eligibility questionnaire has been answered by this participant.
     */
    public boolean hasCompletedEligibilityQuestionnaire() {
        return this.dataManager.hasCompletedEligibilityQuestionnaire();
    }

    /**
     * @param eligibilityQuestionnaireAnswer the answer to the eligibility questionnaire of this participant in this
     *                                       study.
     */
    public void setEligibilityQuestionnaireAnswer(Answer eligibilityQuestionnaireAnswer) {
        this.dataManager.setEligibilityQuestionnaireAnswer(eligibilityQuestionnaireAnswer);
    }


    /**
     * @return the answers to all the questionnaires of this participant in this study.
     */
    public List<Answer> getQuestionnaireAnswers() {
        return this.dataManager.getQuestionnaireAnswers();
    }


    /**
     * Retrieve the answer given a questionnaire.
     *
     * @param questionnaire the questionnaire to retrieve the answer for.
     * @return the answer to the questionnaire.
     */
    public Answer getQuestionnaireAnswer(Questionnaire questionnaire) {
        return this.dataManager.getQuestionnaireAnswer(questionnaire);
    }


    /**
     * Add an answer to the list of answers. This method is used when a new answer for a new questionnaire is created.
     * <p>
     * This should execute immediately following the creation of a new answer and marking the questionnaire as
     * completed using the completeQuestionnaire method.
     * <p>
     * Conditions:
     * - the questionnaire has been completed by the participant
     * - the questionnaire is not the eligibility questionnaire of the participant
     * - the questionnaire is not already in the list of answers
     * - the answer is associated with the participant
     * - the answer is associated with the questionnaire
     */
    public boolean addAnswer(@NotNull Answer answer, @NotNull Questionnaire questionnaire) {
        return this.dataManager.addAnswer(answer, questionnaire);
    }


    /**
     * Retrieve the most recent version of the answer given a questionnaire.
     *
     * @param questionnaire the questionnaire to retrieve the answer for.
     * @return the most recent version of the questionnaire.
     */
    public VersionedAnswer getCurrVersionQuestionnaireAnswer(Questionnaire questionnaire) {
        return this.dataManager.getCurrVersionQuestionnaireAnswer(questionnaire);
    }
}
