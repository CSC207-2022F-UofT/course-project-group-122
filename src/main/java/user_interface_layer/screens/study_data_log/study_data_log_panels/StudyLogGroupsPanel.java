package user_interface_layer.screens.study_data_log.study_data_log_panels;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_log.FetchStudyLogResponseModel;
import use_cases.participant_enroller.BlockRandomGroupGenerator;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used to display the groups of a study.
 */
public class StudyLogGroupsPanel extends JPanel {

    /**
     * The constant string for the Simple strategy
     */
    private static final String SIMPLE = "Simple";
    /**
     * The constant string for the Block strategy
     */
    private static final String BLOCK = "Block";
    /**
     *  The constant string for the stratified strategy
     */
    private static final String STRATIFIED = "Stratified";

    /**
     * The constant string for the random type
     */
    private static final String RANDOMIZATION = " Randomization";

    /**
     * Creates the panel to display the groups of a study.
     * @param data The data to display.
     * @param controllerManager The controller manager.
     */
    public StudyLogGroupsPanel(@NotNull FetchStudyLogResponseModel data, ControllerManager controllerManager) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(data.getStudyType() + " Groups", SwingConstants.CENTER);
        add(label);
        SetTableModel setTableModel = new SetTableModel(new String[]{"Group Name"});
        JTable table = setTableModel.getTable();
        JScrollPane scrollPane = new JScrollPane();
        for (String group : data.getGroupAssignments()) {
            setTableModel.getModel().addRow(new String[]{group});
        }
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(table);

        if (data.getStudyType().equals("Randomized")) {
            JPanel randomizationPanel = new JPanel();
            randomizationPanel.setLayout(new BoxLayout(randomizationPanel, BoxLayout.Y_AXIS));
            JLabel randomizationLabel = new JLabel("Randomization Method: " + data.getRandomizationMethod() +
                    RANDOMIZATION, SwingConstants.CENTER);
            randomizationPanel.add(randomizationLabel);
            if (data.getRandomizationMethod().equals(BLOCK)) {
                JLabel blockLabel = new JLabel("Block Size: " + BlockRandomGroupGenerator.BLOCKSIZEFACTOR,
                        SwingConstants.CENTER);
                randomizationPanel.add(blockLabel);
            } else if (data.getRandomizationMethod().equals(STRATIFIED)) {
                JLabel stratifiedLabel = new JLabel("Stratification Factor: " + data.getStratificationMethod(),
                        SwingConstants.CENTER);
                JLabel stratifiedLabel2 = new JLabel("Block randomization within each stratum with block size = "
                        + BlockRandomGroupGenerator.BLOCKSIZEFACTOR, SwingConstants.CENTER);
                randomizationPanel.add(stratifiedLabel);
                randomizationPanel.add(stratifiedLabel2);
            }
            add(randomizationPanel);
        }

        JPanel buttonPanel = new JPanel();
        if (data.getStudyType().equals("Randomized")) {
            JButton selectStrategy = new JButton("Select Randomized Strategy");
            selectStrategy.addActionListener(
                    e -> {
                        if (data.getEnrolledParticipants().isEmpty()) {
                            JFrame frame = new JFrame();
                            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
                            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                            JRadioButton simple = new JRadioButton(SIMPLE + RANDOMIZATION);
                                JRadioButton block = new JRadioButton(BLOCK + RANDOMIZATION);
                            JRadioButton stratified = new JRadioButton(STRATIFIED + RANDOMIZATION);
                            ButtonGroup group = new ButtonGroup();
                            group.add(simple);
                            group.add(block);
                            group.add(stratified);
                            frame.add(simple);
                            frame.add(block);
                            frame.add(stratified);
                            JButton button = new JButton("Select");
                            button.addActionListener(e1 -> {
                                if (simple.isSelected()) {
                                    controllerManager.setRandomizationStrategyRequest(data.getStudyId(),
                                            SIMPLE, data.getResearcherId());
                                } else if (block.isSelected()) {
                                    controllerManager.setRandomizationStrategyRequest(data.getStudyId(),
                                            BLOCK, data.getResearcherId());
                                } else if (stratified.isSelected()) {
                                    controllerManager.setRandomizationStrategyRequest(data.getStudyId(),
                                            STRATIFIED, data.getResearcherId());
                                }
                                frame.dispose();
                            });
                            frame.add(button);
                            frame.pack();
                            SetScreenToCenter.setCenter(frame);
                            frame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "You can't change the strategy " +
                                    "after adding participants");
                        }
                    }

            );
            buttonPanel.add(selectStrategy);

            if (data.getRandomizationMethod().equals(STRATIFIED)) {
                JButton stratify = new JButton("Select Stratification Criteria");
                stratify.addActionListener(e -> controllerManager.fetchStratificationVariables(data.getStudyId()));
                buttonPanel.add(stratify);
            }
        }
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
