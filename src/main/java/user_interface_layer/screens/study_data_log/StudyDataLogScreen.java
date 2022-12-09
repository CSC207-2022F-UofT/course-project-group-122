package user_interface_layer.screens.study_data_log;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_log.FetchStudyLogResponseModel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.study_data_log.study_data_log_panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is used to display the data of a study.
 */
public class StudyDataLogScreen extends JFrame {
    /**
     * The panel to display the researchers of a study.
     */
    JPanel researchersPanel;
    /**
     * The panel to display the potential participants of a study.
     */
    JPanel potentialParticipantsPanel;
    /**
     * The panel to display the participants of a study.
     */
    JPanel participantsPanel;
    /**
     * The panel to display the questionnaires of a study.
     */
    JPanel questionnairesPanel;
    /**
     * The panel to display the groups of a study.
     */
    JPanel groupsPanel;

    /**
     * Creates the screen to display the data of a study.
     * @param data The data to display.
     * @param controllerManager The controller manager.
     */
    public StudyDataLogScreen(@NotNull FetchStudyLogResponseModel data, ControllerManager controllerManager) {
        setTitle(data.getStudyName() + " (" + data.getStudyStatus() + ")");
        JPanel header = new JPanel(new GridLayout(2, 1));
        JPanel backPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> controllerManager.researcherHomeScreenDriver(data.getResearcherId()));
        backPanel.add(backButton);
        header.add(backPanel);

        JButton downloadDataButton = new JButton("Download Data");
        downloadDataButton.setText("Download Data");
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem allData = new JMenuItem("All Data (coming soon!)");
        allData.setEnabled(false);
        JMenuItem currentData = new JMenuItem("Current Data");
        allData.addActionListener(e -> {
//                    This is where the download all data will be implemented
//                    Left for future implementations
        });
        currentData.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jFileChooser.showSaveDialog(null);
            System.out.println(jFileChooser.getSelectedFile().getPath());
            String filePath = (jFileChooser.getSelectedFile()).getAbsolutePath();
            controllerManager.downloadData(data.getStudyId(), filePath);
        });
        popupMenu.add(allData);
        popupMenu.add(currentData);
        downloadDataButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        });
        mainPanel.add(downloadDataButton);

        JLabel userIDLabel = new JLabel(data.getResearcherName() + " (" + data.getResearcherId() + ")", SwingConstants.CENTER);
        mainPanel.add(userIDLabel);

        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> controllerManager.userLogOutController());
        mainPanel.add(logOutButton);
        header.add(mainPanel);
        add(header, BorderLayout.NORTH);


        JButton closeStudyButton = new JButton("Close Study");
        JPopupMenu popupMenu2 = new JPopupMenu();
        JMenuItem closeStudy = new JMenuItem("Close Study");
        JMenuItem openStudy = new JMenuItem("Reopen Study");
        closeStudy.addActionListener(e -> controllerManager.closeStudy(data.getStudyId(), data.getResearcherId()));
        openStudy.addActionListener(e -> controllerManager.reopenStudy(data.getStudyId(), data.getResearcherId()));
        popupMenu2.add(closeStudy);
        popupMenu2.add(openStudy);
        closeStudyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                popupMenu2.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        });
        backPanel.add(closeStudyButton);

        JButton consentFormButton = new JButton("Consent Form");
        JPopupMenu popupMenu3 = new JPopupMenu();
        JMenuItem createConsentForm = new JMenuItem("Create Consent Form");
        JMenuItem reviewConsentFrom = new JMenuItem("Review Consent Form");
        createConsentForm.addActionListener(e -> controllerManager.requestConsentFormCreation(data.getStudyId()));
        reviewConsentFrom.addActionListener(e -> controllerManager.reviewConsentForm(data.getStudyId()));
        popupMenu3.add(createConsentForm);
        popupMenu3.add(reviewConsentFrom);
        consentFormButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                popupMenu3.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        });
        backPanel.add(consentFormButton);


        JTabbedPane studyLogTabPane = new JTabbedPane();


        researchersPanel = new StudyLogResearcherPanel(data, controllerManager);
        studyLogTabPane.addTab("Researchers", researchersPanel);

        potentialParticipantsPanel = new StudyLogPotentialParticipantsPanel(data, controllerManager);
        studyLogTabPane.addTab("Potential Participants", potentialParticipantsPanel);

        participantsPanel = new StudyLogParticipantsPanel(data, controllerManager);
        studyLogTabPane.addTab("Participants", participantsPanel);

        questionnairesPanel = new StudyLogQuestionnairePanel(data, controllerManager);
        studyLogTabPane.addTab("Questionnaires", questionnairesPanel);

        groupsPanel = new StudyLogGroupsPanel(data, controllerManager);
        studyLogTabPane.addTab("Groups", groupsPanel);


        JPanel studyLogMainPanel = new JPanel();
        GroupLayout participantScreenMainLayout = new GroupLayout(studyLogMainPanel);
        studyLogMainPanel.setLayout(participantScreenMainLayout);
        participantScreenMainLayout.setHorizontalGroup(
                participantScreenMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(participantScreenMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(studyLogTabPane)
                                .addContainerGap())
        );
        participantScreenMainLayout.setVerticalGroup(
                participantScreenMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, participantScreenMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(studyLogTabPane, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                                .addContainerGap())
        );

        add(studyLogMainPanel, BorderLayout.CENTER);
        pack();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        SetScreenToCenter.setCenter(this);
    }
}
