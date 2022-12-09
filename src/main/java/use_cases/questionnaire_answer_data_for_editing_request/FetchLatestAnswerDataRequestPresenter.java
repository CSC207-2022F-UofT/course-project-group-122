package use_cases.questionnaire_answer_data_for_editing_request;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_screen_for_editing_answers.DisplayEditAnswersInterface;

/**
 * The presenter that the use case calls on.
 */
public class FetchLatestAnswerDataRequestPresenter implements FetchLatestAnswerDataRequestOutputBoundary {
    /**
     * The screen that the presenter presents the data to.
     */
    DisplayEditAnswersInterface displayEditAnswersInterface;
    /**
     * The screen that the presenter presents the failure message to.
     */
    DisplayFailureMessageInterface displayFailureMessageInterface;

    /**
     * The method that presents the data to the screen.
     * @param data The data that the use case fetched.
     */
    @Override
    public void presentLatestAnswerDataRequest(ResearcherEditQuestionnaireScreenAnswersInputData data) {
        displayEditAnswersInterface.presentResearcherEditQuestionnaireAnswersScreen(data);
    }

    /**
     * the method that the use case calls on when the questionnaire has not been answered.
     * @param message The failure message that the use case presents.
     */
    @Override
    public void presentQuestionnaireNotAnswered(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    /**
     * The method that sets the screen that the presenter presents the data to.
     * @param displayEditAnswersInterface The screen that the presenter presents the data to.
     */
    public void setDisplayEditAnswersInterface(DisplayEditAnswersInterface displayEditAnswersInterface) {
        this.displayEditAnswersInterface = displayEditAnswersInterface;
    }

    /**
     * The method that sets the screen that the presenter presents the failure message to.
     * @param displayFailureMessageInterface The screen that the presenter presents the failure message to.
     */
    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }
}
