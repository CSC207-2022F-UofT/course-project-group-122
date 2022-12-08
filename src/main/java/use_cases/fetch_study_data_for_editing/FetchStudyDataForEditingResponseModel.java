package use_cases.fetch_study_data_for_editing;

/**
 * The response model that the use case returns to the screen.
 */
public class FetchStudyDataForEditingResponseModel {
    /**
     * The study id
     */
    private final int studyID;

    /**
     * The study name
     */
    private final String studyName;

    /**
     * The study description
     */
    private final String studyDescription;

    /**
     * The target study size
     */
    private final int targetSize;

    /**
     * The study type
     */
    private final String studyType;

    /**
     * Creates a new FetchStudyDataForEditingResponseModel
     * @param studyID           The study id
     * @param studyName         The study name
     * @param studyDescription  The study description
     * @param targetSize        The target study size
     * @param studyType         The study type
     */
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

    /**
     * Gets the study id
     * @return the study id
     */
    public int getStudyID() {
        return studyID;
    }


    /**
     * Gets the study name
     * @return the study name
     */
    public String getStudyName() {
        return studyName;
    }

    /**
     * Gets the study description
     * @return the study description
     */
    public String getStudyDescription() {
        return studyDescription;
    }

    /**
     * Gets the target study size
     * @return the target study size
     */
    public int getTargetSize() {
        return targetSize;
    }

    /**
     * Gets the study type
     * @return the study type
     */
    public String getStudyType() {
        return studyType;
    }


}

