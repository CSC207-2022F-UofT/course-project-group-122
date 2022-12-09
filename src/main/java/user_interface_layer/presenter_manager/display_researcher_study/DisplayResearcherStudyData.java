package user_interface_layer.presenter_manager.display_researcher_study;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_data.FetchStudyDataResponseModel;
import user_interface_layer.presenter_manager.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.researcher_home_screen.ResearcherStudyScreen;
import user_interface_layer.screens.researcher_home_screen.ResearcherStudyScreenInputData;

/**
 * The class that displays the researcher's study screen where all  the studies are displayed.
 */
public class DisplayResearcherStudyData implements DisplayResearcherStudyDataInterface{
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
     * @param screenManager     The screen manager.
     * @param controllerManager The controller manager.
     */
    public DisplayResearcherStudyData(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }


    /**
     * @param response The data needed to display the researcher study screen.
     */
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

    /**
     * @param screenManager The screen manager.
     */
    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

    public void setControllerManager(ControllerManager controllerManager){
        this.controllerManager = controllerManager;
    }
}
