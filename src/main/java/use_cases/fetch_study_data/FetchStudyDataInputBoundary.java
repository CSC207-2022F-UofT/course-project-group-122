package use_cases.fetch_study_data;

/**
 * This interface defines the input boundary for the FetchStudyData use case.
 */
interface FetchStudyDataInputBoundary {

    /**
     * This method fetches the study data for the given user.
     * <p>
     * If this user is a researcher, it will fetch all the study data, including:
     * - the study name
     * - the study ID
     * - the status of the study
     * and package the information to send it to the output boundary.
     * This information will be displayed in the researcher's dashboard where all studies are listed.
     * <p>
     * If this user is a participant, it will fetch the study data that this participant is associated with and package
     * the information to send it to the output boundary. This information will be used to fetch further information
     * on the study, such as the study name, the study ID, and the status of the study, as well as how the participant
     * is involved in the study (i.e., their status in the study, the questionnaires assigned to the participant,
     * the answers of these participants that they have provided, etc.).
     *
     * @param user The user whose study data is to be fetched.
     */
    void fetchStudyData(int userId);
}
