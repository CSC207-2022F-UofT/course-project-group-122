package UserInterfaceLayer.screens.ResearcherRequestParticipantScreen;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.SetScreenToCenter;
import UserInterfaceLayer.screens.ControllerManager;
import UserInterfaceLayer.screens.ParticipantHomeScreens.ParticipantHomeScreen;
import UserInterfaceLayer.screens.ParticipantHomeScreens.ParticipantHomeScreenInputData;
import UserInterfaceLayer.screens.ResearcherRequestParticipantScreen.QuestionnairesPanelsForResearchers.AssignedQuestionnairePanelForResearcher;
import UserInterfaceLayer.screens.ResearcherRequestParticipantScreen.QuestionnairesPanelsForResearchers.CompletedQuestionnairePanelForResearcher;
import UserInterfaceLayer.screens.ResearcherRequestParticipantScreen.QuestionnairesPanelsForResearchers.EligibilityQuestionnairePanelForResearcher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResearcherRequestParticipantScreen extends JFrame {
    JPanel completedQuestionnairePanel;
    JPanel eligibilityQuestionnairePanel;
    JPanel assignedQuestionnairePanel;

    public ResearcherRequestParticipantScreen(ResearcherRequestParticipantInputData data) {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);


        JPanel header = new JPanel(new GridLayout(2, 1));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel userIDLabel = new JLabel(data.getParticipantName() + " (" + data.getParticipantId() + ")");
        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> {
            data.getControllerManager().userLogOutController();
        });

        // JLabel message = new JLabel("You are enrolled in " + data.getStudyName(), SwingConstants.CENTER);
        topPanel.add(userIDLabel);
        topPanel.add(logOutButton);
        header.add(topPanel, BorderLayout.NORTH);
        JLabel message = new JLabel("You are a " + data.getParticipantStatus() + " Participant in " + data.getStudyName(), SwingConstants.CENTER);
        header.add(message, BorderLayout.CENTER);
        add(header, BorderLayout.NORTH);

        JTabbedPane QuestionnaireTabPane = new JTabbedPane();
        JPanel EligibilityQuestionnaire = new JPanel();
        JPanel AssignedQuestionnaires = new JPanel();
        JPanel completedQuestionnaire = new JPanel();

        eligibilityQuestionnairePanel = new EligibilityQuestionnairePanelForResearcher(data);
        QuestionnaireTabPane.addTab("Eligibility Questionnaire", eligibilityQuestionnairePanel);

        assignedQuestionnairePanel = new AssignedQuestionnairePanelForResearcher(data);
        QuestionnaireTabPane.addTab("Assigned Questionnaires", assignedQuestionnairePanel);

        completedQuestionnairePanel = new CompletedQuestionnairePanelForResearcher(data);
        QuestionnaireTabPane.addTab("Completed Questionnaires", completedQuestionnairePanel);

        add(QuestionnaireTabPane, BorderLayout.CENTER);
        pack();
        SetScreenToCenter s = new SetScreenToCenter(this);
    }
}


