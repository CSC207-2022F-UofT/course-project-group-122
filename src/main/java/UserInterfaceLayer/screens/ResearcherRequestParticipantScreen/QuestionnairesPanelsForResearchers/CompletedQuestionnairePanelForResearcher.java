package UserInterfaceLayer.screens.ResearcherRequestParticipantScreen.QuestionnairesPanelsForResearchers;

import UserInterfaceLayer.SetTableModel;
import UserInterfaceLayer.screens.ResearcherRequestParticipantScreen.ResearcherRequestParticipantInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CompletedQuestionnairePanelForResearcher extends JPanel {

    public CompletedQuestionnairePanelForResearcher(ResearcherRequestParticipantInputData data) {
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(data.getQuestionnairesTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();


        for (String[] questionnaireData : data.getCompletedQuestionnaireData()) {
            model.addRow(questionnaireData);
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        JButton checkAnswerButton = new JButton("Check Answer");
        checkAnswerButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to check.");
            } else {
                int questionnaireID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
                data.getControllerManager().checkQuestionnaireVersionedAnswerDriver(data.getParticipantID(), questionnaireID,);
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(checkAnswerButton);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
