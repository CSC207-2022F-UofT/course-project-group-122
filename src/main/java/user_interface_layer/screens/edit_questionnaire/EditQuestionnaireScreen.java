package user_interface_layer.screens.edit_questionnaire;

import org.jetbrains.annotations.NotNull;
import use_cases.edit_questionnaire_screen_data.EditQuestionnaireScreenInputData;
import user_interface_layer.screen_helper_classes.SetLabelTextPanel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;
import user_interface_layer.screens.create_questionnaire_inputs_screen.question_screen.MCQuestionScreen;
import user_interface_layer.screens.create_questionnaire_inputs_screen.question_screen.ScaleQuestionScreen;
import user_interface_layer.screens.create_questionnaire_inputs_screen.question_screen.TextQuestionScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * The screen for editing a questionnaire.
 */
public class EditQuestionnaireScreen extends JFrame {
    /**
     * The list of questions from the questionnaire.
     */
    private final List<QuestionModel> existingQuestions;
    /**
     * The list of questions that need to be added.
     */
    private final List<QuestionModel> addedQuestions = new ArrayList<>();
    /**
     * The list of study groups.
     */
    private final List<JRadioButton> studyGroups = new ArrayList<>();

    /**
     * The list of variables.
     */
    private final ArrayList<String> variables;

