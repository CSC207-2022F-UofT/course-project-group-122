package screens.StudyLog;

import view.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class StudyLogInputData {
    private final int researchID;
    private final int studyID;
    private final String studyType;
    private String randomizedStrategy = "";
    private final String studyName;
    private final String[] researchersTableHeader = {"ID", "Username", "Name"};
    private final List<String[]> researchers;
    private final String[] potentialsTableHeader = {"ID", "Username", "Name"};
    private final List<String[]> potentials;
    private final String[] participantsTableHeader = {"ID", "Username", "Name"};
    private final List<String[]> participants;
    private final String[] questionnairesTableHeader = {"ID", "Name", "Description", "Published", "Status"};
    private final String[] eligibilityQuestionnaire;
    private List<String[]> questionnaires;
    private List<String> groups = new ArrayList<>();
    ViewModel viewModel;

    public StudyLogInputData(
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
            ViewModel viewModel)
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
        this.viewModel = viewModel;
    }
    public StudyLogInputData(
            int researchID,
            int studyID,
            String studyType,
            String studyName,
            List<String[]> researchers,
            List<String[]> potentials,
            List<String[]> participants,
            String[] eligibilityQuestionnaire,
            List<String[]> questionnaires,
            List<String> groups,
            ViewModel viewModel)
    {
        this.researchID = researchID;
        this.studyID = studyID;
        this.studyType = studyType;
        this.studyName = studyName;
        this.researchers = researchers;
        this.potentials = potentials;
        this.participants = participants;
        this.eligibilityQuestionnaire = eligibilityQuestionnaire;
        this.questionnaires = questionnaires;
        this.groups = groups;
        this.viewModel = viewModel;
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

    public String[] getResearchersTableHeader() {
        return researchersTableHeader;
    }
    public List<String[]> getResearchers() {
        return researchers;
    }
    public String[] getPotentialsTableHeader() {
        return potentialsTableHeader;
    }
    public List<String[]> getPotentials() {
        return potentials;
    }
    public String[] getParticipantsTableHeader() {
        return participantsTableHeader;
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

    public ViewModel getViewModel() {
        return viewModel;
    }

    public boolean isStudyEmpty(){
        return (potentials == null || potentials.isEmpty()) && (participants == null || participants.isEmpty());
    }


}
