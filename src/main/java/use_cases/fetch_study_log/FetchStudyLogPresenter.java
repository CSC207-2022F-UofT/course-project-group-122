package use_cases.fetch_study_log;

import user_interface_layer.presenter_manager.display_researcher_study_log.DisplayResearcherStudyLogInterface;

public class FetchStudyLogPresenter implements FetchStudyLogOutputBoundary {

    private DisplayResearcherStudyLogInterface displayResearcherStudyLog;

    /**
     * Present the study log to the user
     *
     * @param fetchStudyLogResponseModel The response model.
     */
    @Override
    public void presentStudyLog(FetchStudyLogResponseModel fetchStudyLogResponseModel) {
        displayResearcherStudyLog.presentResearcherStudyLogScreen(fetchStudyLogResponseModel);
    }

    /**
     * Set the display researcher study log interface
     * @param displayResearcherStudyLog The display researcher study log interface
     */
    public void setDisplayResearcherStudyLog(DisplayResearcherStudyLogInterface displayResearcherStudyLog) {
        this.displayResearcherStudyLog = displayResearcherStudyLog;
    }
}
