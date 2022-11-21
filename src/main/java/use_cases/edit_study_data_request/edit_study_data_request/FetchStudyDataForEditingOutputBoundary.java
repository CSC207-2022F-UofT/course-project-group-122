package use_cases.edit_study_data_request.edit_study_data_request;

import use_cases.edit_study_data_request.EditStudyInputData;

public interface FetchStudyDataForEditingOutputBoundary {
    void presentStudyDataForEditing(EditStudyInputData response);
}
