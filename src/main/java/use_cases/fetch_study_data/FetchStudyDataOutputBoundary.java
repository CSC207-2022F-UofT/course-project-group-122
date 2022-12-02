package use_cases.fetch_study_data;

/**
 * The interface that the presenter implements and the use case calls on.
 */
interface FetchStudyDataOutputBoundary {


    /**
     * Present the study data to the user.
     * @param participantId the id of the participant
     */
    void displayStudyData(int participantId);


    /**
     * Present the participant not associate with a study.
     * @param participantId the id of the researcher
     * @param participantName the name of the participant
     */
    void displayNoStudyAssociated(int participantId, String participantName);


    /**
     * Present the study data to the researcher.
     * @param response  The response model containing the study data.
     */
    void displayAllStudyData(FetchStudyDataResponseModel response);
}
