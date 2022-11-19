package use_cases.close_study;

public class CloseStudyController {

    /**
     * The use case to close a study
     */
    private CloseStudyInputBoundary closeStudyInteractor = new CloseStudyInteractor();


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
}
