package user_interface_layer.presenter_manager.display_researcher_study_log;

import use_cases.fetch_study_log.FetchStudyLogResponseModel;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.study_data_log.StudyDataLogScreen;

public class DisplayResearcherStudyLog implements DisplayResearcherStudyLogInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;
    @Override
    public void presentResearcherStudyLogScreen(FetchStudyLogResponseModel data) {
        StudyDataLogScreen screen = new StudyDataLogScreen(data, controllerManager);
        screenManager.setStudyDataLogScreen(screen);
        screenManager.updateCurrentScreen(screen);

    }

}
