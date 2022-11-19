package user_interface_layer.presenter_manager.display_researcher_questionnaire;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import use_cases.questionnaire_screen_data_request.QuestionnaireScreenDataRequestResponseModel;

public interface DisplayResearcherQuestionnaireInterface {
    ScreenManager screenManager = null;
    ControllerManager controllerManager = null;

    void presentQuestionnaireScreenForResearcher(QuestionnaireScreenDataRequestResponseModel data);

}
