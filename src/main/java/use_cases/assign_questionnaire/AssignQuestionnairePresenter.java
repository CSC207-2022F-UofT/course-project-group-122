package use_cases.assign_questionnaire;

import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_participant_info.DisplayParticipantInfoInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class AssignQuestionnairePresenter implements AssignQuestionnaireOutputBoundary {


    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;


    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;


    /**
     * Fetch the study log controller.
     */
    private FetchStudyLogController fetchStudyLogController;


    /**
     * Display the participant info
     */
    private DisplayParticipantInfoInterface displayParticipantInfo;


    /**
     * Presents that the questionnaire has fail to assign to all participant in study.
     *
     * @param QuestionnaireId The ID of the questionnaire that cannot be published.
     * @param message         The message to present.
     */
    @Override
    public void assignToAllFail(int QuestionnaireId, int studyID, String message) {
        String errorMessages = "The questionnaire with the id " + QuestionnaireId + " cannot be assigned " + message;
        displayFailureMessage.presentFailureMessage(errorMessages);
    }

    /**
     * Presents that the questionnaire has been assigned to all participant in study.
     *
     * @param questionnaireID The ID of the questionnaire that has been published.
     * @param studyID         The ID of the study that the questionnaire has been published to.
     */
    @Override
    public void assignToAllPresent(int questionnaireID, int studyID, int researcherId) {
        String successMessage = "The questionnaire" + questionnaireID +
                " has been assigned to all participants in the study" + studyID;
        fetchStudyLogController.fetchStudyLog(studyID, researcherId);
        displaySuccessMessage.presentGeneralSuccessMessage(successMessage);
    }

    /**
     * Presents that the questionnaire has fail to assign tp group.
     *
     * @param QuestionnaireId The ID of the questionnaire that cannot be published.
     * @param studyID         The ID of the study that the questionnaire has been published to.
     * @param group          The ID of the group that the questionnaire should assign to.
     * @param message         The message to present.
     */
    @Override
    public void assignToGroupFail(int QuestionnaireId, int studyID, String group, String message) {
        String errorMessages = "The questionnaire with the id " + QuestionnaireId + " cannot assign to group "
                + group + message;
        displayFailureMessage.presentFailureMessage(errorMessages);
    }

    /**
     * Presents that the questionnaire has been assigned to a group in the study.
     *
     * @param questionnaireID The ID of the questionnaire that cannot be published.
     *  @param studyID         The ID of the study that the questionnaire has been published to.
     *  @param group          The ID of the group that the questionnaire should assign to.
     */
    @Override
    public void assignToGroupPresent(int questionnaireID, int studyID, String group, int researcherId) {
        String successMessage = "The questionnaire" + questionnaireID + " has been assigned to group" + group +
                " in the study" + studyID;
        fetchStudyLogController.fetchStudyLog(studyID, researcherId);
        displaySuccessMessage.presentGeneralSuccessMessage(successMessage);
    }

    /**
     * Presents that the questionnaire has failed to assign to participant.
     *
     * @param QuestionnaireId The ID of the questionnaire that has been published.
     * @param studyID         The ID of the study that the questionnaire has been published to.
     * @param participantID   The ID of the participant that the questionnaire should assign to.
     * @param message         The message to present.
     */
    @Override
    public void assignToParticipantFail(int QuestionnaireId, int studyID, int participantID, String message) {
        String errorMessages = "The questionnaire with the id " + QuestionnaireId + " cannot assign to participant" +
                participantID + message;
        displayFailureMessage.presentFailureMessage(errorMessages);
    }

    /**
     * Fetch the participant info to confirm the assignment.
     * @param name              The name of the participant.
     * @param studyId           The ID of the study that the questionnaire has been published to.
     * @param participantId     The ID of the participant that the questionnaire should assign to.
     * @param questionnaireId   The ID of the questionnaire that has been published.
     */
    @Override
    public void fetchParticipantInfoConfirmation(int participantId, String name, int studyId, int questionnaireId) {
        displayParticipantInfo.displayParticipantInfoForQAssignment(participantId, name, studyId, questionnaireId);

    }

    /**
     * Presents that the questionnaire has been assigned to all participant in study.
     *
     * @param questionnaireID The ID of the questionnaire that has been published.
     * @param studyID         The ID of the study that the questionnaire has been published to.
     * @param participantID   The ID of the participant that the questionnaire should assign to.
     */
    @Override
    public void assignToParticipantPresent(int questionnaireID, int studyID, int participantID, int researcherId) {
        String successMessage = "The questionnaire" + questionnaireID + " has been assigned to participant" +
                participantID + " in the study" + studyID;
        fetchStudyLogController.fetchStudyLog(studyID, researcherId);
        displaySuccessMessage.presentGeneralSuccessMessage(successMessage);
    }


    /**
     * set the display failure message interface
     * @param displayFailureMessage The presenter to display the failure message.
     */
    public void setDisplayFailureMessage(DisplayFailureMessageInterface displayFailureMessage) {
        this.displayFailureMessage = displayFailureMessage;
    }


    /**
     * set the display success message interface
     * @param displaySuccessMessage The presenter to display the success message.
     */
    public void setDisplaySuccessMessage(DisplaySuccessMessageInterface displaySuccessMessage) {
        this.displaySuccessMessage = displaySuccessMessage;
    }


    /**
     * set the fetch study log controller
     * @param fetchStudyLogController The controller to fetch the study log.
     */
    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }


    /**
     * set the display participant info interface
     * @param displayParticipantInfo The presenter to display the participant info.
     */
    public void setDisplayParticipantInfo(DisplayParticipantInfoInterface displayParticipantInfo) {
        this.displayParticipantInfo = displayParticipantInfo;
    }
}

