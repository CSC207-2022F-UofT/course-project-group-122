package user_interface_layer.screens.choose_stratification_variable;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * The screen that shows all the stratification variables.
 */
public class ChooseStratificationScreen extends JFrame {
    /**
     * Constructs a new frame that is initially invisible.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     */
    public ChooseStratificationScreen(int studyId, @NotNull List<String> stratificationVariables,
                                      ControllerManager controllerManager) throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JLabel label = new JLabel("Choose Stratification Variable", SwingConstants.CENTER);

        JScrollPane scrollPane = new JScrollPane();
        SetTableModel setTableModel = new SetTableModel(new String[]{"Variable Name"});
        JTable table = setTableModel.getTable();
        DefaultTableModel model = setTableModel.getModel();
        for (String i : stratificationVariables) {
            model.addRow(new String[]{i});
        }
        scrollPane.setViewportView(table);
        JButton button = new JButton("Select");
        button.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                controllerManager.setStratificationVariableRequest(studyId, model.getValueAt(row, 0).toString());
                dispose();
            }
        });
        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        setSize(400, 400);
        SetScreenToCenter.setCenter(this);
    }
}
