package user_interface_layer.presenter_manager.display_researcher_study_log;

import use_cases.fetch_study_log.FetchStudyLogResponseModel;

public interface DisplayResearcherStudyLogInterface {
    void presentResearcherStudyLogScreen(FetchStudyLogResponseModel data);
}
