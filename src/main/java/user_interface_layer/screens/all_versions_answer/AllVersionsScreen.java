package user_interface_layer.screens.all_versions_answer;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * The screen that shows all the versions of an answer.
 */
public class AllVersionsScreen extends JFrame {
    /**
     * @param data The data needed to display the screen.
     * @param controllerManager The controller manager.
     */
    public AllVersionsScreen(@NotNull AllVersionsInputData data, ControllerManager controllerManager) {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Questionnaire Versioned Answers");

        SetTableModel setTableModel = new SetTableModel(data.getAnswerTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();
        for (String[] answerData : data.getAnswer()) {
            model.addRow(answerData);
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        
        JButton selectAnswerButton = new JButton("Check Answer");
        selectAnswerButton.addActionListener(e->{
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select an answer to check.");
            } else {
                int answerID = data.getAnswerId();
                int version = Integer.parseInt((String) model.getValueAt(selectedRow, 1));
                controllerManager.fetchVersionedAnswer(data.getStudyId(),data.getParticipantID(),data.getQuestionnaireID(),answerID,version);
            }
        });
        add(scrollPane, BorderLayout.CENTER);
        add(selectAnswerButton, BorderLayout.SOUTH);
        pack();

        SetScreenToCenter.setCenter(this);
    }

}
