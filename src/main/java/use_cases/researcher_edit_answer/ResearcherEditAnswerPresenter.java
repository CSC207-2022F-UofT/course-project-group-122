package use_cases.researcher_edit_answer;

import entities.Answer;
import use_cases.fetch_id.FetchId;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

import java.util.HashMap;

public class ResearcherEditAnswerPresenter implements ResearcherEditAnswerOutputBoundary{

    private DisplayFailureMessageInterface displayFailureMessage;

    private DisplaySuccessMessageInterface displaySuccessMessage;


    @Override
    public void presentAnswerEditedSuccessfully(int answerID, int researcherID) {
        String message = "Answer" + answerID + "was modified by " + FetchId.getUser(researcherID).getName();
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
}
