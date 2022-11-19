package screens.StudyLog;

import screens.SetScreenToCenter;
import screens.SetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author annaxu
 */
public class ResearcherStudyLogScreen extends JFrame {
    private StudyLogInputData data;
    private StudyLogActionListeners actionListeners;

    JTable researchersTable = new JTable();
    ;
    JTable potentialsTable = new JTable();
    JTable participantsTable = new JTable();
    JTable eligibilityQTable = new JTable();
    JTable questionnairesTable = new JTable();

    JList groupsList = new JList();

    public ResearcherStudyLogScreen(StudyLogInputData data) {
        this.data = data;
        this.actionListeners = new StudyLogActionListeners(data);
        this.initComponents();
    }

    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JPanel studyLogHeader = new JPanel();
        JLabel researcherIdLabel = new JLabel();
        JButton dropStudyButton = new JButton();
        JButton downloadDataButton = new JButton();
        JButton backButton = new JButton();
        JButton logOutButton = new JButton();
        JPanel studyLogMain = new JPanel();
        JTabbedPane studiesTab = new JTabbedPane();
        JPanel researchersPanel = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
//        JTable researchersTable = new JTable();
        JPanel reserchersTableHeader = new JPanel();
        JLabel researchersTitle = new JLabel();
        JPanel researchersSouthPanel = new JPanel();
        JButton removeResearcherButton = new JButton();
        JButton addResearcherButton = new JButton();
        JPanel potentialsPanel = new JPanel();
        JPanel potentialsTableHeader = new JPanel();
        JLabel potentialsTitle = new JLabel();
        JScrollPane jScrollPane2 = new JScrollPane();
//        JTable potentialsTable = new JTable();
        JPanel potentialsSouthPanel = new JPanel();
        JButton removePotentialButton = new JButton();
        JButton checkPotentialButton = new JButton();
        JButton addPotentialButton = new JButton();
        JPanel participantsPanel = new JPanel();
        JPanel participantsTableHeader = new JPanel();
        JLabel participantsTitle = new JLabel();
        JScrollPane jScrollPane3 = new JScrollPane();
//        JTable participantsTable = new JTable();
        JPanel participantsSouthPanel = new JPanel();
        JButton removeParticipantButton = new JButton();
        JButton checkParticipantButton = new JButton();
        // Variables declaration - do not modify
        JButton addParticipantButton = new JButton();
        JPanel questionnairesPanel = new JPanel();
        JPanel questionnairesTableHeader = new JPanel();
        JLabel questionnairesTitle = new JLabel();
        JPanel holdQuestionnairesTables = new JPanel();
//        JTable eligibilityQTable;
        JScrollPane jScrollPane4 = new JScrollPane();
//        JTable questionnairesTable = new JTable();
        JPanel questionnairesSouthPanel = new JPanel();
        JButton assignQButton = new JButton();
        JButton editQButton = new JButton();
        JButton addQButton = new JButton();
        JButton closeQButton = new JButton();
        JPanel groupsPanel = new JPanel();
        JPanel groupsHeader = new JPanel();
        JLabel groupsTitle = new JLabel();
        JScrollPane jScrollPane5 = new JScrollPane();
//        JList<String> groupsList = new JList<>();
        JPanel groupsSouthPanel = new JPanel();
        JButton checkGroupButton = new JButton();

        setTitle(data.getStudyID() + ": " + data.getStudyName());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //////////////////////// HEADER ////////////////////////

        jPanel1.setLayout(new GridLayout(1, 1));
        studyLogHeader.setBackground(new Color(204, 204, 204));
        //studyLogHeader.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        studyLogHeader.setLayout(new FlowLayout(FlowLayout.RIGHT));

