package user_interface_layer.screens.questionnaire_versioned_answer_screen;

import user_interface_layer.SetScreenToCenter;
import user_interface_layer.SetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class QuestionnaireVersionedAnswerScreen extends JFrame {
    public QuestionnaireVersionedAnswerScreen(QuestionnaireVersionedAnswerInputData data) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Questionnaire Versioned Answers");

        SetTableModel setTableModel = new SetTableModel(data.getAnswerTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();

        for (String[] answerData : data.getAnswer()) {
            model.addRow(answerData);
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        JButton selectAnswerButton = new JButton("Check Answer");
        selectAnswerButton.addActionListener(e->{
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select an answer to check.");
            } else {
                int answerID = Integer.parseInt((String) model.getValueAt(selectedRow, 0));
                int version = Integer.parseInt((String) model.getValueAt(selectedRow, 1));
                data.getControllerManager().checkQuestionnaireVersionedAnswerRequest(data.getStudyId(),data.getQuestionnaireID(),answerID,version);
            }
        });
        add(scrollPane, BorderLayout.CENTER);
        add(selectAnswerButton, BorderLayout.SOUTH);
        pack();

        SetScreenToCenter s = new SetScreenToCenter(this);
    }
}
