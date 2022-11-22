package use_cases.answer_questionnaire;

import java.util.Map;

public class AnswerQuestionnaireRequestModel {

    /**
     * The questionnaire ID.
     */
    private int questionnaireId;


    /**
     * A map of variable names to answers
     * The key is the variable name, the value is the answer.
     * For answers:
     * - If the answer is a text question, the answer is a string of text.
     * - If the answer is a multiple choice question, the answer is the choice number as a string.
     * - If the answer is a scale question, the answer is the scale number as a string.
     */
    private Map<String, String> answers;


    /**
     * The participant ID.
     */
    private int participantId;


    /**
     * The modifier ID.
     */
    private int modifierId;


    /**
     * The study ID.
     */
    private int studyId;


    /**
     * The number of questions in the questionnaire.
     */
    private int numQuestions;


    /**
     * Create a new AnswerQuestionnaireRequestModel.
     * @param questionnaireId   The questionnaire ID.
     * @param participantId     The participant ID.
     * @param modifierId        The modifier ID.
     * @param studyId           The study ID.
     */
    public AnswerQuestionnaireRequestModel(int questionnaireId, int participantId, int modifierId, int studyId) {
        this.questionnaireId = questionnaireId;
        this.participantId = participantId;
        this.modifierId = modifierId;
        this.studyId = studyId;
    }


    /**
     * Set the answers.
     */
    public void setAnswers(Map<String, String> answers, int numQuestions) {
        this.answers = answers;
        this.numQuestions = numQuestions;
        assert this.answers.size() == this.numQuestions;
    }


    /**
     * Get the questionnaire ID.
     * @return  The questionnaire ID.
     */
    public int getQuestionnaireId() {
        return questionnaireId;
    }


    /**
     * Get the answers.
     * @return  The answers.
     */
    public Map<String, String> getAnswers() {
        return answers;
    }


    /**
     * Get the participant ID.
     * @return  The participant ID.
     */
    public int getParticipantId() {
        return participantId;
    }


    /**
     * Get the modifier ID.
     * @return  The modifier ID.
     */
    public int getModifierId() {
        return modifierId;
    }


    /**
     * Get the study ID.
     * @return  The study ID.
     */
    public int getStudyId() {
        return studyId;
    }


    /**
     * Get the number of questions in the questionnaire.
     * @return  The number of questions in the questionnaire.
     */
    public int getNumQuestions() {
        return numQuestions;
    }
}
