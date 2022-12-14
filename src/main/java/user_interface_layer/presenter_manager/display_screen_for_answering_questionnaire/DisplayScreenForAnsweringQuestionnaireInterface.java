package user_interface_layer.presenter_manager.display_screen_for_answering_questionnaire;

import use_cases.answer_questionnaire_data_request.FetchQuestionnaireDataForAnswerResponseModel;

/**
 * The interface that the presenter calls to display the screen where the user can answer a questionnaire.
 */
public interface DisplayScreenForAnsweringQuestionnaireInterface {
    /**
     * @param data The data needed to display the screen where the user can answer a questionnaire.
     * @param type The type of the questionnaire.
     */
    void presentUserAnswerQuestionnairesScreen(FetchQuestionnaireDataForAnswerResponseModel data, String type);

}
