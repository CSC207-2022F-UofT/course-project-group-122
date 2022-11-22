package use_cases.modify_study_parameters;

import entities.Questionnaire;
import entities.Study;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

import java.util.List;

public class ModifyStudyParameterInteractor implements ModifyStudyParameterInputBoundary {

    private ModifyStudyParameterOutputBoundary modifyStudyParameterPresenter;


    /**
     * Returns the list of potential stratification variables for the study.
     * <p>
     * Preconditions: The study is a randomized study and its randomization method is stratified.
     *
     * @param studyID The ID of the study.
     */
    @Override
    public void checkPotentialStratificationVariables(int studyID) {
        Study study = FetchId.getStudy(studyID);
        Questionnaire eligibilityQuestionnaire = study.getEligibilityQuestionnaire();
        if (eligibilityQuestionnaire == null) {
            modifyStudyParameterPresenter.displayFailureMessage("The study does not have an eligibility " +
                    "questionnaire. Please add one before adding stratification variables.");
        }
        assert eligibilityQuestionnaire != null;
        List<String> vaiableNames = eligibilityQuestionnaire.getVariableNames();
        modifyStudyParameterPresenter.displayPotentialStratificationVariables(studyID, vaiableNames);
    }


    /**
     * Modifies the basic parameters of the study.
     *
     * @param studyId          The ID of the study.
     * @param studyName        The new name of the study.
     * @param studyDescription The new description of the study.
     * @param targetSize       The new target size of the study.
     */
    @Override
    public void modifyStudyBasicParameters(int studyId, String studyName, String studyDescription, int targetSize) {
        Study study = FetchId.getStudy(studyId);
        assert canModifyStudyParameters(study);
        study.modifyStudyName(studyName);
        study.setStudyDescription(studyDescription);
        study.modifyTargetStudySize(targetSize);
    }


    /**
     * Modifies the type of the study.
     * If the study originally has only 1 group, reset the group number to 2.
     *
     * @param studyId   The ID of the study.
     * @param studyType The new type of the study.
     */
    @Override
    public void modifyStudyType(int studyId, String studyType) {
        Study study = FetchId.getStudy(studyId);
        assert canModifyStudyParameters(study);
        study.setStudyType(studyType);
        if (study.getNumGroups() == 1) {
            study.resetGroups(2);
        }
    }


    /**
     * Modifies the randomization method of the study.
     *
     * @param studyId             The ID of the study.
     * @param randomizationMethod The new randomization method of the study.
     */
    @Override
    public void modifyStudyRandomization(int studyId, String randomizationMethod, int researcherId) {
        Study study = FetchId.getStudy(studyId);
        assert canModifyStudyParameters(study);
        if (study.getStudyType().equals("General")) {
            modifyStudyParameterPresenter.displayFailureMessage("The study is a general study. " +
                    "It does not have a randomization method.");
        }
        study.setRandomizationMethod(randomizationMethod);
        modifyStudyParameterPresenter.displaySuccessMessage(studyId,
                "The randomization method of the study has been modified.", researcherId);
    }


    /**
     * Modifies the stratification variables of the study.
     *
     * @param studyId                The ID of the study.
     * @param stratificationVariable The new stratification variable of the study.
     */
    @Override
    public void modifyStudyStratification(int studyId, String stratificationVariable, int researcherId) {
        Study study = FetchId.getStudy(studyId);
        assert canModifyStudyParameters(study);
        if (study.getStudyType().equals("General")) {
            modifyStudyParameterPresenter.displayFailureMessage("The study is a general study. " +
                    "It does not have a randomization method.");
        } else if (!study.getRandomizationMethod().equals("Stratified")) {
            modifyStudyParameterPresenter.displayFailureMessage("The study is not a stratified study. " +
                    "It does not have a stratification variable.");
        } else if (! validStratificationVariable(study, stratificationVariable)) {
            modifyStudyParameterPresenter.displayFailureMessage("The stratification variable is not a variable in " +
                    "the eligibility questionnaire. Please check your selection.");
        }
        study.setStratificationMethod(stratificationVariable);
        modifyStudyParameterPresenter.displaySuccessMessage(studyId,
                "The stratification variables of the study have been modified.", researcherId);
    }

