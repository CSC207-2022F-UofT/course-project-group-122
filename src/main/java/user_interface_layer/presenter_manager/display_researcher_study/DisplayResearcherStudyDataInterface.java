package user_interface_layer.presenter_manager.display_researcher_study;

import use_cases.fetch_study_data.FetchStudyDataResponseModel;

/**
 * The interface that the presenter calls to display the researcher study screen.
 */
public interface DisplayResearcherStudyDataInterface {

    /**
     * @param response The data needed to display the researcher study screen.
     */
    void presentResearcherHomeScreen(FetchStudyDataResponseModel response);
}
