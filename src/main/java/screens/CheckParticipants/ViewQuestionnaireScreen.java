package screens.CheckParticipants;

import screens.SetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewQuestionnaireScreen extends JFrame {

    public ViewQuestionnaireScreen(ViewQuestionnaireModelInputData data) {

        setLayout(new BorderLayout());

        JPanel questionnaireInfoPanel = new JPanel();
        questionnaireInfoPanel.setLayout(new BorderLayout());

        JLabel questionnaireIDLabel = new JLabel(data.getQuestionnaireID() + data.getQuestionnaireName(), SwingConstants.CENTER);
        JLabel questionnaireDescriptionLabel = new JLabel("Description: " + data.getQuestionnaireDescription());

        questionnaireInfoPanel.add(questionnaireIDLabel, BorderLayout.NORTH);
        questionnaireInfoPanel.add(questionnaireDescriptionLabel,BorderLayout.CENTER);

        SetTableModel questionsTableModel = new SetTableModel(data.getQuestionsTableHeader());
        DefaultTableModel model = questionsTableModel.getModel();
        JTable questionsTable = questionsTableModel.getTable();


        for (String[] question : data.getQuestions()) {
            model.addRow(question);
        }
        JScrollPane questionsTableScrollPane = new JScrollPane(questionsTable);

        JButton editAnswerButton = new JButton("Edit Answer");
        editAnswerButton.addActionListener(e -> {
            int selectedRow = questionsTable.getSelectedRow();
            if (selectedRow != -1) {
                String questionType = (String) model.getValueAt(selectedRow, 0);
//                if (questionType.equals("MC")) {
//                    new EditMCQuestionScreen(data.getQuestionnaireID(), data.getQuestionnaireName(), data.getQuestionnaireDescription(), data.getQuestions(), selectedRow);
//                } else if (questionType.equals("Scale")) {
//                    new EditScaleQuestionScreen(data.getQuestionnaireID(), data.getQuestionnaireName(), data.getQuestionnaireDescription(), data.getQuestions(), selectedRow);
//                } else if (questionType.equals("Text")) {
//                    new EditTextQuestionScreen(data.getQuestionnaireID(), data.getQuestionnaireName(), data.getQuestionnaireDescription(), data.getQuestions(), selectedRow);
//                }
            }
        });









    }






}
