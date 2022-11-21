package user_interface_layer.presenter_manager.display_researcher_study;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_data.FetchStudyDataResponseModel;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.researcher_home_screen.ResearcherStudyScreen;
import user_interface_layer.screens.researcher_home_screen.ResearcherStudyScreenInputData;

public class DisplayResearcherStudyData implements DisplayResearcherStudyDataInterface{
    ScreenManager screenManager;
    ControllerManager controllerManager;

    /**
     * The constructor of the class.
     *
     * @param screenManager     The screen manager.
     * @param controllerManager The controller manager.
     */
    public DisplayResearcherStudyData(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }


    @Override
    public void presentResearcherHomeScreen(@NotNull FetchStudyDataResponseModel response) {
        ResearcherStudyScreenInputData data = new ResearcherStudyScreenInputData(
                response.getResearcherID(),
                response.getResearcherName(),
                response.getStudiesData()
        );
        ResearcherStudyScreen screen = new ResearcherStudyScreen(data, controllerManager);
        screenManager.setResearcherStudyScreen(screen);
        screenManager.updateCurrentScreen(screen);

    }
    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

    public void setControllerManager(ControllerManager controllerManager){
        this.controllerManager = controllerManager;
    }
}
