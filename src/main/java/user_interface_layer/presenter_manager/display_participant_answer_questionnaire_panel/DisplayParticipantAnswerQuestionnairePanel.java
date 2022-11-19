package user_interface_layer.presenter_manager.display_participant_answer_questionnaire_panel;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.participant_answer_questionnaire_panel.ParticipantAnswerQuestionnairePanel;
import user_interface_layer.screens.participant_answer_questionnaire_panel.ParticipantAnswerQuestionnairePanelInputData;

public class DisplayParticipantAnswerQuestionnairePanel implements DisplayParticipantAnswerQuestionnairePanelInterface{
    ScreenManager screenManager;
    ControllerManager controllerManager;
    @Override
    public void presentParticipantAnswerQuestionnairePanel(ParticipantAnswerQuestionnairePanelInputData data) {
        ParticipantAnswerQuestionnairePanel screen = new ParticipantAnswerQuestionnairePanel(data, controllerManager);
        screenManager.setParticipantAnswerQuestionnairePanel(screen);
        screenManager.updateCurrentScreen(screen);

    }
}
