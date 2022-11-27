package user_interface_layer.presenter_manager.display_edit_study;

import use_cases.fetch_study_data_for_editing.FetchStudyDataForEditingResponseModel;

/**
 * The interface that the presenter calls to display the edit study screen.
 */
public interface DisplayEditStudyInterface {

    void presentEditStudyScreen(FetchStudyDataForEditingResponseModel data);
}
