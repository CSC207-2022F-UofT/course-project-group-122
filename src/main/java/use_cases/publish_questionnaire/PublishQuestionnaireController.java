package use_cases.publish_questionnaire;

public class PublishQuestionnaireController {

    private PublishQuestionnaireInputBoundary publishQuestionnaireInteractor = new PublishQuestionnaireInteractor();

    /**
     * Publishes a questionnaire.
     * @param questionnaireID   The ID of the questionnaire to publish.
     */
    public void publishQuestionnaire(int questionnaireID, int studyId) {
        publishQuestionnaireInteractor.publishQuestionnaire(questionnaireID, studyId);
    }
}
