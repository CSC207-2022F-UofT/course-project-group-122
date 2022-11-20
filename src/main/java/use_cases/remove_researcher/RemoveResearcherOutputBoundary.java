package use_cases.remove_researcher;

public interface RemoveResearcherOutputBoundary {

    /**
     * Display that the researcher was successfully removed from the study.
     *
     * @param researcherId  The id of the researcher that was removed.
     * @param name          The name of the researcher that was removed.
     * @param studyID       The id of the study that the researcher was removed from.
     */
    void presentResearcherRemoved(int researcherId, String name, int studyID);


    /**
     * Display that the researcher was not in the study.
     * @param researcherId  The id of the researcher that was not in the study.
     * @param studyID       The id of the study that the researcher was not in.
     */
    void presentResearcherNotInStudy(int researcherId, int studyID);
}
