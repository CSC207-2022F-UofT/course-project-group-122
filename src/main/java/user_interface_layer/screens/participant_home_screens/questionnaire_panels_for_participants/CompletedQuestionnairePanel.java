package user_interface_layer.screens.participant_home_screens.questionnaire_panels_for_participants;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataResponseModel;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the panel that displays the list of completed questionnaires for a participant
 */
public class CompletedQuestionnairePanel extends JPanel {

    /**
     * Creates a panel that displays the list of completed questionnaires for a participant.
     * @param data The data needed to display the list of completed questionnaires.
     * @param controllerManager The controller manager that handles the actions of the buttons.
     */
    public CompletedQuestionnairePanel(@NotNull FetchParticipantStudyDataResponseModel data,
                                       ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(
                new String[]{"Questionnaire ID", "Questionnaire Name", "Questionnaire Status"});
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();

        List<String[]> values = new ArrayList<>(data.getCompletedQuestionnaireData().values());

        for (String[] questionnaireData : values) {
            model.addRow(questionnaireData);
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        JButton checkAnswerButton = new JButton("Check Answers");
        checkAnswerButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to check.");
            } else {
                int questionnaireId = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
                controllerManager.checkQuestionnaireVersionedAnswer(data.getStudyId(), data.getParticipantId(),
                        questionnaireId,data.getQuestionnaireAnswers().get(selectedRow), data.getCompletedQuestionnaireAnswerHistory().get(questionnaireId));
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(checkAnswerButton);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
