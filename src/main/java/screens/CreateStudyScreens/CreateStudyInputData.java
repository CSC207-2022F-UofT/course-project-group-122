package screens.CreateStudyScreens;

import view.ViewModel;

public class CreateStudyInputData {
    private int researchID;
    private ViewModel viewModel;

    public CreateStudyInputData(int researchID, ViewModel viewModel) {
        this.researchID = researchID;
        this.viewModel = viewModel;
    }

    public int getResearchID() {
        return researchID;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }
}
