package use_cases.remove_researcher;

public class RemoveResearcherController {

    private RemoveResearcherInputBoundary removeResearcherInteractor;

    /**
     * Remove the researcher with the given id from the study with the given id.
     * @param researcherId  The id of the researcher to remove.
     * @param studyID       The id of the study to remove the researcher from.
     */
    public void removeResearcherFromStudy(int researcherId, int studyID) {
        removeResearcherInteractor.removeResearcherFromStudy(researcherId, studyID);
    }


    /**
     * Set the interactor for this controller.
     * @param removeResearcherInteractor  The interactor to set.
     */
    public void setRemoveResearcherInteractor(RemoveResearcherInputBoundary removeResearcherInteractor) {
        this.removeResearcherInteractor = removeResearcherInteractor;
    }
}
