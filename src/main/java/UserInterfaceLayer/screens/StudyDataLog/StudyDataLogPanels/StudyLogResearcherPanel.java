package UserInterfaceLayer.screens.StudyDataLog.StudyDataLogPanels;

import UserInterfaceLayer.SetTableModel;
import UserInterfaceLayer.screens.StudyDataLog.StudyDataLogInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudyLogResearcherPanel extends JPanel {
    public StudyLogResearcherPanel(StudyDataLogInputData data) {
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(data.getUserTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();

        for (String[] row : data.getResearchers()) {
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
                int researcherId = Integer.parseInt((String) model.getValueAt(selectedRow, 0));
                data.getControllerManager().removeResearcherFromStudyRequest(researcherId, data.getStudyID());
            }
        });

        buttonPanel.add(removeResearcherButton);

        JButton addResearcherButton = new JButton("Add Researcher");
        addResearcherButton.addActionListener(e-> {
                data.getControllerManager().addResearcherToStudyRequest(data.getStudyID());

        });

        buttonPanel.add(addResearcherButton);

        add(buttonPanel, BorderLayout.PAGE_END);
    }
}
