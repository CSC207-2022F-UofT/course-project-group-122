package user_interface_layer.screens.choose_stratification_variable;

import use_cases.modify_study_parameters.ChooseStratificationInputData;
import user_interface_layer.ScreenManager;
import user_interface_layer.SetScreenToCenter;
import user_interface_layer.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ChooseStratificationScreen extends JFrame {
    /**
     * Constructs a new frame that is initially invisible.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     */
    public ChooseStratificationScreen(ChooseStratificationInputData data, ControllerManager controllerManager) throws HeadlessException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel label = new JLabel("Choose Stratification Variable", SwingConstants.CENTER);

        JScrollPane scrollPane = new JScrollPane();
        SetTableModel setTableModel = new SetTableModel(new String[]{"Variable Name"});
        JTable table = setTableModel.getTable();
        DefaultTableModel model = setTableModel.getModel();
        for (String i : data.getStratificationVariables()) {
            model.addRow(new String[]{i});
        }
        scrollPane.setViewportView(table);
        JButton button = new JButton("Select");
        button.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                controllerManager.setStratificationVariableRequest(data.getStudyId(), model.getValueAt(row, 0).toString());
                dispose();
            }
        });
        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        setSize(400, 400);
        SetScreenToCenter s = new SetScreenToCenter(this);
    }

    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");
        ChooseStratificationInputData data = new ChooseStratificationInputData(1, list);
        ChooseStratificationScreen screen = new ChooseStratificationScreen(data, new ControllerManager(new ScreenManager()));
        screen.setVisible(true);
    }
}
