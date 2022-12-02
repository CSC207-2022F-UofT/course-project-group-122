package user_interface_layer.screens.create_study_inputs_screen;

import user_interface_layer.screen_helper_classes.SetLabelTextPanel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.GeneralFailureScreen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * The screen for creating a study.
 */
public class CreateStudyInputScreen extends JFrame {

    /**
     * The text field for the study type.
     */
    String studyTypeInput = "";
    /**
     * The list of group names for the study.
     */
    List<String> groupNames;

    /**
     * @param data The data to be passed to the next screen.
     * @param controllerManager The controller manager.
     */
    public CreateStudyInputScreen(CreateStudyInputInputData data, ControllerManager controllerManager) {
        super("Create Study Input Screen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField studyName = new JTextField(20);
        JPanel studyNameInputPanel = new SetLabelTextPanel(new JLabel("Study Name: ", SwingConstants.CENTER), studyName);
        studyNameInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextArea studyDescription = new JTextArea(3, 20);
        JPanel studyDescriptionPanel = new JPanel();
        studyDescriptionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel studyDescriptionLabel = new JLabel("Study Description: ", SwingConstants.CENTER);
        studyDescription.setLineWrap(true);
        JScrollPane studyDescriptionScrollPane = new JScrollPane(studyDescription);
        studyDescriptionPanel.add(studyDescriptionLabel);
        studyDescriptionPanel.add(studyDescriptionScrollPane);

        JTextField studyTargetSize = new JTextField(10);
        JPanel studyTargetSizePanel = new SetLabelTextPanel(new JLabel("Study Target Size: "), studyTargetSize);
        studyTargetSizePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel studyTypePanel = new JPanel();
        studyTypePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel studyTypeLabel = new JLabel("Study Type: ", SwingConstants.CENTER);
        JButton randomizeButton = new JButton("Randomized");
        randomizeButton.addActionListener(e -> this.studyTypeInput = "Randomized");
        JButton generalButton = new JButton("General");
        generalButton.addActionListener(e -> this.studyTypeInput = "General");
        studyTypePanel.add(studyTypeLabel);
        studyTypePanel.add(randomizeButton);
        studyTypePanel.add(generalButton);


        JPanel numOfGroupsPanel = new JPanel();
        numOfGroupsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel numOfGroupsLabel = new JLabel("Number of Groups: ");
        AtomicInteger count = new AtomicInteger();
        JPanel addRemoveButtons = new JPanel(new GridLayout(3, 1));
        JLabel labelCount = new JLabel(Integer.toString(count.get()));
        JButton addGroupButton = new JButton("+");
        addGroupButton.addActionListener(e -> {
            count.getAndIncrement();
            labelCount.setText(Integer.toString(count.get()));
        });
        JButton removeGroupButton = new JButton("-");
        removeGroupButton.addActionListener(e -> {
            if (count.get() > 0) {
                count.getAndDecrement();
                labelCount.setText(Integer.toString(count.get()));
            }
        });

        JButton confirmNumOfGroupsButton = new JButton("Confirm Groups");
        confirmNumOfGroupsButton.addActionListener(e -> this.askGroupNamesScreen(count.get()));

        addRemoveButtons.add(addGroupButton);
        addRemoveButtons.add(removeGroupButton);
        addRemoveButtons.add(confirmNumOfGroupsButton);
        numOfGroupsPanel.add(numOfGroupsLabel);
        numOfGroupsPanel.add(labelCount);
        numOfGroupsPanel.add(addRemoveButtons);

        JPanel createStudyButtonPanel = new JPanel();
        JButton createStudyButton = new JButton("Create Study");
        createStudyButton.addActionListener(e -> {
            if (studyName.getText().equals("")
                    || studyDescription.getText().equals("")
                    || studyTargetSize.getText().equals("")
                    || studyTypeInput.equals("") || groupNames == null) {
                new GeneralFailureScreen("Please fill out all fields");
            } else {
                try {
                    int sts = Integer.parseInt(studyTargetSize.getText());
                    String[] groupNamesArray = new String[groupNames.size()];
                    groupNamesArray = groupNames.toArray(groupNamesArray);
                    controllerManager.createStudyController(data.getResearcherID(), studyName.getText(),
                            studyDescription.getText(), sts, this.studyTypeInput,
                            count.get(), groupNamesArray);

                } catch (NumberFormatException nfe) {
                    new GeneralFailureScreen("Please enter a valid number for study target size");
                }
                dispose();
            }
        });
        createStudyButtonPanel.add(createStudyButton);


        JPanel screenPanel = new JPanel();
        screenPanel.setLayout(new BoxLayout(screenPanel, BoxLayout.Y_AXIS));
        screenPanel.add(studyNameInputPanel);
        screenPanel.add(studyDescriptionPanel);
        screenPanel.add(studyTargetSizePanel);
        screenPanel.add(studyTypePanel);
        screenPanel.add(numOfGroupsPanel);
        screenPanel.add(createStudyButtonPanel);

        add(screenPanel, BorderLayout.CENTER);
        pack();
        SetScreenToCenter.setCenter(this);
    }

    /**
     * @param numOfGroups The number of groups.
     */
    private void askGroupNamesScreen(int numOfGroups) {
        java.util.List<JTextField> groupNames = new ArrayList<>();
        JFrame askGroupNamesScreen = new JFrame();
        askGroupNamesScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        askGroupNamesScreen.setLayout(new BoxLayout(askGroupNamesScreen.getContentPane(), BoxLayout.Y_AXIS));
        if (studyTypeInput.equals("Randomized")) {
            askForRandomizedGroupNames(numOfGroups, groupNames, askGroupNamesScreen);
        } else if (studyTypeInput.equals("General")) {
            askForGeneralGroupNames(numOfGroups, groupNames, askGroupNamesScreen);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a study type");
        }
        askGroupNamesScreen.pack();
        SetScreenToCenter.setCenter(askGroupNamesScreen);
    }

    /**
     * The screen to confirm the group names for a general study.
     * @param numOfGroups The number of groups.
     * @param groupNames The list of group names.
     * @param askGroupNamesScreen The screen to ask for group names.
     */
    private void askForGeneralGroupNames(int numOfGroups, java.util.List<JTextField> groupNames, JFrame askGroupNamesScreen) {
        if (numOfGroups > 0) {

            for (int j = 0; j < numOfGroups; j++) {
                JTextField groupName = new JTextField("Group " + (j + 1), 30);
                groupNames.add(groupName);
                JPanel groupNamePanel = new SetLabelTextPanel(new JLabel("Group Name: "), groupName);
                askGroupNamesScreen.add(groupNamePanel);
            }
            JPanel confirmGroupNamesPanel = new JPanel();
            JButton confirmGroupNamesButton = new JButton("Confirm Group Names");
            confirmGroupNamesButton.addActionListener(e -> {
                this.groupNames = groupNames.stream().map(JTextField::getText).collect(Collectors.toList());
                for (String s : this.groupNames) {
                    System.out.println(s);
                }
                askGroupNamesScreen.dispose();

            });
            confirmGroupNamesPanel.add(confirmGroupNamesButton);
            askGroupNamesScreen.add(confirmGroupNamesPanel);
            askGroupNamesScreen.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a number greater than 0 for a General Study.");
        }
    }

    /**
     * The screen to confirm the group names for a randomized study.
     * @param numOfGroups The number of groups.
     * @param groupNames The list of group names.
     * @param askGroupNamesScreen The screen to ask for group names.
     */
    private void askForRandomizedGroupNames(int numOfGroups, List<JTextField> groupNames, JFrame askGroupNamesScreen) {
        if (numOfGroups > 1) {

            for (int j = 0; j < numOfGroups; j++) {
                JTextField groupName = new JTextField("Group " + (j + 1), 30);
                groupNames.add(groupName);
                JPanel groupNamePanel = new SetLabelTextPanel(new JLabel("Group Name: "), groupName);
                askGroupNamesScreen.add(groupNamePanel);
            }
            JPanel confirmGroupNamesPanel = new JPanel();
            JButton confirmGroupNamesButton = new JButton("Confirm Group Names");
            confirmGroupNamesButton.addActionListener(e -> {
                this.groupNames = groupNames.stream().map(JTextField::getText).collect(Collectors.toList());
                askGroupNamesScreen.dispose();
            });
            confirmGroupNamesPanel.add(confirmGroupNamesButton);
            askGroupNamesScreen.add(confirmGroupNamesPanel);
            askGroupNamesScreen.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null,
                    "Please enter a number greater than 1 for a Randomized Study.");
        }

    }
}


