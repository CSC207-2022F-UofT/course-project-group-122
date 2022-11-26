package user_interface_layer.screens.create_questionnaire_inputs_screen.question_screen;

import user_interface_layer.screen_setters.SetLabelTextPanel;
import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MCQuestionScreen extends JFrame {
    private final JTextArea question = new JTextArea(5, 20);
    private final JTextField variable;
    private List<String> options;


    public MCQuestionScreen(ArrayList<String> variables, List<QuestionModel> addedQuestions, DefaultTableModel model, int numOfOptions) {
        setTitle("Create MCQuestion");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
        List<JTextField> options = new ArrayList<>();
        for (int i = 0; i < numOfOptions; i++) {
            JTextField option = new JTextField(50);
            options.add(option);
            optionsPanel.add(new SetLabelTextPanel(new JLabel("Option " + (i + 1) + ": "), option));
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            List<String> stringOptions = options.stream().map(JTextField::getText).collect(Collectors.toList());

            if (question.getText().equals("") || variable.getText().equals("") || stringOptions.contains("")) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            } else if (variables.contains(variable.getText())) {
                JOptionPane.showMessageDialog(null, "Variable already exists");
            } else {
                variables.add(variable.getText());
                this.options = stringOptions;
                QuestionModel newQuestion = new QuestionModel(question.getText(), variable.getText(), this.options);
                model.addRow(new String[]{"MC", question.getText(), variable.getText(), String.join(",", this.options)});
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
        SetScreenToCenter s = new SetScreenToCenter(this);


    }

//    public static void main(String[] args) {
//        List<QuestionModel> addedQuestions = new ArrayList<>();
//        MCQuestionScreen mcQuestionScreen = new MCQuestionScreen(addedQuestions,3);
//        mcQuestionScreen.setVisible(true);
//
//    }

}
