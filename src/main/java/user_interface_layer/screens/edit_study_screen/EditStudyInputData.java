package user_interface_layer.screens.edit_study_screen;

import user_interface_layer.screens.ControllerManager;

public class EditStudyInputData {
    int studyID;
    String studyName;
    String studyDescription;
    int targetSize;
    EditStudyInputData(int studyID,
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

