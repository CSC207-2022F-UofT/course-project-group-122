package user_interface_layer.presenter_manager.display_screen_for_answering_questionnaire;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import use_cases.answer_questionnaire_data_request.UserAnswerQuestionnairePanelInputData;
import user_interface_layer.screens.answer_questionnaire.UserAnswerQuestionnairesScreen;

public class DisplayParticipantAnswerQuestionnairePanel implements DisplayParticipantAnswerQuestionnairePanelInterface{
    ScreenManager screenManager;
    ControllerManager controllerManager;
    @Override
    public void presentParticipantAnswerQuestionnairePanel(UserAnswerQuestionnairePanelInputData data) {
        UserAnswerQuestionnairesScreen screen = new UserAnswerQuestionnairesScreen(data, controllerManager);
        screenManager.setParticipantAnswerQuestionnairePanel(screen);
        screenManager.updateCurrentScreen(screen);

    }
}
