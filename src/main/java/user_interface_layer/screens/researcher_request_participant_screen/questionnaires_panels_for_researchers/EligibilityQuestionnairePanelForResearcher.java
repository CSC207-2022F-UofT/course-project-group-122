package user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers;

import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.researcher_request_participant_screen.ResearcherRequestParticipantInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * This class is the panel that displays the eligibility questionnaire of a participant for a researcher
 */
public class EligibilityQuestionnairePanelForResearcher extends JPanel {

    /**
     * Creates a panel that displays the eligibility questionnaire of a participant for a researcher.
     * @param data The data needed to display the eligibility questionnaire
     * @param controllerManager The controller manager that handles the actions of the buttons
     */
    public EligibilityQuestionnairePanelForResearcher(ResearcherRequestParticipantInputData data, ControllerManager controllerManager) {
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
                    controllerManager.checkQuestionnaireVersionedAnswer(data.getStudyId(), data.getParticipantId(), questionnaireID, data.getEligibilityQuestionnaireAnswerHistory());
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(checkAnswerButton);
        add(buttonsPanel, BorderLayout.SOUTH);

    }
}
