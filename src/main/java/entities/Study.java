package entities;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Study {
    /**
     * The study entity.
     * A study is the overarching entity of the software, in which the creation of the users and all data collection
     * instruments support the study.
     */

    // Basic study attributes and parameters.
    /*
    The ID of the study
     */
    private final int id;

    /*
    Current study ID
     */
    private static int currID = 0;

    /*
    The type of the study. The type must be either "Randomized" or "General"
     */
    private String studyType;

    /*
    The title of the study
     */
    private String studyName;

    /*
    The target study size of the study.
     */
    private int targetStudySize;

    /*
    The status of the study. If the study is active, then the isActive == true, otherwise it is false.
     */
    private boolean isActive = true;

    /*
    The number of groups in the study. The default number of groups is 1.
     */
    private int numGroups = 1;

    /*
    A list storing the name for each of the groups defined.
     */
    private String[] groupNames = {"Default Group"};


    // User management of the study
    /*
    The potential participants of the study. Their eligibility of the study has not been checked.
     */
    private Set<Participant> potentialParticipants = new HashSet<Participant>();

    /*
    The eligible participants of the study. These participants are considered as part of the study.
     */
    private Set<Participant> participants = new HashSet<Participant>();

    /*
    The researchers involved in the study.
     */
    private Set<Researcher> researchers = new HashSet<Researcher>();


    // Data collection instruments
    /*
    The eligibility questionnaire of the study, stored as a separate attribute to the other regular questionnaires which
    are stored separately in another attribute.
     */
    private Questionnaire eligibilityQuestionnaire;

    /*
    The list of all questionnaires created by the researchers for this study.
     */
    private List<Questionnaire> questionnaires;

    /*
      Representation Invariants:
      potentialParticipants, participants, researchers, and questionnaires do not contain duplicates.
     */


    /**
     * Construct a study object with the following parameters specified:
     * The first constructor where the researchers define custom groupings of the study participants.
     * <p>
     * Precondition: the type of the study must be either "Randomized" or "General"
     *
     * @param studyType       The type of the study, which must be either "Randomized" or "General"
     * @param studyName       The name of the study that the researcher specifies
     * @param targetStudySize The target study size. What is the number of participants the researchers of this study
     *                        want to achieve?
     * @param numGroups       The number of groups that the researchers specify. The researchers specify the custom grouping
     *                        they want.
     * @param groupNames      The name for each of the group that researcher specifies. The length of the list must be the
     *                        same as the number of groups, and each name corresponds to the right index to be referred to.
     */
    public Study(String studyType, String studyName, int targetStudySize, int numGroups, String[] groupNames) {
        // update the current ID
        currID++;
        this.id = currID;
        this.studyType = studyType;
        this.studyName = studyName;
        this.targetStudySize = targetStudySize;
        this.numGroups = numGroups;
        this.groupNames = groupNames;
    }


    /**
     * Construct a study object with the following parameters specified:
     * A second constructor, where the grouping is left by default - there is only one group.
     * <p>
     * Precondition: the type of the study must be either "Randomized" or "General"
     *
     * @param studyType       The type of the study, which must be either "Randomized" or "General"
     * @param studyName       The name of the study that the researcher specifies
     * @param targetStudySize The target study size. What is the number of participants the researchers of this study
     *                        want to achieve?
     */
    public Study(String studyType, String studyName, int targetStudySize) {
        // update the current ID
        currID++;
        this.id = currID;
        this.studyType = studyType;
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
        return numGroups;
    }

    /**
     * Return the names of the groups in order.
     *
     * @return the name of each group
     */
    public String[] getGroupNames() {
        return groupNames;
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
        if (this.participants.isEmpty()) {
            this.numGroups = numGroups;
            this.groupNames = groupNames;
            return true;
        }
        return false;
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
        if (this.participants.isEmpty()) {
            String[] groupNames = new String[numGroups];
            for (int i = 0; i < numGroups; i++) {
                int group = i + 1;
                groupNames[i] = "Group " + group;
            }
            this.numGroups = numGroups;
            this.groupNames = groupNames;
            return true;
        }
        return false;
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
        if (this.participants.isEmpty()) {
            this.studyType = studyType;
            return true;
        }
        return false;
    }


    /**
     * Return the list of potential participants. Returns a copy.
     *
     * @return the list of potential participants.
     */
    public List<Participant> getPotentialParticipants() {
        return new ArrayList<Participant>(this.potentialParticipants);
    }


    /**
     * Remove a potential participant from the list of potential participants.
     *
     * @param p the potential participant to be removed.
     * @return whether the removal is successful.
     */
    public boolean removePotentialParticipant(Participant p) {
        if (this.potentialParticipants.contains(p)) {
            return this.potentialParticipants.remove(p);
        }
        return false;
    }


    /**
     * Add a potential participant from the list of potential participants.
     *
     * @param p the potential participant to be added.
     * @return whether the addition is successful.
     */
    public boolean addPotentialParticipant(Participant p) {
        if (!this.potentialParticipants.contains(p)) {
            return this.potentialParticipants.add(p);
        }
        return false;
    }


    /**
     * Return the list of all eligible participants. Returns a copy.
     *
     * @return the list of all eligible participants.
     */
    public List<Participant> getParticipants() {
        return new ArrayList<Participant>(this.participants);
    }


    /**
     * Remove a participant from the list of eligible participants.
     *
     * @param p participant to be removed.
     * @return whether the removal is successful.
     */
    public boolean removeParticipant(Participant p) {
        if (this.participants.contains(p)) {
            return this.participants.remove(p);
        }
        return false;
    }


    /**
     * Add participants from the list of eligible participants.
     * The participant must be in the list of potential participants.
     *
     * @param p participant to be added.
     * @return whether the addition is successful.
     */
    public boolean addParticipant(Participant p) {
        if (this.participants.contains(p)) {
            if (this.potentialParticipants.contains(p)) {
                this.potentialParticipants.remove(p);
                return this.participants.add(p);
            }
            return false;
        }
        return false;
    }


    /**
     * Return the list of all researchers in the study. Returns a copy.
     *
     * @return the list of all researchers in the study.
     */
    public List<Researcher> getResearchers() {
        return new ArrayList<Researcher>(this.researchers);
    }


    /**
     * Add a list of researchers to the existing list of researchers in the study.
     * Return false if the added list is empty.
     *
     * @param researcherList a list of researchers to be added.
     * @return whether the addition is successful.
     */
    public boolean addResearchers(@NotNull List<Researcher> researcherList) {
        if (!researcherList.isEmpty()) {
            this.researchers.addAll(researcherList);
            return true;
        }
        return false;
    }


    /**
     * Retrieve the eligibility questionnaire.
     *
     * @return the eligibility questionnaire.
     */
    public Questionnaire getEligibilityQuestionnaire() {
        return eligibilityQuestionnaire;
    }


    /**
     * Set the eligibility questionnaire.
     *
     * @param eligibilityQuestionnaire the eligibility questionnaire.
     */
    public void setEligibilityQuestionnaire(Questionnaire eligibilityQuestionnaire) {
        this.eligibilityQuestionnaire = eligibilityQuestionnaire;
    }


    /**
     * Retrieve the list of questionnaires of the study.
     *
     * @return the list of questionnaires of the study.
     */
    public List<Questionnaire> getQuestionnaires() {
        return new ArrayList<Questionnaire>(this.questionnaires);
    }


    /**
     * Add a questionnaire to the list of questionnaires.
     *
     * @param q the questionnaire to be added.
     * @return whether the addition is successful.
     */
    public boolean addQuestionnaire(Questionnaire q) {
        if (!this.questionnaires.contains(q)) {
            return this.questionnaires.add(q);
        }
        return false;
    }


    /**
     * Remove a questionnaire from the list of questionnaires.
     *
     * @param q the questionnaire to be removed.
     * @return whether the removal is successful.
     */
    public boolean removeQuestionnaire(Questionnaire q) {
        if (this.questionnaires.contains(q)) {
            return this.questionnaires.remove(q);
        }
        return false;
    }
}