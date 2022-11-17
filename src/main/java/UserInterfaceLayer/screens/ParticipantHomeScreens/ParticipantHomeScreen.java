package UserInterfaceLayer.screens.ParticipantHomeScreens;

import UserInterfaceLayer.SetScreenToCenter;
import UserInterfaceLayer.screens.ParticipantHomeScreens.QuestionnairePanelsForParticipants.AssignedQuestionnairePanel;
import UserInterfaceLayer.screens.ParticipantHomeScreens.QuestionnairePanelsForParticipants.CompletedQuestionnairePanel;
import UserInterfaceLayer.screens.ParticipantHomeScreens.QuestionnairePanelsForParticipants.EligibilityQuestionnairePanel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class ParticipantHomeScreen extends JFrame {
    JPanel eligibilityQuestionnairePanel;
    JPanel assignedQuestionnairePanel;
    JPanel completedQuestionnairePanel;

    public ParticipantHomeScreen(@NotNull ParticipantHomeScreenInputData data) {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        JPanel header = new JPanel(new GridLayout(2, 1));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel userIDLabel = new JLabel(data.getParticipantName() + " (" + data.getParticipantId()+ ")");
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
        getContentPane().add(header, BorderLayout.PAGE_START);

        JTabbedPane QuestionnaireTabPane = new JTabbedPane();


        eligibilityQuestionnairePanel = new EligibilityQuestionnairePanel(data);
        QuestionnaireTabPane.addTab("Eligibility Questionnaire", eligibilityQuestionnairePanel);

        assignedQuestionnairePanel = new AssignedQuestionnairePanel(data);
        QuestionnaireTabPane.addTab("Assigned Questionnaires", assignedQuestionnairePanel);

        completedQuestionnairePanel = new CompletedQuestionnairePanel(data);
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

        add(participantScreenMain, BorderLayout.CENTER);
        pack();
        SetScreenToCenter s = new SetScreenToCenter(this);
    }
}
