package screens.AnswerQuestionnaireScreens;

import screens.QuestionPanels.QuestionPanels;
import view.ViewModel;

import java.util.HashMap;
import java.util.List;

public class AnswerQuestionnaireInputData {
    private final int participantID;

    private final int studyID;

    private String questionnaireName;

    private String questionnaireDescription;
    private final int questionnaireID;

    private List<QuestionPanels> questions;
    private HashMap<String, String> answerKey = new HashMap<>();

    private ViewModel viewModel;

    public AnswerQuestionnaireInputData(int participantID, int studyID, String questionnaireName, String questionnaireDescription, int questionnaireID, List<QuestionPanels> questions, ViewModel viewModel) {
        this.participantID = participantID;
        this.studyID = studyID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.questionnaireID = questionnaireID;
        this.questions = questions;
    }

    public int getParticipantID() {
        return participantID;
    }

    public int getStudyID() {
        return studyID;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public int getQuestionnaireID() {
        return questionnaireID;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public List<QuestionPanels> getQuestions() {
        return questions;
    }

    public void setAnswerKey(HashMap<String, String> answerKey) {
        this.answerKey = answerKey;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }
}
