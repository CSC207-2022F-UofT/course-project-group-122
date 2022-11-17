package UserInterfaceLayer.screens.ResearcherRequestParticipantScreen;

import UserInterfaceLayer.screens.ControllerManager;

import java.util.List;
import java.util.Map;

public class ResearcherRequestParticipantInputData {
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


    ControllerManager controllerManager;

    public ResearcherRequestParticipantInputData(int participantID,
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
                                                 Map<Integer, List<String[]>> completedQuestionnaireAnswerHistory,
                                                 ControllerManager controllerManager) {
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
        this.controllerManager = controllerManager;
    }

    public int getParticipantId() {
        return participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public String getParticipantStatus() {
        return participantStatus;
    }

    public int getStudyId() {
        return studyId;
    }

    public String getStudyName() {
        return studyName;
    }

    public String getStudyDescription() {
        return studyDescription;
    }

    public String getStudyStatus() {
        return studyStatus;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public int getEligibilityQuestionnaireId() {
        return eligibilityQuestionnaireId;
    }

    public String getEligibilityQuestionnaireAnswerStatus() {
        return eligibilityQuestionnaireAnswerStatus;
    }

    public List<Integer> getAssignedQuestionnaires() {
        return assignedQuestionnaires;
    }

    public List<Integer> getCompletedQuestionnaires() {
        return completedQuestionnaires;
    }

    public List<Integer> getQuestionnaireAnswers() {
        return questionnaireAnswers;
    }

    public String[] getEligibilityQuestionnaireData() {
        return eligibilityQuestionnaireData;
    }

    public Map<Integer, String[]> getAssignedQuestionnaireData() {
        return assignedQuestionnaireData;
    }

    public Map<Integer, String[]> getCompletedQuestionnaireData() {
        return completedQuestionnaireData;
    }

    public List<String[]> getEligibilityQuestionnaireAnswerHistory() {
        return eligibilityQuestionnaireAnswerHistory;
    }

    public Map<Integer, List<String[]>> getCompletedQuestionnaireAnswerHistory() {
        return completedQuestionnaireAnswerHistory;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }


    public String[] getQuestionnairesTableHeader() {
        return new String[]{"Questionnaire ID", "Questionnaire Name", "Questionnaire Status"};

    }
}
