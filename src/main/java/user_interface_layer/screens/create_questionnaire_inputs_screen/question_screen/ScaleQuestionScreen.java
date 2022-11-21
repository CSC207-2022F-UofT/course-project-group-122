package user_interface_layer.screens.create_questionnaire_inputs_screen.question_screen;

import user_interface_layer.screen_setters.SetLabelTextPanel;
import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ScaleQuestionScreen extends JFrame {
    private final JTextArea question = new JTextArea(5, 20);
    private final JTextField variable;
    private final JTextField bottomLabel;
    private final JTextField topLabel;

    public ScaleQuestionScreen(List<QuestionModel> addedQuestions, DefaultTableModel model, int scale){
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
            } else {
                QuestionModel newQuestion = new QuestionModel(question.getText(), variable.getText(), bottomLabel.getText(), topLabel.getText(), scale);
                model.addRow(new String[]{"Scale",question.getText(), variable.getText(), bottomLabel.getText()+ " - " + scale + " - "+ topLabel.getText()});
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
        SetScreenToCenter s = new SetScreenToCenter(this);

    }
//
//    public static void main(String[] args) {
//        List<QuestionModel> addedQuestions = new ArrayList<>();
//        ScaleQuestionScreen t = new ScaleQuestionScreen(addedQuestions, 5);
//        t.setVisible(true);
//    }


}
