package use_cases.create_questionnaire;

/**
 * The interface that the use case implements and the controller calls on.
 */
public interface CreateQuestionnaireInputBoundary {
    /**
     * This method calls on the use case that creates a questionnaire.
     * @param createQuestionnaireRequestModel The request model that contains the data for the questionnaire to be created.
     */
    void createQuestionnaire(CreateQuestionnaireRequestModel createQuestionnaireRequestModel);
}
