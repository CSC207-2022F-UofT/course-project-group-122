package use_cases.create_study;

import use_cases.fetch_study_log.FetchStudyLogController;

public class CreateStudyPresenter implements CreateStudyOutputBoundary {

    private FetchStudyLogController fetchStudyLogController;

    /**
     * Present the failure to create a study.
     *
     * @param message The message to present.
     */
    @Override
    public void displayFailureMessage(String message) {

    }

    /**
     * Present the success of creating a study.
     *
     * @param studyId   The study ID.
     * @param studyName The study name.
     */
    @Override
    public void presentStudyCreatedSuccessfully(int studyId, String studyName) {

    }


    /**
     * Set the study log controller.
     * @param fetchStudyLogController   The study log controller.
     */
    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }
}
