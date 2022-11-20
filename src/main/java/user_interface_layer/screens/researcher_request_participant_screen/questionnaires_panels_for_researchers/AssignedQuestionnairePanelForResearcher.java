package user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers;

import user_interface_layer.SetTableModel;
import user_interface_layer.screens.researcher_request_participant_screen.ResearcherRequestParticipantInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AssignedQuestionnairePanelForResearcher extends JPanel {

public AssignedQuestionnairePanelForResearcher(ResearcherRequestParticipantInputData data) {
    setLayout(new BorderLayout());
    SetTableModel setTableModel = new SetTableModel(data.getQuestionnairesTableHeader());
    DefaultTableModel model = setTableModel.getModel();
    JTable table = setTableModel.getTable();

    List<Integer> keys = new ArrayList<>(data.getAssignedQuestionnaireData().keySet());
    List<String[]> values = new ArrayList<>(data.getAssignedQuestionnaireData().values());

    for (String[] questionnaireData : values) {
        model.addRow(questionnaireData);
    }

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setViewportView(table);
    add(scrollPane, BorderLayout.CENTER);

    JPanel buttonsPanel = new JPanel();
    add(buttonsPanel, BorderLayout.SOUTH);
    }

    JButton answerButton = new JButton("Answer Questionnaire");
    answerButton.addActionListener(e -> {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a questionnaire to answer");
        } else {
            if (model.getValueAt(selectedRow, 2).toString().equals("Closed")) {
                JOptionPane.showMessageDialog(null, "This Questionnaire is closed");
            } else {
                controllerManager.answerQuestionnaireRequestData(data.getParticipantId(), keys.get(selectedRow));
            }

        }
    });
}
