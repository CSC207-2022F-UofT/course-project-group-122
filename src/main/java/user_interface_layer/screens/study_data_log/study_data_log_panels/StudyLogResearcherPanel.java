package user_interface_layer.screens.study_data_log.study_data_log_panels;

import user_interface_layer.SetScreenToCenter;
import user_interface_layer.SetTableModel;
import user_interface_layer.screens.study_data_log.StudyDataLogInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudyLogResearcherPanel extends JPanel {
    public StudyLogResearcherPanel(StudyDataLogInputData data) {
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(data.getUserTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();

        List<Integer> keys = new ArrayList<>(data.getResearchersData().keySet());
        List<String[]> values = new ArrayList<>(data.getResearchersData().values());

        for (String[] row : values) {
            model.addRow(row);
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton removeResearcherButton = new JButton("Remove Researcher");
        removeResearcherButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a researcher to remove");
            } else {
                int researcherId = keys.get(selectedRow);
                data.getControllerManager().removeResearcherFromStudyRequest(researcherId, data.getStudyId());
            }
        });

        buttonPanel.add(removeResearcherButton);

        JButton addResearcherButton = new JButton("Add Researcher");
        addResearcherButton.addActionListener(e-> {
                JFrame frame = new JFrame("Add Researcher");
                frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JLabel label = new JLabel("Enter researcher's Identifier", SwingConstants.CENTER);
                JTextField textField = new JTextField(10);
                JButton button = new JButton("Add");
                button.addActionListener(e1 -> {
                    String researcherId = textField.getText();
                    try {
                        int researcherIdInt = Integer.parseInt(researcherId);
                        data.getControllerManager().addResearcherToStudyRequest(researcherIdInt, data.getStudyId());
                        frame.dispose();
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid researcher identifier");
                    }
                });
                frame.add(label);
                frame.add(textField);
                frame.add(button);
                frame.pack();
                SetScreenToCenter s = new SetScreenToCenter(frame);
                frame.setVisible(true);
        });

        buttonPanel.add(addResearcherButton);

        add(buttonPanel, BorderLayout.PAGE_END);
    }
}
