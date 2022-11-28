package use_cases.modify_study_parameters;

public class ModifyStudyParameterRequestModel {

    /**
     * The ID of the researcher.
     */
    private int researcherId;

    /**
     * The id of the study to modify.
     */
    private int studyId;

    /**
     * The new name of the study.
     */
    private String studyName;

    /**
     * The new description of the study.
     */
    private String studyDescription;

    /**
     * The target number of participants for the study.
     */
    private int studyTargetSize;

    /**
     * The type of the study.
     * Has to be one of the following:
     * "General",
     * "Randomized"
     */
    private String studyType;

    /**
     * The number of groups in the study.
     */
    private int numGroups;

    /**
     * The names of the groups in the study.
     * The number of names has to be equal to the number of groups.
     */
    private String[] groupNames;


    /**
     * Creates a new ModifyStudyParameterRequestModel.
     * @param studyId           The id of the study to modify.
     * @param studyName         The new name of the study.
     * @param studyDescription  The new description of the study.
     */
    public ModifyStudyParameterRequestModel(int studyId, String studyName, String studyDescription) {
        this.studyId = studyId;
        this.studyName = studyName;
        this.studyDescription = studyDescription;
    }


    /**
     * Creates a new ModifyStudyParameterRequestModel.
     * @param researcherId    The ID of the researcher.
     */
    public void setResearcherId(int researcherId) {
        this.researcherId = researcherId;
    }


    /**
     * Set the target size of the study.
     * @param studyTargetSize
     */
    public void setStudyTargetSize(int studyTargetSize) {
        this.studyTargetSize = studyTargetSize;
    }


    /**
     * Set the type of the study.
     * @param studyType The type of the study.
     */
    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    /**
     * Set the number of groups in the study.
     * @param numGroups     The number of groups in the study.
     */
    public void setNumGroups(int numGroups) {
        this.numGroups = numGroups;
    }


    /**
     * Set the names of the groups in the study.
     *
     * @param groupNames    The names of the groups in the study.
     */
    public void setGroupNames(String[] groupNames) {
        this.groupNames = groupNames;
    }


    /**
     * Returns the ID of the researcher.
     * @return The ID of the researcher.
     */
    public int getResearcherId() {
        return researcherId;
    }


    /**
     * Get the id of the study to modify.
     * @return  The id of the study to modify.
     */
    public int getStudyId() {
        return studyId;
    }


    /**
     * Get the new name of the study.
     * @return  The new name of the study.
     */
    public String getStudyName() {
        return studyName;
    }


    /**
     * Get the new description of the study.
     * @return  The new description of the study.
     */
    public String getStudyDescription() {
        return studyDescription;
    }


    /**
     * Get the target number of participants for the study.
     * @return  The target number of participants for the study.
     */
    public int getStudyTargetSize() {
        return studyTargetSize;
    }


    /**
     * Get the type of the study.
     * @return  The type of the study.
     */
    public String getStudyType() {
        return studyType;
    }


    /**
     * Get the number of groups in the study.
     * @return  The number of groups in the study.
     */
    public int getNumGroups() {
        return numGroups;
    }


    /**
     * Get the names of the groups in the study.
     * @return  The names of the groups in the study.
     */
    public String[] getGroupNames() {
        return groupNames;
    }
}
