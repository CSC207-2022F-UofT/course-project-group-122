package user_interface_layer.presenter_manager.display_screen_for_answering_questionnaire;

import org.jetbrains.annotations.NotNull;
import use_cases.answer_questionnaire_data_request.FetchQuestionnaireDataForAnswerResponseModel;
import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.user_answer_questionnaires_screen.UserAnswerQuestionnairesScreen;

/**
 * The class that displays the screen where the user can answer a questionnaire.
 */
public class DisplayScreenForAnsweringQuestionnaire implements DisplayScreenForAnsweringQuestionnaireInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;


    /**
     * The constructor of the class.
     *
     * @param screenManager         The screen manager.
     * @param controllerManager     The controller manager.
     */
    public DisplayScreenForAnsweringQuestionnaire(@NotNull ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }

    @Override
    public void presentUserAnswerQuestionnairesScreen(FetchQuestionnaireDataForAnswerResponseModel data, String type) {
        UserAnswerQuestionnairesScreen screen = new UserAnswerQuestionnairesScreen(data, type, controllerManager);
        screenManager.setParticipantAnswerQuestionnairePanel(screen);

    }
}
