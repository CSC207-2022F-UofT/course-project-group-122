package user_interface_layer.presenter_manager.display_researcher_study_log;

import use_cases.fetch_study_log.FetchStudyLogResponseModel;

/**
 * The interface that the presenter calls to display the researcher study log screen.
 */
public interface DisplayResearcherStudyLogInterface {
    /**
     * @param data The data needed to display the researcher study log screen.
     */
    void presentResearcherStudyLogScreen(FetchStudyLogResponseModel data);
}
