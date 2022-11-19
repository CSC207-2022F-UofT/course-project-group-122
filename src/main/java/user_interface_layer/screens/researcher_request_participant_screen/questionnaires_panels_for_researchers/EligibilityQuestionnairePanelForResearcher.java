package user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers;

import user_interface_layer.SetTableModel;
import user_interface_layer.screens.researcher_request_participant_screen.ResearcherRequestParticipantInputData;

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
                int questionnaireID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
                    data.getControllerManager().checkQuestionnaireVersionedAnswer(data.getStudyId(), data.getParticipantId(), questionnaireID, data.getEligibilityQuestionnaireAnswerHistory());
                    JOptionPane.showMessageDialog(null, "Please answer the questionnaire first");

            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(checkAnswerButton);
        add(buttonsPanel, BorderLayout.SOUTH);

    }
}
