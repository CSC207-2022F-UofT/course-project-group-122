package use_cases.researcher_enroller;

import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_researcher_info.DisplayResearcherInfoInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class ResearcherEnrollerPresenter implements ResearcherEnrollerOutputBoundary {

    /**
     * The display researcher info interface.
     */
    DisplayResearcherInfoInterface displayResearcherInfoInterface;

    /**
     * The controller for fetching the study log.
     */
    private FetchStudyLogController fetchStudyLogController;

    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;


    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;


    /**
     * Presents a error message saying that the researcher id is invalid.
     *
     * @param researcherId The researcher id that is invalid.
     * @param message      The error message.
     */
    @Override
    public void invalidResearcherId(int researcherId, String message) {
        String messageToPresenter = "Researcher id " + researcherId + " is invalid. " + message;
        displayFailureMessage.presentFailureMessage(messageToPresenter);
    }

    /**
     * Presents the researcher's information.
     *
     * @param id   The researcher's id.
     * @param name The researcher's name.
     */
    @Override
    public void presentResearcherInformation(int id, String name, int studyId) {
        displayResearcherInfoInterface.displayResearcherInfo(id, name, studyId);
    }

    /**
     * Presents a success message saying that the researcher has been enrolled.
     *
     * @param researcherId   The researcher's id.
     * @param researcherName The researcher's name.
     * @param studyId        The study's id.
     * @param studyName      The study's name.
     */
    @Override
    public void presentEnrollmentSuccess(int researcherId, String researcherName, int studyId, String studyName, int userId) {
        String messageToPresenter = "Researcher " + researcherName +
                " has been enrolled in study (" + studyId + "): " + studyName;
        displaySuccessMessage.presentGeneralSuccessMessage(messageToPresenter);
        fetchStudyLogController.fetchStudyLog(studyId, userId);
    }


    /**
     * Presents the failure to add a potential participant to a study.
     * @param displayFailureMessage The presenter to display the failure message.
     */
    public void setDisplayFailureMessage(DisplayFailureMessageInterface displayFailureMessage) {
        this.displayFailureMessage = displayFailureMessage;
    }


    /**
     * Presents the success to add a potential participant to a study.
     * @param displaySuccessMessage The presenter to display the success message.
     */
    public void setDisplaySuccessMessage(DisplaySuccessMessageInterface displaySuccessMessage) {
        this.displaySuccessMessage = displaySuccessMessage;
    }


    /**
     * Sets the controller for fetching the study log.
     * @param fetchStudyLogController The controller for fetching the study log.
     */
    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }


    /**
     * Sets the display researcher info interface.
     * @param displayResearcherInfoInterface
     */
    public void setDisplayResearcherInfoInterface(DisplayResearcherInfoInterface displayResearcherInfoInterface) {
        this.displayResearcherInfoInterface = displayResearcherInfoInterface;
    }
}
