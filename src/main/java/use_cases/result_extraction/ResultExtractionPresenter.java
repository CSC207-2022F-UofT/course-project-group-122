package use_cases.result_extraction;

import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;

import java.util.ArrayList;

public class ResultExtractionPresenter implements ResultExtractionOutputBoundary {

    DisplaySuccessMessageInterface displaySuccessMessageInterface;
    DisplayFailureMessageInterface displayFailureMessageInterface;


    public String presentSavingInfo(ArrayList<String> failList){
        StringBuilder failMessage = new StringBuilder();
        for (String fail: failList){
            failMessage.append("\r\n").append(fail);
        }
        return failMessage.toString();
    }
    public void presentSuccessSave(int StudyID, String filepath){
        String message = "The result of study " + StudyID + " has been saved to " + filepath + "correctly";
        displaySuccessMessageInterface.presentGeneralSuccessMessage(message);
    }

    public void presentFailSave(int StudyID, String filepath, ArrayList<String> failList){
        String message =  "The result of study " + StudyID + " has been saved to " + filepath + " incorrectly\r\n" +
                presentSavingInfo(failList);;

        displayFailureMessageInterface.presentFailureMessage(message);

    }

    public void setDisplaySuccessMessageInterface(DisplaySuccessMessageInterface displaySuccessMessageInterface) {
        this.displaySuccessMessageInterface = displaySuccessMessageInterface;
    }

    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface){
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }


}
