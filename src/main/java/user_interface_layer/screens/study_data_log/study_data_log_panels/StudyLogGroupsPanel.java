package user_interface_layer.screens.study_data_log.study_data_log_panels;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_log.FetchStudyLogResponseModel;
import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screen_setters.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

public class StudyLogGroupsPanel extends JPanel {

    private static final String SIMPLE = "Simple";
    private static final String BLOCK = "Block";
    private static final String STRATIFIED = "Stratified";

    private static final String RANDOMIZATION = " Randomization";

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
                            SetScreenToCenter s = new SetScreenToCenter(frame);
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
