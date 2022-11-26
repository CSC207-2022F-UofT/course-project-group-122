package user_interface_layer.screens.study_data_log;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_log.FetchStudyLogResponseModel;
import user_interface_layer.screen_setters.SetScreenToCenter;
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
        setTitle(data.getStudyName() + " (" + data.getStudyStatus() + ")");
        JPanel header = new JPanel(new GridLayout(2, 1));
        JPanel backPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            controllerManager.researcherHomeScreenDriver(data.getResearcherId());
        });
        backPanel.add(backButton);
        header.add(backPanel);

        JButton downloadDataButton = new JButton("Download Data");
        downloadDataButton.setText("Download Data");
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem allData = new JMenuItem("All Data");
        JMenuItem currentData = new JMenuItem("Current Data");
        allData.addActionListener(e -> {
//                    controllerManager.downloadDataButtonActionPerformed("All Data", data.getStudyId());
                });
        currentData.addActionListener(e->{
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jFileChooser.showSaveDialog(null);
            String filePath = (jFileChooser.getSelectedFile()).getAbsolutePath();
                        controllerManager.downloadData(data.getStudyId(), filePath);
                });
        popupMenu.add(allData);
        popupMenu.add(currentData);
        downloadDataButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }});
        mainPanel.add(downloadDataButton);

        JLabel userIDLabel = new JLabel(data.getResearherName() + " (" + data.getResearcherId() + ")", SwingConstants.CENTER);
        mainPanel.add(userIDLabel);

        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> {
            controllerManager.userLogOutController();
        });
        mainPanel.add(logOutButton);
        header.add(mainPanel);
        add(header, BorderLayout.NORTH);


        JButton closeStudyButton = new JButton("Close Study");
        JPopupMenu popupMenu2 = new JPopupMenu();
        JMenuItem closeStudy = new JMenuItem("Close Study");
        JMenuItem openStudy = new JMenuItem("Reopen Study");
        closeStudy.addActionListener(e -> {
            controllerManager.closeStudy(data.getStudyId(), data.getResearcherId());});
        openStudy.addActionListener(e -> {
            controllerManager.reopenStudy(data.getStudyId(), data.getResearcherId());});
        popupMenu2.add(closeStudy);
        popupMenu2.add(openStudy);
        closeStudyButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                popupMenu2.show(evt.getComponent(), evt.getX(), evt.getY());
            }});
        backPanel.add(closeStudyButton);

        JButton consentFormButton = new JButton("Consent Form");
        JPopupMenu popupMenu3 = new JPopupMenu();
        JMenuItem createConsentForm = new JMenuItem("Create Consent Form");
        JMenuItem reviewConsentFrom = new JMenuItem("Review Consent Form");
        createConsentForm.addActionListener(e -> {
            controllerManager.requestConsentFormCreation(data.getStudyId());});
        reviewConsentFrom.addActionListener(e -> {
            controllerManager.reviewConsentForm(data.getStudyId());});
        popupMenu3.add(createConsentForm);
        popupMenu3.add(reviewConsentFrom);
        consentFormButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                popupMenu3.show(evt.getComponent(), evt.getX(), evt.getY());
            }});
        backPanel.add(consentFormButton);


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
