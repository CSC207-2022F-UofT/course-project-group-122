package entities;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The study entity.
 * A study is the overarching entity of the software, in which the creation of the users and all data collection
 * instruments support the study.
 * <p>
 * Representation Invariants:
 * potentialParticipants, participants, researchers, and questionnaires do not contain duplicates.
 */
public class Study {

    /**
     * Current study ID
     */
    private static int currID = 0;
    /**
     * The ID of the study
     */
    private final int id;
    /**
     * The type of the study. The type must be either "Randomized" or "General"
     */
    private String studyType;

    /**
     * The randomization method of the study. The randomization method is "N/A" if and only if the study type is
     * "General". The randomization method must be "Simple", "Block", or "Stratified" when the study type is
     * "Randomized". This attribute is initially set to "N/A". If the study type is changed to "Randomized", the
     * randomization method must not be "N/A". For randomized studies, the randomization method is by default set to
     * "Block". The randomization method can be changed to "Simple" if the user wishes to do so, but this is done after
     * the study is initialized.
     * <p>
     * There are three types of randomization methods:
     * - Simple randomization: each participant is assigned to a group using a pseudo-random number generator based on
     * simple uniform distribution.
     * - Block randomization: each participant is assigned to a group using a pseudo-random number generator based on
     * randomization within a block. The participants are evenly distributed across the groups within a block. The block
     * size is a multiple of the number of groups. This method is used to ensure a balance in sample size across groups
     * over time.
     * - Stratified randomization: each participant is assigned to a group using a pseudo-random number generator based
     * on randomization within a stratum. The participants are evenly distributed across the groups within a stratum.
     * The stratum is a subset of the participants that have the same value for a certain attribute. This attribute is
     * defined by the user as a variable (question) in the eligibility questionnaire. This method is used to ensure a
     * balance in sample size across groups over time.
     */

    private String randomizationMethod = "N/A";

    /**
     * The stratification method of the study. The stratification method is "N/A" if and only if (the study type is
     * "General") or (the study type is "Randomized" AND the randomizationMethod is not "Stratified"). The
     * stratification method must be a non-empty string indicating a variable name in the eligibility questionnaire and
     * that the question this variable refers to is a multiple choice or a scale question. This attribute is initially
     * set to "N/A". If the study type is changed to "Randomized" and the randomization method is changed to
     * "Stratified", the stratification method must not be "N/A". The stratification method can be changed to a
     * non-empty string if the user wishes to do so, but this is done after the study is initialized.
     */
    private String stratificationMethod = "N/A";

    /**
     * The title of the study
     */
    private String studyName;

    /**
     * The description of the study
     */
    private String studyDescription;

    /**
     * The target study size of the study.
     */
    private int targetStudySize;

    /**
     * The status of the study. If the study is active, then the isActive == true, otherwise it is false.
     */
    private boolean isActive = true;

    /**
     * The study user manager of the study. The study user manager manages the users of the study. The study user
     * manager is initialized when the study is initialized. This includes the researchers, potential participants,
     * and participants of the study.
     */
    private final StudyUserManager studyUserManager = new StudyUserManager(this);

    /**
     * The study questionnaire manager of the study. The study questionnaire manager manages the questionnaires of
     * the study. The study questionnaire manager is initialized when the study is initialized. This includes the
     * eligibility questionnaire, the consent form, and the questionnaires for the participants.
     */
    private final StudyQuestionnaireManager studyQuestionnaireManager = new StudyQuestionnaireManager(this);


    /**
     * Construct a study object with the following parameters specified:
     * The first constructor where the researchers define custom groupings of the study participants.
     * <p>
     * Precondition: the type of the study must be either "Randomized" or "General". The number of groups must be
     * the same as the number of group names specified. This condition is checked in the use case class.
     *
     * @param studyType       The type of the study, which must be either "Randomized" or "General"
     * @param studyName       The name of the study that the researcher specifies
     * @param targetStudySize The target study size. What is the number of participants the researchers of this study
     *                        want to achieve?
     * @param numGroups       The number of groups that the researchers specify. The researchers specify the custom
     *                        grouping they want.
     * @param groupNames      The name for each of the group that researcher specifies. The length of the list must be
     *                        the same as the number of groups, and each name corresponds to the right index to be
     *                        referred to.
     */
    public Study(@NotNull String studyType, String studyName, int targetStudySize, int numGroups, String[] groupNames) {
        // update the current ID
        currID++;
        this.id = currID;
        this.studyType = studyType;
        if (studyType.equals("Randomized")) {
            this.randomizationMethod = "Block";
        }
        this.studyName = studyName;
        this.targetStudySize = targetStudySize;
        this.studyUserManager.resetGroups(numGroups, groupNames);
    }


