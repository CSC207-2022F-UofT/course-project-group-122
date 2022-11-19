package user_interface_layer.screens.study_data_log;

import user_interface_layer.screens.ControllerManager;

import java.util.List;
import java.util.Map;

public class StudyDataLogInputData {
        private final int researchId;
        private final String researcherName;
        private final int studyId;
        private final String studyType;
        private String randomizedStrategy = "";
        private final String studyName;
        private final String[] UserTableHeader = {"ID", "Username", "Name"};
        private final Map<Integer, String[]> researchersData;
        private final Map<Integer, String[]> potentialsData;
        private final Map<Integer, String[]> participantsData;
        private final String[] questionnairesTableHeader = {"Questionnaire ID", "Questionnaire Name", "Published Status", "Closed Status"};
        private final int eligibilityQuestionnaireId;
        private final String[] eligibilityQuestionnaire;
        private Map<Integer, String[]> questionnairesData;
        private List<String> groups;
       private final ControllerManager controllerManager;

    public StudyDataLogInputData(
            int researchId,
            String researcherName,
            int studyId,
            String studyType,
            String studyName,
            Map<Integer, String[]> researchersData,
            Map<Integer, String[]> potentialsData,
            Map<Integer, String[]> participantsData,
            int eligibilityQuestionnaireId,
            String[] eligibilityQuestionnaire,
            Map<Integer, String[]> questionnairesData,
            List<String> groups,
            ControllerManager controllerManager) {

        this.researchId = researchId;
        this.researcherName = researcherName;
        this.studyId = studyId;
        this.studyType = studyType;
        this.studyName = studyName;
        this.researchersData = researchersData;
        this.potentialsData = potentialsData;
        this.participantsData = participantsData;
        this.eligibilityQuestionnaireId = eligibilityQuestionnaireId;
        this.eligibilityQuestionnaire = eligibilityQuestionnaire;
        this.questionnairesData = questionnairesData;
        this.groups = groups;
        this.controllerManager = controllerManager;
        }

    public int getResearchId() {
        return researchId;
    }

    public String getResearcherName() {
        return researcherName;
    }

    public int getStudyId() {
        return studyId;
    }

    public String getStudyType() {
        return studyType;
    }

    public String getStudyName() {
        return studyName;
    }

    public String[] getUserTableHeader() {
        return UserTableHeader;
    }

    public String [] getPotentialParticipantsTableHeader() {
        return new String[] {"ID", "Username", "Name", "Eligibility"};
    }

    public Map<Integer, String[]> getResearchersData() {
        return researchersData;
    }

    public Map<Integer, String[]> getPotentialsData() {
        return potentialsData;
    }

    public Map<Integer, String[]> getParticipantsData() {
        return participantsData;
    }

    public String[] getQuestionnairesTableHeader() {
        return questionnairesTableHeader;
    }

    public int getEligibilityQuestionnaireId() {
        return eligibilityQuestionnaireId;
    }

    public String[] getEligibilityQuestionnaire() {
        return eligibilityQuestionnaire;
    }

    public Map<Integer, String[]> getQuestionnairesData() {
        return questionnairesData;
    }

    public List<String> getGroups() {
        return groups;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }

    public String getRandomizedStrategy() {
        return randomizedStrategy;
    }

    public void setRandomizedStrategy(String randomizedStrategy) {
        this.randomizedStrategy = randomizedStrategy;
    }

    public void setQuestionnairesData(Map<Integer, String[]> questionnairesData) {
        this.questionnairesData = questionnairesData;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }


    public boolean isStudyEmpty() {
         return potentialsData.isEmpty() && participantsData.isEmpty();
    }
}

