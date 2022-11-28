package use_cases.add_potential_participant;

import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_participant_info.DisplayParticipantInfoInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class AddPotentialParticipantPresenter implements AddPotentialParticipantOutputBoundary {

    /**
     * Display participant info
     */
    private DisplayParticipantInfoInterface displayParticipantInfo;


    /**
     * The display failure message interface.
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
     * Presents the success to add a potential participant to a study.
     * @param participantID The ID of the participant to add.
     * @param studyId       The ID of the study to add the participant to.
     */
    @Override
    public void presentSuccess(int participantID, int studyId, int userId) {
        String successMessage = "Participant " + participantID + " has been added to study " + studyId + " as a " +
                "potential participant.";
        fetchStudyLogController.fetchStudyLog(studyId, userId);
        displaySuccessMessage.presentGeneralSuccessMessage(successMessage);
    }

    /**
     * Presents the failure to add a potential participant to a study.
     * @param participantID The ID of the participant to add.
     * @param studyId       The ID of the study to add the participant to.
     */
    @Override
    public void presentFailure(int participantID, int studyId, String message) {
        String failureMessage = "Participant " + participantID + " cannot be added to study " + studyId + ". " + message;
        displayFailureMessage.presentFailureMessage(failureMessage);
    }

    /**
     * Presents the participant information.
     *
     * @param participantID The ID of the participant to add.
     * @param name          The name of the participant.
     */
    @Override
    public void presentParticipantInfo(int participantID, String name, int studyId) {
        displayParticipantInfo.displayParticipantInfo(participantID, name, studyId);
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
     * Sets the fetch study log controller.
     */
    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }


    /**
     * Sets the display participant info interface.
     */
    public void setDisplayParticipantInfo(DisplayParticipantInfoInterface displayParticipantInfo) {
        this.displayParticipantInfo = displayParticipantInfo;
    }
}
