package user_interface_layer.presenter_manager.display_researcher_questionnaire;

import use_cases.questionnaire_screen_data_request.CheckQuestionnaireInputData;

/**
 * The interface that the presenter calls to display a questionnaire.
 */
public interface DisplayResearcherQuestionnaireInterface {
    /**
     * @param data The data needed to display the questionnaire.
     */
    void presentQuestionnaireScreenForResearcher(CheckQuestionnaireInputData data);

}
