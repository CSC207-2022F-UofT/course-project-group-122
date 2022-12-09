package user_interface_layer.screens.create_questionnaire_inputs_screen.question_screen;

import user_interface_layer.screen_helper_classes.SetLabelTextPanel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The screen for creating a multiple choice question.
 */
public class MCQuestionScreen extends JFrame {
    /**
     * The text area for the question.
     */
    private final JTextArea question = new JTextArea(5, 20);
    /**
     * The text field for the variable.
     */
    private final JTextField variable;
    /**
     * The list of options.
     */
    private List<String> options;

    public MCQuestionScreen(List<String> variables, List<QuestionModel> addedQuestions, DefaultTableModel model, int numOfOptions) {
        setTitle("Create MCQuestion");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel questionPanel = new JPanel(new GridLayout(2, 1));
        JLabel questionLabel = new JLabel("Question: ", SwingConstants.CENTER);
        JScrollPane scrollPane = new JScrollPane();
        question.setLineWrap(true);
        scrollPane.setViewportView(question);

        questionPanel.add(questionLabel);
        questionPanel.add(scrollPane);

        variable = new JTextField(20);
        JPanel variablePanel = new SetLabelTextPanel(new JLabel("Variable: "), variable);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        List<JTextField> mcOptions = new ArrayList<>();
        for (int i = 0; i < numOfOptions; i++) {
            JTextField option = new JTextField(50);
            mcOptions.add(option);
            optionsPanel.add(new SetLabelTextPanel(new JLabel("Option " + (i + 1) + ": "), option));
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            List<String> stringOptions = mcOptions.stream().map(JTextField::getText).collect(Collectors.toList());

            if (question.getText().equals("") || variable.getText().equals("") || stringOptions.contains("")) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            } else if (variables.contains(variable.getText())) {
                JOptionPane.showMessageDialog(null, "Variable already exists");
            } else {
                variables.add(variable.getText());
                this.options = stringOptions;
                QuestionModel newQuestion = new QuestionModel(question.getText(), variable.getText(), this.options);
                model.addRow(new String[]{newQuestion.getType(), newQuestion.getContent(), newQuestion.getVariable(), newQuestion.getOptions()});
                addedQuestions.add(newQuestion);
                this.dispose();
            }
        });
        setLayout(new BorderLayout());
        panel.add(questionPanel);
        panel.add(variablePanel);
        panel.add(optionsPanel);
        add(panel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
        pack();
        SetScreenToCenter.setCenter(this);
    }


}