        downloadDataButton.setText("Download Data");
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem allData = new JMenuItem("All Data");
        JMenuItem currentData = new JMenuItem("Current Data");
        allData.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actionListeners.downloadAllDataButtonActionPerformed();
                    }
                }
        );

        currentData.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actionListeners.downloadCurrentDataButtonActionPerformed();
                    }
                }
        );
        popupMenu.add(allData);
        popupMenu.add(currentData);
        downloadDataButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        });
        studyLogHeader.add(downloadDataButton);

        dropStudyButton.setText("Drop Study");
        studyLogHeader.add(dropStudyButton);
        dropStudyButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actionListeners.dropStudyButtonActionPerformed();
                    }
                }
        );

        researcherIdLabel.setText("ID: " + Integer.toString(data.getResearchID()));
        studyLogHeader.add(researcherIdLabel);

        backButton.setText("Back");
        studyLogHeader.add(backButton);
        backButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actionListeners.backButtonActionPerformed();
                    }
                }
        );

        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionListeners.logOutButtonActionPerformed();
            }
        });
        studyLogHeader.add(logOutButton);
        jPanel1.add(studyLogHeader);
        getContentPane().add(jPanel1, BorderLayout.PAGE_START);
        studiesTab.setBackground(new Color(153, 153, 153));

        ////////////////////////////RESEARCHERS PANEL/////////////////////////////////////

        researchersPanel.setLayout(new BorderLayout());
        SetTableModel setTableModel = new SetTableModel(data.getResearchersTableHeader());
        DefaultTableModel researchersTableModel = setTableModel.getModel();
        researchersTable = setTableModel.getTable();

        for (String[] row : data.getResearchers()) {
            researchersTableModel.addRow(row);
        }

        jScrollPane1.setViewportView(researchersTable);

        researchersPanel.add(jScrollPane1, BorderLayout.CENTER);

        researchersTitle.setText("Researchers");
        reserchersTableHeader.add(researchersTitle);

        researchersPanel.add(reserchersTableHeader, BorderLayout.PAGE_START);

        researchersSouthPanel.setBackground(new Color(153, 153, 153));

        removeResearcherButton.setText("Remove Researcher");
        removeResearcherButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        actionListeners.removeResearcherButtonActionPerformed(researchersTableModel, researchersTable);
                    }
                });

        researchersSouthPanel.add(removeResearcherButton);

        addResearcherButton.setText("Add Researcher");
        addResearcherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionListeners.addResearcherButtonActionPerformed();
            }
        });
        researchersSouthPanel.add(addResearcherButton);

        researchersPanel.add(researchersSouthPanel, BorderLayout.PAGE_END);

        studiesTab.addTab("Researchers", researchersPanel);

        potentialsPanel.setLayout(new BorderLayout());

        potentialsTitle.setText("Potential Participants");
        potentialsTableHeader.add(potentialsTitle);

        potentialsPanel.add(potentialsTableHeader, BorderLayout.PAGE_START);

        SetTableModel setTableModel1 = new SetTableModel(data.getPotentialsTableHeader());
        DefaultTableModel potentialTableModel = setTableModel1.getModel();
        potentialsTable = setTableModel1.getTable();

        for (String[] row : data.getPotentials()) {
            potentialTableModel.addRow(row);
        }

        jScrollPane2.setViewportView(potentialsTable);
