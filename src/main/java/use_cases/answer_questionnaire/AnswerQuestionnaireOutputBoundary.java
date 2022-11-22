package use_cases.answer_questionnaire;

public interface AnswerQuestionnaireOutputBoundary {

    /**
     * Present failure to answer questionnaire.
     * @param message   The failure message.
     */
    void presentAnswerQuestionnaireFailure(String message);

    /**
     * Present success to answer questionnaire.
     */
    void presentAnswerQuestionnaireSuccess(int participantId, int modifierId, int questionnaireId, String time);
}
