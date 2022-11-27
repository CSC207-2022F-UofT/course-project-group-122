package user_interface_layer.screens.questionnaire_versioned_answer_screen;

import user_interface_layer.ScreenManager;
import user_interface_layer.SetScreenToCenter;
import user_interface_layer.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class QuestionnaireVersionedAnswerScreen extends JFrame {
    public QuestionnaireVersionedAnswerScreen(QuestionnaireVersionedAnswerInputData data, ControllerManager controllerManager) {
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
                controllerManager.checkQuestionnaireVersionedAnswerRequest(data.getStudyId(),data.getQuestionnaireID(),answerID,version);
            }
        });
        add(scrollPane, BorderLayout.CENTER);
        add(selectAnswerButton, BorderLayout.SOUTH);
        pack();

        SetScreenToCenter s = new SetScreenToCenter(this);
    }

    public static void main(String[] args) {
        ArrayList<String[]> answer = new ArrayList<>();
        answer.add(new String[]{"32", "4", "Jannet", "2020-12-12", "Some Answer"});
        answer.add(new String[]{"33", "5", "Jannet", "2020-12-12", "Some Answer"});
        answer.add(new String[]{"34", "6", "Jannet", "2020-12-12", "Some Answer"});


        QuestionnaireVersionedAnswerInputData data = new QuestionnaireVersionedAnswerInputData(44, 65, 76, answer);
        QuestionnaireVersionedAnswerScreen screen = new QuestionnaireVersionedAnswerScreen(data, new ControllerManager(new ScreenManager()));
        screen.setVisible(true);

    }
}
