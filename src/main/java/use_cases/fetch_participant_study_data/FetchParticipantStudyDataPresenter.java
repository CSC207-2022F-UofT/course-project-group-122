package use_cases.fetch_participant_study_data;

import UserInterfaceLayer.PresenterManager.DisplayParticipantStudy.DisplayParticipantStudyDataInterface;
import entities.Participant;
import entities.User;

public class FetchParticipantStudyDataPresenter implements FetchParticipantStudyDataOutputBoundary {

    /**
     * The view model used to control the view
     */
    private DisplayParticipantStudyDataInterface screenSetter;


    /**
     * Displays the study data for the given participant.
     *
     * @param response The response model containing the study data.
     */
    @Override
    public void displayParticipantStudyData(FetchParticipantStudyDataResponseModel response, User user) {
        if (user instanceof Participant) {
            screenSetter.presentParticipantHomeScreenForParticipant(response);
        } else {
            screenSetter.presentParticipantHomeScreenForResearcher(response);
        }
    }

    /**
     * Sets the view model used to control the view.
     *
     * @param screenSetter The view model used to control the view.
     */
    public void setViewModel(DisplayParticipantStudyDataInterface screenSetter) {
        this.screenSetter = screenSetter;
    }
}