    /**
     * Modifies the grouping of the study
     *
     * @param studyId    The ID of the study.
     * @param groupSize  The new group size of the study.
     * @param groupNames The new group names of the study.
     */
    @Override
    public void modifyStudyGrouping(int studyId, int groupSize, String @NotNull [] groupNames, int researcherId) {
        Study study = FetchId.getStudy(studyId);
        assert canModifyStudyParameters(study);
        if (groupingIsValid(study, groupSize, groupNames)) {
            if (namesAreEmpty(groupNames)) {
                study.resetGroups(groupSize);
                modifyStudyParameterPresenter.displaySuccessMessage(studyId,
                        "The parameters of the study have been modified.", researcherId);
            } else {
                study.resetGroups(groupSize, groupNames);
                modifyStudyParameterPresenter.displaySuccessMessage(studyId,
                        "The parameters of the study have been modified.", researcherId);
            }
        }
    }


    /**
     * Returns true if the grouping is valid.
     * <p>
     * Grouping is valid if:
     * 1. If the study is a randomized study, then the group size must be greater than 1.
     * 2. The number of group names must be equal to the group size.
     * @param study         The study.
     * @param groupSize     The group size.
     * @param groupNames    The group names.
     * @return              True if the grouping is valid.
     */
    @Contract(pure = true)
    private boolean groupingIsValid(Study study, int groupSize, String @NotNull [] groupNames) {
        if (groupSize != groupNames.length) {
            modifyStudyParameterPresenter.displayFailureMessage(
                    "The number of group names does not match the group size.");
            return false;
        } else if (study.getStudyType().equals("Randomized") && groupSize < 2) {
            modifyStudyParameterPresenter.displayFailureMessage(
                    "The study is a randomized study. It must have at least 2 groups.");
            return false;
        }
        return true;
    }


    /**
     * Checks if the names of the groups are all empty.
     * This means that the user does not provide any group names.
     * @param groupNames    The names of the groups.
     * @return              True if all the names are empty.
     */
    @Contract(pure = true)
    private boolean namesAreEmpty(String @NotNull [] groupNames) {
        for (String name : groupNames) {
            if (! name.equals("")) {
                return false;
            }
        }
        return true;
    }


    /**
     * Building the names of the groups.
     * @param groupNames    The names of the groups.
     * @return              The names of the groups in a string.
     */
    private @NotNull String buildNames(String @NotNull [] groupNames) {
        StringBuilder names = new StringBuilder();
        for (String name : groupNames) {
            names.append(name).append(", ");
        }
        return names.toString();
    }

    /**
     * Check if the study parameters can be modified.
     *
     * @param study   The study.
     * @return        True if the study parameters can be modified.
     */
    private boolean canModifyStudyParameters(@NotNull Study study) {
        if (!study.isActive()) {
            modifyStudyParameterPresenter.displayFailureMessage("The study is not active. " +
                    "You cannot modify the parameters of the study.");
            return false;
        } else if (!study.getParticipants().isEmpty()) {
            modifyStudyParameterPresenter.displayFailureMessage("The study has participants. " +
                    "You cannot modify the parameters of the study.");
            return false;
        }
        return true;
    }


    /**
     * Checks if the selected stratification variable is valid.
     * @param study                     The study.
     * @param stratificationVariable    The stratification variable.
     * @return                          True if the stratification variable is valid. False otherwise.
     */
    private boolean validStratificationVariable(@NotNull Study study, String stratificationVariable) {
        List<String> potentialVariables = study.getEligibilityQuestionnaire().getVariableNames();
        return potentialVariables.contains(stratificationVariable);
    }


    /**
     * Modifies the eligibility questionnaire of the study.
     * @param modifyStudyParameterPresenter The presenter.
     */
    public void setModifyStudyParameterPresenter(@NotNull ModifyStudyParameterPresenter modifyStudyParameterPresenter) {
        this.modifyStudyParameterPresenter = modifyStudyParameterPresenter;
    }
}
