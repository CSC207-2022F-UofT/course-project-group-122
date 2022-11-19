package screens.EnrollPotentialParticipantScreen;

import screens.SetScreenToCenter;
import screens.SetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EnrollPotentialParticipantScreen extends JFrame {
    private EnrollPotentialParticipantInputData data;

    private JTable potentialsTable;

    public EnrollPotentialParticipantScreen(EnrollPotentialParticipantInputData data) {
        this.data = data;

        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Enroll Potential Participants to Study " + data.getStudyID());
        SetTableModel setTableModel = new SetTableModel(data.getPotentialsTableHeader());
        DefaultTableModel tableModel = setTableModel.getModel();
        potentialsTable = new JTable(tableModel);
        potentialsTable.setEnabled(false);
        for (String[] potentialParticipant : data.getPotentialParticipants()) {
            tableModel.addRow(potentialParticipant);
        }

        JScrollPane tableScrollPanel = new JScrollPane(potentialsTable);
        add(tableScrollPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton checkEligibilityButton = new JButton("Check Eligibility");
        buttonPanel.add(checkEligibilityButton);
        checkEligibilityButton.addActionListener(e -> {
            int selectedRow = potentialsTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a potential participant to check eligibility");
            } else {
                String potentialParticipantID = potentialsTable.getValueAt(selectedRow, 0).toString();

                data.getViewModel().checkEligibilityQuestionnaireDataRequest(data.getStudyID(), potentialParticipantID);
            }
        });

        JButton enrollButton = new JButton("Enroll");
        buttonPanel.add(enrollButton);
        enrollButton.addActionListener(e -> {
            int selectedRow = potentialsTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a potential participant to enroll");
            } else {
                String potentialParticipantID = potentialsTable.getValueAt(selectedRow, 0).toString();

                data.getViewModel().enrollPotentialParticipantController(data.getStudyID(), potentialParticipantID);
                dispose();
            }
        });

        buttonPanel.add(checkEligibilityButton);
        buttonPanel.add(enrollButton);
        add(buttonPanel, BorderLayout.PAGE_END);

        pack();
        SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);
    }

}
