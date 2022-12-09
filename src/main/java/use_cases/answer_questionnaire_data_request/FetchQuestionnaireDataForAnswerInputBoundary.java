package use_cases.answer_questionnaire_data_request;

/*
 * This the interface that the use case implements and the controller calls on.
 */
public interface FetchQuestionnaireDataForAnswerInputBoundary {

    /**
     * @param modifier The modifier's ID that is modifying the answer to the questionnaire.
     * @param participantID The participant ID of the participant that the questionnaire was assigned to.
     * @param studyId The study ID of the study that the questionnaire belongs to.
     * @param questionnaireId The questionnaire ID of the questionnaire that the participant is answering.
     * @param questionnaireType The questionnaireType of questionnaire that the participant is answering.
     */
    void questionnaireRequestData(int modifier, int participantID, int studyId,
                                  int questionnaireId, String questionnaireType);
}
