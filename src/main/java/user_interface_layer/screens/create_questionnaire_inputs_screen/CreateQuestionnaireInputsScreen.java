package user_interface_layer.screens.create_questionnaire_inputs_screen;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screen_helper_classes.SetLabelTextPanel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.create_questionnaire_inputs_screen.question_screen.MCQuestionScreen;
import user_interface_layer.screens.create_questionnaire_inputs_screen.question_screen.ScaleQuestionScreen;
import user_interface_layer.screens.create_questionnaire_inputs_screen.question_screen.TextQuestionScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CreateQuestionnaireInputsScreen extends JFrame {
    private final List<QuestionModel> addedQuestions = new ArrayList<>();
    List<JRadioButton> studyGroups = new ArrayList<>();
    private final ArrayList<String> variables = new ArrayList<>();

    public CreateQuestionnaireInputsScreen(@NotNull CreateQuestionnaireInputsScreenInputData data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        JTextField questionnaireName = new JTextField(30);
        JTextArea questionnaireDescription = new JTextArea(5, 20);


        JPanel inputsPanel = new JPanel();
        inputsPanel.setLayout(new BoxLayout(inputsPanel, BoxLayout.Y_AXIS));

        JPanel questionnaireNamePanel = new SetLabelTextPanel(new JLabel("Questionnaire Name: "), questionnaireName);

        JPanel questionnaireDescriptionPanel = new JPanel(new GridLayout(2, 1));
        JLabel questionnaireDescriptionLabel = new JLabel("Questionnaire Description: ", SwingConstants.CENTER);
        questionnaireDescription.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(questionnaireDescription);

        questionnaireDescriptionPanel.add(questionnaireDescriptionLabel);
        questionnaireDescriptionPanel.add(scrollPane);

        JPanel groupsPanel = new JPanel();
        JLabel groupsLabel = new JLabel("Select Target groups: ", SwingConstants.CENTER);
        groupsPanel.setLayout(new BoxLayout(groupsPanel, BoxLayout.Y_AXIS));
        groupsPanel.add(groupsLabel);
        for (String group : data.getStudyGroups()) {
            JRadioButton radioButton = new JRadioButton(group);
            studyGroups.add(radioButton);
            groupsPanel.add(radioButton);
        }

        JPanel questionsPanel = new JPanel(new BorderLayout());
        JLabel questionsLabel = new JLabel("Questions: ", SwingConstants.CENTER);
        JScrollPane questionsScrollPane = new JScrollPane();
        SetTableModel setTableModel = new SetTableModel(new String[]{"Type", "Question", "Variable", "Options"});
        DefaultTableModel questionsTableModel = setTableModel.getModel();
        JTable questionsTable = setTableModel.getTable();

        questionsScrollPane.setViewportView(questionsTable);

        questionsPanel.add(questionsLabel, BorderLayout.NORTH);
        questionsPanel.add(questionsScrollPane, BorderLayout.CENTER);


        JButton addQuestionButton = new JButton("Add Question");
        JPopupMenu addQuestionMenu = new JPopupMenu();
        JMenuItem addMCQuestion = new JMenuItem("MC Question");
        JMenuItem addScaleQuestion = new JMenuItem("Scale Question");
        JMenuItem addTextQuestion = new JMenuItem("Text Question");
        addQuestionMenu.add(addTextQuestion);
        addQuestionMenu.add(addScaleQuestion);
        addQuestionMenu.add(addMCQuestion);
        addQuestionButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                addQuestionMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        });
        addMCQuestion.addActionListener(e -> {
            JFrame mcNumOfChoices = new JFrame();
            mcNumOfChoices.setLayout(new BorderLayout());
            mcNumOfChoices.setTitle("Number of Choices");
            mcNumOfChoices.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JTextField numOfChoices = new JTextField(10);
            JButton continueButton = new JButton("Continue");
            continueButton.addActionListener(e1 -> {
                try {
                    int num = Integer.parseInt(numOfChoices.getText());
                    if (num < 2) {
                        JOptionPane.showMessageDialog(null, "Please enter a number greater than 1");
                    } else {
                        MCQuestionScreen mcQuestionScreen = new MCQuestionScreen(variables, addedQuestions, questionsTableModel, num);
                        mcQuestionScreen.setVisible(true);
                        mcNumOfChoices.dispose();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a number");
                }
            });
            mcNumOfChoices.add(numOfChoices, BorderLayout.CENTER);
            mcNumOfChoices.add(continueButton, BorderLayout.SOUTH);
            mcNumOfChoices.setSize(300, 100);
            SetScreenToCenter.setCenter(mcNumOfChoices);
            mcNumOfChoices.setVisible(true);
        });

        addScaleQuestion.addActionListener(e -> {
            JFrame numOfScale = new JFrame();
            numOfScale.setLayout(new BorderLayout());
            numOfScale.setTitle("Number of Scale");
            numOfScale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JTextField numOfChoices = new JTextField(10);
            JButton continueButton = new JButton("Continue");
            continueButton.addActionListener(e1 -> {
                try {
                    int num = Integer.parseInt(numOfChoices.getText());
                    if (num < 2) {
                        JOptionPane.showMessageDialog(null, "Please enter a number greater than 1");
                    } else {
                        ScaleQuestionScreen scaleQuestionScreen = new ScaleQuestionScreen(variables, addedQuestions, questionsTableModel, num);
                        scaleQuestionScreen.setVisible(true);
                        numOfScale.setSize(300, 100);
                        numOfScale.dispose();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a number");
                }
            });
            numOfScale.add(numOfChoices, BorderLayout.CENTER);
            numOfScale.add(continueButton, BorderLayout.SOUTH);
            numOfScale.setSize(300, 100);
            SetScreenToCenter.setCenter(numOfScale);
            numOfScale.setVisible(true);

        });

        addTextQuestion.addActionListener(e -> {
            TextQuestionScreen textQuestionScreen = new TextQuestionScreen(variables, addedQuestions, questionsTableModel);
            textQuestionScreen.setVisible(true);
        });

        JButton deleteQuestionButton = new JButton("Delete Question");
        deleteQuestionButton.addActionListener(e -> {
            if (addedQuestions.size() == 0) {
                JOptionPane.showMessageDialog(null, "There are no questions to delete");
            } else {
                int row = questionsTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a question to delete");
                } else {
                    addedQuestions.remove(row);
                    questionsTableModel.removeRow(row);
                }
            }
        });

        JButton createQuestionnaireButton = new JButton("Create Questionnaire");
        createQuestionnaireButton.addActionListener(e ->
                createQuestionnaire("General",
                        data, controllerManager,
                        questionnaireName, questionnaireDescription));

        JButton createEligibilityQuestionnaireButton = new JButton("Create Eligibility Questionnaire");
        createEligibilityQuestionnaireButton.addActionListener(e -> createQuestionnaire(
                "Eligibility",
                data,
                controllerManager,
                questionnaireName,
                questionnaireDescription));

        inputsPanel.add(questionnaireNamePanel);
        inputsPanel.add(questionnaireDescriptionPanel);
        JPanel leftAlign = new JPanel();
        leftAlign.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftAlign.add(groupsPanel);
        inputsPanel.add(leftAlign);
        inputsPanel.add(questionsPanel);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(addQuestionButton);
        buttonsPanel.add(deleteQuestionButton);
        inputsPanel.add(buttonsPanel);

        add(inputsPanel, BorderLayout.CENTER);
        JPanel buttons = new JPanel(new GridLayout(2,1));
        buttons.add(createQuestionnaireButton);
        buttons.add(createEligibilityQuestionnaireButton);
        add(buttons, BorderLayout.SOUTH);
        setTitle("Create Questionnaire");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();

        SetScreenToCenter.setCenter(this);
    }

    private void createQuestionnaire(String questionnaireType, CreateQuestionnaireInputsScreenInputData data,
                                     ControllerManager controllerManager,
                                     JTextField questionnaireName,
                                     JTextArea questionnaireDescription) {
        boolean selected = false;
        for (JRadioButton radioButton : studyGroups) {
            if (radioButton.isSelected()) {
                selected = true;
            }
        }
        if (questionnaireName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a name for the questionnaire");
        } else if (questionnaireDescription.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a description for the questionnaire");
        } else if (addedQuestions.size() == 0) {
            JOptionPane.showMessageDialog(null, "Please add at least one question to the questionnaire");
        } else if (!selected) {
            JOptionPane.showMessageDialog(null, "Please select a study group for the questionnaire");
        } else {
            ArrayList<String> groups = new ArrayList<>();
            for (JRadioButton radioButton : studyGroups) {
                if (radioButton.isSelected()) {
                    groups.add(radioButton.getText());
                }
            }
            controllerManager.createQuestionnaireController(questionnaireType, data.getStudyID(), data.getResearchID(), questionnaireName.getText(), questionnaireDescription.getText(), groups, addedQuestions.size(), addedQuestions);
            dispose();
        }
    }
}
