package screens.CreateEditQuestionnaireScreens.CreateQuestionnaireScreen;

import view.ViewModel;

public class CreateQuestionnaireDataInput {
    private final int studyID;

    private final ViewModel viewModel;

    public CreateQuestionnaireDataInput(int studyID, ViewModel viewModel) {
        this.studyID = studyID;

        this.viewModel = viewModel;
    }

    public int getStudyID() {
        return studyID;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }
}
