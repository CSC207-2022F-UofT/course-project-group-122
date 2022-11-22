package use_cases.close_study;

import entities.Study;
import use_cases.fetch_id.FetchId;

public class CloseStudyInteractor implements CloseStudyInputBoundary {

    /**
     * The output boundary of this use case.
     */
    private CloseStudyOutputBoundary closeStudyPresenter;


    /**
     * Close a study
     *
     * @param studyId The id of the study to close
     */
    @Override
    public void closeStudy(int studyId, int researcherId) {
        Study study = FetchId.getStudy(studyId);
        if (study.isActive()) {
            study.closeStudy();
            closeStudyPresenter.displayMessage(study, "Study closed successfully. " +
                    "Thank you for your continuous dedication!", researcherId);
        } else {
            closeStudyPresenter.displayMessage(study, "Study is already closed.", researcherId);
        }
    }

    /**
     * Reopen a study
     *
     * @param studyId The id of the study to reopen
     */
    @Override
    public void reopenStudy(int studyId, int researcherId) {
        Study study = FetchId.getStudy(studyId);
        if (!study.isActive()) {
            study.reopenStudy();
            closeStudyPresenter.displayMessage(study, "Study reopened successfully. " +
                    "Thank you for your continuous dedication!", researcherId);
        } else {
            closeStudyPresenter.displayMessage(study, "Study is currently active.", researcherId);
        }
    }


    /**
     * Set the presenter for this use case.
     * @param closeStudyPresenter The presenter for this use case.
     */
    public void setCloseStudyPresenter(CloseStudyOutputBoundary closeStudyPresenter) {
        this.closeStudyPresenter = closeStudyPresenter;
    }
}
