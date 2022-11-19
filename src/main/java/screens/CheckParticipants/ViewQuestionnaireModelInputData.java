package screens.CheckParticipants;

import view.ViewModel;

import java.util.List;

public class ViewQuestionnaireModelInputData {

    private int questionnaireID;
    private String questionnaireName;
    private String questionnaireDescription;
    private String[] questionsTableHeader = {"Type", "Question", "Variable", "Answer"};
    private List<String[]> questions;

    private ViewModel viewModel;

    public ViewQuestionnaireModelInputData(int questionnaireID, String questionnaireName, String questionnaireDescription, List<String[]> questions, ViewModel viewModel) {
        this.questionnaireID = questionnaireID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.questions = questions;
        this.viewModel = viewModel;
    }

    public int getQuestionnaireID() {
        return questionnaireID;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public String[] getQuestionsTableHeader() {
        return questionsTableHeader;
    }

    public List<String[]> getQuestions() {
        return questions;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }
}
