package use_cases.questionnaire_answer_data_for_editing_request;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_screen_for_editing_answers.DisplayEditAnswersInterface;
//import user_interface_layer.presenter_manager.display_researcher_edit_questionnaire_answers.DisplayResearcherEditQuestionnaireAnswersInterface;

public class FetchLatestAnswerDataRequestPresenter implements FetchLatestAnswerDataRequestOutputBoundary {
    DisplayEditAnswersInterface displayEditAnswersInterface;
    DisplayFailureMessageInterface displayFailureMessageInterface;
    @Override
    public void presentLatestAnswerDataRequest(ResearcherEditQuestionnaireScreenAnswersInputData data) {
        displayEditAnswersInterface.presentResearcherEditQuestionnaireAnswersScreen(data);
    }
    @Override
    public void presentQuestionnaireNotAnswered(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    public void setDisplayEditAnswersInterface(DisplayEditAnswersInterface displayEditAnswersInterface) {
        this.displayEditAnswersInterface = displayEditAnswersInterface;
    }

    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }
}