    /**
     * Construct a study object with the following parameters specified:
     * A second constructor, where the grouping is left by default - there is only one group.
     * <p>
     * Precondition: the type of the study must be either "Randomized" or "General".
     *
     * @param studyType       The type of the study, which must be either "Randomized" or "General"
     * @param studyName       The name of the study that the researcher specifies
     * @param targetStudySize The target study size. What is the number of participants the researchers of this study
     *                        want to achieve?
     */
    public Study(@NotNull String studyType, String studyName, int targetStudySize) {
        // update the current ID
        currID++;
        this.id = currID;
        this.studyType = studyType;
        if (studyType.equals("Randomized")) {
            this.randomizationMethod = "Block";
        }
        this.studyName = studyName;
        this.targetStudySize = targetStudySize;
    }


    /**
     * Construct a study object with the following parameters specified:
     * A third constructor, where the grouping is left by default - there is only one group, and the study type is
     * "General" by default.
     *
     * @param studyName       The name of the study that the researcher specifies
     * @param targetStudySize The target study size. What is the number of participants the researchers of this study
     *                        want to achieve?
     */
    public Study(String studyName, int targetStudySize) {
        // update the current ID
        currID++;
        this.id = currID;
        this.studyType = "General";
        this.studyName = studyName;
        this.targetStudySize = targetStudySize;
    }


    /**
     * Return the name of the study.
     *
     * @return the name of the study.
     */
    public String getStudyName() {
        return studyName;
    }


    /**
     * Modify the name of the study.
     *
     * @param name The new name of the study that a researcher wants to change to.
     */
    public void modifyStudyName(String name) {
        this.studyName = name;
    }


    /**
     * Return the target study size.
     *
     * @return the target study size.
     */
    public int getTargetStudySize() {
        return targetStudySize;
    }


    /**
     * Modify the target study size.
     *
     * @param targetStudySize the new target study size.
     */
    public void modifyTargetStudySize(int targetStudySize) {
        this.targetStudySize = targetStudySize;
    }


    /**
     * The current number of participants in the study.
     *
     * @return the current number of participants in the study.
     */
    public int currentStudySize() {
        return studyUserManager.currentStudySize();
    }


    /**
     * Retrieve the ID of the study.
     *
     * @return the ID of the study.
     */
    public int getId() {
        return id;
    }


    /**
     * Return the if the study is still active.
     *
     * @return a boolean indicating the active status of the study.
     */
    public boolean isActive() {
        return isActive;
    }


    /**
     * Set the status of the study to the closed.
     */
    public void closeStudy() {
        this.isActive = false;
    }


    /**
     * Reopen the study. Only executed when the study is closed.
     */
    public void reopenStudy() {
        if (!this.isActive) {
            this.isActive = true;
        }
    }


    /**
     * Return the number of groups in the study.
     *
     * @return the number of groups in the study.
     */
    public int getNumGroups() {
        return studyUserManager.getNumGroups();
    }


    /**
     * Return the names of the groups in order.
     *
     * @return the names of each groups
     */
    public String[] getGroupNames() {
        return studyUserManager.getGroupNames();
    }

    /**
     * Reset the grouping of the study, including the names.
     * Only allowed when there is no eligible participants in the study.
     * <p>
     * This method is overloaded.
     *
     * <p>
     * Precondition: the number of names defined in groupNames is the same as the number of groups. This precondition is
     * maintained in the use case.
     *
     * @param numGroups  the number of groups
     * @param groupNames the name of the groups
     * @return whether the change is successful
     */
    public boolean resetGroups(int numGroups, String[] groupNames) {
        return studyUserManager.resetGroups(numGroups, groupNames);
    }


