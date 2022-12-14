package user_interface_layer.presenter_manager.display_researcher_study_log;

import use_cases.fetch_study_log.FetchStudyLogResponseModel;
import user_interface_layer.presenter_manager.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.study_data_log.StudyDataLogScreen;

/**
 * The class that displays information about a specific study/
 */
public class DisplayResearcherStudyLog implements DisplayResearcherStudyLogInterface {
    /**
     * The screen manager.
     */
    ScreenManager screenManager;
    /**
     * The controller manager.
     */
    ControllerManager controllerManager;

    /**
     * The constructor of the class.
     *
     * @param screenManager         The screen manager.
     * @param controllerManager     The controller manager.
     */
    public DisplayResearcherStudyLog(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }

    /**
     * @param data The data needed to display the researcher study log screen.
     */
    @Override
    public void presentResearcherStudyLogScreen(FetchStudyLogResponseModel data) {
        StudyDataLogScreen screen = new StudyDataLogScreen(data, controllerManager);
        screenManager.setStudyDataLogScreen(screen);
        screenManager.updateCurrentScreen(screen);

    }

}
