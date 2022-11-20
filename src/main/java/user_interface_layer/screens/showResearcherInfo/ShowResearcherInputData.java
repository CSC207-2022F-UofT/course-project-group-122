package user_interface_layer.screens.showResearcherInfo;

public class ShowResearcherInputData {
    int researcherId;
    String userName;

    int StudyId;

    public ShowResearcherInputData(int userId, String userName, int StudyId) {
        this.researcherId = userId;
        this.userName = userName;
        this.StudyId = StudyId;
    }

    public int getResearcherId() {
        return researcherId;
    }

    public String getUserName() {
        return userName;
    }

    public int getStudyId() {
        return StudyId;
    }
}

