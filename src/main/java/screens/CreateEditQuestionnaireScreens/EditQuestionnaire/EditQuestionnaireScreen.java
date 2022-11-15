package screens.CreateEditQuestionnaireScreens.EditQuestionnaire;

import screens.QuestionModel;
import screens.SetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class EditQuestionnaireScreen extends JFrame {
    public EditQuestionnaireScreenInputData data;
    List<QuestionModel> questions;

    public EditQuestionnaireScreen(EditQuestionnaireScreenInputData data) {
        this.data = data;
        this.questions = data.getQuestions();

        JPanel headerPanel = new JPanel();
        JLabel questionnaireNameLabel = new JLabel(data.getQuestionnaireName(), SwingConstants.CENTER);
        JLabel questionnaireDescriptionLabel = new JLabel(data.getQuestionnaireDescription(), SwingConstants.CENTER);

        headerPanel.add(questionnaireNameLabel);
        headerPanel.add(questionnaireDescriptionLabel);

        SetTableModel questionsTableModel = new SetTableModel(data.getQuestionsTableHeader());
        DefaultTableModel model = questionsTableModel.getModel();
        JTable questionsTable = questionsTableModel.getTable();
        JScrollPane questionsTableScrollPane = new JScrollPane(questionsTable);

        for (QuestionModel question : questions) {
            String type = question.getType();

            }
        }

    }
