package user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers;

import user_interface_layer.screen_setters.SetTableModel;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.researcher_request_participant_screen.ResearcherRequestParticipantInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompletedQuestionnairePanelForResearcher extends JPanel {

    public CompletedQuestionnairePanelForResearcher(ResearcherRequestParticipantInputData data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(data.getQuestionnairesTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();

        List<Integer> keys = new ArrayList<>(data.getCompletedQuestionnaireData().keySet());
        List<String[]> values = new ArrayList<>(data.getCompletedQuestionnaireData().values());

        for (String[] questionnaireData : values) {
            model.addRow(questionnaireData);
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        JButton checkAnswerButton = new JButton("Check Answer");
        checkAnswerButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to check.");
            } else {
                int questionnaireID = keys.get(selectedRow);
                controllerManager.checkQuestionnaireVersionedAnswer(data.getStudyId(), data.getParticipantId(), questionnaireID, data.getCompletedQuestionnaireAnswerHistory().get(questionnaireID));
            }
        });

        JButton newAnswerButton = new JButton("Edit Answer");
        newAnswerButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to edit its answer.");
            } else {
                int questionnaireID = keys.get(selectedRow);
//                controllerManager.editQuestionnaireAnswerDataRequest(data.getUserId(), data.getStudyId(), data.getParticipantId(), questionnaireID);
            }
        });
        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(checkAnswerButton);
        buttonsPanel.add(newAnswerButton);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
