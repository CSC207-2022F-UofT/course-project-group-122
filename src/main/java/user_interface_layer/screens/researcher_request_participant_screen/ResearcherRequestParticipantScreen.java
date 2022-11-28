package user_interface_layer.screens.researcher_request_participant_screen;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers.AssignedQuestionnairePanelForResearcher;
import user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers.CompletedQuestionnairePanelForResearcher;
import user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers.EligibilityQuestionnairePanelForResearcher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
        JPanel EligibilityQuestionnaire = new JPanel();
        JPanel AssignedQuestionnaires = new JPanel();
        JPanel completedQuestionnaire = new JPanel();

        eligibilityQuestionnairePanel = new EligibilityQuestionnairePanelForResearcher(data, controllerManager);
        QuestionnaireTabPane.addTab("Eligibility Questionnaire", eligibilityQuestionnairePanel);

        assignedQuestionnairePanel = new AssignedQuestionnairePanelForResearcher(data, controllerManager);
        QuestionnaireTabPane.addTab("Assigned Questionnaires", assignedQuestionnairePanel);

        completedQuestionnairePanel = new CompletedQuestionnairePanelForResearcher(data ,controllerManager);
        QuestionnaireTabPane.addTab("Completed Questionnaires", completedQuestionnairePanel);

        add(QuestionnaireTabPane, BorderLayout.SOUTH);
        pack();
        SetScreenToCenter s = new SetScreenToCenter(this);
    }

    public static void main(String[] args) {
        ResearcherRequestParticipantInputData data = new ResearcherRequestParticipantInputData(2, 1,
                "Participant 1", "Active", 1, "Study1", "SD1",
                "Active", 2, 3, "Active",
                new ArrayList<>(Collections.singleton(1)), new ArrayList<>(Collections.singleton(1)),
                new ArrayList<>(Collections.singleton(1)), new String[]{"1"},
                new HashMap<>(Collections.singletonMap(1, new String[]{"Questionnaire1"})), new HashMap<>(Collections.singletonMap(1, new String[]{"Questionnaire1"})),
                new ArrayList<>(Collections.singleton(new String[]{"1"})), new HashMap<>(Collections.singletonMap(1, new ArrayList<>(Collections.singleton(new String[]{"1"})))));

        ResearcherRequestParticipantScreen screen = new ResearcherRequestParticipantScreen(data, null);
        screen.setVisible(true);

    }

}


