package use_cases.create_questionnaire;

import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessage;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_researcher_study_log.DisplayResearcherStudyLogInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

/**
 * This class is the presenter for the CreateQuestionnaire use case.
 */
public class CreateQuestionnairePresenter implements CreateQuestionnaireOutputBoundary {
    /**
     * The display failure message presenter.
     */
    private DisplayFailureMessageInterface displayFailureMessageInterface;
    /**
     * The display success message presenter.
     */
    private DisplaySuccessMessageInterface displaySuccessMessageInterface;
    /**
     * The display researcher study log presenter.
     */
    private FetchStudyLogController fetchStudyLogController;

    /**
     * This method presents the failure output of the CreateQuestionnaire use case.
     *
     * @param message The failure message to be displayed to the user. This message is passed to the display failure message presenter.
     */
    @Override
    public void presentFailureScreen(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    /**
     * This method presents the success output of the CreateQuestionnaire use case.
     *
     * @param researcherId The researcher ID of the researcher who created the questionnaire.
     * @param studyId      The study ID of the study that the questionnaire belongs to.
     */
    @Override
    public void presentSuccessScreen(int researcherId, int studyId) {
        fetchStudyLogController.fetchStudyLog(studyId, researcherId);
        displaySuccessMessageInterface.presentGeneralSuccessMessage("Questionnaire created successfully");
    }

    /**
     * This method sets the display failure message presenter.
     *
     * @param displayFailureMessageInterface The display failure message presenter.
     */
    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }

    /**
     * This method sets the display success message presenter.
     *
     * @param displaySuccessMessageInterface The display success message presenter.
     */
    public void setDisplaySuccessMessageInterface(DisplaySuccessMessageInterface displaySuccessMessageInterface) {
        this.displaySuccessMessageInterface = displaySuccessMessageInterface;
    }

    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }
}
