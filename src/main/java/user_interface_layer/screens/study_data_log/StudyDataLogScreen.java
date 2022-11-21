package user_interface_layer.screens.study_data_log;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_log.FetchStudyLogResponseModel;
import user_interface_layer.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.study_data_log.study_data_log_panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudyDataLogScreen extends JFrame {
    JPanel researchersPanel;
    JPanel potentialParticipantsPanel;
    JPanel participantsPanel;
    JPanel questionnairesPanel;
    JPanel questionsPanel;

    public StudyDataLogScreen(@NotNull FetchStudyLogResponseModel data, ControllerManager controllerManager) {
        JPanel header = new JPanel(new GridLayout(2, 1));
        JPanel backPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            controllerManager.ResearcherHomeScreenDriver(data.getResearcherId());
        });
        backPanel.add(backButton);
        header.add(backPanel);

        JButton downloadDataButton = new JButton("Download Data");
        downloadDataButton.setText("Download Data");
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem allData = new JMenuItem("All Data");
        JMenuItem currentData = new JMenuItem("Current Data");
        allData.addActionListener(e -> {
                    controllerManager.downloadDataButtonActionPerformed("All Data", data.getStudyId());
                });
        currentData.addActionListener(e->{
                        controllerManager.downloadDataButtonActionPerformed("Current Data", data.getStudyId());
                });
        popupMenu.add(allData);
        popupMenu.add(currentData);
        downloadDataButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }});
        mainPanel.add(downloadDataButton);

//        JButton dropStudyButton = new JButton("Drop Study");
//        dropStudyButton.setText("Drop Study");
//        dropStudyButton.addActionListener(e->{
//            JFrame confirm = new JFrame();
//            confirm.setSize(400, 200);
//            confirm.setLayout(new GridLayout(3, 1));
//            JLabel confirmLabel = new JLabel("Are you sure you want to drop this study?");
//            confirmLabel.setHorizontalAlignment(JLabel.CENTER);
//            confirm.add(confirmLabel);
//            JPanel buttons = new JPanel();
//            buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
//            JButton yesButton = new JButton("Yes");
//            JButton noButton = new JButton("No");
//            yesButton.addActionListener(e1 -> {
//                        controllerManager.userDropStudyRequest(data.getResearchId(), data.getStudyId());
//                });
//            noButton.addActionListener(e1 -> {
//                        confirm.dispose();
//                });
//            buttons.add(yesButton);
//            buttons.add(noButton);
//            confirm.add(buttons);
//            confirm.setVisible(true);
//        SetScreenToCenter s = new SetScreenToCenter(confirm);
//        });
//        add(dropStudyButton, BorderLayout.SOUTH);

        JLabel userIDLabel = new JLabel(data.getResearherName() + " (" + data.getResearcherId() + ")", SwingConstants.CENTER);
        mainPanel.add(userIDLabel);

        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> {
            controllerManager.userLogOutController();
        });
        mainPanel.add(logOutButton);
        header.add(mainPanel);
        add(header, BorderLayout.NORTH);


        JTabbedPane StudyLogTabPane = new JTabbedPane();


        researchersPanel = new StudyLogResearcherPanel(data, controllerManager);
        StudyLogTabPane.addTab("Researchers", researchersPanel);

        potentialParticipantsPanel = new StudyLogPotentialParticipantsPanel(data, controllerManager);
        StudyLogTabPane.addTab("Potential Participants", potentialParticipantsPanel);

        participantsPanel = new StudyLogParticipantsPanel(data, controllerManager);
        StudyLogTabPane.addTab("Participants", participantsPanel);

        questionnairesPanel = new StudyLogQuestionnairePanel(data, controllerManager);
        StudyLogTabPane.addTab("Questionnaires", questionnairesPanel);

        questionsPanel = new StudyLogGroupsPanel(data, controllerManager);
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

    public static void main(String[] args) {
        HashMap<Integer, String[]> researchers = new HashMap<>();
        researchers.put(1, new String[]{"1", "JohnSmith", "John"});
        researchers.put(2, new String[]{"2", "JaneSmith", "Jane"});
        researchers.put(3, new String[]{"3", "JohnDoe", "John"});
        researchers.put(4, new String[]{"4", "JaneDoe", "Jane"});
        HashMap<Integer, String[]> potentialParticipants = new HashMap<>();
        potentialParticipants.put(1, new String[]{"1", "JohnSmith", "John"});
        potentialParticipants.put(2, new String[]{"2", "JaneSmith", "Jane"});
        potentialParticipants.put(3, new String[]{"3", "JohnDoe", "John"});
        potentialParticipants.put(4, new String[]{"4", "JaneDoe", "Jane"});
        HashMap<Integer, String[]> participants = new HashMap<>();
        participants.put(1, new String[]{"1", "JohnSmith", "John"});
        participants.put(2, new String[]{"2", "JaneSmith", "Jane"});
        participants.put(3, new String[]{"3", "JohnDoe", "John"});
        participants.put(4, new String[]{"4", "JaneDoe", "Jane"});
        String[] eligibility = new String[]{"1", "Eligibility " + "Questionnaire", "Yes", "No"};
        Map<Integer, String[]> questionnaires = new HashMap<>();
        questionnaires.put(1, new String[]{"1", "Questionnaire 1", "Yes", "No"});
        questionnaires.put(2, new String[]{"2", "Questionnaire 2", "Yes", "No"});
        questionnaires.put(3, new String[]{"3", "Questionnaire 3", "No", "No"});
        List<String> groups = new ArrayList<>();
        groups.add("The Ingenious");
        groups.add("The Dumb");
        groups.add("The Smart");
        groups.add("The Stupid");



    }
}
