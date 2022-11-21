package user_interface_layer.screens.participant_home_screens;

import user_interface_layer.screens.ControllerManager;

import java.util.List;
import java.util.Map;

public class ParticipantHomeScreenInputData {
    /**
     * The ID of the participant.
     */
    private final int participantId;

    /**
     * The name of the participant.
     */
    private final String participantName;

    /**
     * The status of the participant.
     */
    private final String participantStatus;

    /**
     * The ID of the study.
     */
    private final int studyId;

    /**
     * The name of the study.
     */
    private final String studyName;

    /**
     * The description of the study.
     */
    private final String studyDescription;

    /**
     * The status of the study.
     */
    private final String studyStatus;

    /**
     * The group number attached to this participant.
     */
    private final int groupNumber;

    /**
     * The eligibility questionnaire attached to this participant.
     */
    private final int eligibilityQuestionnaireId;

    /**
     * The status of the eligibility questionnaire answer.
     */
    private final String eligibilityQuestionnaireAnswerStatus;

    /**
     * The questionnaires assigned to this participant.
     */
    private final List<Integer> assignedQuestionnaires;

    /**
     * The questionnaires completed by this participant.
     */
    private final List<Integer> completedQuestionnaires;

    /**
     * The answers to the questionnaires completed by this participant.
     */
    private final List<Integer> questionnaireAnswers;

    /**
     * The data of the eligibility questionnaire.
     */
    private final String[] eligibilityQuestionnaireData;

    /**
     * The data of the assigned questionnaires.
     */
    private final Map<Integer, String[]> assignedQuestionnaireData;

    /**
     * The data of the completed questionnaires.
     */
    private final Map<Integer, String[]> completedQuestionnaireData;

    /**
     * This history of all versions of the eligibility questionnaire.
     */
    private final List<String[]> eligibilityQuestionnaireAnswerHistory;

    /**
     * This history of all versions of the completed questionnaires.
     */
    private final Map<Integer, List<String[]>> completedQuestionnaireAnswerHistory;

    /**
     * The constructor of the class.
     */
    public ParticipantHomeScreenInputData(int participantID,
                                          String participantName,
                                          String participantStatus,
                                          int studyID,
                                          String studyName,
                                          String studyDescription,
                                          String studyStatus,
                                          int groupNumber,
                                          int eligibilityQuestionnaireID,
                                          String eligibilityQuestionnaireAnswerStatus,
                                          List<Integer> assignedQuestionnaires,
                                          List<Integer> completedQuestionnaires,
                                          List<Integer> questionnaireAnswers,
                                          String[] eligibilityQuestionnaireData,
                                          Map<Integer, String[]> assignedQuestionnaireData,
                                          Map<Integer, String[]> completedQuestionnaireData,
                                          List<String[]> eligibilityQuestionnaireAnswerHistory,
                                          Map<Integer, List<String[]>> completedQuestionnaireAnswerHistory) {
        this.participantId = participantID;
        this.participantName = participantName;
        this.participantStatus = participantStatus;
        this.studyId = studyID;
        this.studyName = studyName;
        this.studyDescription = studyDescription;
        this.studyStatus = studyStatus;
        this.groupNumber = groupNumber;
        this.eligibilityQuestionnaireId = eligibilityQuestionnaireID;
        this.eligibilityQuestionnaireAnswerStatus = eligibilityQuestionnaireAnswerStatus;
        this.assignedQuestionnaires = assignedQuestionnaires;
        this.completedQuestionnaires = completedQuestionnaires;
        this.questionnaireAnswers = questionnaireAnswers;
        this.eligibilityQuestionnaireData = eligibilityQuestionnaireData;
        this.assignedQuestionnaireData = assignedQuestionnaireData;
        this.completedQuestionnaireData = completedQuestionnaireData;
        this.eligibilityQuestionnaireAnswerHistory = eligibilityQuestionnaireAnswerHistory;
        this.completedQuestionnaireAnswerHistory = completedQuestionnaireAnswerHistory;
    }

    /**
     * Returns the ID of the participant.
     */
    public int getParticipantId() {
        return participantId;
    }

    /**
     * Returns the name of the participant.
     */
    public String getParticipantName() {
        return participantName;
    }

    /**
     * Returns the status of the participant.
     */
    public String getParticipantStatus() {
        return participantStatus;
    }

    /**
     * Returns the ID of the study.
     */
    public int getStudyId() {
        return studyId;
    }

    /**
     * Returns the name of the study.
     */
    public String getStudyName() {
        return studyName;
    }

    /**
     * Returns the description of the study.
     */
    public String getStudyDescription() {
        return studyDescription;
    }

    /**
     * Returns the status of the study.
     */
    public String getStudyStatus() {
        return studyStatus;
    }

    /**
     * Returns the group number attached to this participant.
     */
    public int getGroupNumber() {
        return groupNumber;
    }

    /**
     * Returns the eligibility questionnaire attached to this participant.
     */
    public int getEligibilityQuestionnaireId() {
        return eligibilityQuestionnaireId;
    }

    /**
     * Returns the status of the eligibility questionnaire answer.
     */
    public String getEligibilityQuestionnaireAnswerStatus() {
        return eligibilityQuestionnaireAnswerStatus;
    }

    /**
     * Returns the questionnaires assigned to this participant.
     */
    public List<Integer> getAssignedQuestionnaires() {
        return assignedQuestionnaires;
    }

    /**
     * Returns the questionnaires completed by this participant.
     */
    public List<Integer> getCompletedQuestionnaires() {
        return completedQuestionnaires;
    }

    /**
     * Returns the answers to the questionnaires completed by this participant.
     */
    public List<Integer> getQuestionnaireAnswers() {
        return questionnaireAnswers;
    }

    /**
     * Returns the data of the eligibility questionnaire.
     *
     */
    public String[] getEligibilityQuestionnaireData() {
        return eligibilityQuestionnaireData;
    }

    /**
     * Returns the data of the assigned questionnaires.
     */
    public Map<Integer, String[]> getAssignedQuestionnaireData() {
        return assignedQuestionnaireData;
    }

    /**
     * Returns the data of the completed questionnaires.
     */
    public Map<Integer, String[]> getCompletedQuestionnaireData() {
        return completedQuestionnaireData;
    }

    /**
     * Returns the history of all versions of the eligibility questionnaire.
     */
    public List<String[]> getEligibilityQuestionnaireAnswerHistory() {
        return eligibilityQuestionnaireAnswerHistory;
    }

    /**
     * Returns the history of all versions of the completed questionnaires.
     */
    public Map<Integer, List<String[]>> getCompletedQuestionnaireAnswerHistory() {
        return completedQuestionnaireAnswerHistory;
    }

    /*
     * Returns the header for the questionnaire table
     */
    public String[] getQuestionnairesTableHeader() {
        return new String[]{"Questionnaire ID", "Questionnaire Name", "Questionnaire Status"};
    }
}