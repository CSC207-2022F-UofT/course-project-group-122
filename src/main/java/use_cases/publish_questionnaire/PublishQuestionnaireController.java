package use_cases.publish_questionnaire;

public class PublishQuestionnaireController {


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
