package user_interface_layer.screens.choose_groups_to_assign;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A screen that allows the user to choose the groups to assign.
 */
public class ChooseGroupToAssignScreen extends JFrame {
    /**
     * The radio buttons of groups that the user can choose from.
     */
    List<JRadioButton> groupButtons = new ArrayList<>();

    /**
     * @param targetGroups The groups that the user can choose from.
     * @param allStudyGroups The study groups that the user can choose from.
     * @param controllerManager The controller manager.
     * @param studyID The study ID.
     * @param questionnaireID The questionnaire ID.
     */
    public ChooseGroupToAssignScreen(@NotNull Map<Integer, String> targetGroups,
                                     @NotNull Map<Integer, String> allStudyGroups,
                                     ControllerManager controllerManager,
                                     int studyID, int questionnaireID) {
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
                controllerManager.assignQuestionnaireToGroups(studyID, questionnaireID, selectedGroups);
            }});
        add(labelTargetGroups, BorderLayout.NORTH);
        add(groupsPanel, BorderLayout.CENTER);
        add(assignButton, BorderLayout.SOUTH);
        pack();
        setVisible(true);

        setSize(600, 400);
        SetScreenToCenter.setCenter(this);
    }
}
