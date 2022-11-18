package UserInterfaceLayer.screens.StudyDataLog.StudyDataLogPanels;

import UserInterfaceLayer.SetTableModel;
import UserInterfaceLayer.screens.StudyDataLog.StudyDataLogInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudyLogParticipantsPanel extends JPanel {
    public StudyLogParticipantsPanel(StudyDataLogInputData data) {
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
                data.getControllerManager().researcherRequestParticipantScreenRequest(data.getResearchId(),participantId,data.getStudyId());
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(check);
        add(buttonPanel, BorderLayout.SOUTH);

    }

}
