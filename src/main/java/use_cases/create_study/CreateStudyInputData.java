package use_cases.create_study;

import java.util.List;

public class CreateStudyInputData {

    public int researcherID;
    public String studyName;
    public String studyDescription;
    int targetSize;
    String studyTypeInput;
    int groupNumber;
    List<String> groupNames;

    public CreateStudyInputData(int researcherID, String studyName, String studyDescription, int targetSize, String studyTypeInput, int groupNum, List<String> groupNames) {
        this.researcherID = researcherID;
        this.studyName = studyName;
        this.studyDescription = studyDescription;
        this.targetSize = targetSize;
        this.studyTypeInput = studyTypeInput;
        this.groupNumber = groupNum;
        this.groupNames = groupNames;
    }
}
