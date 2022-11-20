package user_interface_layer.screens.study_data_log.study_data_log_panels;

import user_interface_layer.SetScreenToCenter;
import user_interface_layer.SetTableModel;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.study_data_log.StudyDataLogInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudyLogPotentialParticipantsPanel extends JPanel {

    public StudyLogPotentialParticipantsPanel(StudyDataLogInputData data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(data.getPotentialParticipantsTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();

        java.util.List<Integer> keys = new ArrayList<>(data.getPotentialsData().keySet());
        List<String[]> values = new ArrayList<>(data.getPotentialsData().values());

        for (String[] row : values) {
            model.addRow(row);
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        add(scrollPane, BorderLayout.CENTER);

        JButton addParticipantButton = new JButton("Add Potential Participant");
        addParticipantButton.addActionListener(e -> {
            JFrame frame = new JFrame("Add Potential Participant");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            JLabel label = new JLabel("Enter potential participant's Identifier", SwingConstants.CENTER);
            JTextField textField = new JTextField(10);
            JButton button = new JButton("Add");
            button.addActionListener(e1 -> {
                String participantId = textField.getText();
                try {
                    int participantIdInt = Integer.parseInt(participantId);
                    controllerManager.fetchParticipant(participantIdInt, data.getStudyId());
                    frame.dispose();
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }
            });
            frame.add(label);
            frame.add(textField);
            frame.add(button);
            frame.pack();
            SetScreenToCenter s = new SetScreenToCenter(frame);
            frame.setVisible(true);
        });

        JButton makeEligibleParticipantButton = new JButton("Make Eligible");
        makeEligibleParticipantButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a potential participant to make eligible");
            } else {
                int participantId = keys.get(selectedRow);
                controllerManager.makeParticipantEligibleRequest(participantId, data.getStudyId());
            }
        });

        JButton enrollParticipantButton = new JButton("Enroll Participant");
        enrollParticipantButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a potential participant to enroll");
            } else {
                int participantId = keys.get(selectedRow);
                controllerManager.enrollParticipantRequest(participantId, data.getStudyId());
            }
        });

        JButton Check = new JButton("Check Potential Participant");
        Check.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a potential participant to check");
            } else {
                int participantId = keys.get(selectedRow);
                controllerManager.researcherRequestParticipantScreenRequest(data.getResearchId(), participantId, data.getStudyId());
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addParticipantButton);
        buttonPanel.add(makeEligibleParticipantButton);
        buttonPanel.add(Check);
        buttonPanel.add(enrollParticipantButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

}
