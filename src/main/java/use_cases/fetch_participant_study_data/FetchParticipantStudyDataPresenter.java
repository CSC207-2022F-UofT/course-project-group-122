package use_cases.fetch_participant_study_data;

import user_interface_layer.presenter_manager.display_participant_study.DisplayParticipantStudyDataInterface;


import java.util.Map;
import java.util.Objects;


public class FetchParticipantStudyDataPresenter implements FetchParticipantStudyDataOutputBoundary {

    /**
     * DisplayParticipantStudyDataInterface is the interface that the presenter uses to display the participant
     * home screen for the participant or researcher.
     */

    public DisplayParticipantStudyDataInterface displayParticipantStudyData;



    /**
     * Displays the study data for the given participant.
     *
     * @param response The response model containing the study data.
     */
    @Override
    public void displayParticipantStudyData(FetchParticipantStudyDataResponseModel response, int userId,
                                            String userType) {

        System.out.println(response.getCompletedQuestionnaireAnswerHistory().values().size());
        if (Objects.equals(userType, "Participant")) {
            displayParticipantStudyData.presentParticipantHomeScreenForParticipant(response);
        } else if (Objects.equals(userType, "Researcher")) {
            displayParticipantStudyData.presentParticipantHomeScreenForResearcher(response);
        } else {
            throw new IllegalArgumentException("Invalid user type.");

        }
    }

    /**
     * Sets the display participant study data interface.
     *
     * @param displayParticipantStudyData The display participant study data interface.
     */
    public void setDisplayParticipantStudyData(DisplayParticipantStudyDataInterface displayParticipantStudyData) {
        this.displayParticipantStudyData = displayParticipantStudyData;

    }
}
