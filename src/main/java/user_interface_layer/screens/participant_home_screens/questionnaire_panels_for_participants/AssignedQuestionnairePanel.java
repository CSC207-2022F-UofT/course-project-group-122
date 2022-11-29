package user_interface_layer.screens.participant_home_screens.questionnaire_panels_for_participants;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataResponseModel;
import user_interface_layer.screen_setters.SetTableModel;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.participant_home_screens.ParticipantHomeScreenInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AssignedQuestionnairePanel extends JPanel {

public AssignedQuestionnairePanel(@NotNull FetchParticipantStudyDataResponseModel data, ControllerManager controllerManager) {
    setLayout(new BorderLayout());
    SetTableModel setTableModel = new SetTableModel(new String[]{"Questionnaire ID", "Questionnaire Name", "Questionnaire Status"});
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

    JButton answerButton = new JButton("Answer Questionnaire");
    answerButton.addActionListener(e -> {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a questionnaire to answer");
        } else {
            if (model.getValueAt(selectedRow, 2).toString().equals("Closed")) {
                JOptionPane.showMessageDialog(null, "This Questionnaire is closed");
            } else {
                controllerManager.questionnaireRequestDataForAnswering(data.getParticipantId(), data.getParticipantId(),
                        data.getStudyId(), keys.get(selectedRow));
            }

        }
    });
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(answerButton);
    add(buttonsPanel, BorderLayout.SOUTH);
    }
}
