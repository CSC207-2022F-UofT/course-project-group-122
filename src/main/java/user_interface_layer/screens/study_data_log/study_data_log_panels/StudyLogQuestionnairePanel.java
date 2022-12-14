package user_interface_layer.screens.study_data_log.study_data_log_panels;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_log.FetchStudyLogResponseModel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to display the questionnaires of a study.
 */
public class StudyLogQuestionnairePanel extends JPanel {

    /**
     * Creates the panel to display the questionnaires of a study.
     * @param data The data to display.
     * @param controllerManager The controller manager.
     */
    public StudyLogQuestionnairePanel(@NotNull FetchStudyLogResponseModel data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        String[] questionnairesTableHeader = {"Questionnaire ID", "Questionnaire Name", "Published Status", "Closed Status"};
        SetTableModel setEligibilityTableModel = new SetTableModel(questionnairesTableHeader);
        DefaultTableModel eligibilityModel = setEligibilityTableModel.getModel();
        JTable eligibilityTable = setEligibilityTableModel.getTable();
        eligibilityModel.addRow(data.getEligibilityQuestionnaireContent());
        JScrollPane eligibilityScrollPane = new JScrollPane();
        eligibilityScrollPane.setViewportView(eligibilityTable);


        SetTableModel setTableModel = new SetTableModel(questionnairesTableHeader);
        DefaultTableModel model = setTableModel.getModel();
        JTable table = setTableModel.getTable();
        List<Integer> keys = new ArrayList<>(data.getQuestionnaires().keySet());
        List<String[]> values = new ArrayList<>(data.getQuestionnaires().values());
        for (String[] row : values) {
            model.addRow(row);
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, eligibilityScrollPane, scrollPane);
        splitPane.setDividerLocation(0.5);
        splitPane.setResizeWeight(0.5);
        add(splitPane, BorderLayout.CENTER);


        JButton checkEligibility = new JButton("Check Eligibility Questionnaire");
        checkEligibility.addActionListener(e -> controllerManager.researcherQuestionnaireScreenRequest(
                data.getResearcherId(), data.getStudyId(),
                data.getEligibilityQuestionnaireId()));

        JButton check = new JButton("Check Questionnaire");
        check.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to check");
            } else {
                int questionnaireId = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
                controllerManager.researcherQuestionnaireScreenRequest(
                        data.getResearcherId(), data.getStudyId(), questionnaireId);
            }
        });

        JButton addQuestionnaire = new JButton("Add Questionnaire");
        List<String> groups = List.of(data.getGroupAssignments());
        addQuestionnaire.addActionListener(e -> controllerManager.researcherAddQuestionnaireScreenRequest(
                data.getResearcherId(), data.getStudyId(), groups));

        JButton editQuestionnaire = new JButton("Edit Questionnaire");
        editQuestionnaire.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to edit");
            } else {
                String publishStatus = (String) table.getValueAt(selectedRow, 2);
                String closedStatus = (String) table.getValueAt(selectedRow, 3);
                if (publishStatus.equals("Yes") || closedStatus.equals("Yes")) {
                    JOptionPane.showMessageDialog(null,
                            "Cannot edit a published or closed questionnaire");
                } else {
                    int questionnaireId = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
                    controllerManager.researcherEditQuestionnaireScreenRequest(data.getResearcherId(),
                            data.getStudyId(), questionnaireId);
                }
            }
        });
        JButton assignQuestionnaire = new JButton("Assign Questionnaire");
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem individual = new JMenuItem("To One");
        JMenuItem group = new JMenuItem("To Group");
        JMenuItem all = new JMenuItem("To All");

        //Assign to individual
        individual.addActionListener(e -> {
                    JFrame frame = new JFrame("Assign Questionnaire");
                    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
                    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    JLabel label = new JLabel("Enter participant's Identifier", SwingConstants.CENTER);
                    JTextField textField = new JTextField(10);
                    JButton button = new JButton("Assign");
                    button.addActionListener(e1 -> {
                        String participantId = textField.getText();
                        try {
                            int participant = Integer.parseInt(participantId);
                            int selectedRow = table.getSelectedRow();
                            int questionnaireId = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
                            controllerManager.fetchParticipantInfoConfirmation(questionnaireId, data.getStudyId(),
                                    participant);
                            frame.dispose();
                        } catch (NumberFormatException exception) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid identifier");
                        }
                    });
                    frame.add(label);
                    frame.add(textField);
                    frame.add(button);
                    frame.pack();
                    SetScreenToCenter.setCenter(frame);
                    frame.setVisible(true);
                });

        // Assign to group
        group.addActionListener(e->{
            int selectedRow = table.getSelectedRow();
            int questionnaireId = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
                            controllerManager.fetchStudyGroups(questionnaireId, data.getStudyId());
        });

        // Assign to all
        all.addActionListener(e->{
            int selectedRow = table.getSelectedRow();
            int questionnaireId = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
            controllerManager.assignQuestionnaireToAll(questionnaireId, data.getStudyId());
        });

        popupMenu.add(individual);
        popupMenu.add(group);
        popupMenu.add(all);
        assignQuestionnaire.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a questionnaire to assign");
                } else {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }}
        });



        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        JPanel buttonPanel1row = new JPanel();
        JPanel buttonPanel2row = new JPanel();
        buttonPanel1row.add(checkEligibility);
        buttonPanel2row.add(check);
        buttonPanel2row.add(addQuestionnaire);
        buttonPanel2row.add(editQuestionnaire);
        buttonPanel2row.add(assignQuestionnaire);
        buttonPanel.add(buttonPanel1row);
        buttonPanel.add(buttonPanel2row);
        add(buttonPanel, BorderLayout.SOUTH);

    }
}
