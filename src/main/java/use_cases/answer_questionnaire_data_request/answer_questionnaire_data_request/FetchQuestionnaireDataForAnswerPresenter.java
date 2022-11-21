package use_cases.answer_questionnaire_data_request.answer_questionnaire_data_request;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_participant_answer_questionnaire_panel.DisplayParticipantAnswerQuestionnairePanelInterface;

public class FetchQuestionnaireDataForAnswerPresenter implements FetchQuestionnaireDataForAnswerOutputBoundary {
    DisplayFailureMessageInterface displayFailureMessageInterface;
    DisplayParticipantAnswerQuestionnairePanelInterface displayParticipantAnswerQuestionnairePanelInterface;
    @Override
    public void presentFailureScreen(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    @Override
    public void presentQuestionnaireDataForAnswering(ParticipantAnswerQuestionnairePanelInputData data) {
        displayParticipantAnswerQuestionnairePanelInterface.presentParticipantAnswerQuestionnairePanel(data);
    }

    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }

    public void setDisplayParticipantAnswerQuestionnairePanelInterface(DisplayParticipantAnswerQuestionnairePanelInterface displayParticipantAnswerQuestionnairePanelInterface) {
        this.displayParticipantAnswerQuestionnairePanelInterface = displayParticipantAnswerQuestionnairePanelInterface;
    }

}

