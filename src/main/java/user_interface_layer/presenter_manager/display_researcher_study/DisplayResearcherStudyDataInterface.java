package user_interface_layer.presenter_manager.display_researcher_study;

import use_cases.fetch_study_data.FetchStudyDataResponseModel;

public interface DisplayResearcherStudyDataInterface {

    void presentResearcherHomeScreen(FetchStudyDataResponseModel response);
}
