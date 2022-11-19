package user_interface_layer.screens.participant_home_screens.questionnaire_panels_for_participants;

import user_interface_layer.SetTableModel;
import user_interface_layer.screens.participant_home_screens.ParticipantHomeScreenInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EligibilityQuestionnairePanel extends JPanel {

    public EligibilityQuestionnairePanel(ParticipantHomeScreenInputData data) {
        super();
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(data.getQuestionnairesTableHeader());
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
                data.getControllerManager().answerEligibilityQuestionnaireRequestData(data.getParticipantId(),questionnaireId);
            }

        });

        JButton checkAnswerButton = new JButton("Check Answers");
        checkAnswerButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to check answers");
            } else {
                int questionnaireID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
                data.getControllerManager().checkQuestionnaireVersionedAnswer(data.getStudyId(), data.getParticipantId(),
                        questionnaireID,
                        data.getEligibilityQuestionnaireAnswerHistory());
                }

        });

        JPanel buttonsPanel = new JPanel();

        buttonsPanel.add(answerButton);
        buttonsPanel.add(checkAnswerButton);
        add(buttonsPanel, BorderLayout.SOUTH);

    }
}
