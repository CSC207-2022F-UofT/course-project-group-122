package use_cases.close_study;

/**
 * This the interface that the use case implements and the controller calls on.
 */
public interface CloseStudyInputBoundary {

    /**
     * Close a study
     * @param studyId   The id of the study to close
     */
    void closeStudy(int studyId, int researcherId);

    /**
     * Reopen a study
     * @param studyId   The id of the study to reopen
     */
    void reopenStudy(int studyId, int researcherId);
}
