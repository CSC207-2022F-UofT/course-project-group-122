package UserInterfaceLayer.screens.StudyDataLog;

import javax.swing.*;

public class StudyDataLogScreen extends JFrame {
    JPanel researchersPanel;
    JPanel potentialParticipantsPanel;
    JPanel participantsPanel;
    JPanel questionnairesPanel;
    JPanel questionsPanel;
    public StudyDataLogScreen(StudyDataLogInputData data) {
        super("Study Data Log");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
