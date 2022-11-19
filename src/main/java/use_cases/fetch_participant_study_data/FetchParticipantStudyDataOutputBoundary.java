package use_cases.fetch_participant_study_data;

import entities.User;

public interface FetchParticipantStudyDataOutputBoundary {

    /**
     * Displays the study data for the given participant.
     * @param response  The response model containing the study data.
     */
    void displayParticipantStudyData(FetchParticipantStudyDataResponseModel response, User user);
}
