package UserInterfaceLayer.PresenterManager.DisplayResearcherStudy;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.screens.ControllerManager;
import UserInterfaceLayer.screens.ParticipantNotEnrolledScreen.ParticipantNotEnrolledInputData;
import UserInterfaceLayer.screens.ParticipantNotEnrolledScreen.ParticipantNotEnrolledScreen;
import UserInterfaceLayer.screens.ResearcherHomeScreen.ResearcherStudyScreen;
import UserInterfaceLayer.screens.ResearcherHomeScreen.ResearcherStudyScreenInputData;
import use_cases.fetch_study_data.FetchStudyDataResponseModel;

public class DisplayResearcherStudy implements DisplayResearcherStudyDataInterface{
    ScreenManager screenManager;
    ControllerManager controllerManager;
    @Override
    public void presentParticipantNotEnrolledScreen(String username, int id) {
        ParticipantNotEnrolledInputData data = new ParticipantNotEnrolledInputData(id, username,controllerManager);
        ParticipantNotEnrolledScreen screen = new ParticipantNotEnrolledScreen(data);
        screenManager.setParticipantNotEnrolledScreen(screen);
        screenManager.updateCurrentScreen(screen);

    }

    @Override
    public void presentResearcherHomeScreen(FetchStudyDataResponseModel response) {
        ResearcherStudyScreenInputData data = new ResearcherStudyScreenInputData(
                response.getResearcherID(),
                response.getResearcherName(),
                response.getStudiesData(),
                controllerManager
        );
        ResearcherStudyScreen screen = new ResearcherStudyScreen(data);
        screenManager.setResearcherStudyScreen(screen);
        screenManager.updateCurrentScreen(screen);

    }
    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }
}
