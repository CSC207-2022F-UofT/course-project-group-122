package user_interface_layer.screens.study_data_log.study_data_log_panels;

import user_interface_layer.SetScreenToCenter;
import user_interface_layer.SetTableModel;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.study_data_log.StudyDataLogInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class StudyLogQuestionnairePanel extends JPanel {

    public StudyLogQuestionnairePanel(StudyDataLogInputData data, ControllerManager controllerManager) {
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
        List<String[]> values = new ArrayList<>(data.getQuestionnairesData().values());
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
            controllerManager.researcherQuestionnaireScreenRequest(data.getResearchId(), data.getStudyId(), data.getEligibilityQuestionnaireId());
        });

        JButton check = new JButton("Check Questionnaire");
        check.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a questionnaire to check");
            } else {
                int questionnaireId = keys.get(selectedRow);
                controllerManager.researcherQuestionnaireScreenRequest(data.getResearchId(),data.getStudyId(),questionnaireId);
            }
        });

        JButton addQuestionnaire = new JButton("Add Questionnaire");
        addQuestionnaire.addActionListener(e -> controllerManager.researcherAddQuestionnaireScreenRequest(data.getResearchId(), data.getStudyId()));

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
                    controllerManager.researcherEditQuestionnaireScreenRequest(data.getResearchId(), data.getStudyId(), questionnaireId);
                }
            }
        });
        JButton assignQuestionnaire = new JButton("Assign Questionnaire");
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem individual = new JMenuItem("To One");
        JMenuItem group = new JMenuItem("To Group");
        JMenuItem all = new JMenuItem("To All");
        individual.addActionListener(e -> {
                    JFrame frame = new JFrame("Assign Questionnaire");
                    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JLabel label = new JLabel("Enter participant's Identifier", SwingConstants.CENTER);
                    JTextField textField = new JTextField(10);
                    JButton button = new JButton("Assign");
                    button.addActionListener(e1 -> {
                        String researcherId = textField.getText();
                        try {
                            int participant = Integer.parseInt(researcherId);
                            controllerManager.assignQuestionnaireToIndividual(data.getResearchId(), data.getStudyId(), participant);
                            frame.dispose();
                        } catch (NumberFormatException exception) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid identifier");
                        }
                    });
                    frame.add(label);
                    frame.add(textField);
                    frame.add(button);
                    frame.pack();
                    SetScreenToCenter s = new SetScreenToCenter(frame);
                    frame.setVisible(true);
                });
        group.addActionListener(e->{
            JFrame frame = new JFrame("Assign Questionnaire");
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel label = new JLabel("Enter a group name", SwingConstants.CENTER);
            JTextField textField = new JTextField(10);
            JButton button = new JButton("Assign");
            button.addActionListener(e1 -> {
                String groupName = textField.getText();
                controllerManager.assignQuestionnaireToGroup(data.getResearchId(), data.getStudyId(), groupName);
        });
            frame.add(label);
            frame.add(textField);
            frame.add(button);
            frame.pack();
            SetScreenToCenter s = new SetScreenToCenter(frame);
            frame.setVisible(true);
        });

        all.addActionListener(e->{
            controllerManager.assignQuestionnaireToAll(data.getResearchId(), data.getStudyId());
        });
        popupMenu.add(individual);
        popupMenu.add(group);
        popupMenu.add(all);
        assignQuestionnaire.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }});



        JPanel buttonPanel = new JPanel();
        buttonPanel.add(checkEligibility);
        buttonPanel.add(check);
        buttonPanel.add(addQuestionnaire);
        buttonPanel.add(editQuestionnaire);
        buttonPanel.add(assignQuestionnaire);
        add(buttonPanel, BorderLayout.SOUTH);

            }
}
