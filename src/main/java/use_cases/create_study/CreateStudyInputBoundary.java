package use_cases.create_study;

public interface CreateStudyInputBoundary {

    /**
     * Creates a new study.
     * @param researcherId  The researcher ID.
     * @param studyName     The study name.
     * @param description   The study description.
     * @param targetSize    The study target size.
     * @param studyType     The study type.
     */
    int createStudyObject(int researcherId, String studyType, String studyName, String description, int targetSize);



    /**
     * Sets the number of groups in the study and the respective group names.
     * @param numberOfGroups    The number of groups.
     * @param groupNames        The group names.
     * @param studyId           The study ID.
     */
    void setStudyGrouping(int studyId, int numberOfGroups, String[] groupNames);
}
