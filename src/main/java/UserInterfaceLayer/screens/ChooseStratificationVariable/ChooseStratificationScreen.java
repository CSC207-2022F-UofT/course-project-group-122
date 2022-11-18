package UserInterfaceLayer.screens.ChooseStratificationVariable;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.SetScreenToCenter;
import UserInterfaceLayer.SetTableModel;
import UserInterfaceLayer.screens.ControllerManager;

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
    public ChooseStratificationScreen(ChooseStratificationInputData data) throws HeadlessException {
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
                data.getControllerManager().setStratificationVariableRequest(data.getStudyId(), model.getValueAt(row, 0).toString());
                dispose();
            }
        });
        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        pack();
        SetScreenToCenter s = new SetScreenToCenter(this);
    }

    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");
        ChooseStratificationInputData data = new ChooseStratificationInputData(1, list, new ControllerManager(new ScreenManager()));
        ChooseStratificationScreen screen = new ChooseStratificationScreen(data);
        screen.setVisible(true);
    }
}
