package user_interface_layer.presenter_manager.display_researcher_study;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.participant_no_study_screen.ParticipantNoStudyScreen;
import user_interface_layer.screens.researcher_home_screen.ResearcherStudyScreen;
import user_interface_layer.screens.researcher_home_screen.ResearcherStudyScreenInputData;
import use_cases.fetch_study_data.FetchStudyDataResponseModel;

public class DisplayResearcherStudy implements DisplayResearcherStudyDataInterface{
    ScreenManager screenManager;
    ControllerManager controllerManager;

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
