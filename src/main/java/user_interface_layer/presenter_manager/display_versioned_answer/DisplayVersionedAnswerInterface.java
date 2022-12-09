package user_interface_layer.presenter_manager.display_versioned_answer;

import use_cases.fetch_versioned_answer.FetchVersionedAnswerResponseModel;

/**
 * The interface that the presenter calls to display the screen where the researcher can check a specific versioned
 * answer of a questionnaire.
 */
public interface DisplayVersionedAnswerInterface {
    /**
     * @param data The data needed to display the screen.
     */
    void presentVersionedAnswersOfQuestionnaireScreen(FetchVersionedAnswerResponseModel data);
}
