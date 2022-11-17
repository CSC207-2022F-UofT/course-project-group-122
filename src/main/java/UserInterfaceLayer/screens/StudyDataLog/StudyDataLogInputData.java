package UserInterfaceLayer.screens.StudyDataLog;

import UserInterfaceLayer.screens.ControllerManager;

import java.util.ArrayList;
import java.util.List;

public class StudyDataLogInputData {
        private final int researchID;
        private final int studyID;
        private final String studyType;
        private String randomizedStrategy = "";
        private final String studyName;
        private final String[] UserTableHeader = {"ID", "Username", "Name"};
        private final List<String[]> researchers;
        private final List<String[]> potentials;
        private final List<String[]> participants;
        private final String[] questionnairesTableHeader = {"ID", "Name", "Description", "Published", "Status"};
        private final String[] eligibilityQuestionnaire;
        private List<String[]> questionnaires;
        private List<String> groups;
       private final ControllerManager controllerManager;

    public StudyDataLogInputData(
        int researchID,
        int studyID,
        String studyType,
        String randomizedStrategy,
        String studyName,
        List<String[]> researchers,
        List<String[]> potentials,
        List<String[]> participants,
        String[] eligibilityQuestionnaire,
        List<String[]> questionnaires,
        List<String> groups,
        ControllerManager controllerManager)

        {
            this.researchID = researchID;
            this.studyID = studyID;
            this.studyType = studyType;
            this.randomizedStrategy = randomizedStrategy;
            this.studyName = studyName;
            this.researchers = researchers;
            this.potentials = potentials;
            this.participants = participants;
            this.eligibilityQuestionnaire = eligibilityQuestionnaire;
            this.questionnaires = questionnaires;
            this.groups = groups;
            this.controllerManager = controllerManager;
        }

        public int getResearchID() {
            return researchID;
        }

        public int getStudyID() {
            return studyID;
        }

        public String getStudyType() {
            return studyType;
        }

        public String getRandomizedStrategy() {
            return randomizedStrategy;
        }

        public void setRandomizedStrategy(String randomizedStrategy) {
            this.randomizedStrategy = randomizedStrategy;
        }

        public String getStudyName() {
            return studyName;
        }

        public String[] getUserTableHeader() {
            return UserTableHeader;
        }
        public List<String[]> getResearchers() {
            return researchers;
        }

        public List<String[]> getPotentials() {
            return potentials;
        }

        public List<String[]> getParticipants() {
            return participants;
        }

        public String[] getQuestionnairesTableHeader() {
            return questionnairesTableHeader;
        }

        public String[] getEligibilityQuestionnaire() {
            return eligibilityQuestionnaire;
        }
        public List<String[]> getQuestionnaires() {
            return questionnaires;
        }

        public void setQuestionnaires(List<String[]> questionnaires) {
            this.questionnaires = questionnaires;
        }

        public List<String> getGroups() {
            return groups;
        }

        public void setGroups(List<String> groups) {
            this.groups = groups;
        }

        public ControllerManager getControllerManager() {
            return controllerManager;
        }

        public boolean isStudyEmpty(){
            return (potentials == null || potentials.isEmpty()) && (participants == null || participants.isEmpty());
        }
    }

