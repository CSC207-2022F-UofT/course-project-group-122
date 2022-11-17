package UserInterfaceLayer.screens.StudyDataLog;

import UserInterfaceLayer.SetScreenToCenter;
import UserInterfaceLayer.screens.ParticipantHomeScreens.QuestionnairePanelsForParticipants.AssignedQuestionnairePanel;
import UserInterfaceLayer.screens.ParticipantHomeScreens.QuestionnairePanelsForParticipants.CompletedQuestionnairePanel;
import UserInterfaceLayer.screens.ParticipantHomeScreens.QuestionnairePanelsForParticipants.EligibilityQuestionnairePanel;
import UserInterfaceLayer.screens.StudyDataLog.StudyDataLogPanels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudyDataLogScreen extends JFrame {
    JPanel researchersPanel;
    JPanel potentialParticipantsPanel;
    JPanel participantsPanel;
    JPanel questionnairesPanel;
    JPanel questionsPanel;

    public StudyDataLogScreen(StudyDataLogInputData data) {
        JPanel header = new JPanel(new GridLayout(2, 1));
        JPanel backPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            data.getControllerManager().ResearcherHomeScreenDriver(data.getResearchId());
        });
        backPanel.add(backButton);
        header.add(backPanel);

        JButton downloadDataButton = new JButton("Download Data");
        downloadDataButton.setText("Download Data");
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem allData = new JMenuItem("All Data");
        JMenuItem currentData = new JMenuItem("Current Data");
        allData.addActionListener(e -> {
                    data.getControllerManager().downloadDataButtonActionPerformed("All Data", data.getStudyId());
                });
        currentData.addActionListener(e->{
                        data.getControllerManager().downloadDataButtonActionPerformed("Current Data", data.getStudyId());
                });
        popupMenu.add(allData);
        popupMenu.add(currentData);
        downloadDataButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }});
        mainPanel.add(downloadDataButton);

        JButton dropStudyButton = new JButton("Drop Study");
        dropStudyButton.setText("Drop Study");

        dropStudyButton.addActionListener(e->{
                        data.getControllerManager().userDropStudyRequest(data.getResearchId(), data.getStudyId());
                });
        add(dropStudyButton, BorderLayout.SOUTH);

        JLabel userIDLabel = new JLabel(data.getResearcherName() + " (" + data.getResearchId() + ")", SwingConstants.CENTER);
        mainPanel.add(userIDLabel);

        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> {
            data.getControllerManager().userLogOutController();
        });
        mainPanel.add(logOutButton);
        header.add(mainPanel);
        add(header, BorderLayout.NORTH);


        JTabbedPane StudyLogTabPane = new JTabbedPane();


        researchersPanel = new StudyLogResearcherPanel(data);
        StudyLogTabPane.addTab("Researchers", researchersPanel);

        potentialParticipantsPanel = new StudyLogPotentialParticipantsPanel(data);
        StudyLogTabPane.addTab("Potential Participants", potentialParticipantsPanel);

        participantsPanel = new StudyLogParticipantsPanel(data);
        StudyLogTabPane.addTab("Participants", participantsPanel);

        questionnairesPanel = new StudyLogQuestionnairePanel(data);
        StudyLogTabPane.addTab("Questionnaires", questionnairesPanel);

        questionsPanel = new StudyLogGroupsPanel(data);
        StudyLogTabPane.addTab("Groups", questionsPanel);


        JPanel studyLogMainPanel = new JPanel();
        GroupLayout participantScreenMainLayout = new GroupLayout(studyLogMainPanel);
        studyLogMainPanel.setLayout(participantScreenMainLayout);
        participantScreenMainLayout.setHorizontalGroup(
                participantScreenMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(participantScreenMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(StudyLogTabPane)
                                .addContainerGap())
        );
        participantScreenMainLayout.setVerticalGroup(
                participantScreenMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, participantScreenMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(StudyLogTabPane, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                                .addContainerGap())
        );

        add(studyLogMainPanel, BorderLayout.CENTER);
        pack();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        SetScreenToCenter s = new SetScreenToCenter(this);
    }
}
