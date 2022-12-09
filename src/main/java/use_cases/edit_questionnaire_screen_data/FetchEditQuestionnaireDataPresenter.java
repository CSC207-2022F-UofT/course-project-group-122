package use_cases.edit_questionnaire_screen_data;

import user_interface_layer.presenter_manager.display_edit_questionnaire.DisplayEditQuestionnaireInterface;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;

/**
 * The presenter that the use calls on to present the data to the user.
 */
public class FetchEditQuestionnaireDataPresenter implements FetchEditQuestionnaireDataOutBoundary{
    /**
     * The display edit questionnaire presenter.
     */
    DisplayEditQuestionnaireInterface displayEditQuestionnaireInterface;
    /**
     * The display failure message presenter.
     */
    DisplayFailureMessageInterface displayFailureMessageInterface;

    /**
     * The method that the use case calls on to present the data to the user.
     * @param response The response that the use case sends to the presenter.
     */
    @Override
    public void presentEditQuestionnaireScreenData(EditQuestionnaireScreenInputData response) {
        displayEditQuestionnaireInterface.presentEditQuestionnaireScreen(response);
    }

    /**
     * The method that the use case calls on to present the failure message to the user.
     * @param message The failure message that the use case sends to the presenter.
     */
    @Override
    public void presentFailureScreen(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    /**
     * Set the display edit questionnaire presenter.
     * @param displayEditQuestionnaireInterface The display edit questionnaire presenter.
     */
    public void setDisplayEditQuestionnaireInterface(DisplayEditQuestionnaireInterface displayEditQuestionnaireInterface) {
        this.displayEditQuestionnaireInterface = displayEditQuestionnaireInterface;
    }

    /**
     * Set the display failure message presenter.
     * @param displayFailureMessageInterface The display failure message presenter.
     */
    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }
}
