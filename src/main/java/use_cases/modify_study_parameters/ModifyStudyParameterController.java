package use_cases.modify_study_parameters;


/**
 * The controller for modifying the parameters of a study.
 */
public class ModifyStudyParameterController {

    /**
     * The interactor of the use case.
     */
    private final ModifyStudyParameterInputBoundary modifyStudyParameterInteractor = new ModifyStudyParameterInteractor();


    /**
     * Returns the list of potential stratification variables for the study.
     * @param studyID   The ID of the study.
     */
    public void checkPotentialStratificationVariables(int studyID) {
        modifyStudyParameterInteractor.checkPotentialStratificationVariables(studyID);
    }


    /**
     * Modifies the basic parameters of the study.
     * @param studyId               The ID of the study.
     * @param studyName             The new name of the study.
     * @param studyDescription      The new description of the study.
     * @param targetSize            The new target size of the study.
     */
    public void modifyStudyBasicParameters(int studyId, String studyName, String studyDescription, int targetSize) {
        modifyStudyParameterInteractor.modifyStudyBasicParameters(studyId, studyName, studyDescription, targetSize);
    }


    /**
     * Modifies the type of the study.
     * @param studyId           The ID of the study.
     * @param studyType         The new type of the study.
     */
    public void modifyStudyType(int studyId, String studyType) {
        modifyStudyParameterInteractor.modifyStudyType(studyId, studyType);
    }


    /**
     * Modifies the randomization method of the study.
     * @param studyId               The ID of the study.
     * @param randomizationMethod   The new randomization method of the study.
     */
    public void modifyStudyRandomization(int studyId, String randomizationMethod) {
        modifyStudyParameterInteractor.modifyStudyRandomization(studyId, randomizationMethod);
    }


    /**
     * Modifies the stratification variables of the study.
     * @param studyId                   The ID of the study.
     * @param stratificationVariable    The new stratification variable of the study.
     */
    public void modifyStratificationVariables(int studyId, String stratificationVariable) {
        modifyStudyParameterInteractor.modifyStudyStratification(studyId, stratificationVariable);
    }


}
