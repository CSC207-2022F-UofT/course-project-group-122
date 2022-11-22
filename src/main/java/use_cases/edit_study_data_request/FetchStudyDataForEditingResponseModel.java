package use_cases.edit_study_data_request;

public class FetchStudyDataForEditingResponseModel {
    int studyID;
    String studyName;
    String studyDescription;
    int targetSize;
    public FetchStudyDataForEditingResponseModel(int studyID,
                                                 String studyName,
                                                 String studyDescription,
                                                 int targetSize) {
        this.studyID = studyID;
        this.studyName = studyName;
        this.studyDescription = studyDescription;
        this.targetSize = targetSize;
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


}

