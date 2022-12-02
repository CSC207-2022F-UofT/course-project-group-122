package use_cases.remove_researcher;

/**
 * The interface that the presenter implements and the use case calls on.
 */
public interface RemoveResearcherOutputBoundary {

    /**
     * Display that the researcher was successfully removed from the study.
     *
     * @param researcherId The id of the researcher that was removed.
     * @param name         The name of the researcher that was removed.
     * @param studyID      The id of the study that the researcher was removed from.
     * @param userId       The id of the user that removed the researcher.
     */
    void presentResearcherRemoved(int researcherId, String name, int studyID, int userId);


    /**
     * Display that the researcher was not in the study.
     * @param researcherId  The id of the researcher that was not in the study.
     * @param studyID       The id of the study that the researcher was not in.
     */
    void presentResearcherNotInStudy(int researcherId, int studyID);


    /**
     * Display that the researcher cannot remove themselves from the study.
     * @param researcherId  The id of the researcher that cannot remove themselves.
     * @param studyID       The id of the study that the researcher cannot remove themselves from.
     */
    void presentRemoveResearcherError(int researcherId, int studyID);
}
