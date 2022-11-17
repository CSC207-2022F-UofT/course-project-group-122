package UserInterfaceLayer.screens.StudyDataLog.StudyDataLogPanels;

import UserInterfaceLayer.SetTableModel;
import UserInterfaceLayer.screens.StudyDataLog.StudyDataLogInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudyLogQuestionnairePanel extends JPanel {

    public StudyLogQuestionnairePanel(StudyDataLogInputData data) {
        setLayout(new BorderLayout());
        SetTableModel setEligibilityTableModel = new SetTableModel(data.getQuestionnairesTableHeader());
        DefaultTableModel eligibilityModel = setEligibilityTableModel.getModel();
        JTable eligibilityTable = setEligibilityTableModel.getTable();
        eligibilityModel.addRow(data.getEligibilityQuestionnaire());
        JScrollPane eligibilityScrollPane = new JScrollPane();
        eligibilityScrollPane.setViewportView(eligibilityTable);


        SetTableModel setTableModel = new SetTableModel(data.getQuestionnairesTableHeader());
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();
        List<Integer> keys = new ArrayList<>(data.getQuestionnairesData().keySet());
        List<String[]> values = new ArrayList<>(data.getParticipantsData().values());
        for (String[] row : values) {
            model.addRow(row);
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, eligibilityScrollPane, scrollPane);
        splitPane.setDividerLocation(2);
        add(splitPane, BorderLayout.CENTER);

        JButton checkEligibility = new JButton("Check Eligibility Questionnaire");
        checkEligibility.addActionListener(e -> {
            data.getControllerManager().researcherQuestionnaireScreenRequest(data.getResearchId(), data.getStudyId(), data.getEligibilityQuestionnaireId());
        });

        JButton check = new JButton("Check Questionnaire");
        check.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to check");
            } else {
                int questionnaireId = keys.get(selectedRow);
                data.getControllerManager().researcherQuestionnaireScreenRequest(data.getResearchId(),data.getStudyId(),questionnaireId);
            }
        });

        JButton addQuestionnaire = new JButton("Add Questionnaire");
        addQuestionnaire.addActionListener(e -> data.getControllerManager().researcherAddQuestionnaireScreenRequest(data.getResearchId(), data.getStudyId()));

        JButton editQuestionnaire = new JButton("Edit Questionnaire");
        editQuestionnaire.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to edit");
            } else {
                String publishStatus = (String) table.getValueAt(selectedRow, 2);
                String closedStatus = (String) table.getValueAt(selectedRow, 3);
                if (publishStatus.equals("Yes") || closedStatus.equals("Yes")) {
                    JOptionPane.showMessageDialog(null, "Cannot edit a published or closed questionnaire");
                } else {
                    int questionnaireId = keys.get(selectedRow);
                    data.getControllerManager().researcherEditQuestionnaireScreenRequest(data.getResearchId(), data.getStudyId(), questionnaireId);
                }
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(checkEligibility);
        buttonPanel.add(check);
        buttonPanel.add(addQuestionnaire);
        buttonPanel.add(editQuestionnaire);
        add(buttonPanel, BorderLayout.SOUTH);

            }
}
