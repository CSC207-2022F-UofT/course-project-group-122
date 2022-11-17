package UserInterfaceLayer.screens.ParticipantHomeScreens.QuestionnairePanelsForParticipants;

import UserInterfaceLayer.SetTableModel;
import UserInterfaceLayer.screens.ParticipantHomeScreens.ParticipantHomeScreenInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CompletedQuestionnairePanel extends JPanel {

    public CompletedQuestionnairePanel(ParticipantHomeScreenInputData data) {
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(data.getQuestionnairesTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();


        for (String[] questionnaireData : data.getCompletedQuestionnaireData()) {
            model.addRow(questionnaireData);
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        JButton checkAnswerButton = new JButton("Check Answers");
        checkAnswerButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to check.");
            } else {
                int questionnaireID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
                data.getControllerManager().checkQuestionnaireVersionedAnswerDriver(data.getParticipantID(),
                        questionnaireID,
                        data.getCompletedQuestionnairesAnswerHistory().get(questionnaireID));
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(checkAnswerButton);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
