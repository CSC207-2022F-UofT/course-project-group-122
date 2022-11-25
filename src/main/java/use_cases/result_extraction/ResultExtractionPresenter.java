package use_cases.result_extraction;

import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;

import java.util.ArrayList;

public class ResultExtractionPresenter implements ResultExtractionOutputBoundary {

    /**
     * The display success message interface.
     */
    DisplaySuccessMessageInterface displaySuccessMessageInterface;

    /**
     * The display failure message interface.
     */
    DisplayFailureMessageInterface displayFailureMessageInterface;


    /**
     * Transform the failure message into one String with new line character.
     * @param failList the given list of failure message.
     * @return a String that contain all the failure information.
     */
    public String presentSavingInfo(ArrayList<String> failList){
        StringBuilder failMessage = new StringBuilder();
        for (String fail: failList){
            failMessage.append("\r\n").append(fail);
        }
        return failMessage.toString();
    }

    /**
     * Presents the result extraction failure.
     *
     * @param StudyID the ID of the given study.
     * @param filepath the file path given by researcher.
     */
    public void presentSuccessSave(int StudyID, String filepath){
        String message = "The result of study " + StudyID + " has been saved to " + filepath + "correctly";
        displaySuccessMessageInterface.presentGeneralSuccessMessage(message);
    }

    /**
     * Presents the result extraction success.
     * @param StudyID the ID of the given study.
     * @param filepath the file path given by the researcher.
     * @param failList the list collect failure message.
     */
    public void presentFailSave(int StudyID, String filepath, ArrayList<String> failList){
        String message =  "The result of study " + StudyID + " has been saved to " + filepath + " incorrectly\r\n" +
                presentSavingInfo(failList);

        displayFailureMessageInterface.presentFailureMessage(message);

    }


    /**
     * Sets the interface for presenting success message.
     * @param displaySuccessMessageInterface the interface for related message.
     */
    public void setDisplaySuccessMessageInterface(DisplaySuccessMessageInterface displaySuccessMessageInterface) {
        this.displaySuccessMessageInterface = displaySuccessMessageInterface;
    }

    /**
     * Sets the interface for presenting failure message.
     * @param displayFailureMessageInterface the interface for related message.
     */
    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface){
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }


}
