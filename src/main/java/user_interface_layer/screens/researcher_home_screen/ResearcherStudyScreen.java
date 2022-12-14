package user_interface_layer.screens.researcher_home_screen;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the screen that displays the list of studies for a researcher
 */
public class ResearcherStudyScreen extends JFrame {

    /**
     * The table that contains the list of studies
     */
    private JTable studiesTable;

    /**
     * This is the constructor for the ResearcherStudyScreen class
     * @param data The data needed to display the list of studies
     * @param controllerManager The controller manager that handles the actions of the buttons
     */
    public ResearcherStudyScreen(@NotNull ResearcherStudyScreenInputData data, ControllerManager controllerManager) {

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
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
        framePanel.setLayout(new BorderLayout());
        headerPanel.setLayout(new GridLayout(2, 1));
        userPanel.setLayout(new FlowLayout(java.awt.FlowLayout.RIGHT));

        userLabel.setText(data.getResearcherName()+" ("+ data.getResearchID()+")");
        userPanel.add(userLabel);

        logOutButton.setText("Log Out");
        logOutButton.addActionListener(
                e-> controllerManager.userLogOutController());

        userPanel.add(logOutButton);
        headerPanel.add(userPanel);

        tableTitle.setHorizontalAlignment(SwingConstants.CENTER);
        tableTitle.setText("Studies");
        headerPanel.add(tableTitle);

        framePanel.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        SetTableModel setTableModel = new SetTableModel(data.getStudiesTableHeader());
        DefaultTableModel studiesTableModel = setTableModel.getModel();
        this.studiesTable = setTableModel.getTable();

        List<Integer> keys = new ArrayList<>(data.getListStudiesData().keySet());
        List<String []> values = new ArrayList<>(data.getListStudiesData().values());

        for (String[] i : values) {
            studiesTableModel.addRow(i);
        }

        studiesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(studiesTable);

        framePanel.add(jScrollPane1,BorderLayout.CENTER);


        selectStudyButton.setText("Select Study");
        selectStudyButton.addActionListener(
                e-> {
                    int selectedRow = studiesTable.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Please select a study to continue.");
                    } else {
                        controllerManager.requestResearcherStudyLog(keys.get(selectedRow), data.getResearchID());
                    }
                });
        southPanel.add(selectStudyButton);

        createStudyButton.setText("Create Study");
        createStudyButton.addActionListener(e -> controllerManager.requestCreateStudyModel(data.getResearchID()));

        JButton editStudyButton = new JButton("Edit Study");
        editStudyButton.addActionListener(e -> {
            int selectedRow = studiesTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a study to continue.");
            } else {
                controllerManager.editStudyDataRequest(keys.get(selectedRow), data.getResearchID());
            }
        });
        southPanel.add(editStudyButton);
        southPanel.add(createStudyButton);
        framePanel.add(southPanel, BorderLayout.PAGE_END);
        getContentPane().add(framePanel);
        pack();
        SetScreenToCenter.setCenter(this);
    }
}

