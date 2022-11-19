package user_interface_layer.screens.study_data_log.study_data_log_panels;

import user_interface_layer.SetTableModel;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.study_data_log.StudyDataLogInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudyLogParticipantsPanel extends JPanel {
    public StudyLogParticipantsPanel(StudyDataLogInputData data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(data.getUserTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();

        java.util.List<Integer> keys = new ArrayList<>(data.getParticipantsData().keySet());
        List<String[]> values = new ArrayList<>(data.getParticipantsData().values());

        for (String[] row : values) {
            model.addRow(row);
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        add(scrollPane, BorderLayout.CENTER);

        JButton check = new JButton("Check Participant");
        check.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a participant to check");
            } else {
                int participantId = keys.get(selectedRow);
                System.out.println(participantId);
                controllerManager.researcherRequestParticipantScreenRequest(data.getResearchId(),participantId,data.getStudyId());
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(check);
        add(buttonPanel, BorderLayout.SOUTH);

    }

}
