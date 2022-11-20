package use_cases.close_study;

public class CloseStudyController {

    /**
     * The use case to close a study
     */
    private CloseStudyInputBoundary closeStudyInteractor;


    /**
     * Close a study
     * @param studyId   The id of the study to close
     */
    public void closeStudy(int studyId) {
        closeStudyInteractor.closeStudy(studyId);
    }


    /**
     * Reopen a study
     * @param studyId   The id of the study to reopen
     */
    public void reopenStudy(int studyId) {
        closeStudyInteractor.reopenStudy(studyId);
    }


    /**
     * Set the interactor for this controller
     * @param closeStudyInteractor  The interactor to set
     */
    public void setCloseStudyInteractor(CloseStudyInputBoundary closeStudyInteractor) {
        this.closeStudyInteractor = closeStudyInteractor;
    }
}