    /**
     * @param data The data for the screen.
     * @param controllerManager The controller manager.
     */
    public EditQuestionnaireScreen(@NotNull EditQuestionnaireScreenInputData data, ControllerManager controllerManager) {
        this.variables = (ArrayList<String>) data.getPreviousVariables();
        existingQuestions = data.getQuestions();

        setLayout(new BorderLayout());
        JTextField questionnaireName = new JTextField(data.getQuestionnaireName(), 30);
        JTextArea questionnaireDescription = new JTextArea(3, 20);
        questionnaireDescription.setText(data.getQuestionnaireDescription());

        JPanel inputsPanel = new JPanel();
        inputsPanel.setLayout(new BoxLayout(inputsPanel, BoxLayout.Y_AXIS));

        JPanel questionnaireNamePanel = new SetLabelTextPanel(new JLabel("Questionnaire Name: "), questionnaireName);

        JPanel questionnaireDescriptionPanel = new JPanel(new GridLayout(3, 1));
        JLabel questionnaireDescriptionLabel = new JLabel("Questionnaire Description: ", SwingConstants.CENTER);
        questionnaireDescription.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(questionnaireDescription);


        questionnaireDescriptionPanel.add(questionnaireDescriptionLabel);
        questionnaireDescriptionPanel.add(scrollPane);

        JPanel groupsPanel = new JPanel();
        JLabel groupsLabel = new JLabel("Select target groups: ", SwingConstants.CENTER);
        groupsPanel.setLayout(new BoxLayout(groupsPanel, BoxLayout.Y_AXIS));
        groupsPanel.add(groupsLabel);
        for (String group : data.getStudyGroups()) {
            JRadioButton radioButton = new JRadioButton(group);
            studyGroups.add(radioButton);
            groupsPanel.add(radioButton);
        }


        JPanel questionsPanel = new JPanel();
        questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));
        JScrollPane previousQuestionsScrollPane = new JScrollPane();
        SetTableModel setTableModel2 = new SetTableModel(new String[]{"Type", "Previous Questions", "Variable", "Options"});
        DefaultTableModel model = setTableModel2.getModel();
        JTable table = setTableModel2.getTable();
        previousQuestionsScrollPane.setViewportView(table);
        for (QuestionModel questionModel : existingQuestions) {
            String[] question = new String[4];
            question[0] = questionModel.getType();
            question[1] = questionModel.getContent();
            question[2] = questionModel.getVariable();
            question[3] = questionModel.getOptions();
            model.addRow(question);
        }

        JScrollPane questionsScrollPane = new JScrollPane();
        SetTableModel setTableModel = new SetTableModel(new String[]{"Type", "New Questions", "Variable", "Options"});
        DefaultTableModel questionsTableModel = setTableModel.getModel();
        JTable questionsTable = setTableModel.getTable();

        questionsScrollPane.setViewportView(questionsTable);

        JPanel questionsTablePanel = new JPanel();
        questionsTablePanel.setLayout(new BoxLayout(questionsTablePanel, BoxLayout.Y_AXIS));
        questionsTablePanel.add(previousQuestionsScrollPane);
        questionsTablePanel.add(questionsScrollPane);
        questionsPanel.add(questionsTablePanel, BorderLayout.CENTER);


        JButton addQuestionButton = new JButton("Add Question");
        JPopupMenu addQuestionMenu = new JPopupMenu();
        JMenuItem addMCQuestion = new JMenuItem("MC Question");
        JMenuItem addScaleQuestion = new JMenuItem("Scale Question");
        JMenuItem addTextQuestion = new JMenuItem("Text Question");
        addQuestionMenu.add(addTextQuestion);
        addQuestionMenu.add(addScaleQuestion);
        addQuestionMenu.add(addMCQuestion);
        addQuestionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                addQuestionMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        });
        addMCQuestion.addActionListener(e -> {
            JFrame mcNumOfChoices = new JFrame();
            mcNumOfChoices.setLayout(new BorderLayout());
            mcNumOfChoices.setTitle("Number of Choices");
            mcNumOfChoices.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
            numOfScale.setTitle("Number of Choices");
            numOfScale.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
                        numOfScale.dispose();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a number");
                }
            });
            numOfScale.add(numOfChoices, BorderLayout.CENTER);
            numOfScale.add(continueButton, BorderLayout.SOUTH);
            numOfScale.pack();
            SetScreenToCenter.setCenter(numOfScale);
            numOfScale.setVisible(true);

        });

        addTextQuestion.addActionListener(e -> {
            TextQuestionScreen textQuestionScreen = new TextQuestionScreen(variables, addedQuestions, questionsTableModel);
            textQuestionScreen.setVisible(true);
        });

        JButton deletePreviousQuestionButton = new JButton("Delete Previous Question");
        deletePreviousQuestionButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                String variable = (String) table.getValueAt(row, 2);
                existingQuestions.remove(row);
                variables.remove(variable);
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a question to delete");
            }
        });

        JButton deleteQuestionButton = new JButton("Delete Question");
        deleteQuestionButton.addActionListener(e -> {
            if (addedQuestions.isEmpty()) {
                JOptionPane.showMessageDialog(null, "There are no questions to delete");
            } else {
                int row = questionsTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a question to delete");
                } else {
                    variables.remove(row);
                    addedQuestions.remove(row);
                    questionsTableModel.removeRow(row);
                }
            }
        });

        JButton createQuestionnaireButton = createSaveQuestionnaireButton(data,
                controllerManager,
                questionnaireName,
                questionnaireDescription);

        inputsPanel.add(questionnaireNamePanel);
        inputsPanel.add(questionnaireDescriptionPanel);
        inputsPanel.add(groupsPanel);
        inputsPanel.add(questionsPanel);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(addQuestionButton);
        buttonsPanel.add(deleteQuestionButton);
        buttonsPanel.add(deletePreviousQuestionButton);
        inputsPanel.add(buttonsPanel);

        add(inputsPanel, BorderLayout.CENTER);
        add(createQuestionnaireButton, BorderLayout.SOUTH);
        setTitle("Edit Questionnaire");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        SetScreenToCenter.setCenter(this);
    }

    /**
     * Creates a button that saves the questionnaire to the database
     * @param data the data
     * @param controllerManager the controller manager
     * @param questionnaireName the questionnaire name
     * @param questionnaireDescription the questionnaire description
     * @return The button to save the questionnaire
     */
    @NotNull
    private JButton createSaveQuestionnaireButton(EditQuestionnaireScreenInputData data,
                                                  ControllerManager controllerManager,
                                                  JTextField questionnaireName,
                                                  JTextArea questionnaireDescription) {
        JButton createQuestionnaireButton = new JButton("Save Questionnaire");
        createQuestionnaireButton.addActionListener(e -> {
            boolean selected = false;
            for (JRadioButton radioButton : studyGroups) {
                if (radioButton.isSelected()) {
                    selected = true;
                    break;
                }
            }
            if (questionnaireName.getText().equals("")) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a name for the questionnaire");
            } else if (questionnaireDescription.getText().equals("")) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a description for the questionnaire");
            } else if (addedQuestions.size() + existingQuestions.size() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Please add at least one question to the questionnaire");
            } else if (!selected) {
                JOptionPane.showMessageDialog(null,
                        "Please select at least one study group");
            } else {
                ArrayList<String> studyGroupNames = new ArrayList<>();
                for (JRadioButton radioButton : studyGroups) {
                    if (radioButton.isSelected()) {
                        studyGroupNames.add(radioButton.getName());
                    }
                }
                existingQuestions.addAll(addedQuestions);
                controllerManager.editQuestionnaire(
                        data.getStudyID(),
                        data.getQuestionnaireID(),
                        data.getResearcherID(),
                        questionnaireName.getText(),
                        questionnaireDescription.getText(),
                        studyGroupNames,
                        existingQuestions);
                this.dispose();
            }
        });
        return createQuestionnaireButton;
    }
}

