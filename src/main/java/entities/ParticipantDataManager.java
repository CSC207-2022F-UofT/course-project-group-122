package entities;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The data manager for Participant objects. Each ParticipantDataManager object is associated with a Participant object.
 * The ParticipantDataManager object is responsible for managing the data of the Participant object, including the
 * questionnaires and the answers to the questionnaires.
 */
public class ParticipantDataManager implements java.io.Serializable{

    /**
     * The Participant object this ParticipantDataManager object is associated with.
     */
    private final Participant participant;

    /**
     * The assigned eligibility questionnaire for this participant.
     */
    private Questionnaire eligibilityQuestionnaire;

    /**
     * The assigned questionnaires for this participant. These do not include the eligibility questionnaire. A
     * questionnaire is considered assigned to a participant if and only if a researcher assigns the questionnaire to
     * the participant and the participant has not completed the questionnaire.
     */
    private final List<Questionnaire> assignedQuestionnaires = new ArrayList<>();

    /**
     * The completed questionnaires for this participant. A questionnaire is considered completed by a participant if
     * and only if the participant has completed the questionnaire. The completed questionnaires are not included in
     * the assigned questionnaire list.
     */
    private final List<Questionnaire> completedQuestionnaires = new ArrayList<>();

    /**
     * The answer to the eligibility questionnaire of this participant in this study.
     */
    private Answer eligibilityQuestionnaireAnswer;

    /**
     * The answers to all the questionnaires of this participant in this study. The number of answers in this list
     * should be the same as the number of questionnaires in the completedQuestionnaires list.
     */
    private final List<Answer> questionnaireAnswers = new ArrayList<>();


    /**
     * Constructor for ParticipantDataManager.
     *
     * @param participant the Participant object this ParticipantDataManager object is associated with.
     */
    public ParticipantDataManager(Participant participant) {
        this.participant = participant;
    }


    /**
     * @return the assigned eligibility questionnaire for this participant.
     */
    protected Questionnaire getEligibilityQuestionnaire() {
        return eligibilityQuestionnaire;
    }


    /**
     * @param eligibilityQuestionnaire the assigned eligibility questionnaire for this participant.
     */
    protected void setEligibilityQuestionnaire(Questionnaire eligibilityQuestionnaire) {
        this.eligibilityQuestionnaire = eligibilityQuestionnaire;
    }


    /**
     * @return the assigned questionnaires for this participant.
     */
    protected List<Questionnaire> getAssignedQuestionnaires() {
        return assignedQuestionnaires;
    }


    /**
     * @return the completed questionnaires for this participant.
     */
    protected List<Questionnaire> getCompletedQuestionnaires() {
        return completedQuestionnaires;
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
    protected boolean assignQuestionnaire(Questionnaire questionnaire) {
        if (canBeAssigned(questionnaire)) {
            this.assignedQuestionnaires.add(questionnaire);
            return true;
        }
        return false;
    }


    /**
     * Checks if a questionnaire can be assigned to a participant.
     * This is a helper method for the assignQuestionnaire method.
     * <p>
     * Conditions:
     * - the participant and the questionnaire are associated with the same study
     * - the questionnaire has not been assigned to the participant
     * - the questionnaire has not been completed by the participant
     * - the questionnaire is not the eligibility questionnaire of the participant
     *
     * @param questionnaire the questionnaire to be assigned to the participant.
     * @return true if the questionnaire can be assigned to the participant, false otherwise.
     */
    private boolean canBeAssigned(@NotNull Questionnaire questionnaire) {
        return questionnaire.getStudy().equals(participant.getStudy()) &&
                !this.assignedQuestionnaires.contains(questionnaire) &&
                !this.completedQuestionnaires.contains(questionnaire) &&
                !questionnaire.equals(this.eligibilityQuestionnaire);
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
    protected boolean completeQuestionnaire(Questionnaire questionnaire) {
        if (this.assignedQuestionnaires.contains(questionnaire) &&
                !this.completedQuestionnaires.contains(questionnaire)) {
            this.assignedQuestionnaires.remove(questionnaire);
            this.completedQuestionnaires.add(questionnaire);
            return true;
        }
        return false;
    }


    /**
     * @return the answer to the eligibility questionnaire of this participant in this study.
     */
    protected Answer getEligibilityQuestionnaireAnswer() {
        return eligibilityQuestionnaireAnswer;
    }

    /**
     * @return the answer content of the most recent version of the eligibility questionnaire.
     */
    protected Map<String, String> getCurrEligibilityAnswerContent() {
        return eligibilityQuestionnaireAnswer.getCurrentVersion().getAnswer();
    }


    /**
     * @return if the eligibility questionnaire has been answered by this participant.
     */
    protected boolean hasCompletedEligibilityQuestionnaire() {
        return eligibilityQuestionnaireAnswer != null;
    }

    /**
     * @param eligibilityQuestionnaireAnswer the answer to the eligibility questionnaire of this participant in this
     *                                       study.
     */
    protected void setEligibilityQuestionnaireAnswer(Answer eligibilityQuestionnaireAnswer) {
        this.eligibilityQuestionnaireAnswer = eligibilityQuestionnaireAnswer;
    }


    /**
     * @return the answers to all the questionnaires of this participant in this study.
     */
    protected List<Answer> getQuestionnaireAnswers() {
        return questionnaireAnswers;
    }


    /**
     * Retrieve the answer given a questionnaire.
     *
     * @param questionnaire the questionnaire to retrieve the answer for.
     * @return the answer to the questionnaire.
     */
    protected Answer getQuestionnaireAnswer(Questionnaire questionnaire) {
        for (Answer answer : questionnaireAnswers) {
            if (answer.getQuestionnaire().equals(questionnaire)) {
                return answer;
            }
        }
        return null;
    }


    /**
     * Retrieve the most recent version of the answer given a questionnaire.
     *
     * @param questionnaire the questionnaire to retrieve the answer for.
     * @return the most recent version of the questionnaire.
     */
    protected VersionedAnswer getCurrVersionQuestionnaireAnswer(Questionnaire questionnaire) {
        for (Answer answer : questionnaireAnswers) {
            if (answer.getQuestionnaire().equals(questionnaire)) {
                return answer.getCurrentVersion();
            }
        }
        return null;
    }
}