package use_cases.researcher_edit_answer;

import entities.Answer;
import use_cases.fetch_id.FetchId;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;
import use_cases.fetch_study_data.FetchStudyDataController;
import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

import java.util.HashMap;

public class ResearcherEditAnswerPresenter implements ResearcherEditAnswerOutputBoundary{
    FetchStudyLogController fetchStudyLogController;
    FetchParticipantStudyDataController fetchParticipantStudyDataController;
    private DisplayFailureMessageInterface displayFailureMessage;

    private DisplaySuccessMessageInterface displaySuccessMessage;


    @Override
    public void presentAnswerEditedSuccessfully(int researcherID, int participantID, int studyId, int answerID) {
        String message = "Answer" + answerID + "was modified by " + FetchId.getUser(researcherID).getName();
        fetchStudyLogController.fetchStudyLog(studyId, researcherID);
        fetchParticipantStudyDataController.fetchParticipantStudyData(participantID, researcherID);
        displaySuccessMessage.presentGeneralSuccessMessage(message);
    }

    public void presentDisplayFailureMessage(String message){
        displayFailureMessage.presentFailureMessage(message);
    }

    public void setDisplayFailureMessage(DisplayFailureMessageInterface displayFailureMessage) {
        this.displayFailureMessage = displayFailureMessage;
    }

    public void setDisplaySuccessMessage(DisplaySuccessMessageInterface displaySuccessMessage) {
        this.displaySuccessMessage = displaySuccessMessage;
    }
    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }

    public void setFetchParticipantStudyDataController(FetchParticipantStudyDataController fetchParticipantStudyDataController) {
        this.fetchParticipantStudyDataController = fetchParticipantStudyDataController;
    }
}
