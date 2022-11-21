package use_cases.create_questionnaire;

import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessage;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_researcher_study_log.DisplayResearcherStudyLogInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class CreateQuestionnairePresenter implements CreateQuestionnaireOutputBoundary{
    DisplayFailureMessageInterface displayFailureMessageInterface;
    DisplaySuccessMessageInterface displaySuccessMessageInterface;
    FetchStudyLogController fetchStudyLogController;
    @Override
    public void presentFailureScreen(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    @Override
    public void presentSuccessScreen() {

        displaySuccessMessageInterface.presentGeneralSuccessMessage("Questionnaire created successfully");
    }

    public void  presentStudyLogScreen(int study, int researcher){
        fetchStudyLogController.fetchStudyLog(study, researcher);

    }

    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }

    public void setDisplaySuccessMessageInterface(DisplaySuccessMessageInterface displaySuccessMessageInterface) {
        this.displaySuccessMessageInterface = displaySuccessMessageInterface;
    }

    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }
}
