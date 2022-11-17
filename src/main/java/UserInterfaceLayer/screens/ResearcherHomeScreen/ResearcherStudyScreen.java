package UserInterfaceLayer.screens.ResearcherHomeScreen;

import UserInterfaceLayer.SetScreenToCenter;
import UserInterfaceLayer.SetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ResearcherStudyScreen extends JFrame {

    private JTable studiesTable;

    public ResearcherStudyScreen(ResearcherStudyScreenInputData data) {

        // Initialize the elements of the screen.
        JPanel framePanel = new JPanel();
        JPanel headerPanel = new JPanel();
        JPanel userPanel = new JPanel();
        JLabel userLabel = new JLabel();
        JButton logOutButton = new JButton();
        JLabel tableTitle = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        studiesTable = new JTable();
        JPanel southPanel = new JPanel();
        JButton selectStudyButton = new JButton();
        JButton createStudyButton = new JButton();

        // Set the properties of the screen and elements.
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
        framePanel.setLayout(new BorderLayout());
        headerPanel.setLayout(new GridLayout(2, 1));
        userPanel.setBackground(new Color(204, 204, 204));
        userPanel.setLayout(new FlowLayout(java.awt.FlowLayout.RIGHT));

        userLabel.setText(data.getResearcherName()+" ("+ data.getResearchID()+")");
        userPanel.add(userLabel);

        logOutButton.setText("Log Out");
        logOutButton.addActionListener(
                e-> {
                    data.getController().userLogOutController();
                });

        userPanel.add(logOutButton);
        headerPanel.add(userPanel);

        tableTitle.setHorizontalAlignment(SwingConstants.CENTER);
        tableTitle.setText("Studies");
        headerPanel.add(tableTitle);

        framePanel.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        SetTableModel setTableModel = new SetTableModel(data.getStudiesTableHeader());
        DefaultTableModel studiesTableModel = setTableModel.getModel();
        this.studiesTable = setTableModel.getTable();


        for (String[] i : data.getListStudiesData()) {
            studiesTableModel.addRow(i);
        }

        studiesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(studiesTable);

        framePanel.add(jScrollPane1,BorderLayout.CENTER);

        southPanel.setBackground(new Color(204, 204, 204));
        selectStudyButton.setText("Select Study");
        selectStudyButton.addActionListener(
                e-> {
                    int selectedRow = studiesTable.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Please select a study to continue.");
                    } else {
                        data.getController().requestResearcherStudyLog(data.getListStudiesData().get(selectedRow), data.getResearchID());
                    }
                });
        southPanel.add(selectStudyButton);

        createStudyButton.setText("Create Study");
        createStudyButton.addActionListener(e -> {
            data.getController().requestCreateStudyModel(data.getResearchID());
        });
        southPanel.add(createStudyButton);
        framePanel.add(southPanel, BorderLayout.PAGE_END);
        getContentPane().add(framePanel);
        pack();
        SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);

    }

}
