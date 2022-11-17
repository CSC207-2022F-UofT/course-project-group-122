package UserInterfaceLayer.PresenterManager.DisplayResearcherStudy;

import UserInterfaceLayer.ScreenManager;
import use_cases.fetch_study_data.FetchStudyDataResponseModel;

public class DisplayResearcherStudy implements DisplayResearcherStudyDataInterface{
    ScreenManager screenManager;
    @Override
    public void presentParticipantNotEnrolledScreen(String username, int id) {

    }

    @Override
    public void presentResearcherHomeScreen(FetchStudyDataResponseModel response) {

    }
    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }
}
