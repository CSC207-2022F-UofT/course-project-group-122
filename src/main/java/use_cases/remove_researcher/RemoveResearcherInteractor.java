package use_cases.remove_researcher;

import entities.Researcher;
import entities.Study;
import use_cases.fetch_id.FetchId;

public class RemoveResearcherInteractor implements RemoveResearcherInputBoundary {

    private RemoveResearcherOutputBoundary removeResearcherPresenter;


    /**
     * Remove the researcher with the given id from the study with the given id.
     *
     * @param researcherId The id of the researcher to remove.
     * @param studyID      The id of the study to remove the researcher from.
     */
    @Override
    public void removeResearcherFromStudy(int researcherId, int studyID) {
        Researcher researcher = (Researcher) FetchId.getUser(researcherId);
        Study study = FetchId.getStudy(studyID);
        if (researcher.getListStudies().contains(study) && study.getResearchers().contains(researcher)) {
            researcher.removeFromListStudies(study);
            study.removeResearcher(researcher);
            removeResearcherPresenter.presentResearcherRemoved(researcher.getId(), researcher.getName(), study.getId());
        } else {
            removeResearcherPresenter.presentResearcherNotInStudy(researcher.getId(), study.getId());
        }
    }


    /**
     * Set the presenter for this interactor.
     * @param removeResearcherPresenter     The presenter for this interactor.
     */
    public void setRemoveResearcherPresenter(RemoveResearcherOutputBoundary removeResearcherPresenter) {
        this.removeResearcherPresenter = removeResearcherPresenter;
    }
}
