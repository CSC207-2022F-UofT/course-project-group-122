package use_cases.fetch_study_log;

import entities.Researcher;
import entities.Study;
import use_cases.fetch_id.FetchId;

/**
 *
 */
public class FetchStudyLogInteractor implements FetchStudyLogInputBoundary {


    /**
     * The presenter for this use case.
     */
    private FetchStudyLogOutputBoundary fetchStudyLogPresenter;

    /**
     * Fetches the study log for a given study.
     *
     * @param studyId      The study ID.
     * @param researcherId The researcher ID.
     */
    @Override
    public void fetchStudyLog(int studyId, int researcherId) {
        Study study = FetchId.getStudy(studyId);
        Researcher researcher = (Researcher) FetchId.getUser(researcherId);
        assert researcher != null;
        assert study != null;
        FetchStudyLogResponseModel fetchStudyLogResponseModel =
                new FetchStudyLogResponseModel(researcher.getId(), researcher.getName(), study);
        fetchStudyLogPresenter.presentStudyLog(fetchStudyLogResponseModel);
    }

    /**
     * Sets the presenter for this interactor.
     * @param fetchStudyLogPresenter  The presenter for this interactor.
     */
    public void setFetchStudyLogPresenter(FetchStudyLogOutputBoundary fetchStudyLogPresenter) {
        this.fetchStudyLogPresenter = fetchStudyLogPresenter;
    }
}
