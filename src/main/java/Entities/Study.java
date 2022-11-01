package Entities;

import java.util.ArrayList;
import java.util.List;


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
    private int id;

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
    private List<Participant> potentialParticipants = new ArrayList<Participant>();

    /*
    The eligible participants of the study. These participants are considered as part of the study.
     */
    private List<Participant> participants = new ArrayList<Participant>();

    /*
    The researchers involved in the study.
     */
    private List<Researcher> researchers = new ArrayList<Researcher>();


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


    /**
     * Construct a study object with the following parameters specified:
     * The first constructor where the researchers define custom groupings of the study participants.
     *
     * @param studyType The type of the study, which must be either "Randomized" or "General"
     * @param studyName The name of the study that the researcher specifies
     * @param targetStudySize The target study size. What is the number of participants the researchers of this study
     *                        want to achieve?
     * @param numGroups The number of groups that the researchers specify. The researchers specify the custom grouping
     *                  they want.
     * @param groupNames The name for each of the group that researcher specifies. The length of the list must be the
     *                   same as the number of groups, and each name corresponds to the right index to be referred to.
     */
    public Study(String studyType, String studyName, int targetStudySize, int numGroups, String[] groupNames) {
        // update the current ID
        currID ++;
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
     *
     * @param studyType The type of the study, which must be either "Randomized" or "General"
     * @param studyName The name of the study that the researcher specifies
     * @param targetStudySize The target study size. What is the number of participants the researchers of this study
     *                        want to achieve?
     */
    public Study(String studyType, String studyName, int targetStudySize) {
        // update the current ID
        currID ++;
        this.id = currID;
        this.studyType = studyType;
        this.studyName = studyName;
        this.targetStudySize = targetStudySize;
    }


    /**
     * Return the name of the study.
     * @return the name of the study.
     */
    public String getStudyName() {
        return studyName;
    };


    /**
     * Modify the name of the study.
     * @param name  The new name of the study that a researcher wants to change to.
     */
    public void modifyStudyName(String name) {
        this.studyName = name;
    }


    /**
     * Return the target study size.
     * @return the target study size.
     */
    public int getTargetStudySize() {
        return targetStudySize;
    }


    /**
     * Modify the target study size.
     * @param targetStudySize the new target study size.
     */
    public void modifyTargetStudySize(int targetStudySize) {
        this.targetStudySize = targetStudySize;
    }


    /**
     * Retrieve the ID of the study.
     * @return the ID of the study.
     */
    public int getId() {
        return id;
    }


    /**
     * Return the if the study is still active.
     * @return a boolean indicating the active status of the study.
     */
    public boolean isActive() {
        return isActive;
    }


    /**
     * Return the number of groups in the study.
     * @return the number of groups in the study.
     */
    public int getNumGroups() {
        return numGroups;
    }














}
