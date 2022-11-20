package use_cases.remove_researcher;

public interface RemoveResearcherInputBoundary {

    /**
     * Remove the researcher with the given id from the study with the given id.
     * @param researcherId  The id of the researcher to remove.
     * @param studyID       The id of the study to remove the researcher from.
     */
    void removeResearcherFromStudy(int researcherId, int studyID);
}
