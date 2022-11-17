package UserInterfaceLayer.PresenterManager.DisplayResearcherStudy;

import use_cases.fetch_study_data.FetchStudyDataResponseModel;

public interface DisplayResearcherStudyDataInterface {
    void presentParticipantNotEnrolledScreen(String username, int id);

    void presentResearcherHomeScreen(FetchStudyDataResponseModel response);
}
