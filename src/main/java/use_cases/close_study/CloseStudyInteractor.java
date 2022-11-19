package use_cases.close_study;

import entities.Study;
import use_cases.fetch_id.FetchId;

public class CloseStudyInteractor implements CloseStudyInputBoundary {

    /**
     * The output boundary of this use case.
     */
    private CloseStudyOutputBoundary closeStudyPresenter = new CloseStudyPresenter();


    /**
     * Close a study
     *
     * @param studyId The id of the study to close
     */
    @Override
    public void closeStudy(int studyId) {
        Study study = FetchId.getStudy(studyId);
        if (study.isActive()) {
            study.closeStudy();
            closeStudyPresenter.displayMessage(study, "Study closed successfully. " +
                    "Thank you for your continuous dedication!");
        } else {
            closeStudyPresenter.displayMessage(study, "Study is already closed.");
        }
    }

    /**
     * Reopen a study
     *
     * @param studyId The id of the study to reopen
     */
    @Override
    public void reopenStudy(int studyId) {
        Study study = FetchId.getStudy(studyId);
        if (!study.isActive()) {
            study.reopenStudy();
            closeStudyPresenter.displayMessage(study, "Study reopened successfully. " +
                    "Thank you for your continuous dedication!");
        } else {
            closeStudyPresenter.displayMessage(study, "Study is currently active.");
        }
    }
}
