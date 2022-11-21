package use_cases.edit_study_data_request;

import use_cases.edit_study_data_reque.EditStudyInputData;
import user_interface_layer.presenter_manager.display_edit_study.DisplayEditStudyInterface;

public class FetchStudyDataForEditingPresenter implements FetchStudyDataForEditingOutputBoundary {
    DisplayEditStudyInterface displayEditStudyInterface;
    public void presentStudyDataForEditing(FetchStudyDataForEditingResponseModel response) {
        displayEditStudyInterface.presentEditStudyScreen(response);
    }
}