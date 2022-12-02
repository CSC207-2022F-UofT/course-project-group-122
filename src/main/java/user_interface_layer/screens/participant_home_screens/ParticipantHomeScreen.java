package user_interface_layer.screens.participant_home_screens;

import use_cases.fetch_participant_study_data.FetchParticipantStudyDataResponseModel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.participant_home_screens.questionnaire_panels_for_participants.AssignedQuestionnairePanel;
import user_interface_layer.screens.participant_home_screens.questionnaire_panels_for_participants.CompletedQuestionnairePanel;
import user_interface_layer.screens.participant_home_screens.questionnaire_panels_for_participants.EligibilityQuestionnairePanel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the screen that displays the screen for an enrolled participant and potential participant
 */
public class ParticipantHomeScreen extends JFrame {
    /**
     * The panel that displays the eligibility questionnaire
     */
    JPanel eligibilityQuestionnairePanel;
    /**
     * The panel that displays the assigned questionnaires
     */
    JPanel assignedQuestionnairePanel;
    /**
     * The panel that displays the completed questionnaires
     */
    JPanel completedQuestionnairePanel;

    /**
     * This is the constructor for the ParticipantHomeScreen class
     * @param data The data needed to display the screen
     * @param controllerManager The controller manager that handles the actions of the buttons
     */
    public ParticipantHomeScreen(@NotNull FetchParticipantStudyDataResponseModel data, @NotNull ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        JPanel header = new JPanel(new GridLayout(2, 1));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel userIDLabel = new JLabel(data.getParticipantName() + " (" + data.getParticipantId()+ ")");
        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> controllerManager.userLogOutController());

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
        dropOutButton.addActionListener(e -> controllerManager.participantDropStudy(data.getParticipantId(),data.getStudyId()));
        add(dropOutButton, BorderLayout.SOUTH);

        add(participantScreenMain, BorderLayout.CENTER);
        setSize(600, 400);
        SetScreenToCenter.setCenter(this);
    }
}
