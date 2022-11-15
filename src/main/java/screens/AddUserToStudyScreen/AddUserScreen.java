package screens.AddUserToStudyScreen;

import screens.SetScreenToCenter;
import screens.SetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddUserScreen extends JFrame {

    private AddUserInputData data;

    private JTable userTable;

    public AddUserScreen(AddUserInputData data) {
        this.data = data;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JScrollPane tableScrollPanel = new JScrollPane();
        this.userTable = new JTable();
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add " + data.getTypeOfUSer() + " to Study " + data.getStudyID());

        SetTableModel setTableModel = new SetTableModel(data.getUserTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        userTable = new JTable(model);
        userTable.setEnabled(false);
        for (String[] researcher : data.getUsers()) {
            model.addRow(researcher);
        }
        tableScrollPanel.setViewportView(userTable);
        getContentPane().add(tableScrollPanel, BorderLayout.CENTER);

        addButton.setText("Add " + data.getTypeOfUSer());
        buttonPanel.add(addButton);
        addButton.addActionListener(e -> {
                    int selectedRow = userTable.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Please select a " + data.getTypeOfUSer() + " to add");
                    } else {
                        String userID = userTable.getValueAt(selectedRow, 0).toString();
                        String userUsername = userTable.getValueAt(selectedRow, 1).toString();

                        data.getViewModel().addUserToStudyController(data.getStudyID(), userID, userUsername, data.getTypeOfUSer());
                        dispose();
                    }
                }
        );
        getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
        pack();
        int width = this.getWidth();
        int height = this.getHeight();
        SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this, width, height);

    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//
//        /* Create and display the form */
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                String[] researchersTableHeader = {"ID", "Username", "Name"};
//                List<String[]> researchers = new ArrayList<>(){
//                    {
//                        add(new String[]{"1", "username1", "name1"});
//                        add(new String[]{"2", "username2", "name2"});
//                        add(new String[]{"3", "username3", "name3"});
//                    }
//                };
//
//
//                AddResearcherInputData data = new AddResearcherInputData(researchers);
//                new AddResearcherScreen(data).setVisible(true);
//            }
//        });
//    }

    // End of variables declaration
}
