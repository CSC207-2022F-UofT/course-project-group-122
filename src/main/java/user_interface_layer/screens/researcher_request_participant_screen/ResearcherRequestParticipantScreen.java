package user_interface_layer.screens.researcher_request_participant_screen;

import user_interface_layer.ScreenManager;
import user_interface_layer.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.participant_home_screens.ParticipantHomeScreen;
import user_interface_layer.screens.participant_home_screens.ParticipantHomeScreenInputData;
import user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers.AssignedQuestionnairePanelForResearcher;
import user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers.CompletedQuestionnairePanelForResearcher;
import user_interface_layer.screens.researcher_request_participant_screen.questionnaires_panels_for_researchers.EligibilityQuestionnairePanelForResearcher;
import user_interface_layer.screens.screen_drivers.SetQuestionnaireVersionedAnswerDriver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResearcherRequestParticipantScreen extends JFrame {
    JPanel completedQuestionnairePanel;
    JPanel eligibilityQuestionnairePanel;
    JPanel assignedQuestionnairePanel;

    public ResearcherRequestParticipantScreen(ResearcherRequestParticipantInputData data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);


        JPanel header = new JPanel(new GridLayout(2, 1));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel userIDLabel = new JLabel(data.getParticipantName() + " (" + data.getParticipantId() + ")");
        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> {
            controllerManager.userLogOutController();
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

        eligibilityQuestionnairePanel = new EligibilityQuestionnairePanelForResearcher(data, controllerManager);
        QuestionnaireTabPane.addTab("Eligibility Questionnaire", eligibilityQuestionnairePanel);

        assignedQuestionnairePanel = new AssignedQuestionnairePanelForResearcher(data, controllerManager);
        QuestionnaireTabPane.addTab("Assigned Questionnaires", assignedQuestionnairePanel);

        completedQuestionnairePanel = new CompletedQuestionnairePanelForResearcher(data ,controllerManager);
        QuestionnaireTabPane.addTab("Completed Questionnaires", completedQuestionnairePanel);

        add(QuestionnaireTabPane, BorderLayout.CENTER);
        pack();
        SetScreenToCenter s = new SetScreenToCenter(this);
    }

//    public static void main(String[] args) {
//        java.util.List<Integer> assignedQuestionnaires = new ArrayList<>();
//        assignedQuestionnaires.add(1);
//        assignedQuestionnaires.add(2);
//        Map<Integer, String[]> assignedQuestionnairesData = new HashMap<>();
//        assignedQuestionnairesData.put(1, new String[]{"1", "A second questionnaire", "Open"});
//        assignedQuestionnairesData.put(2, new String[]{"2", "A third questionnaire", "Open"});
//        java.util.List<Integer> completedQuestionnaires = new ArrayList<>();
//        completedQuestionnaires.add(3);
//        completedQuestionnaires.add(4);
//        Map<Integer, String[]> completedQuestionnairesData = new HashMap<>();
//        completedQuestionnairesData.put(3, new String[]{"3", "A first questionnaire", "Completed"});
//        completedQuestionnairesData.put(4, new String[]{"4", "A second questionnaire", "Completed"});
//        java.util.List<Integer> answeredToQuestionnaires = new ArrayList<>();
//        answeredToQuestionnaires.add(5);
//        answeredToQuestionnaires.add(6);
//        java.util.List<String[]> eligibilityQuestionnaireAnswerHistory = new ArrayList<>();
//        eligibilityQuestionnaireAnswerHistory.add(new String[]{"34", "6", "Jannet", "2020-12-12", "Some Answer"});
//        eligibilityQuestionnaireAnswerHistory.add(new String[]{"35", "6", "Jannet", "2020-12-12", "Some Answer"});
//        eligibilityQuestionnaireAnswerHistory.add(new String[]{"36", "6", "Jannet", "2020-12-12", "Some Answer"});
//        Map<Integer, List<String[]>> completedQuestionnaireAnswerHistory = new HashMap<>();
//        completedQuestionnaireAnswerHistory.put(3,eligibilityQuestionnaireAnswerHistory);
//        completedQuestionnaireAnswerHistory.put(4,eligibilityQuestionnaireAnswerHistory);
//
//
//        ResearcherRequestParticipantInputData data = new ResearcherRequestParticipantInputData(44,45,
//                "Bob",
//                "Potential",
//                4,
//                "Sleep",
//                "Sleep deprivation will give you cancer",
//                "Open",
//                3,
//                2,
//                "Open",
//                assignedQuestionnaires,
//                completedQuestionnaires,
//                answeredToQuestionnaires,
//                new String[]{"2", "a questionnaire", "Open"},
//                assignedQuestionnairesData,
//                completedQuestionnairesData,
//                eligibilityQuestionnaireAnswerHistory,
//                completedQuestionnaireAnswerHistory);
//        ControllerManager controllerManager = new ControllerManager(new ScreenManager());
//        controllerManager.setSetQuestionnaireVersionedAnswerDriver(new SetQuestionnaireVersionedAnswerDriver());
//        ResearcherRequestParticipantScreen screen = new ResearcherRequestParticipantScreen(data, controllerManager);
//        screen.setVisible(true);
//    }
}


