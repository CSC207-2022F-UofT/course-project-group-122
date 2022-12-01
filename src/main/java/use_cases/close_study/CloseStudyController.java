package use_cases.close_study;

/**
 * The controller for the use case CloseStudy. The screen calls on this class to close a study.
 */
public class CloseStudyController {

    /**
     * The use case to close a study
     */
    private CloseStudyInputBoundary closeStudyInteractor;


    /**
     * Close a study
     * @param studyId   The id of the study to close
     */
    public void closeStudy(int studyId, int researcherId) {
        closeStudyInteractor.closeStudy(studyId, researcherId);
    }


    /**
     * Reopen a study
     * @param studyId   The id of the study to reopen
     */
    public void reopenStudy(int studyId, int researcherId) {
        closeStudyInteractor.reopenStudy(studyId, researcherId);
    }


    /**
     * Set the interactor for this controller
     * @param closeStudyInteractor  The interactor to set
     */
    public void setCloseStudyInteractor(CloseStudyInputBoundary closeStudyInteractor) {
        this.closeStudyInteractor = closeStudyInteractor;
    }
}
