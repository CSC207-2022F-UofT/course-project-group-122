package user_interface_layer.screens.participant_home_screens.questionnaire_panels_for_participants;

import use_cases.fetch_participant_study_data.FetchParticipantStudyDataResponseModel;
import user_interface_layer.screen_setters.SetTableModel;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.participant_home_screens.ParticipantHomeScreenInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompletedQuestionnairePanel extends JPanel {

    public CompletedQuestionnairePanel(FetchParticipantStudyDataResponseModel data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(new String[]{"Questionnaire ID", "Questionnaire Name", "Questionnaire Status"});
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
                int questionnaireId = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
                int questionnaireID = keys.get(selectedRow);
                for (Map.Entry<Integer, List<String[]>> entry : data.getCompletedQuestionnaireAnswerHistory().entrySet()) {
                    System.out.println(entry.getKey());

                }
                controllerManager.checkQuestionnaireVersionedAnswer(data.getStudyId(), data.getParticipantId(),
                        questionnaireId, data.getCompletedQuestionnaireAnswerHistory().get(questionnaireId));
                System.out.println(data.getCompletedQuestionnaireAnswerHistory().size());
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(checkAnswerButton);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
