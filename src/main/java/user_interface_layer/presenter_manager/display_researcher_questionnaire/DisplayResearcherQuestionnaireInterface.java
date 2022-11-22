package user_interface_layer.presenter_manager.display_researcher_questionnaire;

import use_cases.questionnaire_screen_data_request.CheckQuestionnaireInputData;

/**
 * The interface that the presenter calls to display a questionnaire.
 */
public interface DisplayResearcherQuestionnaireInterface {
    void presentQuestionnaireScreenForResearcher(CheckQuestionnaireInputData data);

}
