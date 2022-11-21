package use_cases.create_study;

import org.jetbrains.annotations.NotNull;

public class CreateStudyController {

    private CreateStudyInputBoundary createStudyInteractor;


    /**
     * Create a study and save it into the user pool
     * @param createStudyRequestModel   The request model for creating a study
     */
    public void createStudy(@NotNull CreateStudyRequestModel createStudyRequestModel) {
        int researcherId = createStudyRequestModel.getResearcherId();
        String studyName = createStudyRequestModel.getStudyName();
        String studyDescription = createStudyRequestModel.getStudyDescription();
        int studyTargetSize = createStudyRequestModel.getStudyTargetSize();
        String studyType = createStudyRequestModel.getStudyType();
        int numGroups = createStudyRequestModel.getNumGroups();
        String[] groupNames = createStudyRequestModel.getGroupNames();

        int studyId = createStudyInteractor.createStudyObject(researcherId, studyType, studyName,
                studyDescription, studyTargetSize);

        createStudyInteractor.setStudyGrouping(studyId, numGroups, groupNames);

        createStudyInteractor.checkStudyCreatedSuccessfully(studyId, researcherId);
    }

    /**
     * Sets the interactor for the controller
     */
    public void setCreateStudyInteractor(CreateStudyInputBoundary createStudyInteractor) {
        this.createStudyInteractor = createStudyInteractor;
    }
}
