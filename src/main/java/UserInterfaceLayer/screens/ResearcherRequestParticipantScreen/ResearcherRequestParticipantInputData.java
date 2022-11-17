package UserInterfaceLayer.screens.ResearcherRequestParticipantScreen;

import UserInterfaceLayer.screens.ControllerManager;
import entities.Answer;
import entities.Questionnaire;
import entities.Study;
import entities.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResearcherRequestParticipantInputData {
    private final int participantID;
    private final String participantName;

    private final String participantStatus;
//    private final Study study;

    private final int studyID;
    private final String StudyName;
    private final String[] questionnairesTableHeader = {"ID", "Name", "Version", "Status"};
    //    private final Questionnaire eligibilityQuestionnaire;
    private final String[] eligibilityQuestionnaireData;
    private final Map<String,String> eligibilityQuestionnaireAnswers;
    //    private final List<String[]> eligibilityQuestionnaireAnswerHistory;
    private final List<String[]> assignedQuestionnaireData;
    private final List<String[]> completedQuestionnaireData;

    private final List<Map<String,String>> completedQuestionnairesAnswers;

//    private final List<Questionnaire> assignedQuestionnaires;
//    private final Map<Questionnaire, String[]> assignedQuestionnaireData;

//    private final List<Questionnaire> completedQuestionnaires;
//    private final List<Answer> questionnaireAnswers;
//    private final Map<Questionnaire, String[]> completedQuestionnaireData;

    //    HashMap<Questionnaire, String[]> questionnaireData;
    ControllerManager controllerManager;

    public ResearcherRequestParticipantInputData(int participantID,
                                          String participantName,
                                          String participantStatus,
                                          int studyID, String studyName,
                                          String[] eligibilityQuestionnaireData,
                                          Map<String,String> eligibilityQuestionnaireAnswers,
//                                         List<String[]> eligibilityQuestionnaireAnswerHistory,
                                          List<String[]> assignedQuestionnaireData,
                                          List<String[]> completedQuestionnaireData,
                                          List<Map<String,String>> completedQuestionnairesAnswers,
                                          ControllerManager controllerManager) {


//        this.user = user;
        this.participantID = participantID;
        this.participantName = participantName;
        this.participantStatus = participantStatus;
//        this.study = study;
        this.studyID = studyID;
        StudyName = studyName;
//        this.eligibilityQuestionnaire = eligibilityQuestionnaire;
        this.eligibilityQuestionnaireData = eligibilityQuestionnaireData;
        this.eligibilityQuestionnaireAnswers = eligibilityQuestionnaireAnswers;
//        this.eligibilityQuestionnaireAnswerHistory = eligibilityQuestionnaireAnswerHistory;
//        this.assignedQuestionnaires = assignedQuestionnaires;
        this.assignedQuestionnaireData = assignedQuestionnaireData;
//        this.completedQuestionnaires = completedQuestionnaires;
//        this.questionnaireAnswers = questionnaireAnswers;
        this.completedQuestionnaireData = completedQuestionnaireData;
        this.completedQuestionnairesAnswers = completedQuestionnairesAnswers;
//        this.questionnaireData = questionnaireData;
        this.controllerManager = controllerManager;

    }

//    public User getUser() {
//        return user;
//    }

    public int getParticipantID() {
        return participantID;
    }

    public String getParticipantName() {
        return participantName;
    }

//    public Study getStudy() {
//        return study;
//    }

    public int getStudyID() {return studyID;}

    public String getStudyName() {
        return StudyName;
    }

    public String[] getQuestionnairesTableHeader() {
        return questionnairesTableHeader;
    }

//    public Questionnaire getEligibilityQuestionnaire() {
//        return eligibilityQuestionnaire;
//    }

    public String[] getEligibilityQuestionnaireData() {
        return eligibilityQuestionnaireData;
    }

    public Map<String,String> getEligibilityQuestionnaireAnswers() {
        return eligibilityQuestionnaireAnswers;
    }

//    public List<String[]> getEligibilityQuestionnaireAnswerHistory() {
//        return eligibilityQuestionnaireAnswerHistory;
//    }

//    public List<Questionnaire> getAssignedQuestionnaires() {
//        return assignedQuestionnaires;
//    }

    public List<String[]> getAssignedQuestionnaireData() {
        return assignedQuestionnaireData;
    }

    public List<String[]> getCompletedQuestionnaireData() {
        return completedQuestionnaireData;
    }

    public List<Map<String,String>> getCompletedQuestionnairesAnswers() {
        return completedQuestionnairesAnswers;
    }

//    public List<Questionnaire> getCompletedQuestionnaires() {
//        return completedQuestionnaires;
//    }

//    public List<Answer> getQuestionnaireAnswers() {
//        return questionnaireAnswers;
//    }

//    public Map<Questionnaire, String[]> getCompletedQuestionnaireData() {
//        return completedQuestionnaireData;
//    }

//    public HashMap<Questionnaire, String[]> getQuestionnaireData() {
//        return questionnaireData;
//    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }

    public String getParticipantStatus() {
        return participantStatus;
    }
}