//        if (potentialsTable.getColumnModel().getColumnCount() > 0) {
//            potentialsTable.getColumnModel().getColumn(0).setResizable(false);
//            potentialsTable.getColumnModel().getColumn(1).setResizable(false);
//            potentialsTable.getColumnModel().getColumn(2).setResizable(false);
//        }


        ////////////////////////////POTENTIAL PARTICIPANTS PANEL/////////////////////////////////////
        potentialsPanel.add(jScrollPane2, BorderLayout.CENTER);

        potentialsSouthPanel.setBackground(new Color(153, 153, 153));

        removePotentialButton.setText("Remove Potential Participant");
        removePotentialButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        actionListeners.removePotentialButtonActionPerformed(potentialTableModel, potentialsTable);
                    }
                });
        potentialsSouthPanel.add(removePotentialButton);

        checkPotentialButton.setText("Check Potential Participant");
        checkPotentialButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        actionListeners.checkPotentialButtonActionPerformed(potentialTableModel, potentialsTable);
                    }
                });
        potentialsSouthPanel.add(checkPotentialButton);

        addPotentialButton.setText("Add Potential Participants");
        addPotentialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionListeners.addPotentialButtonActionPerformed();
            }
        });
        potentialsSouthPanel.add(addPotentialButton);

        potentialsPanel.add(potentialsSouthPanel, BorderLayout.PAGE_END);

        studiesTab.addTab("Potential Participants", potentialsPanel);

        participantsPanel.setLayout(new BorderLayout());

        participantsTitle.setText("Participants");
        participantsTableHeader.add(participantsTitle);

        participantsPanel.add(participantsTableHeader, BorderLayout.PAGE_START);

        SetTableModel setTableModel2 = new SetTableModel(data.getParticipantsTableHeader());
        DefaultTableModel participantTableModel = setTableModel2.getModel();
        participantsTable = setTableModel2.getTable();

        for (String[] row : data.getParticipants()) {
            participantTableModel.addRow(row);
        }

        jScrollPane3.setViewportView(participantsTable);
//        if (participantsTable.getColumnModel().getColumnCount() > 0) {
//            participantsTable.getColumnModel().getColumn(0).setResizable(false);
//            participantsTable.getColumnModel().getColumn(1).setResizable(false);
//            participantsTable.getColumnModel().getColumn(2).setResizable(false);
//        }


        ////////////////////////////PARTICIPANTS PANEL/////////////////////////////////////
        participantsPanel.add(jScrollPane3, BorderLayout.CENTER);

        participantsSouthPanel.setBackground(new Color(153, 153, 153));

        removeParticipantButton.setText("Remove Participant");
        removeParticipantButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionListeners.removeParticipantButtonActionPerformed(participantTableModel, participantsTable);
            }
        });
        participantsSouthPanel.add(removeParticipantButton);

        checkParticipantButton.setText("Check Participant");
        checkParticipantButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionListeners.checkParticipantButtonActionPerformed(participantTableModel, participantsTable);
            }
        });
        participantsSouthPanel.add(checkParticipantButton);

