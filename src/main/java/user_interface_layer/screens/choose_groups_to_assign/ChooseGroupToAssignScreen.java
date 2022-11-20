package user_interface_layer.screens.choose_groups_to_assign;

import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ChooseGroupToAssignScreen extends JFrame {
    List<JRadioButton> groupButtons = new ArrayList<>();

    public ChooseGroupToAssignScreen(ChooseGroupToAssignInputData data, ControllerManager controllerManager) {
        JPanel groupsPanel = new JPanel();
        groupsPanel.setLayout(new BoxLayout(groupsPanel, BoxLayout.Y_AXIS));
        for (String group : data.getGroupsToChoose()) {
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
            if (selectedGroups.size() == 0) {
                JOptionPane.showMessageDialog(null, "Please select at least one group");
            } else {
                controllerManager.assignQuestionnaireToGroups(data.getStudyID(), data.getQuestionnaireID(), selectedGroups);
            }});
    }
}
