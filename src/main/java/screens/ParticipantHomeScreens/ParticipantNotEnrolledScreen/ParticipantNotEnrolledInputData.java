package screens.ParticipantHomeScreens.ParticipantNotEnrolledScreen;

import view.ViewModel;

public class ParticipantNotEnrolledInputData {
    private final int participantID;
    private ViewModel viewModel;

    public ParticipantNotEnrolledInputData(int participantID, ViewModel viewModel) {
        this.participantID = participantID;
        this.viewModel = viewModel;
    }

    public int getParticipantID() {
        return participantID;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }
}
