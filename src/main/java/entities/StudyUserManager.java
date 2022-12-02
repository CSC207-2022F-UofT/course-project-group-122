package entities;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudyUserManager implements Serializable {

    /**
     * The study that this manager is managing.
     */
    private final Study study;

    /**
     * The number of groups in the study. The default number of groups is 1.
     */
    private int numGroups = 1;
    /**
     * A list storing the name for each of the groups defined.
     */
    private String[] groupNames = {"Group 1"};
    /**
     * The potential participants of the study. Their eligibility of the study has not been checked.
     */
    private final Set<Participant> potentialParticipants = new HashSet<>();
    /**
     * The eligible participants of the study. These participants are considered as part of the study.
     */
    private final Set<Participant> participants = new HashSet<>();
    /**
     * The researchers involved in the study.
     */
    private final Set<Researcher> researchers = new HashSet<>();


    /**
     * Constructor for StudyUserManager.
     *
     * @param study the study that this StudyUserManager is managing.
     */
    public StudyUserManager(Study study) {
        this.study = study;
    }


    /**
     * Retrieve the study that this manager is managing.
     *
     * @return the study that this manager is managing.
     */
    public Study getStudy() {
        return study;
    }


    /**
     * The current number of participants in the study.
     *
     * @return the current number of participants in the study.
     */
    protected int currentStudySize() {
        return participants.size();
    }

    /**
     * Return the number of groups in the study.
     *
     * @return the number of groups in the study.
     */
    protected int getNumGroups() {
        return numGroups;
    }

    /**
     * Return the names of the groups in order.
     *
     * @return the names of each groups
     */
    protected String[] getGroupNames() {
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
    protected boolean resetGroups(int numGroups, String[] groupNames) {
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
    protected boolean resetGroups(int numGroups) {
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
     * Return the list of potential participants. Returns a copy.
     *
     * @return the list of potential participants.
     */
    protected List<Participant> getPotentialParticipants() {
        return new ArrayList<>(this.potentialParticipants);
    }

    /**
     * Remove a potential participant from the list of potential participants.
     *
     * @param p the potential participant to be removed.
     * @return whether the removal is successful.
     */
    protected boolean removePotentialParticipant(Participant p) {
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
    protected boolean addPotentialParticipant(Participant p) {
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
    protected List<Participant> getParticipants() {
        return new ArrayList<>(this.participants);
    }

    /**
     * Remove a participant from the list of eligible participants.
     *
     * @param p participant to be removed.
     * @return whether the removal is successful.
     */
    protected boolean removeParticipant(Participant p) {
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
    protected boolean addParticipant(Participant p) {
        if (!this.participants.contains(p)) {
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
    protected List<Researcher> getResearchers() {
        return new ArrayList<>(this.researchers);
    }

    /**
     * Add a list of researchers to the existing list of researchers in the study.
     * Return false if the added list is empty.
     *
     * @param researcherList a list of researchers to be added.
     * @return whether the addition is successful.
     */
    protected boolean addResearchers(@NotNull List<Researcher> researcherList) {
        if (!researcherList.isEmpty()) {
            this.researchers.addAll(researcherList);
            return true;
        }
        return false;
    }

    /**
     * Add a researcher to the existing list of researchers in the study.
     *
     * @param researcher a researchers to be added.
     * @return whether the addition is successful.
     */
    public boolean addResearcher(Researcher researcher) {
        return this.researchers.add(researcher);
    }

    /**
     * Remove a researcher from the list of researchers in the study.
     *
     * @param researcher researcher to be removed.
     * @return whether the removal is successful.
     */
    protected boolean removeResearcher(Researcher researcher) {
        if (this.researchers.contains(researcher)) {
            return this.researchers.remove(researcher);
        }
        return false;
    }


}