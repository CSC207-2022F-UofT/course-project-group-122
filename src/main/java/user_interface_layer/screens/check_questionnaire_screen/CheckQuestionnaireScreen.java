package user_interface_layer.screens.check_questionnaire_screen;

import use_cases.questionnaire_screen_data_request.CheckQuestionnaireInputData;
import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screen_setters.SetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;

public class CheckQuestionnaireScreen extends JFrame {

    public CheckQuestionnaireScreen(CheckQuestionnaireInputData data) {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        JLabel headerLabel = new JLabel("Questionnaire ID: " + data.getQuestionnaireId(), SwingConstants.CENTER);
        JLabel headerLabel2 = new JLabel("Questionnaire Name: " + data.getQuestionnaireName(), SwingConstants.CENTER);
        JScrollPane scrollPane = new JScrollPane();
        JTextArea descriptionTextArea = new JTextArea(5, 20);
        descriptionTextArea.setText(data.getQuestionnaireDescription());
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setLineWrap(true);

        scrollPane.setViewportView(descriptionTextArea);

        headerPanel.add(headerLabel);
        headerPanel.add(headerLabel2);
        headerPanel.add(scrollPane);


        JScrollPane questionsScrollPane = new JScrollPane();
        SetTableModel tableModel = new SetTableModel(data.getQuestionsTableHeader());
        DefaultTableModel model = tableModel.getModel();
        JTable questionsTable = tableModel.getTable();
        questionsTable.getTableHeader().setResizingAllowed(true);

        for (String[] row : data.getFormattedQuestions()) {
            model.addRow(row);
        }
        questionsScrollPane.setViewportView(questionsTable);
        add(headerPanel, BorderLayout.NORTH);
        add(questionsScrollPane, BorderLayout.CENTER);
        pack();
        SetScreenToCenter s = new SetScreenToCenter(this);


    }

    public static void main(String[] args) {
        HashMap<String, String[]> existingQuestions = new HashMap<>();
        existingQuestions.put("What is your name?", new String[]{"Text", "name", "John"});
        existingQuestions.put("What is your age?", new String[]{"Scale", "age", "20"});
        CheckQuestionnaireInputData data = new CheckQuestionnaireInputData(1, "Questionnaire 1", "This is a questionnaire", existingQuestions);
        CheckQuestionnaireScreen screen = new CheckQuestionnaireScreen(data);
        screen.setVisible(true);

    }
}