    /**
     * Reset the grouping of the study. The names of the group are generated by default.
     * Only allowed when there is no eligible participants in the study.
     * <p>
     * This method is overloaded.
     *
     * <p>
     * Precondition: the number of names defined in groupNames is the same as the number of groups. This precondition is
     * maintained in the use case.
     *
     * @param numGroups the number of groups
     * @return whether the change is successful
     */
    public boolean resetGroups(int numGroups) {
        return studyUserManager.resetGroups(numGroups);
    }


    /**
     * Retrieve the type of the study.
     *
     * @return the type of the study.
     */
    public String getStudyType() {
        return this.studyType;
    }


    /**
     * Reset the type of the study.
     * Only allowed when there is no eligible participants in the study.
     * <p>
     * Precondition: the type of the study must be either "Randomized" or "General".
     *
     * @param studyType the type of the study
     * @return whether the change is successful
     */
    public boolean setStudyType(String studyType) {
        if (this.studyUserManager.getParticipants().isEmpty()) {
            this.studyType = studyType;
            if (studyType.equals("Randomized")) {
                this.randomizationMethod = "Block";
            } else {
                this.randomizationMethod = "N/A";
            }
            return true;
        }
        return false;
    }


    /**
     * Retrieve the randomization method of the study.
     *
     * @return the randomization method of the study.
     */
    public String getRandomizationMethod() {
        return randomizationMethod;
    }


    /**
     * Reset the randomization method of the study.
     * Only allowed when there is no eligible participants in the study. Also, only allowed when the study type is
     * "Randomized".
     * <p>
     * Precondition: the randomization method of the study must be "Block", "Simple", or "Stratified".
     *
     * @param randomizationMethod the randomization method of the study
     * @return whether the change is successful
     */
    public boolean setRandomizationMethod(String randomizationMethod) {
        if (this.studyUserManager.getParticipants().isEmpty() && this.studyType.equals("Randomized")) {
            this.randomizationMethod = randomizationMethod;
            return true;
        }
        return false;
    }


    /**
     * Retrieve the stratification method of the study.
     *
     * @return the stratification method of the study.
     */
    public String getStratificationMethod() {
        return stratificationMethod;
    }


    /**
     * Reset the stratification method of the study.
     * Only allowed when there is no eligible participants in the study. Also, only allowed when the study type is
     * "Randomized" and the randomization method is "Stratified".
     * <p>
     * The stratification method of the study must be a valid variable name in the eligibility questionnaire.
     *
     * @param stratificationMethod the stratification method of the study
     * @return whether the change is successful
     */
    public boolean setStratificationMethod(String stratificationMethod) {
        if (this.studyUserManager.getParticipants().isEmpty() && this.studyType.equals("Randomized") &&
                this.randomizationMethod.equals("Stratified")) {
            this.stratificationMethod = stratificationMethod;
            return true;
        }
        return false;
    }


    /**
     * Retrieve the description of the study.
     *
     * @return the description of the study.
     */
    public String getStudyDescription() {
        return studyDescription;
    }


    /**
     * Modify the description of the study.
     *
     * @param studyDescription the new description of the study.
     */
    public void setStudyDescription(String studyDescription) {
        this.studyDescription = studyDescription;
    }


    /**
     * Return the list of potential participants. Returns a copy.
     *
     * @return the list of potential participants.
     */
    public List<Participant> getPotentialParticipants() {
        return studyUserManager.getPotentialParticipants();
    }


    /**
     * Remove a potential participant from the list of potential participants.
     *
     * @param p the potential participant to be removed.
     * @return whether the removal is successful.
     */
    public boolean removePotentialParticipant(Participant p) {
        return studyUserManager.removePotentialParticipant(p);
    }


    /**
     * Add a potential participant from the list of potential participants.
     *
     * @param p the potential participant to be added.
     * @return whether the addition is successful.
     */
    public boolean addPotentialParticipant(Participant p) {
        return studyUserManager.addPotentialParticipant(p);
    }


    /**
     * Return the list of all eligible participants. Returns a copy.
     *
     * @return the list of all eligible participants.
     */
    public List<Participant> getParticipants() {
        return studyUserManager.getParticipants();
    }


