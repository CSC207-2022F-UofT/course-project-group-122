package use_cases.modify_study_parameters;

interface ModifyStudyParameterInputBoundary {

    /**
     * Returns the list of potential stratification variables for the study.
     * <p>
     * Preconditions: The study is a randomized study and its randomization method is stratified.
     * @param studyID   The ID of the study.
     */
    void checkPotentialStratificationVariables(int studyID);


    /**
     * Modifies the basic parameters of the study.
     * @param studyId           The ID of the study.
     * @param studyName         The new name of the study.
     * @param studyDescription  The new description of the study.
     * @param targetSize        The new target size of the study.
     */
    void modifyStudyBasicParameters(int studyId, String studyName, String studyDescription, int targetSize);


    /**
     * Modifies the randomization method of the study.
     * @param studyId               The ID of the study.
     * @param randomizationMethod   The new randomization method of the study.
     */
    void modifyStudyRandomization(int studyId, String randomizationMethod, int researcherId);


    /**
     * Modifies the stratification variables of the study.
     * @param studyId                   The ID of the study.
     * @param stratificationVariable   The new stratification variable of the study.
     */
    void modifyStudyStratification(int studyId, String stratificationVariable, int researcherId);


    /**
     * Modifies the grouping of the study
     * @param studyId       The ID of the study.
     * @param groupSize     The new group size of the study.
     * @param groupNames    The new group names of the study.
     */
    void modifyStudyGrouping(int studyId, int groupSize, String[] groupNames, int researcherId);
}
