package user_interface_layer.screens.create_questionnaire_inputs_screen.question_screen;

import user_interface_layer.screen_setters.SetLabelTextPanel;
import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TextQuestionScreen extends JFrame{
    private final JTextArea question = new JTextArea(5, 20);
    private final JTextField variable;

    public TextQuestionScreen(ArrayList<String> variables, List<QuestionModel> addedQuestions, DefaultTableModel model) {
        setTitle("Create Text Question");
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

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            if (question.getText().equals("") || variable.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            } else if (variables.contains(variable.getText())) {
                JOptionPane.showMessageDialog(null, "Variable already exists");
            }
            else {
                variables.add(variable.getText());
                QuestionModel newQuestion = new QuestionModel(question.getText(), variable.getText());
                model.addRow(new String[]{newQuestion.getType(),newQuestion.getContent(),newQuestion.getVariable(), newQuestion.getOptions()});
                addedQuestions.add(newQuestion);
                this.dispose();
            }
        });

        panel.add(questionPanel);
        panel.add(variablePanel);
        panel.add(submitButton);

        add(panel);
        pack();
        SetScreenToCenter s = new SetScreenToCenter(this);
    }

//    public static void main(String[] args) {
//        List<QuestionModel> addedQuestions = new ArrayList<>();
//        TextQuestionScreen t = new TextQuestionScreen(addedQuestions);
//        t.setVisible(true);
//    }


}
