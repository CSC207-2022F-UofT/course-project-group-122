package user_interface_layer.screens.participant_home_screens.questionnaire_panels_for_participants;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataResponseModel;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class is the panel that displays the eligibility questionnaire for a participant
 */
public class EligibilityQuestionnairePanel extends JPanel {

    /**
     * Creates a panel that displays the eligibility questionnaire for a participant.
     * @param data The data needed to display the eligibility questionnaire
     * @param controllerManager The controller manager that handles the actions of the buttons
     */
    public EligibilityQuestionnairePanel(@NotNull FetchParticipantStudyDataResponseModel data , ControllerManager controllerManager) {
        super();
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(new String[]{"Questionnaire ID", "Questionnaire Name", "Questionnaire Status"});
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();
        model.addRow(data.getEligibilityQuestionnaireData());

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton answerButton = new JButton("Answer Eligibility Questionnaire");
        answerButton.addActionListener(e ->{

            String status = model.getValueAt(0, 2).toString();
            if (status.equals("Closed")) {
                JOptionPane.showMessageDialog(null, "This Questionnaire is closed");
            } else {
                int questionnaireId = Integer.parseInt(model.getValueAt(0, 0).toString());
                controllerManager.fetchConsentForm(data.getStudyId(), questionnaireId, data.getParticipantId());
            }

        });

        JButton checkAnswerButton = new JButton("Check Answers");
        checkAnswerButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to check answers");
            } else {
                int questionnaireID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
                controllerManager.checkQuestionnaireVersionedAnswer(data.getStudyId(), data.getParticipantId(),
                        questionnaireID, data.getEligibilityQuestionnaire(),
                        data.getEligibilityQuestionnaireAnswerHistory());
                }

        });

        JPanel buttonsPanel = new JPanel();

        buttonsPanel.add(answerButton);
        buttonsPanel.add(checkAnswerButton);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
