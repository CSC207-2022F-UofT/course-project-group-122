package user_interface_layer.presenter_manager.display_screen_for_answering_questionnaire;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import use_cases.answer_questionnaire_data_request.FetchQuestionnaireDataForAnswerResponseModel;
import user_interface_layer.screens.user_answer_questionnaires_screen.UserAnswerQuestionnairesScreen;

public class DisplayScreenForAnsweringQuestionnaire implements DisplayScreenForAnsweringQuestionnaireInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;
    @Override
    public void presentUserAnswerQuestionnairesScreen(FetchQuestionnaireDataForAnswerResponseModel data) {
        UserAnswerQuestionnairesScreen screen = new UserAnswerQuestionnairesScreen(data, controllerManager);
        screenManager.setParticipantAnswerQuestionnairePanel(screen);
        screenManager.updateCurrentScreen(screen);

    }
}
