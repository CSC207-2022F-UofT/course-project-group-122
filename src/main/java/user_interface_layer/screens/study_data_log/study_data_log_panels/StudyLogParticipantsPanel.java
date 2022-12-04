package user_interface_layer.screens.study_data_log.study_data_log_panels;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_log.FetchStudyLogResponseModel;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to display the participants of a study.
 */
public class StudyLogParticipantsPanel extends JPanel {
    /**
     * Creates the panel to display the participants of a study.
     * @param data The data to display.
     * @param controllerManager The controller manager.
     */
    public StudyLogParticipantsPanel(@NotNull FetchStudyLogResponseModel data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        String[] userTableHeader = {"ID", "Name", "Status", "Group"};
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
                controllerManager.researcherRequestParticipantScreenRequest(data.getResearcherId(),participantId);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(check);
        add(buttonPanel, BorderLayout.SOUTH);

    }

}
