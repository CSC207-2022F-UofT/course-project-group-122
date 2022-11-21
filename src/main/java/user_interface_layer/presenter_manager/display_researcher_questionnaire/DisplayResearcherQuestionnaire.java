package user_interface_layer.presenter_manager.display_researcher_questionnaire;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import use_cases.questionnaire_screen_data_request.CheckQuestionnaireInputData;
import user_interface_layer.screens.check_questionnaire_screen.CheckQuestionnaireScreen;

public class DisplayResearcherQuestionnaire implements DisplayResearcherQuestionnaireInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;


    /**
     * The constructor of the class.
     *
     * @param screenManager         The screen manager.
     * @param controllerManager     The controller manager.
     */
    public DisplayResearcherQuestionnaire(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }

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
