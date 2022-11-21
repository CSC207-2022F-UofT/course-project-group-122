package user_interface_layer.screens.edit_questionnaire;

import use_cases.edit_questionnaire_screen_data.EditQuestionnaireScreenInputData;
import user_interface_layer.ScreenManager;
import user_interface_layer.SetLabelTextPanel;
import user_interface_layer.SetScreenToCenter;
import user_interface_layer.SetTableModel;
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

public class EditQuestionnaireScreen extends JFrame {
    public EditQuestionnaireScreenInputData data;
    Map<String, String[]> existingQuestions;
    List<QuestionModel> addedQuestions = new ArrayList<>();
    List<JRadioButton> studyGroups = new ArrayList<>();

    public EditQuestionnaireScreen(EditQuestionnaireScreenInputData data, ControllerManager controllerManager) {
        existingQuestions = data.getQuestions();

        JPanel headerPanel = new JPanel();
        setLayout(new BorderLayout());
        JTextField questionnaireName = new JTextField(data.getQuestionnaireName(),30);
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

//        JScrollPane scrollPane2 = new JScrollPane();
//        JTextArea reasonForModification = new JTextArea(3, 20);
//        reasonForModification.setLineWrap(true);
//        scrollPane2.setViewportView(reasonForModification);
//        JPanel reasonForModificationPanel = new JPanel(new GridLayout(2, 1));
//        JLabel reasonForModificationLabel = new JLabel("Reason for Modification: ", SwingConstants.CENTER);
//        reasonForModificationPanel.add(reasonForModificationLabel);
//        reasonForModificationPanel.add(scrollPane2);

        questionnaireDescriptionPanel.add(questionnaireDescriptionLabel);
        questionnaireDescriptionPanel.add(scrollPane);
//        questionnaireDescriptionPanel.add(reasonForModificationPanel);

        JPanel groupsPanel = new JPanel();
        JLabel groupsLabel = new JLabel("Select Target groups: ", SwingConstants.CENTER);
        groupsPanel.setLayout(new BoxLayout(groupsPanel, BoxLayout.Y_AXIS));
        groupsPanel.add(groupsLabel);
        for (String group : data.getStudyGroups()) {
            JRadioButton radioButton = new JRadioButton(group);
            studyGroups.add(radioButton);
            groupsPanel.add(radioButton);
        }


        JPanel questionsPanel = new JPanel();
        questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));
        JLabel questionsLabel = new JLabel("Questions: ", SwingConstants.CENTER);

        JScrollPane previousQuestionsScrollPane = new JScrollPane();
        SetTableModel setTableModel2 = new SetTableModel(new String[]{"Type", "Question", "Variable", "Options"});
        DefaultTableModel model = setTableModel2.getModel();
        JTable table = setTableModel2.getTable();
        previousQuestionsScrollPane.setViewportView(table);
        for (Map.Entry<String, String[]> entry : existingQuestions.entrySet()) {
            String[] question = new String[4];
            question[1] = entry.getKey();
            question[0] = entry.getValue()[0];
            question[2] = entry.getValue()[1];
            question[3] = entry.getValue()[2];
            model.addRow(question);
        }

        JScrollPane questionsScrollPane = new JScrollPane();
        SetTableModel setTableModel = new SetTableModel(new String[]{"Type", "Question", "Variable", "Options"});
        DefaultTableModel questionsTableModel = setTableModel.getModel();
        JTable questionsTable = setTableModel.getTable();

        questionsScrollPane.setViewportView(questionsTable);

        questionsPanel.add(questionsLabel, BorderLayout.NORTH);

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
                        MCQuestionScreen mcQuestionScreen = new MCQuestionScreen(addedQuestions, questionsTableModel, num);
                        mcQuestionScreen.setVisible(true);
                        mcNumOfChoices.dispose();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a number");
                }
            });
            mcNumOfChoices.add(numOfChoices, BorderLayout.CENTER);
            mcNumOfChoices.add(continueButton, BorderLayout.SOUTH);
            mcNumOfChoices.pack();
            SetScreenToCenter s = new SetScreenToCenter(mcNumOfChoices);
            mcNumOfChoices.setVisible(true);
        });

        addScaleQuestion.addActionListener(e -> {
            JFrame numOfScale = new JFrame();
            numOfScale.setLayout(new BorderLayout());
            numOfScale.setTitle("Number of Choices");
            numOfScale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JTextField numOfChoices = new JTextField(10);
            JButton continueButton = new JButton("Continue");
            continueButton.addActionListener(e1 -> {
                try {
                    int num = Integer.parseInt(numOfChoices.getText());
                    if (num < 2) {
                        JOptionPane.showMessageDialog(null, "Please enter a number greater than 1");
                    } else {
                        ScaleQuestionScreen scaleQuestionScreen = new ScaleQuestionScreen(addedQuestions, questionsTableModel, num);
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
            SetScreenToCenter s = new SetScreenToCenter(numOfScale);
            numOfScale.setVisible(true);

        });

        addTextQuestion.addActionListener(e -> {
            TextQuestionScreen textQuestionScreen = new TextQuestionScreen(addedQuestions, questionsTableModel);
            textQuestionScreen.setVisible(true);
        });

        JButton deletePreviousQuestionButton = new JButton("Delete Previous Question");
        deletePreviousQuestionButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                String question = (String) table.getValueAt(row, 1);
                existingQuestions.remove(question);
                model.removeRow(row);
            }else {
                JOptionPane.showMessageDialog(null, "Please select a question to delete");
            }
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

        JButton publishButton = new JButton("Publish");
        publishButton.addActionListener(e->
                controllerManager.publishQuestionnaire(data.getQuestionnaireID(), data.getStudyID()));


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
                JOptionPane.showMessageDialog(null, "Please enter a name for the questionnaire");
            } else if (questionnaireDescription.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a description for the questionnaire");
            } else if (addedQuestions.size() + existingQuestions.size() == 0) {
                JOptionPane.showMessageDialog(null, "Please add at least one question to the questionnaire");
            }
            else if (!selected) {
                JOptionPane.showMessageDialog(null, "Please select at least one study group");
            } else {
                ArrayList<String> studyGroupNames = new ArrayList<>();
                for (JRadioButton radioButton : studyGroups) {
                    if (radioButton.isSelected()) {
                        studyGroupNames.add(radioButton.getName());
                    }
                }
                for (QuestionModel question : addedQuestions) {
                    existingQuestions.put(question.getVariable(), new String[]{question.getType(), question.getQuestion(), question.getOptions()});
                }
                controllerManager.editQuestionnaire(data.getStudyID(), data.getQuestionnaireID(),questionnaireName.getText(), questionnaireDescription.getText(), studyGroupNames,existingQuestions);
                this.dispose();
            }
        });

        inputsPanel.add(questionnaireNamePanel);
        inputsPanel.add(questionnaireDescriptionPanel);
        inputsPanel.add(groupsPanel);
        inputsPanel.add(questionsPanel);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(addQuestionButton);
        buttonsPanel.add(deleteQuestionButton);
        buttonsPanel.add(deletePreviousQuestionButton);
        buttonsPanel.add(publishButton);
        inputsPanel.add(buttonsPanel);

        add(inputsPanel, BorderLayout.CENTER);
        add(createQuestionnaireButton, BorderLayout.SOUTH);
        setTitle("Edit Questionnaire");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();

        SetScreenToCenter s = new SetScreenToCenter(this);

    }

    public static void main(String[] args) {
        HashMap<String, String[]> existingQuestions = new HashMap<>();
        existingQuestions.put("What is your name?", new String[]{"Text", "name", "John"});
        existingQuestions.put("What is your age?", new String[]{"Scale", "age", "20"});

        EditQuestionnaireScreenInputData data = new EditQuestionnaireScreenInputData(44, 1, "Questionnaire 1", "This is a description",new ArrayList<>(Arrays.asList("me", "you", "Question 3")),existingQuestions);
EditQuestionnaireScreen editQuestionnaireScreen = new EditQuestionnaireScreen(data , new ControllerManager(new ScreenManager()));
        editQuestionnaireScreen.setVisible(true);
    }
}