    /**
     * Remove a participant from the list of eligible participants.
     *
     * @param p participant to be removed.
     * @return whether the removal is successful.
     */
    public boolean removeParticipant(Participant p) {
        return studyUserManager.removeParticipant(p);
    }


    /**
     * Add participants from the list of eligible participants.
     * The participant must be in the list of potential participants.
     *
     * @param p participant to be added.
     * @return whether the addition is successful.
     */
    public boolean addParticipant(Participant p) {
        return studyUserManager.addParticipant(p);
    }


    /**
     * Return the list of all researchers in the study. Returns a copy.
     *
     * @return the list of all researchers in the study.
     */
    public List<Researcher> getResearchers() {
        return studyUserManager.getResearchers();
    }


    /**
     * Add a list of researchers to the existing list of researchers in the study.
     * Return false if the added list is empty.
     *
     * @param researcherList a list of researchers to be added.
     * @return whether the addition is successful.
     */
    public boolean addResearchers(@NotNull List<Researcher> researcherList) {
        return studyUserManager.addResearchers(researcherList);
    }


    /**
     * Add a researcher to the existing list of researchers in the study.
     *
     * @param researcher a researcher to be added.
     * @return whether the addition is successful.
     */
    public boolean addResearchers(Researcher researcher) {
        return studyUserManager.addResearcher(researcher);
    }


    /**
     * Remove a researcher from the list of researchers in the study.
     *
     * @param researcher researcher to be removed.
     * @return whether the removal is successful.
     */
    public boolean removeResearcher(Researcher researcher) {
        return studyUserManager.removeResearcher(researcher);
    }


    /**
     * Retrieve the eligibility questionnaire.
     *
     * @return the eligibility questionnaire.
     */
    public Questionnaire getEligibilityQuestionnaire() {
        return this.studyQuestionnaireManager.getEligibilityQuestionnaire();
    }

    /**
     * Set the eligibility questionnaire.
     *
     * @param eligibilityQuestionnaire the eligibility questionnaire.
     */
    public void setEligibilityQuestionnaire(Questionnaire eligibilityQuestionnaire) {
        this.studyQuestionnaireManager.setEligibilityQuestionnaire(eligibilityQuestionnaire);
    }

    /**
     * Retrieve the list of questionnaires of the study. Return a copy.
     *
     * @return the list of questionnaires of the study.
     */
    public List<Questionnaire> getQuestionnaires() {
        return this.studyQuestionnaireManager.getQuestionnaires();
    }

    /**
     * Add a questionnaire to the list of questionnaires.
     *
     * @param q the questionnaire to be added.
     * @return whether the addition is successful.
     */
    public boolean addQuestionnaire(Questionnaire q) {
        return this.studyQuestionnaireManager.addQuestionnaire(q);
    }

    /**
     * Remove a questionnaire from the list of questionnaires.
     *
     * @param q the questionnaire to be removed.
     * @return whether the removal is successful.
     */
    public boolean removeQuestionnaire(Questionnaire q) {
        return this.studyQuestionnaireManager.removeQuestionnaire(q);
    }

    /**
     * Retrieve the consent form.
     *
     * @return the consent form.
     */
    public ConsentForm getConsentForm() {
        return this.studyQuestionnaireManager.getConsentForm();
    }

    /**
     * Set the consent form. Returns true if the consent form is set successfully.
     *
     * @param consentForm the consent form.
     * @return whether the consent form is set successfully.
     */
    public boolean setConsentForm(@NotNull ConsentForm consentForm) {
        if (consentForm.getStudy().equals(this)) {
            this.studyQuestionnaireManager.setConsentForm(consentForm);
            return true;
        }
        return false;
    }


    /**
     * Retrieve the map of group number to group names.
     * @return  the map of group number to group names.
     */
    public Map<Integer, String> getMatchedGroupNames() {
        Map<Integer, String> matchedGroupNames = new HashMap<>();
        for (int i = 0; i < this.getGroupNames().length; i++) {
            matchedGroupNames.put(i + 1, this.getGroupNames()[i]);
        }
        return matchedGroupNames;
    }
}