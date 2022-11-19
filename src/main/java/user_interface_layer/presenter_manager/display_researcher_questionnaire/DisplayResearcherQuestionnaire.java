package user_interface_layer.presenter_manager.display_researcher_questionnaire;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.check_questionnaire_screen.CheckQuestionnaireInputData;
import user_interface_layer.screens.check_questionnaire_screen.CheckQuestionnaireScreen;

public class DisplayResearcherQuestionnaire implements DisplayResearcherQuestionnaireInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;

    @Override
    public void presentQuestionnaireScreenForResearcher(CheckQuestionnaireInputData data) {
        CheckQuestionnaireScreen screen = new CheckQuestionnaireScreen(data);
        screenManager.setCheckQuestionnaireScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

    public void setControllerManager(ControllerManager controllerManager){
        this.controllerManager = controllerManager;
    }
}
