package use_cases.researcher_edit_answer;

import use_cases.fetch_id.FetchId;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;
import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

/**
 * The presenter that the use case calls on.
 */
public class ResearcherEditAnswerPresenter implements ResearcherEditAnswerOutputBoundary {

    /**
     * The controller for the fetch study log use case.
     */
    FetchStudyLogController fetchStudyLogController;

    /**
     * The controller for the fetch participant study data use case.
     */
    FetchParticipantStudyDataController fetchParticipantStudyDataController;

    /**
     * The interface for displaying a failure message.
     */
    private DisplayFailureMessageInterface displayFailureMessage;

    /**
     * The interface for displaying a success message.
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;

    /**
     * Display that the answer was successfully edited.
     *
     * @param researcherID  The id of the researcher editing the answer.
     * @param participantID The id of the participant who answered the question.
     * @param studyId       The id of the study that the answer is in.
     * @param answerID      The id of the answer to edit.
     */
    @Override
    public void presentAnswerEditedSuccessfully(int researcherID, int participantID, int studyId, int answerID) {
        String message = "Answer" + answerID + "was modified by " + FetchId.getUser(researcherID).getName();
        fetchStudyLogController.fetchStudyLog(studyId, researcherID);
        fetchParticipantStudyDataController.fetchParticipantStudyData(participantID, researcherID);
        displaySuccessMessage.presentGeneralSuccessMessage(message);
    }

    /**
     * @param message The failure message to display.
     */
    public void presentDisplayFailureMessage(String message) {
        displayFailureMessage.presentFailureMessage(message);
    }

    /**
     * Set the display failure message interface.
     *
     * @param displayFailureMessage The display failure message interface.
     */
    public void setDisplayFailureMessage(DisplayFailureMessageInterface displayFailureMessage) {
        this.displayFailureMessage = displayFailureMessage;
    }

    /**
     * Set the display success message interface.
     *
     * @param displaySuccessMessage The display success message interface.
     */
    public void setDisplaySuccessMessage(DisplaySuccessMessageInterface displaySuccessMessage) {
        this.displaySuccessMessage = displaySuccessMessage;
    }

    /**
     * Set the fetch study log controller.
     *
     * @param fetchStudyLogController The fetch study log controller.
     */
    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }

    /**
     * Set the fetch participant study data controller.
     *
     * @param fetchParticipantStudyDataController The fetch participant study data controller.
     */
    public void setFetchParticipantStudyDataController(FetchParticipantStudyDataController fetchParticipantStudyDataController) {
        this.fetchParticipantStudyDataController = fetchParticipantStudyDataController;
    }
}
