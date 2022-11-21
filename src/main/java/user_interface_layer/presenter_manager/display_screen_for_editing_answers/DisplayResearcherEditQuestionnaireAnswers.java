package user_interface_layer.presenter_manager.display_screen_for_editing_answers;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.edit_questionnaire_answers.EditQuestionnaireAnswers;
import use_cases.questionnaire_answer_data_for_editing_request.ResearcherEditQuestionnaireScreenAnswersInputData;

public class DisplayResearcherEditQuestionnaireAnswers implements DisplayResearcherEditQuestionnaireAnswersInterface {
    ScreenManager screenManager;

    ControllerManager controllerManager;

    /**
     * The constructor of the class.
     *
     * @param screenManager         The screen manager.
     * @param controllerManager     The controller manager.
     */
    public DisplayResearcherEditQuestionnaireAnswers(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }


    @Override
    public void presentResearcherEditQuestionnaireAnswersScreen(ResearcherEditQuestionnaireScreenAnswersInputData data) {
        EditQuestionnaireAnswers screen = new EditQuestionnaireAnswers(data, controllerManager);
        screenManager.setResearcherEditQuestionnaireAnswersScreen(screen);
        screenManager.updateCurrentScreen(screen);


    }

}
