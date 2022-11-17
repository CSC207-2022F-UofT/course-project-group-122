package UserInterfaceLayer.screens.ParticipantHomeScreens.QuestionnairePanelsForParticipants;

import UserInterfaceLayer.SetTableModel;
import UserInterfaceLayer.screens.ParticipantHomeScreens.ParticipantHomeScreenInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompletedQuestionnairePanel extends JPanel {

    public CompletedQuestionnairePanel(ParticipantHomeScreenInputData data) {
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(data.getQuestionnairesTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();

        List<Integer> keys = new ArrayList<>(data.getCompletedQuestionnaireData().keySet());
        List<String[]> values = new ArrayList<>(data.getCompletedQuestionnaireData().values());

        for (String[] questionnaireData : values) {
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
                int questionnaireID = keys.get(selectedRow);
                data.getControllerManager().checkQuestionnaireVersionedAnswerDriver(data.getStudyId(), data.getParticipantId(),
                        questionnaireID, data.getCompletedQuestionnaireAnswerHistory().get(questionnaireID));
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(checkAnswerButton);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
