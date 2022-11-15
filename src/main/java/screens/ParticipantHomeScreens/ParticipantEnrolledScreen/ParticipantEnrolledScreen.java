package screens.ParticipantHomeScreens.ParticipantEnrolledScreen;

import screens.SetScreenToCenter;
import screens.SetSimpleUserScreenHeader;
import screens.SetTableModel;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ParticipantEnrolledScreen extends JFrame {
    // Controller for this class
    private ParticipantEnrolledInputData data;
    private ParticipantEnrolledActionListeners actionListeners;

    DefaultTableModel questionnairesTableModel;
    JTable questionnairesTable;
    DefaultTableModel eligibilityQTableModel;
    JTable eligibilityQTable;

    public ParticipantEnrolledScreen(ParticipantEnrolledInputData data) {
        actionListeners = new ParticipantEnrolledActionListeners(data);

        setTitle(data.getStudyName());
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel header = new SetSimpleUserScreenHeader(data.getParticipantID(), data.getViewModel());
        add(header, BorderLayout.NORTH);

        JPanel tablePanel = new JPanel(new BorderLayout());

        JLabel tableTitle = new JLabel("Questionnaires", SwingConstants.CENTER);
        tablePanel.add(tableTitle, BorderLayout.NORTH);

        JScrollPane jScrollPane6 = new JScrollPane();

        SetTableModel setTableModel4 = new SetTableModel(data.getQuestionnaireTableHeader());
        eligibilityQTableModel = setTableModel4.getModel();
        eligibilityQTable = setTableModel4.getTable();

        eligibilityQTableModel.addRow(data.getEligibilityQuestionnaire());


        jScrollPane6.setViewportView(eligibilityQTable);

        if (eligibilityQTable.getColumnModel().getColumnCount() > 0) {
            eligibilityQTable.getColumnModel().getColumn(1).setResizable(false);
            eligibilityQTable.getColumnModel().getColumn(2).setResizable(false);
            eligibilityQTable.getColumnModel().getColumn(3).setResizable(false);
        }

        JScrollPane scrollPane = new JScrollPane();
        SetTableModel setTableModel = new SetTableModel(data.getQuestionnaireTableHeader());
        questionnairesTableModel = setTableModel.getModel();
        questionnairesTable = setTableModel.getTable();

        for (String[] i : data.getQuestionnaires()) {
            questionnairesTableModel.addRow(i);
        }
        scrollPane.setViewportView(questionnairesTable);

        JSplitPane vsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jScrollPane6, scrollPane);
        vsplit.setDividerLocation(2);

        tablePanel.add(vsplit, BorderLayout.CENTER);
        add(tablePanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout());

        JButton dropStudyButton = new JButton("Drop Study");
        dropStudyButton.addActionListener(e ->
                actionListeners.dropStudyButtonActionPerformed());

        JButton answerQuestionnaireButton = new JButton("Answer Questionnaire");
        answerQuestionnaireButton.addActionListener(
                e -> actionListeners.answerQuestionnaireButtonActionPerformed(questionnairesTableModel, questionnairesTable));

        JButton answerEligibilityButton = new JButton("Answer Eligibility Questionnaire");
        answerEligibilityButton.addActionListener(
                e -> actionListeners.answerEligibilityButtonActionPerformed(eligibilityQTableModel, eligibilityQTable));

        buttonsPanel.add(dropStudyButton);
        buttonsPanel.add(answerQuestionnaireButton);
        buttonsPanel.add(answerEligibilityButton);


        add(buttonsPanel, BorderLayout.SOUTH);

        setSize(600, 400);
        SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);
    }

    public void addQuestionnaireToTable(String[] array) {
        data.getQuestionnaires().add(array);
        questionnairesTableModel.addRow(array);
    }

    public void removeQuestionnaireFromTable(String[] array) {
        if (data.getQuestionnaires().contains(array)) {
            int rowToRemove = data.getQuestionnaires().indexOf(array);
            data.getQuestionnaires().remove(array);
            questionnairesTableModel.removeRow(rowToRemove);
        }
    }


}
