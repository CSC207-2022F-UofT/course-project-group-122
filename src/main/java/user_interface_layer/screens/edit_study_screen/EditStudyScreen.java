package user_interface_layer.screens.edit_study_screen;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_data_for_editing.FetchStudyDataForEditingResponseModel;
import use_cases.modify_study_parameters.ModifyStudyParameterRequestModel;
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
 * The screen for editing a study.
 */
public class EditStudyScreen extends JFrame {
    /**
     * The list of group names for the study.
     */
    private List<String> groupNames;

    /**
     * Creates the screen for editing a study.
     * @param data The data needed to display the screen.
     * @param controllerManager The controller manager.
     */
    public EditStudyScreen(@NotNull FetchStudyDataForEditingResponseModel data, ControllerManager controllerManager) {
        super("Edit Study Input Screen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField studyName = new JTextField(data.getStudyName(),20);
        JPanel studyNameInputPanel = new SetLabelTextPanel(new JLabel("Study Name: ", SwingConstants.CENTER), studyName);
        studyNameInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextArea studyDescription = new JTextArea(3, 20);
        JPanel studyDescriptionPanel = new JPanel();
        studyDescriptionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel studyDescriptionLabel = new JLabel("Study Description: ", SwingConstants.CENTER);
        studyDescription.setText(data.getStudyDescription());
        studyDescription.setLineWrap(true);
        JScrollPane studyDescriptionScrollPane = new JScrollPane(studyDescription);
        studyDescriptionPanel.add(studyDescriptionLabel);
        studyDescriptionPanel.add(studyDescriptionScrollPane);

        JTextField studyTargetSize = new JTextField( Integer.toString(data.getTargetSize()),10);
        JPanel studyTargetSizePanel = new SetLabelTextPanel(new JLabel("Study Target Size: "), studyTargetSize);
        studyTargetSizePanel.setLayout(new FlowLayout(FlowLayout.LEFT));


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
        confirmNumOfGroupsButton.addActionListener(e -> this.askGroupNamesScreen(count.get(), data.getStudyType()));

        addRemoveButtons.add(addGroupButton);
        addRemoveButtons.add(removeGroupButton);
        addRemoveButtons.add(confirmNumOfGroupsButton);
        numOfGroupsPanel.add(numOfGroupsLabel);
        numOfGroupsPanel.add(labelCount);
        numOfGroupsPanel.add(addRemoveButtons);

        JPanel createStudyButtonPanel = new JPanel();
        JButton createStudyButton = new JButton("Edit Study");
        createStudyButton.addActionListener(e -> {
            if (studyName.getText().equals("") || studyDescription.getText().equals("") ||
                    studyTargetSize.getText().equals("") || groupNames == null) {
                new GeneralFailureScreen("Please fill out all fields");
            } else {
                try {
                    int sts = Integer.parseInt(studyTargetSize.getText());
                    ModifyStudyParameterRequestModel requestModel = new ModifyStudyParameterRequestModel(
                            data.getStudyID(), studyName.getText(), studyDescription.getText());
                    requestModel.setStudyTargetSize(sts);
                    requestModel.setGroupNames(groupNames.toArray(new String[count.get()]));
                    requestModel.setNumGroups(count.get());
                    controllerManager.modifyStudyParameters(requestModel);
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
        screenPanel.add(numOfGroupsPanel);
        screenPanel.add(createStudyButtonPanel);

        add(screenPanel, BorderLayout.CENTER);

        pack();
        SetScreenToCenter.setCenter(this);

    }

    /**
     * @param numOfGroups The number of groups for the study.
     * @param studyType The type of study.
     */
    private void askGroupNamesScreen(int numOfGroups, @NotNull String studyType) {
        List<JTextField> groupNames = new ArrayList<>();
        JFrame askGroupNamesScreen = new JFrame();
        askGroupNamesScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        askGroupNamesScreen.setLayout(new BoxLayout(askGroupNamesScreen.getContentPane(), BoxLayout.Y_AXIS));
        if (studyType.equals("Randomized")) {
            askForRandomizedGroupNames(numOfGroups, groupNames, askGroupNamesScreen);
        } else if (studyType.equals("General")) {
            askForGeneralGroupNames(numOfGroups, groupNames, askGroupNamesScreen);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a study type");
        }
        askGroupNamesScreen.pack();
        SetScreenToCenter.setCenter(askGroupNamesScreen);
    }

    /**
     * @param numOfGroups The number of groups for the study.
     * @param groupNames The list of group names.
     * @param askGroupNamesScreen The screen for asking for group names.
     */
    private void askForGeneralGroupNames(int numOfGroups, List<JTextField> groupNames, JFrame askGroupNamesScreen) {
        if (numOfGroups > 0) {

            getGroupNames(numOfGroups, groupNames, askGroupNamesScreen);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Please enter a number greater than 0 for a General Study.");
        }
    }

    /**
     * @param numOfGroups The number of groups for the study.
     * @param groupNames The list of group names.
     * @param askGroupNamesScreen The screen for asking for group names.
     */
    private void askForRandomizedGroupNames(int numOfGroups, List<JTextField> groupNames, JFrame askGroupNamesScreen) {
        if (numOfGroups > 1) {

            getGroupNames(numOfGroups, groupNames, askGroupNamesScreen);

        } else {
            JOptionPane.showMessageDialog(null,
                    "Please enter a number greater than 1 for a Randomized Study.");
        }

    }

    /**
     * @param numOfGroups The number of groups for the study.
     * @param groupNames The list of group names.
     * @param askGroupNamesScreen The screen for asking for group names.
     */
    private void getGroupNames(int numOfGroups, List<JTextField> groupNames, JFrame askGroupNamesScreen) {
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
    }

}
