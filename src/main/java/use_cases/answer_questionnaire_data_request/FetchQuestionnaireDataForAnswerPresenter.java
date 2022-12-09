package use_cases.answer_questionnaire_data_request;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_screen_for_answering_questionnaire.DisplayScreenForAnsweringQuestionnaireInterface;

/**
 * The presenter for the use case that fetches the data for answering a questionnaire.
 */
public class FetchQuestionnaireDataForAnswerPresenter implements FetchQuestionnaireDataForAnswerOutputBoundary {
    /**
     * The display failure message interface.
     */
    DisplayFailureMessageInterface displayFailureMessageInterface;

    /**
     * The display screen that the user will be directed to.
     */
    DisplayScreenForAnsweringQuestionnaireInterface displayScreenForAnsweringQuestionnaireInterface;

    /**
     * The method that the use case calls on to present a failure message to the user.
     *
     * @param message The failure message. This method is called on by the use case to present a failure message to
     *                the user.
     */
    @Override
    public void presentFailureScreen(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    /**
     *  This method is called on by the use case to present the data to the user.
     *
     * @param data The data that the use case fetched in order to display the screen for the user to answer the
     *             questionnaire.
     * @param questionnaireType  The type of questionnaire that the user is answering.
     */
    @Override
    public void presentQuestionnaireDataForAnswering(FetchQuestionnaireDataForAnswerResponseModel data,
                                                     String questionnaireType) {
        displayScreenForAnsweringQuestionnaireInterface.presentUserAnswerQuestionnairesScreen(data, questionnaireType);
    }

    /**
     *  This method sets the display failure message interface.
     *
     * @param displayFailureMessageInterface The display failure message interface.
     */
    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }

    public void setDisplayParticipantAnswerQuestionnairePanelInterface(DisplayScreenForAnsweringQuestionnaireInterface displayParticipantAnswerQuestionnairePanelInterface) {
        this.displayScreenForAnsweringQuestionnaireInterface = displayParticipantAnswerQuestionnairePanelInterface;
    }

}

