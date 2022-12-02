package user_interface_layer.screens.study_data_log.study_data_log_panels;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_log.FetchStudyLogResponseModel;
import user_interface_layer.screen_setters.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudyLogParticipantsPanel extends JPanel {
    public StudyLogParticipantsPanel(@NotNull FetchStudyLogResponseModel data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        String[] userTableHeader = {"ID", "Name", "Status"};
        SetTableModel setTableModel = new SetTableModel(userTableHeader);
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();

        java.util.List<Integer> keys = new ArrayList<>(data.getEnrolledParticipants().keySet());
        List<String[]> values = new ArrayList<>(data.getEnrolledParticipants().values());

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
                controllerManager.researcherRequestParticipantScreenRequest(data.getResearcherId(),participantId,data.getStudyId());
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(check);
        add(buttonPanel, BorderLayout.SOUTH);

    }

}
