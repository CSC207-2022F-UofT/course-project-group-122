package use_cases.modify_study_parameters;


import org.jetbrains.annotations.NotNull;

/**
 * The controller for modifying the parameters of a study.
 */
public class ModifyStudyParameterController {

    /**
     * The input boundary for modifying the parameters of a study.
     */
    private ModifyStudyParameterInputBoundary modifyStudyParameterInteractor;


    /**
     * Modify the parameters of a study.
     * @param requestModel      The request model containing the new parameters of the study.
     */
    public void modifyStudyParameters(@NotNull ModifyStudyParameterRequestModel requestModel) {
        int researcherId = requestModel.getResearcherId();
        int studyId = requestModel.getStudyId();
        String studyName = requestModel.getStudyName();
        String studyDescription = requestModel.getStudyDescription();
        int targetSize = requestModel.getStudyTargetSize();
        String studyType = requestModel.getStudyType();
        int numGroups = requestModel.getNumGroups();
        String[] groupNames = requestModel.getGroupNames();

        modifyStudyParameterInteractor.modifyStudyBasicParameters(studyId, studyName, studyDescription, targetSize);
        modifyStudyParameterInteractor.modifyStudyType(studyId, studyType);
        modifyStudyParameterInteractor.modifyStudyGrouping(studyId, numGroups, groupNames, researcherId);
    }


    /**
     * Checks the potential stratification variables for the study.
     * @param studyID   The ID of the study.
     */
    public void checkPotentialStratificationVariables(int studyID) {
        modifyStudyParameterInteractor.checkPotentialStratificationVariables(studyID);
    }


    /**
     * Modifies the randomization method of the study.
     * @param studyId               The ID of the study.
     * @param randomizationMethod   The new randomization method of the study.
     */
    public void modifyStudyRandomization(int studyId, String randomizationMethod, int researcherId) {
        modifyStudyParameterInteractor.modifyStudyRandomization(studyId, randomizationMethod, researcherId);
    }


    /**
     * Modifies the stratification variables of the study.
     * @param studyId                   The ID of the study.
     * @param stratificationVariable    The new stratification variable of the study.
     */
    public void modifyStudyStratification(int studyId, String stratificationVariable, int researcherId) {
        modifyStudyParameterInteractor.modifyStudyStratification(studyId, stratificationVariable, researcherId);
    }


    /**
     * Set the input boundary for modifying the parameters of a study.
     */
    public void setModifyStudyParameterInteractor(ModifyStudyParameterInputBoundary modifyStudyParameterInteractor) {
        this.modifyStudyParameterInteractor = modifyStudyParameterInteractor;
    }
}
