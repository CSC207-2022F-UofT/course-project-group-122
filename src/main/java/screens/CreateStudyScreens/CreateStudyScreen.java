package screens.CreateStudyScreens;

import screens.FailedScreenTemplate;
import screens.SetLabelTextPanel;
import screens.SetScreenToCenter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CreateStudyScreen extends JFrame {

    private CreateStudyInputData data;
    JTextField studyName = new JTextField(30);
    JTextArea studyDescription = new JTextArea(3, 20);
    JTextField studyTargetSize = new JTextField(10);
    String studyType = "";
    AtomicInteger count = new AtomicInteger();
    List<String> groupNames;

    public CreateStudyScreen(CreateStudyInputData data) {
        this.data = data;


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel studyNamePanel = new SetLabelTextPanel(new JLabel("Study Name: "), studyName);
        studyNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));


        JPanel studyDescriptionPanel = new JPanel(new BorderLayout());
        JLabel studyDescriptionLabel = new JLabel("Study Description: ", SwingConstants.CENTER);
        studyDescription.setLineWrap(true);
        JScrollPane studyDescriptionScrollPane = new JScrollPane(studyDescription);

        studyDescriptionPanel.add(studyDescriptionLabel, BorderLayout.NORTH);
        studyDescriptionPanel.add(studyDescriptionScrollPane, BorderLayout.CENTER);

        JPanel studyTargetSizePanel = new SetLabelTextPanel(new JLabel("Study Target Size: "), studyTargetSize);


        JPanel studyTypePanel = new JPanel();
        JLabel studyTypeLabel = new JLabel("Study Type: ", SwingConstants.CENTER);
        JButton randomizeButton = new JButton("Randomized");
        randomizeButton.addActionListener(e -> {
            studyType = "Randomized";
        });
        JButton generalButton = new JButton("General");
        generalButton.addActionListener(e -> {
            studyType = "General";
        });
        studyTypePanel.add(studyTypeLabel);
        studyTypePanel.add(randomizeButton);
        studyTypePanel.add(generalButton);


        JPanel numOfGroupsPanel = new JPanel();
        JLabel numOfGroupsLabel = new JLabel("Number of Groups: ");
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
        confirmNumOfGroupsButton.addActionListener(e -> {
            this.askGroupNamesScreen(count.get());
        });

        addRemoveButtons.add(addGroupButton);
        addRemoveButtons.add(removeGroupButton);
        addRemoveButtons.add(confirmNumOfGroupsButton);
        numOfGroupsPanel.add(numOfGroupsLabel);
        numOfGroupsPanel.add(labelCount);
        numOfGroupsPanel.add(addRemoveButtons);

        JPanel createStudyButtonPanel = new JPanel();
        JButton createStudyButton = new JButton("Create Study");
        createStudyButton.addActionListener(e -> {
            if (studyName.getText().equals("") || studyDescription.getText().equals("") || studyTargetSize.getText().equals("") || studyType.equals("") || groupNames == null) {
                new FailedScreenTemplate("Please fill in all fields");
            } else {
                try {
                    int sts = Integer.parseInt(studyTargetSize.getText());
                } catch (NumberFormatException nfe) {
                    FailedScreenTemplate failedScreenTemplate = new FailedScreenTemplate("Please enter a valid number for study target size.");
                    return;
                }
                data.getViewModel().createStudyController(data.getResearchID(), studyName.getText(),
                        studyDescription.getText(), Integer.parseInt(studyTargetSize.getText()), studyType,
                        count.get(), groupNames);

            }
        });
        createStudyButtonPanel.add(createStudyButton);


        JPanel screenPanel = new JPanel(new GridLayout(6, 1));
        screenPanel.add(studyNamePanel);
        screenPanel.add(studyDescriptionPanel);
        screenPanel.add(studyTargetSizePanel);
        screenPanel.add(studyTypePanel);
        screenPanel.add(numOfGroupsPanel);
        screenPanel.add(createStudyButtonPanel);

        add(screenPanel, BorderLayout.CENTER);

        pack();
        SetScreenToCenter s = new SetScreenToCenter(this);

    }

    private void askGroupNamesScreen(int i) {
        List<JTextField> groupNames = new ArrayList<>();
        JFrame askGroupNamesScreen = new JFrame();
        askGroupNamesScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        askGroupNamesScreen.setLayout(new BoxLayout(askGroupNamesScreen.getContentPane(), BoxLayout.Y_AXIS));
        if (studyType.equals("Randomized")) {
            askForRandomizedGroupNames(i, groupNames, askGroupNamesScreen);
        } else if (studyType.equals("General")) {
            askForGeneralGroupNames(i, groupNames, askGroupNamesScreen);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a study type");
            //FailedScreenTemplate failedScreenTemplate = new FailedScreenTemplate("Please select a study type");
        }
        askGroupNamesScreen.pack();
        SetScreenToCenter s = new SetScreenToCenter(askGroupNamesScreen);
    }

    private void askForGeneralGroupNames(int i, List<JTextField> groupNames, JFrame askGroupNamesScreen) {
        if (i > 0) {

            for (int j = 0; j < i; j++) {
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

    private void askForRandomizedGroupNames(int i, List<JTextField> groupNames, JFrame askGroupNamesScreen) {
        if (i > 1) {

            for (int j = 0; j < i; j++) {
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
            JOptionPane.showMessageDialog(null, "Please enter a number greater than 1 for a Randomized Study.");
        }
    }
}
