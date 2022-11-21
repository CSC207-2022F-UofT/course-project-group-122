package screens.ParticipantHomeScreens.ParticipantEnrolledScreen;

import view.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ParticipantEnrolledInputData {
    int studyID;
    String studyName;
    private int participantID;
    String[] questionnaireTableHeader = {"ID", "Name", "Description", "Status"};
    String [] eligibilityQuestionnaire;
    List<String[]> questionnaires = new ArrayList<>();
    ViewModel viewModel;
    public ParticipantEnrolledInputData(int studyID, String studyName, int participantID, String [] eligibilityQ, List<String[]> questionnaires, ViewModel viewModel) {
        this.studyID = studyID;
        this.studyName = studyName;
        this.participantID = participantID;
        this.eligibilityQuestionnaire = eligibilityQ;
        this.questionnaires = questionnaires;
        this.viewModel = viewModel;
    }

    public int getStudyID() {
        return studyID;
    }

    public String getStudyName() {
        return studyName;
    }

    public int getParticipantID() {
        return participantID;
    }

    public String[] getQuestionnaireTableHeader() {
        return questionnaireTableHeader;
    }

    public List<String[]> getQuestionnaires() {
        return questionnaires;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }

    public String[] getEligibilityQuestionnaire() {
        return eligibilityQuestionnaire;
    }
}
