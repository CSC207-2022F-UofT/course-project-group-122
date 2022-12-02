package use_cases.questionnaire_answer_data_for_editing_request;

/**
 * The class that the screen calls on to fetch the latest answer data of a questionnaire.
 */
public class FetchLatestAnswerDataRequestController {

    /**
     * The use case that fetches the latest answer data of a questionnaire.
     */
    FetchLatestAnswerDataRequestInputBoundary inputBoundary;

    /**
     * Calls on the use case that fetches the latest answer data of a questionnaire.
     * @param researcherId The researcher ID of the researcher that is fetching the latest answer data of a questionnaire.
     * @param studyId The study ID of the study that the questionnaire belongs to.
     * @param participantId The participant ID of the participant that answered the questionnaire.
     * @param questionnaireID The questionnaire ID of the questionnaire that the participant answered.
     */
    public void fetchQuestionnaireAnswerData(int researcherId, int studyId, int participantId, int questionnaireID) {
        inputBoundary.fetchLatestAnswerDataRequest(researcherId, studyId, participantId, questionnaireID);
    }

    /**
     * Sets the Input Boundary of the controller.
     * @param inputBoundary The use case that fetches the latest answer data of a questionnaire.
     */
    public void setInputBoundary(FetchLatestAnswerDataRequestInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
