package user_interface_layer.screens.study_data_log.study_data_log_panels;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_log.FetchStudyLogResponseModel;
import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screen_setters.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudyLogResearcherPanel extends JPanel {
    public StudyLogResearcherPanel(@NotNull FetchStudyLogResponseModel data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        String[] tableHeaders = {"ID", "Name"};
        SetTableModel setTableModel = new SetTableModel(tableHeaders);
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();

        List<Integer> keys = new ArrayList<>(data.getResearchers().keySet());
        List<String[]> values = new ArrayList<>(data.getResearchers().values());

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
                controllerManager.removeResearcherFromStudyRequest(researcherId, data.getStudyId(),data.getResearcherId());
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
                        controllerManager.fetchResearcher(researcherIdInt, data.getStudyId());
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
