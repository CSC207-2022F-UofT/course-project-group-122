package screens.ParticipantHomeScreens.ParticipantEnrolledScreen;

import screens.SetScreenToCenter;
import view.ViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ParticipantEnrolledActionListeners {
    private ParticipantEnrolledInputData data;
    private ViewModel viewModel;

    public ParticipantEnrolledActionListeners(ParticipantEnrolledInputData data) {
        this.data = data;
        viewModel = data.getViewModel();
    }

    public void dropStudyButtonActionPerformed() {
        int participantID = data.getParticipantID();
        int studyID = data.getStudyID();

        JFrame confirmationScreen = new JFrame();
        confirmationScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SetScreenToCenter toCenter = new SetScreenToCenter(confirmationScreen, new GridLayout(2, 1), 500, 100);
        JLabel message = new JLabel("Are you sure you want to drop this study?", SwingConstants.CENTER);
        JPanel buttons = new JPanel();
        JButton yesButton = new JButton("Yes");
        yesButton.addActionListener(e -> {
            viewModel.removeParticipantFromStudyController(participantID, studyID);
            viewModel.disposeCurrentScreen();
        });
        JButton noButton = new JButton("No");
        noButton.addActionListener(e -> {
            confirmationScreen.dispose();
        });
        buttons.add(yesButton);
        buttons.add(noButton);
        confirmationScreen.add(message, BorderLayout.PAGE_START);
        confirmationScreen.add(buttons, BorderLayout.PAGE_END);
        confirmationScreen.setVisible(true);
    }

    public void answerQuestionnaireButtonActionPerformed(DefaultTableModel questionnairesTableModel, JTable questionnairesTable) {
        int selectedRow = questionnairesTable.getSelectedRow();
        //int eligibilityselected = eligibilityQTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a questionnaire to answer");
        } else if (questionnairesTableModel.getValueAt(selectedRow, 3).equals("Completed")) {
            JOptionPane.showMessageDialog(null, "You have completed this Questionnaire");
        } else {
            int questionnaireID = Integer.parseInt((String) questionnairesTableModel.getValueAt(selectedRow, 0));
            viewModel.answerQuestionnaireController(data.getStudyID(), questionnaireID, data.getParticipantID());
        }

    }

    public void answerEligibilityButtonActionPerformed(DefaultTableModel eligibilityQTableModel, JTable eligibilityQTable) {
        int eligibilitySelected = eligibilityQTable.getSelectedRow();
        if (eligibilitySelected == -1) {
            JOptionPane.showMessageDialog(null, "Please select the Eligibility Questionnaire to answer");
        } else if (eligibilityQTableModel.getValueAt(eligibilitySelected, 3).equals("Completed")) {
            JOptionPane.showMessageDialog(null, "You have completed this Questionnaire");
        } else {
            int eligibilityID = Integer.parseInt((String) eligibilityQTableModel.getValueAt(eligibilitySelected, 0));
            viewModel.answerQuestionnaireController(data.getStudyID(), eligibilityID, data.getParticipantID());
        }

    }
}
