package screens.ResearcherHomeScreen;

import screens.SetScreenToCenter;
import screens.SetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ResearcherStudiesScreen extends JFrame {

    private ResearchersStudiesInputData data;
    private JTable studiesTable;



    public ResearcherStudiesScreen(ResearchersStudiesInputData data) {
        this.data = data;

        initComponents();
    }

    private void initComponents() {

        JPanel wholePanel = new JPanel();
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

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));

        wholePanel.setLayout(new BorderLayout());

        headerPanel.setLayout(new GridLayout(2, 1));

        userPanel.setBackground(new Color(204, 204, 204));
        userPanel.setLayout(new FlowLayout(java.awt.FlowLayout.RIGHT));

        //userLabel.setFont(new java.awt.Font("Avenir", 2, 14)); // NOI18N
        userLabel.setText("Researcher ID: "+ data.getResearchID());
        userPanel.add(userLabel);

        //logOutButton.setFont(new java.awt.Font("Avenir", 2, 12)); // NOI18N
        logOutButton.setText("Log Out");
        logOutButton.addActionListener(
                e-> {
                    data.getViewModel().getRegisterScreen().setVisible(true);
                    data.getViewModel().getUserHomeScreen().dispose();
                });

        userPanel.add(logOutButton);
        headerPanel.add(userPanel);

        tableTitle.setHorizontalAlignment(SwingConstants.CENTER);
        tableTitle.setText("Studies");
        headerPanel.add(tableTitle);

        wholePanel.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        SetTableModel setTableModel = new SetTableModel(data.getStudiesTableHeader());
        DefaultTableModel studiesTableModel = setTableModel.getModel();
        this.studiesTable = setTableModel.getTable();


        for (String[] i : data.getStudies()) {
            studiesTableModel.addRow(i);
        }

        studiesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(studiesTable);

        wholePanel.add(jScrollPane1,BorderLayout.CENTER);

        southPanel.setBackground(new Color(204, 204, 204));
        selectStudyButton.setText("Select Study");
        selectStudyButton.addActionListener(
                e-> {
                    int selectedRow = studiesTable.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Please select a study to continue.");
                    } else {
                        int studyID = Integer.parseInt((String) studiesTable.getValueAt(selectedRow, 0));
                        data.getViewModel().researcherHomeToStudyLogDriver(studyID, data.getResearchID());
                        data.getViewModel().getUserHomeScreen().setVisible(false);
                    }
                });
        southPanel.add(selectStudyButton);

        createStudyButton.setText("Create Study");
        createStudyButton.addActionListener(e -> {
            data.getViewModel().researcherHomeCreateStudyDriver(data.getResearchID());
        });
        southPanel.add(createStudyButton);

        wholePanel.add(southPanel, BorderLayout.PAGE_END);

        getContentPane().add(wholePanel);

        pack();

        SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);

    }

}

