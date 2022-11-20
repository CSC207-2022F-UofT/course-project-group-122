package use_cases.edit_study;

import java.util.List;

public class EditStudyInputDataForController {

    private final int studyId;
    private final String studyName;
    private final String studyDescription;
    private final int targetSize;

    private final String studyTypeInput;
    private final int groupNum;
    private final List<String> groupNames;

    public EditStudyInputDataForController(int studyId,
                                           String studyName,
                                           String studyDescription,
                                           int studyTargetSize,
                                           String studyTypeInput,
                                           int groupNum,
                                           List<String> groupNames){
        this.studyId = studyId;
        this.studyName = studyName;
        this.studyDescription = studyDescription;
        this.targetSize = studyTargetSize;
        this.studyTypeInput = studyTypeInput;
        this.groupNum = groupNum;
        this.groupNames = groupNames;
    }

    public int getStudyId() {
        return studyId;
    }

    public String getStudyName() {
        return studyName;
    }

    public String getStudyDescription() {
        return studyDescription;
    }

    public int getTargetSize() {
        return targetSize;
    }

    public String getStudyTypeInput() {
        return studyTypeInput;
    }

    public int getGroupNum() {
        return groupNum;
    }

    public List<String> getGroupNames() {
        return groupNames;
    }
}
