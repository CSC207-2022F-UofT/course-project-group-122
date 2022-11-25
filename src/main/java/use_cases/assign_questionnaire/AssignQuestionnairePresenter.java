package use_cases.assign_questionnaire;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
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
    public void assignToAllPresent(int questionnaireID, int studyID) {
        String successMessage = "The questionnaire" + questionnaireID +
                " has been assigned to all participants in the study" + studyID;
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
    public void assignToGroupPresent(int questionnaireID, int studyID, String group) {
        String successMessage = "The questionnaire" + questionnaireID + " has been assigned to group" + group +
                " in the study" + studyID;
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
     * Presents that the questionnaire has been assigned to all participant in study.
     *
     * @param questionnaireID The ID of the questionnaire that has been published.
     * @param studyID         The ID of the study that the questionnaire has been published to.
     * @param participantID   The ID of the participant that the questionnaire should assign to.
     */
    @Override
    public void assignToParticipantPresent(int questionnaireID, int studyID, int participantID) {
        String successMessage = "The questionnaire" + questionnaireID + " has been assigned to participant" +
                participantID + " in the study" + studyID;
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
}
