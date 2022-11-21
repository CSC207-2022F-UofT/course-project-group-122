package screens.ResearcherHomeScreen;

import entities.User;
import view.ViewModel;

import java.util.List;

public class ResearchersStudiesInputData {
    private User user;
    private final int researchID;
    private String researcherName;
    private final String[] studiesTableHeader = {"ID", "Name", "Description", "Published", "Status"};
    private final List<String[]> studies;
    private final ViewModel viewModel;

    public ResearchersStudiesInputData(int researchID, List<String[]> studies, ViewModel viewModel) {
        this.researchID = researchID;
        this.studies = studies;
        this.viewModel = viewModel;
    }

    public int getResearchID() {
        return researchID;
    }

    public String[] getStudiesTableHeader() {
        return studiesTableHeader;
    }

    public List<String[]> getStudies() {
        return studies;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }

}
