package use_cases.publish_questionnaire;

public interface PublishQuestionnaireOutputBoundary {

    /**
     * Presents that the questionnaire cannot be published.
     *
     * @param QuestionnaireId   The ID of the questionnaire that cannot be published.
     * @param message           The message to present.
     */
    void invalidQuestionnaire(int QuestionnaireId, String message);


    /**
     * Presents that the questionnaire has been published.
     * @param questionnaireID   The ID of the questionnaire that has been published.
     * @param studyId           The ID of the study that the questionnaire has been published to.
     * @param researcherId      The ID of the researcher that published the questionnaire.
     */
    void publishQuestionnaire(int questionnaireID, int studyId, int researcherId);


    /**
     * Assign the questionnaire to all potential participants.
     * @param questionnaireId   The ID of the questionnaire that has been published.
     * @param studyId        The ID of the study that the questionnaire has been published to.
     * @param researcherId      The ID of the researcher that published the questionnaire.
     */
    void assignToAllPotentialParticipants(int questionnaireId, int studyId, int researcherId);
}
