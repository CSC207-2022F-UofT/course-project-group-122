package screens.EnrollPotentialParticipantScreen;

import view.ViewModel;

import java.util.List;

public class EnrollPotentialParticipantInputData {
    private final int studyID;

    private String[] potentialsTableHeader = {"ID", "Username", "Name"};
    private List<String[]> potentialParticipants;

    public ViewModel viewModel;
    public EnrollPotentialParticipantInputData(int studyID, List<String[]> potentialParticipants, ViewModel viewModel) {
        this.studyID = studyID;
        this.potentialParticipants = potentialParticipants;
        this.viewModel = viewModel;
    }

    public int getStudyID() {
        return studyID;
    }

    public String[] getPotentialsTableHeader() {
        return potentialsTableHeader;
    }

    public List<String[]> getPotentialParticipants() {
        return potentialParticipants;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }
}
