package use_cases.publish_questionnaire;

/**
 * The interface that the  use case implements and the controller calls on.
 */
public interface PublishQuestionnaireInputBoundary {

    /**
     * Publishes a questionnaire.
     * @param questionnaireID   The ID of the questionnaire to publish.
     * @param studyId           The ID of the study to publish the questionnaire to.
     */
    void publishQuestionnaire(int questionnaireID, int studyId, int researcherId);
}
