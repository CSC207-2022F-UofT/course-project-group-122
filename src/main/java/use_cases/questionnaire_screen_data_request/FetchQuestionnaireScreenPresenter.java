package use_cases.questionnaire_screen_data_request;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_researcher_questionnaire.DisplayResearcherQuestionnaireInterface;

/**
 * The presenter that the use case calls on.
 */
public class FetchQuestionnaireScreenPresenter implements FetchQuestionnaireScreenOutputBoundary {
    /**
     * The display that the presenter calls to present the screen to the user.
     */
    DisplayResearcherQuestionnaireInterface displayResearcherQuestionnaireInterface;
    /**
     * The display that the presenter calls to present the failure message to the user.
     */
    DisplayFailureMessageInterface displayFailureMessageInterface;

    /**
     * The method that presents the data to the screen.
     * @param data The data that the use case fetched.
     */
    @Override
    public void presentQuestionnaireScreenData(CheckQuestionnaireInputData data) {
        displayResearcherQuestionnaireInterface.presentQuestionnaireScreenForResearcher(data);
    }

    /**
     * The method that presents the failure message to the screen.
     * @param message The failure message that the use case presents.
     */
    @Override
    public void presentQuestionnaireScreenDataFailure(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    /**
     * The method that sets the display that the presenter calls to present the screen to the user.
     * @param displayResearcherQuestionnaireInterface The display that the presenter calls to present the screen to
     *                                                the user.
     */
    public void setDisplayResearcherQuestionnaireInterface(DisplayResearcherQuestionnaireInterface displayResearcherQuestionnaireInterface) {
        this.displayResearcherQuestionnaireInterface = displayResearcherQuestionnaireInterface;
    }

    /**
     * The method that sets the display that the presenter calls to present the failure message to the user.
     * @param displayFailureMessageInterface The display that the presenter calls to present the failure message
     *                                       to the user.
     */
    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }
}

