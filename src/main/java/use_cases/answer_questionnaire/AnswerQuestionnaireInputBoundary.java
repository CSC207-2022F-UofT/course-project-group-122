package use_cases.answer_questionnaire;

import java.util.Map;

public interface AnswerQuestionnaireInputBoundary {


    /**
     * Answer a questionnaire.
     * @param questionnaireId   The questionnaire ID.
     * @param participantId     The participant ID.
     * @param modifierId        The modifier ID.
     * @param studyId           The study ID.
     * @param answers           A map of variable names to answers
     * @param numQuestions      The number of questions in the questionnaire.
     */
    void answerQuestionnaire(int questionnaireId, int participantId, int modifierId, int studyId,
                             Map<String, String> answers, int numQuestions);

    /**
     * Answer an eligibility questionnaire.
     * @param questionnaireId   The questionnaire ID.
     * @param participantId     The participant ID.
     * @param modifierId        The modifier ID.
     * @param studyId           The study ID.
     * @param answers           A map of variable names to answers
     * @param numQuestions      The number of questions in the questionnaire.
     */
    void answerEligibilityQuestionnaire(int questionnaireId, int participantId, int modifierId, int studyId,
                                               Map<String, String> answers, int numQuestions);
}
