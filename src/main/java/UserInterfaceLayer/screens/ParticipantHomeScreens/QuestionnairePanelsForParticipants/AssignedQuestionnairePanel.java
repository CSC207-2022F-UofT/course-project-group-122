package UserInterfaceLayer.screens.ParticipantHomeScreens.QuestionnairePanelsForParticipants;

import UserInterfaceLayer.SetTableModel;
import UserInterfaceLayer.screens.ParticipantHomeScreens.ParticipantHomeScreenInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AssignedQuestionnairePanel extends JPanel {

public AssignedQuestionnairePanel(ParticipantHomeScreenInputData data) {
    setLayout(new BorderLayout());
    SetTableModel setTableModel = new SetTableModel(data.getQuestionnairesTableHeader());
    DefaultTableModel model = setTableModel.getModel();
    JTable table = setTableModel.getTable();


    for (String[] questionnaireData : data.getAssignedQuestionnaireData()) {
        model.addRow(questionnaireData);
    }

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setViewportView(table);
    add(scrollPane, BorderLayout.CENTER);

    JButton answerButton = new JButton("Answer Questionnaire");
    answerButton.addActionListener(e -> {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a questionnaire to answer");
        } else {
            if (model.getValueAt(selectedRow, 2).toString().equals("Closed")) {
                JOptionPane.showMessageDialog(null, "This Questionnaire is closed");
            } else {
                int questionnaireID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
                data.getControllerManager().answerQuestionnaireRequestData(data.getParticipantID(), questionnaireID);
            }

        }
    });



    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(answerButton);
    add(buttonsPanel, BorderLayout.SOUTH);
    }
}