//        addParticipantButton.setText("Add Participants");
//        addParticipantButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                actionListeners.addParticipantButtonActionPerformed();
//            }
//        });
//        participantsSouthPanel.add(addParticipantButton);

        participantsPanel.add(participantsSouthPanel, BorderLayout.PAGE_END);

        studiesTab.addTab("Participants", participantsPanel);


        ////////////////////////////QUESTIONNAIRES PANEL/////////////////////////////////////
        questionnairesPanel.setLayout(new BorderLayout());

        questionnairesTitle.setText("Questionnaires");
        questionnairesTableHeader.add(questionnairesTitle);

        questionnairesPanel.add(questionnairesTableHeader, BorderLayout.PAGE_START);


        SetTableModel setTableModel4 = new SetTableModel(data.getQuestionnairesTableHeader());
        DefaultTableModel eligibilityQTableModel = setTableModel4.getModel();
        eligibilityQTable = setTableModel4.getTable();

        eligibilityQTableModel.addRow(data.getEligibilityQuestionnaire());

        JScrollPane jScrollPane6 = new JScrollPane();

        jScrollPane6.setViewportView(eligibilityQTable);

        if (eligibilityQTable.getColumnModel().getColumnCount() > 0) {
            eligibilityQTable.getColumnModel().getColumn(1).setResizable(false);
            eligibilityQTable.getColumnModel().getColumn(2).setResizable(false);
            eligibilityQTable.getColumnModel().getColumn(3).setResizable(false);
        }

        //holdQuestionnairesTables.add(jScrollPane6);


        SetTableModel setTableModel3 = new SetTableModel(data.getQuestionnairesTableHeader());
        DefaultTableModel questionnaireTableModel = setTableModel3.getModel();
        questionnairesTable = setTableModel3.getTable();

        for (String[] row : data.getQuestionnaires()) {
            questionnaireTableModel.addRow(row);
        }

        jScrollPane4.setViewportView(questionnairesTable);
        if (questionnairesTable.getColumnModel().getColumnCount() > 0) {
            questionnairesTable.getColumnModel().getColumn(1).setResizable(false);
            questionnairesTable.getColumnModel().getColumn(2).setResizable(false);
            questionnairesTable.getColumnModel().getColumn(3).setResizable(false);
        }

        // holdQuestionnairesTables.add(jScrollPane4);

        JSplitPane vsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jScrollPane6, jScrollPane4);
        vsplit.setDividerLocation(2);

        questionnairesPanel.add(vsplit, BorderLayout.CENTER);

        questionnairesSouthPanel.setBackground(new Color(153, 153, 153));

        assignQButton.setText("Publish Questionnaire");
        assignQButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionListeners.publishQButtonActionPerformed(questionnaireTableModel, questionnairesTable);
            }
        });
        questionnairesSouthPanel.add(assignQButton);

        editQButton.setText("Edit Questionnaire");
        editQButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionListeners.editQButtonActionPerformed(questionnaireTableModel, questionnairesTable);
            }
        });
        questionnairesSouthPanel.add(editQButton);

        addQButton.setText("Add Questionnaire");
        addQButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionListeners.addQButtonActionPerformed();
            }
        });
        questionnairesSouthPanel.add(addQButton);

        closeQButton.setText("Close Questionnaire");
        closeQButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionListeners.closeQButtonActionPerformed(questionnaireTableModel, questionnairesTable);
            }
        });
        questionnairesSouthPanel.add(closeQButton);

        questionnairesPanel.add(questionnairesSouthPanel, BorderLayout.PAGE_END);

        studiesTab.addTab("Questionnaires", questionnairesPanel);

        groupsPanel.setLayout(new BorderLayout());


        groupsTitle.setText(data.getRandomizedStrategy() + " " + data.getStudyType() + " Groups");
        groupsHeader.add(groupsTitle);

        groupsPanel.add(groupsHeader, BorderLayout.PAGE_START);

        DefaultListModel<String> groupsListModel = new DefaultListModel<>();
        groupsList = new JList<>(groupsListModel);
        for (String group : data.getGroups()) {
            groupsListModel.addElement(group);
        }

        groupsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(groupsList);


        ////////////////////////////GROUPS PANEL/////////////////////////////////////
        groupsPanel.add(jScrollPane5, BorderLayout.CENTER);

        groupsSouthPanel.setBackground(new Color(153, 153, 153));

        if (data.getStudyType().equals("Randomized")) {
            JButton selectStrategy = new JButton("Select Randomized Strategy");

            selectStrategy.addActionListener(
                    e -> {
                        if (data.isStudyEmpty()){
                        actionListeners.selectStrategyButtonActionPerformed();
                    }else {
                            JOptionPane.showMessageDialog(null, "You can't change the strategy after adding participants or Potential Participants");
                        }
                    }

            );
            groupsSouthPanel.add(selectStrategy);
        }
        checkGroupButton.setText("Check Group");
        checkGroupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionListeners.checkGroupButtonActionPerformed(groupsList);
            }
        });
        groupsSouthPanel.add(checkGroupButton);

        groupsPanel.add(groupsSouthPanel, BorderLayout.PAGE_END);

        studiesTab.addTab("Groups", groupsPanel);

        GroupLayout studyLogMainLayout = new GroupLayout(studyLogMain);
        studyLogMain.setLayout(studyLogMainLayout);
        studyLogMainLayout.setHorizontalGroup(
                studyLogMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(studyLogMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(studiesTab)
                                .addContainerGap())
        );
        studyLogMainLayout.setVerticalGroup(
                studyLogMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, studyLogMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(studiesTab, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                                .addContainerGap())
        );

        getContentPane().add(studyLogMain, BorderLayout.CENTER);

        pack();
        int width = getWidth();
        int height = getHeight();
        SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this, width, height);
    }// </editor-fold>


}
