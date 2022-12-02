package user_interface_layer.presenter_manager.display_participant_study;

import use_cases.fetch_participant_study_data.FetchParticipantStudyDataResponseModel;

/**
 * The interface that the presenter calls to display the participant study screen.
 */
public interface DisplayParticipantStudyDataInterface {
    /**
     * @param response The data needed to display the participant study screen.
     */
    void presentParticipantHomeScreenForParticipant(FetchParticipantStudyDataResponseModel response);

    /**
     * @param response The data needed to display the participant study screen for a researcher.
     */
    void presentParticipantHomeScreenForResearcher(FetchParticipantStudyDataResponseModel response);
}
