package user_interface_layer.screens.choose_groups_to_assign;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChooseGroupToAssignScreen extends JFrame {
    List<JRadioButton> groupButtons = new ArrayList<>();

    public ChooseGroupToAssignScreen(@NotNull Map<Integer, String> targetGroups, @NotNull Map<Integer, String> allStudyGroups,
                                     ControllerManager controllerManager, int studyID, int questionnaireID) {
        StringBuilder targets = new StringBuilder();
        for (Map.Entry<Integer, String> entry : targetGroups.entrySet()) {
            targets.append("Group ").append(entry.getKey()).append(": ").append(entry.getValue()).append("; ");
        }

        JLabel labelTargetGroups = new JLabel(targets.toString());
        JPanel groupsPanel = new JPanel();
        groupsPanel.setLayout(new BoxLayout(groupsPanel, BoxLayout.Y_AXIS));
        for (String group : allStudyGroups.values()) {
            JRadioButton radioButton = new JRadioButton(group);
            groupButtons.add(radioButton);
            groupsPanel.add(radioButton);
        }
        JButton assignButton = new JButton("Assign");
        assignButton.addActionListener(e -> {
            List<String> selectedGroups = new ArrayList<>();
            for (JRadioButton button : groupButtons) {
                if (button.isSelected()) {
                    selectedGroups.add(button.getText());
                }
            }
            if (selectedGroups.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select at least one group");
            } else {
//                controllerManager.assignQuestionnaireToGroups(studyID, questionnaireID, selectedGroups);
            }});
    }
}
