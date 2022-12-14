package use_cases.result_extraction;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;

import java.util.ArrayList;

/**
 * The presenter that the use case calls on.
 */
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
    public String presentSavingInfo(@NotNull ArrayList<String> failList){
        StringBuilder failMessage = new StringBuilder();
        for (String fail: failList){
            failMessage.append(fail);
            failMessage.append("\n");
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

    public void presentFailSave(String message){
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
