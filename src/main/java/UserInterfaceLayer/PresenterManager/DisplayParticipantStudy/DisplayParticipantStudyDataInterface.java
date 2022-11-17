package UserInterfaceLayer.PresenterManager.DisplayParticipantStudy;

import use_cases.fetch_participant_study_data.FetchParticipantStudyDataResponseModel;

public interface DisplayParticipantStudyDataInterface {
    void presentParticipantHomeScreenForParticipant(FetchParticipantStudyDataResponseModel response);

    void presentParticipantHomeScreenForResearcher(FetchParticipantStudyDataResponseModel response);
}