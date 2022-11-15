package screens.CreateEditQuestionnaireScreens.EditQuestionnaire;

import screens.QuestionModel;
import view.ViewModel;

import java.util.List;

public class EditQuestionnaireScreenInputData {

    private final int studyID;

    private final String questionnaireName;

    private final String questionnaireDescription;

    private final String[] questionsTableHeader = {"Type", "Question", "Variable", "Answer"};

    private final List<QuestionModel> questions;

    private final ViewModel viewModel;

    public EditQuestionnaireScreenInputData(int studyID, String questionnaireName, String questionnaireDescription ,List<QuestionModel> questions, ViewModel viewModel) {
        this.studyID = studyID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.questions = questions;
        this.viewModel = viewModel;
    }

    public int getStudyID() {
        return studyID;
    }
    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public String[] getQuestionsTableHeader() {
        return questionsTableHeader;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }


}

