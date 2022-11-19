package screens.AddUserToStudyScreen;

import view.ViewModel;

import java.util.List;

public class AddUserInputData {

    private final int studyID;

    private final String typeOfUSer;
    private String[] userTableHeader = {"ID", "Username", "Name"};
    private List<String[]> users;

    public ViewModel viewModel;

    public AddUserInputData(int studyID, String typeOfUSer,List<String[]> users, ViewModel viewModel) {
        this.studyID = studyID;
        this.typeOfUSer = typeOfUSer;
        this.users = users;
        this.viewModel = viewModel;
    }

    public String[] getUserTableHeader() {
        return userTableHeader;
    }

    public List<String[]> getUsers() {
        return users;
    }

    public String getTypeOfUSer() {
        return typeOfUSer;
    }

    public int getStudyID() {
        return studyID;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }
}
