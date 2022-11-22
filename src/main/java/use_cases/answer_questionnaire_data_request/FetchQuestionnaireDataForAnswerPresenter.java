package use_cases.answer_questionnaire_data_request;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_screen_for_answering_questionnaire.DisplayScreenForAnsweringQuestionnaireInterface;

public class FetchQuestionnaireDataForAnswerPresenter implements FetchQuestionnaireDataForAnswerOutputBoundary {
    DisplayFailureMessageInterface displayFailureMessageInterface;
    DisplayScreenForAnsweringQuestionnaireInterface displayScreenForAnsweringQuestionnaireInterface;
    @Override
    public void presentFailureScreen(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    @Override
    public void presentQuestionnaireDataForAnswering(FetchQuestionnaireDataForAnswerResponseModel data) {
        displayScreenForAnsweringQuestionnaireInterface.presentUserAnswerQuestionnairesScreen(data);
    }

    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }

    public void setDisplayParticipantAnswerQuestionnairePanelInterface(DisplayScreenForAnsweringQuestionnaireInterface displayParticipantAnswerQuestionnairePanelInterface) {
        this.displayScreenForAnsweringQuestionnaireInterface = displayParticipantAnswerQuestionnairePanelInterface;
    }

}

