package user_interface_layer.screens.researcher_request_participant_screen;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers.AssignedQuestionnairePanelForResearcher;
import user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers.CompletedQuestionnairePanelForResearcher;
import user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers.EligibilityQuestionnairePanelForResearcher;

import javax.swing.*;
import java.awt.*;

public class ResearcherRequestParticipantScreen extends JFrame {
    JPanel completedQuestionnairePanel;
    JPanel eligibilityQuestionnairePanel;
    JPanel assignedQuestionnairePanel;

    public ResearcherRequestParticipantScreen(@NotNull ResearcherRequestParticipantInputData data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel header = new JPanel(new GridLayout(2, 1));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel userIDLabel = new JLabel(data.getParticipantName() + " (" + data.getParticipantId() + ")");
        topPanel.add(userIDLabel);
        header.add(topPanel, BorderLayout.NORTH);
        add(header, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 1));
        JLabel nameLabel = new JLabel("Name: " + data.getParticipantName() + " (" + data.getParticipantId() + ")");
        JLabel statusLabel = new JLabel("Status: " + data.getParticipantStatus());
        JLabel groupNumberLabel = new JLabel("Group Number: " + data.getGroupNumber());
        centerPanel.add(nameLabel);
        centerPanel.add(statusLabel);
        centerPanel.add(groupNumberLabel);
        add(centerPanel, BorderLayout.CENTER);

        JTabbedPane QuestionnaireTabPane = new JTabbedPane();
        eligibilityQuestionnairePanel = new EligibilityQuestionnairePanelForResearcher(data, controllerManager);
        QuestionnaireTabPane.addTab("Eligibility Questionnaire", eligibilityQuestionnairePanel);

        assignedQuestionnairePanel = new AssignedQuestionnairePanelForResearcher(data, controllerManager);
        QuestionnaireTabPane.addTab("Assigned Questionnaires", assignedQuestionnairePanel);

        completedQuestionnairePanel = new CompletedQuestionnairePanelForResearcher(data ,controllerManager);
        QuestionnaireTabPane.addTab("Completed Questionnaires", completedQuestionnairePanel);

        add(QuestionnaireTabPane, BorderLayout.SOUTH);
        setSize(600, 700);
        SetScreenToCenter.setCenter(this);
    }
}


