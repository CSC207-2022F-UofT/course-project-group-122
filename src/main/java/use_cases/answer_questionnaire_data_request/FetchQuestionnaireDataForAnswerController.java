package use_cases.answer_questionnaire_data_request;

/**
 * This the controller that calls on the use case that fetches the data for the participant to answer the questionnaire.
 */
public class FetchQuestionnaireDataForAnswerController {
    /**
     * The interface that the use case implements and is called on by the controller.
     */
    FetchQuestionnaireDataForAnswerInputBoundary fetchQuestionnaireDataForAnswerInteractor;

    /**
     * This method calls on the use case that fetches the data for the participant to answer the questionnaire.
     * @param studyId The study ID of the study that the questionnaire belongs to.
     * @param participantID The participant ID of the participant that is answering the questionnaire.
     * @param questionnaireId The questionnaire ID of the questionnaire that the participant is answering.
     */
    public void questionnaireRequestData(int modifier, int participantID, int studyId, int questionnaireId, String type) {
        fetchQuestionnaireDataForAnswerInteractor.questionnaireRequestData(modifier, participantID, studyId, questionnaireId, type);
    }

    /**
     * This method sets the Input Boundary of the controller.
     * @param interactor The interface that the use case implements and is called on by the controller.
     */
    public void setFetchQuestionnaireDataForAnsweringInputBoundary(FetchQuestionnaireDataForAnswerInputBoundary interactor) {
        this.fetchQuestionnaireDataForAnswerInteractor = interactor;
    }
}
