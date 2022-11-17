package UserInterfaceLayer.screens.ResearcherRequestParticipantScreen.QuestionnairesPanelsForResearchers;

import UserInterfaceLayer.SetTableModel;
import UserInterfaceLayer.screens.ResearcherRequestParticipantScreen.ResearcherRequestParticipantInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EligibilityQuestionnairePanelForResearcher extends JPanel {

    public EligibilityQuestionnairePanelForResearcher(ResearcherRequestParticipantInputData data) {
        super();
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(data.getQuestionnairesTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();
        model.addRow(data.getEligibilityQuestionnaireData());

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        add(scrollPane, BorderLayout.CENTER);


        JButton checkAnswerButton = new JButton("Check Answer");
        checkAnswerButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to check answers");
            } else {
                String status = model.getValueAt(selectedRow, 3).toString();
                if (status.equals("Completed")) {
                    data.getControllerManager().checkQuestionnaireVersionedAnswerDriver(data.getParticipantID(), questionnaireID, data.getEligibilityQuestionnaireAnswers());
                } else {
                    JOptionPane.showMessageDialog(null, "Please answer the questionnaire first");
                }
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(checkAnswerButton);
        add(buttonsPanel, BorderLayout.SOUTH);

    }
}
