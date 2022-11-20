package user_interface_layer.screens.choose_groups_to_assign;

public class ChooseGroupToAssignInputData {
    private final int studyID;

    private final int questionnaireID;

    private final String[] groupsToChoose;

    private final String[] targetGroup;



    public ChooseGroupToAssignInputData(int studyID, int questionnaireID, String[] groupsToChoose, String[] targetGroup) {
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.groupsToChoose = groupsToChoose;
        this.targetGroup = targetGroup;
    }

    public int getStudyID() {
        return studyID;
    }

    public int getQuestionnaireID() {
        return questionnaireID;
    }

    public String[] getGroupsToChoose() {
        return groupsToChoose;
    }

    public String[] getTargetGroup() {
        return targetGroup;
    }
}
