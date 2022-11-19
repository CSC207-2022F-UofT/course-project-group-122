package use_cases.fetch_participant_study_data;

import entities.Participant;
import entities.User;
import view.ViewModel;

public class FetchParticipantStudyDataPresenter implements FetchParticipantStudyDataOutputBoundary {

    /**
     * The view model used to control the view
     */
    private ViewModel viewModel;


    /**
     * Displays the study data for the given participant.
     *
     * @param response The response model containing the study data.
     */
    @Override
    public void displayParticipantStudyData(FetchParticipantStudyDataResponseModel response, User user) {
        if (user instanceof Participant) {
            viewModel.presentParticipantHomeScreenForParticipant(response);
        } else {
            viewModel.presentParticipantHomeScreenForResearcher(response);
        }
    }

    /**
     * Sets the view model used to control the view.
     *
     * @param viewModel The view model used to control the view.
     */
    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
