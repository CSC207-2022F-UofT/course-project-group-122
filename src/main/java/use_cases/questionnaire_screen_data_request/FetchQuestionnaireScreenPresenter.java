package use_cases.questionnaire_screen_data_request;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_researcher_questionnaire.DisplayResearcherQuestionnaireInterface;

public class FetchQuestionnaireScreenPresenter implements FetchQuestionnaireScreenOutputBoundary {
    DisplayResearcherQuestionnaireInterface displayResearcherQuestionnaireInterface;
    DisplayFailureMessageInterface displayFailureMessageInterface;
    @Override
    public void presentQuestionnaireScreenData(CheckQuestionnaireInputData data) {
        displayResearcherQuestionnaireInterface.presentQuestionnaireScreenForResearcher(data);
    }

    @Override
    public void presentQuestionnaireScreenDataFailure(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    public void setDisplayResearcherQuestionnaireInterface(DisplayResearcherQuestionnaireInterface displayResearcherQuestionnaireInterface) {
        this.displayResearcherQuestionnaireInterface = displayResearcherQuestionnaireInterface;
    }

    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }
}

