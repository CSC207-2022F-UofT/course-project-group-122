package user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.researcher_request_participant_screen.ResearcherRequestParticipantInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the panel that displays the list of assigned questionnaires of a participant for a researcher
 */
public class AssignedQuestionnairePanelForResearcher extends JPanel {

    /**
     * Creates a panel that displays the list of assigned questionnaires of a participant for a researcher.
     * @param data The data needed to display the list of assigned questionnaires
     * @param controllerManager The controller manager that handles the actions of the buttons
     */
public AssignedQuestionnairePanelForResearcher(@NotNull ResearcherRequestParticipantInputData data, ControllerManager controllerManager) {
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
    JButton answerButton = new JButton("Answer Questionnaire");
    answerButton.addActionListener(e -> {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a questionnaire to answer");
        } else {
            if (model.getValueAt(selectedRow, 2).toString().equals("Closed")) {
                JOptionPane.showMessageDialog(null, "This Questionnaire is closed");
            } else {
                controllerManager.questionnaireRequestDataForAnswering(data.getUserId(), data.getParticipantId(),
                        data.getStudyId(), keys.get(selectedRow));
            }

        }
    });

    buttonsPanel.add(answerButton);

    }

}
