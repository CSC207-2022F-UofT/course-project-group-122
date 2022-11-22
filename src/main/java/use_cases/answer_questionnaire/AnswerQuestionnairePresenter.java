package use_cases.answer_questionnaire;

import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class AnswerQuestionnairePresenter implements AnswerQuestionnaireOutputBoundary {

    /**
     * The fetch participant study data controller.
     */
    private FetchParticipantStudyDataController fetchParticipantStudyDataController;


    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;


    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;


    /**
     * Present failure to answer questionnaire.
     *
     * @param message The failure message.
     */
    @Override
    public void presentAnswerQuestionnaireFailure(String message) {
        displayFailureMessage.presentFailureMessage(message);
    }

    /**
     * Present success to answer questionnaire.
     *
     * @param participantId     The participant ID.
     * @param modifierId        The modifier ID.
     * @param questionnaireId   The questionnaire ID.
     * @param time              The time.
     */
    @Override
    public void presentAnswerQuestionnaireSuccess(int participantId, int modifierId, int questionnaireId, String time) {
        String message = "Participant " + participantId + " has answered questionnaire " + questionnaireId + " at " + time;
        displaySuccessMessage.presentGeneralSuccessMessage(message);
        fetchParticipantStudyDataController.fetchParticipantStudyData(participantId, modifierId);
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
     * Sets the fetch participant study data controller.
     * @param fetchParticipantStudyDataController The fetch participant study data controller.
     */
    public void setFetchParticipantStudyDataController(FetchParticipantStudyDataController fetchParticipantStudyDataController) {
        this.fetchParticipantStudyDataController = fetchParticipantStudyDataController;
    }
}
