package use_cases.fetch_study_data_for_editing;

public class FetchStudyDataForEditingResponseModel {
    private int studyID;
    private String studyName;
    private String studyDescription;
    private int targetSize;
    private String studyType;
    public FetchStudyDataForEditingResponseModel(int studyID,
                                                 String studyName,
                                                 String studyDescription,
                                                 int targetSize,
                                                 String studyType) {
        this.studyID = studyID;
        this.studyName = studyName;
        this.studyDescription = studyDescription;
        this.targetSize = targetSize;
        this.studyType = studyType;
    }

    public int getStudyID() {
        return studyID;
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

    public String getStudyType() {
        return studyType;
    }


}

