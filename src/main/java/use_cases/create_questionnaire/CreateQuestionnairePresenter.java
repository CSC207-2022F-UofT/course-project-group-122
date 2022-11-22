package use_cases.create_questionnaire;

import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessage;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_researcher_study_log.DisplayResearcherStudyLogInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class CreateQuestionnairePresenter implements CreateQuestionnaireOutputBoundary{
    private DisplayFailureMessageInterface displayFailureMessageInterface;
    private DisplaySuccessMessageInterface displaySuccessMessageInterface;
    private FetchStudyLogController fetchStudyLogController;
    @Override
    public void presentFailureScreen(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    @Override
    public void presentSuccessScreen(int researcherId, int studyId) {
        fetchStudyLogController.fetchStudyLog(studyId, researcherId);
        displaySuccessMessageInterface.presentGeneralSuccessMessage("Questionnaire created successfully");
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
