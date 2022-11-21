package user_interface_layer.screens.study_data_log.study_data_log_panels;

import user_interface_layer.SetScreenToCenter;
import user_interface_layer.SetTableModel;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.study_data_log.StudyDataLogInputData;

import javax.swing.*;
import java.awt.*;

public class StudyLogGroupsPanel extends JPanel {
    public StudyLogGroupsPanel(StudyDataLogInputData data, ControllerManager controllerManager) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(data.getStudyType() + " Groups", SwingConstants.CENTER);
        add(label);
        SetTableModel setTableModel = new SetTableModel(new String[]{"Group Name"});
        JTable table = setTableModel.getTable();
        JScrollPane scrollPane = new JScrollPane();
        for (String group : data.getGroups()) {
            setTableModel.getModel().addRow(new String[]{group});
        }
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(table);
        JPanel buttonPanel = new JPanel();
        if (data.getStudyType().equals("Randomized")) {
            JButton selectStrategy = new JButton("Select Randomized Strategy");
            selectStrategy.addActionListener(
                    e -> {
                        if (data.isStudyEmpty()) {
                            JFrame frame = new JFrame();
                            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            JRadioButton item = new JRadioButton("Simple Randomization");
                            JRadioButton item2 = new JRadioButton("Block Randomization");
                            JRadioButton item3 = new JRadioButton("Stratified Randomization");
                            ButtonGroup group = new ButtonGroup();
                            group.add(item);
                            group.add(item2);
                            group.add(item3);
                            frame.add(item);
                            frame.add(item2);
                            frame.add(item3);
                            JButton button = new JButton("Select");
                            button.addActionListener(e1 -> {
                                if (item.isSelected()) {
                                    controllerManager.setRandomizationStrategyRequest(data.getStudyId(), "Simple");
                                } else if (item2.isSelected()) {
                                    controllerManager.setRandomizationStrategyRequest(data.getStudyId(), "Block");
                                } else if (item3.isSelected()) {
                                    controllerManager.setRandomizationStrategyRequest(data.getStudyId(), "Stratified");
                                }
                                frame.dispose();
                            });
                            frame.add(button);
                            frame.pack();
                            SetScreenToCenter s = new SetScreenToCenter(frame);
                            frame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "You can't change the strategy after adding participants");
                        }
                    }

            );
            buttonPanel.add(selectStrategy);
        }
        add(buttonPanel, BorderLayout.SOUTH);

    }


}