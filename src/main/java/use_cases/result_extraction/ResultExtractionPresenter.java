package use_cases.result_extraction;

import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class ResultExtractionPresenter implements ResultExtractionOutputBoundary {

    DisplaySuccessMessageInterface displaySuccessMessageInterface;


    public void presentSavingInfo(int StudyID, String filepath){
        String message = "The result of study " + StudyID + " has been saved to " + filepath;
        displaySuccessMessageInterface.presentGeneralSuccessMessage(message);
    }

    public void setDisplaySuccessMessageInterface(DisplaySuccessMessageInterface displaySuccessMessageInterface) {
        this.displaySuccessMessageInterface = displaySuccessMessageInterface;
    }


}
