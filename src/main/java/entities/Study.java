package entities;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
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
public abstract class Study implements Serializable {

    /**
     * The ID of the study
     */
    private final int id;

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
    protected final StudyUserManager studyUserManager = new StudyUserManager(this);

    /**
     * The study questionnaire manager of the study. The study questionnaire manager manages the questionnaires of
     * the study. The study questionnaire manager is initialized when the study is initialized. This includes the
     * eligibility questionnaire, the consent form, and the questionnaires for the participants.
     */
    protected final StudyQuestionnaireManager studyQuestionnaireManager = new StudyQuestionnaireManager(this);


    /**
     * Construct a study object with the following parameters specified:
     *
     * @param studyName       The name of the study that the researcher specifies
     * @param targetStudySize The target study size. What is the number of participants the researchers of this study
     *                        want to achieve?
     */
    protected Study(int id, String studyName, int targetStudySize) {
        this.id = id;
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
     */
    public void resetGroups(int numGroups, String[] groupNames) {
        studyUserManager.resetGroups(numGroups, groupNames);
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
     */
    public void resetGroups(int numGroups) {
        studyUserManager.resetGroups(numGroups);
    }


    /**
     * Retrieve the type of the study.
     *
     * @return the type of the study.
     */
    public abstract String getStudyType();


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
     * Add a potential participant from the list of potential participants.
     *
     * @param p the potential participant to be added.
     */
    public void addPotentialParticipant(Participant p) {
        studyUserManager.addPotentialParticipant(p);
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
     * Add participants from the list of eligible participants.
     * The participant must be in the list of potential participants.
     *
     * @param p participant to be added.
     */
    public void addParticipant(Participant p) {
        studyUserManager.addParticipant(p);
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
     * Add a researcher to the existing list of researchers in the study.
     *
     * @param researcher a researcher to be added.
     */
    public void addResearcher(Researcher researcher) {
        studyUserManager.addResearcher(researcher);
    }


    /**
     * Remove a researcher from the list of researchers in the study.
     *
     * @param researcher researcher to be removed.
     */
    public void removeResearcher(Researcher researcher) {
        studyUserManager.removeResearcher(researcher);
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
     */
    public void addQuestionnaire(Questionnaire q) {
        this.studyQuestionnaireManager.addQuestionnaire(q);
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
     */
    public void setConsentForm(@NotNull ConsentForm consentForm) {
        if (consentForm.getStudy().equals(this)) {
            this.studyQuestionnaireManager.setConsentForm(consentForm);
        }
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