package user_interface_layer.presenter_manager.display_screen_for_editing_answers;

import user_interface_layer.presenter_manager.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.edit_questionnaire_answers.EditQuestionnaireAnswers;
import use_cases.questionnaire_answer_data_for_editing_request.ResearcherEditQuestionnaireScreenAnswersInputData;

/**
 * The class that displays the screen where the researcher can edit the answers of a questionnaire.
 */
public class DisplayEditAnswers implements DisplayEditAnswersInterface {
    /**
     * The screen manager.
     */
    ScreenManager screenManager;

    /**
     * The controller manager.
     */
    ControllerManager controllerManager;

    /**
     * The constructor of the class.
     *
     * @param screenManager         The screen manager.
     * @param controllerManager     The controller manager.
     */
    public DisplayEditAnswers(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }


    /**
     * @param data The data needed to display the screen.
     */
    @Override
    public void presentResearcherEditQuestionnaireAnswersScreen(ResearcherEditQuestionnaireScreenAnswersInputData data) {
        EditQuestionnaireAnswers screen = new EditQuestionnaireAnswers(data, controllerManager);
        screenManager.setResearcherEditQuestionnaireAnswersScreen(screen);
    }

}
