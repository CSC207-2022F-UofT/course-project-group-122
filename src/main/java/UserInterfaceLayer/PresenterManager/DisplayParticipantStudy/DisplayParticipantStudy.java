package UserInterfaceLayer.PresenterManager.DisplayParticipantStudy;

import UserInterfaceLayer.ScreenManager;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataResponseModel;

public class DisplayParticipantStudy implements DisplayParticipantStudyDataInterface{
    ScreenManager screenManager;
    @Override
    public void presentParticipantHomeScreenForParticipant(FetchParticipantStudyDataResponseModel response) {

    }

    @Override
    public void presentParticipantHomeScreenForResearcher(FetchParticipantStudyDataResponseModel response) {

    }
    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }
}
