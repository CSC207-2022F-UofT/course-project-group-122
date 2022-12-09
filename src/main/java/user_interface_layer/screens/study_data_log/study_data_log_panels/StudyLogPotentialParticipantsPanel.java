package user_interface_layer.screens.study_data_log.study_data_log_panels;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_log.FetchStudyLogResponseModel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * This class is used to display the potential participants of a study.
 */
public class StudyLogPotentialParticipantsPanel extends JPanel {

    /**
     * Creates the panel to display the potential participants of a study.
     * @param data The data to display.
     * @param controllerManager The controller manager.
     */
    public StudyLogPotentialParticipantsPanel(@NotNull FetchStudyLogResponseModel data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        String[] potentialParticipantsTableHeader = {"ID", "Name", "Eligibility"};
        SetTableModel setTableModel = new SetTableModel(potentialParticipantsTableHeader);
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();

        java.util.List<Integer> keys = new ArrayList<>(data.getPotentialParticipants().keySet());
        List<String[]> values = new ArrayList<>(data.getPotentialParticipants().values());
        for (String[] row : values) {
            model.addRow(row);
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        add(scrollPane, BorderLayout.CENTER);

        JButton addParticipantButton = new JButton("Add Potential Participant");
        addParticipantButton.addActionListener(e -> {
            JFrame frame = new JFrame("Add Potential Participant");
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            JLabel label = new JLabel("Enter potential participant's Identifier", SwingConstants.CENTER);
            JTextField textField = new JTextField(10);
            JButton button = new JButton("Add");
            button.addActionListener(e1 -> {
                String participantId = textField.getText().trim();
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
            SetScreenToCenter.setCenter(frame);
            frame.setVisible(true);
        });

        JButton makeEligibleParticipantButton = new JButton("Make Eligible");
        makeEligibleParticipantButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a potential participant to make eligible");
            } else {
                int participantId = keys.get(selectedRow);
                controllerManager.makeParticipantEligibleRequest(participantId, data.getStudyId(), data.getResearcherId());
            }
        });

        JButton enrollParticipantButton = new JButton("Enroll Participant");
        enrollParticipantButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a potential participant to enroll");
            } else {
               enrollParticipant(data, controllerManager,table, selectedRow);
            }
        });

        JButton check = new JButton("Check Potential Participant");
        check.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a potential participant to check");
            } else {
                int participantId = keys.get(selectedRow);
                controllerManager.researcherRequestParticipantScreenRequest(data.getResearcherId(), participantId);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addParticipantButton);
        buttonPanel.add(makeEligibleParticipantButton);
        buttonPanel.add(check);
        buttonPanel.add(enrollParticipantButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private static void enrollParticipant(@NotNull FetchStudyLogResponseModel data, ControllerManager controllerManager, JTable table, int selectedRow) {
        if (data.getStudyType().equals("Randomized")) {
            int participantId = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
            controllerManager.enrollRandomizedParticipantRequest(participantId, data.getStudyId(), data.getResearcherId());
        } else {
            JFrame chooseGroupsFrame = new JFrame("Enroll Participant");
            JPanel chooseGroupsPanel = new JPanel();
            chooseGroupsPanel.setLayout(new BoxLayout(chooseGroupsPanel, BoxLayout.Y_AXIS));
            ButtonGroup buttonGroup = new ButtonGroup();
            for (String group : data.getGroupAssignments()) {
                JRadioButton radioButton = new JRadioButton(group);
                buttonGroup.add(radioButton);
                chooseGroupsPanel.add(radioButton);
            }
            JButton enrollButton = new JButton("Enroll");
            enrollButton.addActionListener(evn -> {
                String selectedGroup = "";
                for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        selectedGroup = button.getText().split(":")[0];
                    }
                }
                if (selectedGroup.equals("")){
                    JOptionPane.showMessageDialog(null, "Please select a group to enroll the participant in");
                } else {
                    int participantId = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
                    int selectedGroupNum = Integer.parseInt(selectedGroup);
                    controllerManager.enrollGeneralParticipantRequest(participantId, data.getStudyId(),
                            selectedGroupNum, data.getResearcherId());
                    chooseGroupsFrame.dispose();
                }

            });
            chooseGroupsPanel.add(enrollButton);
            chooseGroupsFrame.add(chooseGroupsPanel);
            chooseGroupsFrame.pack();
            SetScreenToCenter.setCenter(chooseGroupsFrame);
            chooseGroupsFrame.setVisible(true);
        }
    }

}
