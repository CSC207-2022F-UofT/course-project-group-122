package use_cases.create_study;

public class CreateStudyRequestModel {

    /**
     * The id of the researcher who created the study.
     */
    private final int researcherId;

    /**
     * The name of the study.
     */
    private final String studyName;

    /**
     * The description of the study.
     */
    private final String studyDescription;

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
     * Creates a new .
     * @param studyName         The name of the study.
     * @param studyDescription  The description of the study.
     */
    public CreateStudyRequestModel(int researcherId, String studyName, String studyDescription) {
        this.researcherId = researcherId;
        this.studyName = studyName;
        this.studyDescription = studyDescription;
    }


    /**
     * Set the target size of the study.
     * @param studyTargetSize   The target size of the study.
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


    /**
     * Get the id of the researcher who created the study.
     * @return  The id of the researcher who created the study.
     */
    public int getResearcherId() {
        return researcherId;
    }
}
