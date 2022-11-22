package user_interface_layer.screens.participant_home_screens;

import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.participant_home_screens.questionnaire_panels_for_participants.AssignedQuestionnairePanel;
import user_interface_layer.screens.participant_home_screens.questionnaire_panels_for_participants.CompletedQuestionnairePanel;
import user_interface_layer.screens.participant_home_screens.questionnaire_panels_for_participants.EligibilityQuestionnairePanel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParticipantHomeScreen extends JFrame {
    JPanel eligibilityQuestionnairePanel;
    JPanel assignedQuestionnairePanel;
    JPanel completedQuestionnairePanel;

    public ParticipantHomeScreen(@NotNull ParticipantHomeScreenInputData data, @NotNull ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        JPanel header = new JPanel(new GridLayout(2, 1));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel userIDLabel = new JLabel(data.getParticipantName() + " (" + data.getParticipantId()+ ")");
        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> {
            controllerManager.userLogOutController();
        });

        // JLabel message = new JLabel("You are enrolled in " + data.getStudyName(), SwingConstants.CENTER);
        topPanel.add(userIDLabel);
        topPanel.add(logOutButton);
        header.add(topPanel, BorderLayout.NORTH);
        JLabel message = new JLabel("You are " + data.getParticipantStatus() + " Participant in " + data.getStudyName(), SwingConstants.CENTER);
        header.add(message, BorderLayout.CENTER);
        getContentPane().add(header, BorderLayout.PAGE_START);

        JTabbedPane QuestionnaireTabPane = new JTabbedPane();


        eligibilityQuestionnairePanel = new EligibilityQuestionnairePanel(data, controllerManager);
        QuestionnaireTabPane.addTab("Eligibility Questionnaire", eligibilityQuestionnairePanel);

        assignedQuestionnairePanel = new AssignedQuestionnairePanel(data, controllerManager);
        QuestionnaireTabPane.addTab("Assigned Questionnaires", assignedQuestionnairePanel);

        completedQuestionnairePanel = new CompletedQuestionnairePanel(data, controllerManager);
        QuestionnaireTabPane.addTab("Completed Questionnaires", completedQuestionnairePanel);


        JPanel participantScreenMain = new JPanel();
        GroupLayout participantScreenMainLayout = new GroupLayout(participantScreenMain);
        participantScreenMain.setLayout(participantScreenMainLayout);
        participantScreenMainLayout.setHorizontalGroup(
                participantScreenMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(participantScreenMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(QuestionnaireTabPane)
                                .addContainerGap())
        );
        participantScreenMainLayout.setVerticalGroup(
                participantScreenMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, participantScreenMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(QuestionnaireTabPane, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                                .addContainerGap())
        );
        JButton dropOutButton = new JButton("Drop Out");
        dropOutButton.addActionListener(e -> {
            controllerManager.participantDropStudy(data.getParticipantId(),data.getStudyId());
        });
        add(dropOutButton, BorderLayout.SOUTH);

        add(participantScreenMain, BorderLayout.CENTER);
        setSize(600, 400);
        SetScreenToCenter s = new SetScreenToCenter(this);
    }

    public static void main(String[] args) {
        List<Integer> assignedQuestionnaires = new ArrayList<>();
        assignedQuestionnaires.add(1);
        assignedQuestionnaires.add(2);
        Map<Integer, String[]> assignedQuestionnairesData = new HashMap<>();
        assignedQuestionnairesData.put(1, new String[]{"1", "A second questionnaire", "Open"});
        assignedQuestionnairesData.put(2, new String[]{"2", "A third questionnaire", "Open"});
        List<Integer> completedQuestionnaires = new ArrayList<>();
        completedQuestionnaires.add(3);
        completedQuestionnaires.add(4);
        Map<Integer, String[]> completedQuestionnairesData = new HashMap<>();
        completedQuestionnairesData.put(3, new String[]{"3", "A first questionnaire", "Completed"});
        completedQuestionnairesData.put(4, new String[]{"4", "A second questionnaire", "Completed"});
        List<Integer> answeredToQuestionnaires = new ArrayList<>();
        answeredToQuestionnaires.add(5);
        answeredToQuestionnaires.add(6);
        List<String[]> eligibilityQuestionnaireAnswerHistory = new ArrayList<>();
        eligibilityQuestionnaireAnswerHistory.add(new String[]{"34", "6", "Jannet", "2020-12-12", "Some Answer"});
        eligibilityQuestionnaireAnswerHistory.add(new String[]{"35", "6", "Jannet", "2020-12-12", "Some Answer"});
        eligibilityQuestionnaireAnswerHistory.add(new String[]{"36", "6", "Jannet", "2020-12-12", "Some Answer"});
        Map<Integer, List<String[]>> completedQuestionnaireAnswerHistory = new HashMap<>();
        completedQuestionnaireAnswerHistory.put(3,eligibilityQuestionnaireAnswerHistory);
        completedQuestionnaireAnswerHistory.put(4,eligibilityQuestionnaireAnswerHistory);


        ParticipantHomeScreenInputData data = new ParticipantHomeScreenInputData(45,
                "Bob",
                "Potential",
                4,
                "Sleep",
                "Sleep deprivation will give you cancer",
                "Open",
                3,
                2,
                "Open",
                assignedQuestionnaires,
                completedQuestionnaires,
                answeredToQuestionnaires,
                new String[]{"2", "a questionnaire", "Open"},
                assignedQuestionnairesData,
                completedQuestionnairesData,
                eligibilityQuestionnaireAnswerHistory,
                completedQuestionnaireAnswerHistory);
        ParticipantHomeScreen screen = new ParticipantHomeScreen(data, new ControllerManager(new ScreenManager()));
        screen.setVisible(true);


    }
}
