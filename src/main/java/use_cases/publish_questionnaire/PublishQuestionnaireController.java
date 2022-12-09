package use_cases.publish_questionnaire;

/**
 * The class that the screen calls on to publish a questionnaire.
 */
public class PublishQuestionnaireController {

    /**
     * The use case that publishes a questionnaire.
     */
    private PublishQuestionnaireInputBoundary publishQuestionnaireInteractor;

    /**
     * Publishes a questionnaire.
     * @param questionnaireID   The ID of the questionnaire to publish.
     */
    public void publishQuestionnaire(int questionnaireID, int studyId, int researcherId) {
        publishQuestionnaireInteractor.publishQuestionnaire(questionnaireID, studyId, researcherId);
    }

    /**
     * Sets the interactor to publish a questionnaire.
     * @param publishQuestionnaireInteractor The interactor to publish a questionnaire.
     */
    public void setPublishQuestionnaireInteractor(PublishQuestionnaireInputBoundary publishQuestionnaireInteractor) {
        this.publishQuestionnaireInteractor = publishQuestionnaireInteractor;
    }
}
