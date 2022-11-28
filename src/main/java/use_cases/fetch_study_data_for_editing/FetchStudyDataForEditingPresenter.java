package use_cases.fetch_study_data_for_editing;

import user_interface_layer.presenter_manager.display_edit_study.DisplayEditStudyInterface;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;

public class FetchStudyDataForEditingPresenter implements FetchStudyDataForEditingOutputBoundary {
    DisplayEditStudyInterface displayEditStudyInterface;

    DisplayFailureMessageInterface displayFailureMessageInterface;


    /**
     * Presents the study data to the user.
     * @param response  The response containing the study data.
     */
    public void presentStudyDataForEditing(FetchStudyDataForEditingResponseModel response) {
        displayEditStudyInterface.presentEditStudyScreen(response);
    }

    /**
     * Presents the failure to fetch the study data for editing
     *
     * @param studyId The study id
     */
    @Override
    public void presentFailture(int studyId) {
        displayFailureMessageInterface.presentFailureMessage("Study with id " + studyId + " has already started and " +
                "cannot be edited.");
    }


    /**
     * Sets the displayEditStudyInterface to the given displayEditStudyInterface.
     * @param displayEditStudyInterface The displayEditStudyInterface to be set.
     */
    public void setDisplayEditStudy(DisplayEditStudyInterface displayEditStudyInterface) {
        this.displayEditStudyInterface = displayEditStudyInterface;
    }


    /**
     * Sets the displayFailureMessageInterface to the given displayFailureMessageInterface.
     * @param displayFailureMessageInterface The displayFailureMessageInterface to be set.
     */
    public void setDisplayFailureMessage(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }
}
