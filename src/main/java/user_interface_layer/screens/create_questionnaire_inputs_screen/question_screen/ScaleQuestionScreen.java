package user_interface_layer.screens.create_questionnaire_inputs_screen.question_screen;

import user_interface_layer.screen_helper_classes.SetLabelTextPanel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The screen for creating a scale choice question.
 */
public class ScaleQuestionScreen extends JFrame {
    /**
     * The text area for the question.
     */
    private final JTextArea question = new JTextArea(5, 20);
    /**
     * The text field for the variable.
     */
    private final JTextField variable;
    /**
     * The text field for the minimum label
     */
    private final JTextField bottomLabel;
    /**
     * The text field for the maximum label
     */
    private final JTextField topLabel;

    /**
     * The constructor of the class.
     *
     * @param variables      The list of variables.
     * @param addedQuestions The list of questions that have been added.
     * @param model         The table model.
     * @param scale        The scale of the question.
     */
    public ScaleQuestionScreen(ArrayList<String> variables, List<QuestionModel> addedQuestions, DefaultTableModel model, int scale){
        setTitle("Create Scale Question");
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


        bottomLabel = new JTextField(20);
        JPanel bottomLabelPanel = new SetLabelTextPanel(new JLabel("Bottom Label: "), bottomLabel);

        topLabel = new JTextField(20);
        JPanel topLabelPanel = new SetLabelTextPanel(new JLabel("Top Label: "), topLabel);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            if (question.getText().equals("") || variable.getText().equals("") || bottomLabel.getText().equals("") || topLabel.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            } else if (variables.contains(variable.getText())) {
                JOptionPane.showMessageDialog(null, "Variable already exists");
            }
            else {
                variables.add(variable.getText());
                QuestionModel newQuestion = new QuestionModel(question.getText(), variable.getText(), bottomLabel.getText(), topLabel.getText(), scale);
                model.addRow(new String[]{newQuestion.getType(), newQuestion.getContent(), newQuestion.getVariable(), newQuestion.getOptions()});
                addedQuestions.add(newQuestion);
                this.dispose();
            }
        });

        panel.add(questionPanel);
        panel.add(variablePanel);
        panel.add(bottomLabelPanel);
        panel.add(topLabelPanel);
        panel.add(submitButton);

        add(panel);
        pack();
        SetScreenToCenter.setCenter(this);
    }
}
