package use_cases.remove_researcher;

public class RemoveResearcherController {

    private RemoveResearcherInputBoundary removeResearcherInteractor = new RemoveResearcherInteractor();

    /**
     * Remove the researcher with the given id from the study with the given id.
     * @param researcherId  The id of the researcher to remove.
     * @param studyID       The id of the study to remove the researcher from.
     */
    public void removeResearcherFromStudy(int researcherId, int studyID) {
        removeResearcherInteractor.removeResearcherFromStudy(researcherId, studyID);
    }
}
