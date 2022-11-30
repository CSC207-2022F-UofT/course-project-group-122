package user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class MCQuestionPanelForResearchers extends JPanel implements ResearchersQuestionPanel {
    private final ButtonGroup buttonGroup;
    private final String variable;
    private final String type;
    private final String question;
    public MCQuestionPanelForResearchers(String question, String type, String variable, String[] options, String answers) {
        this.variable = variable;
        this.type = type;
        this.question = question;
        setLayout(new BorderLayout());
        JPanel questionAnswerPanel = new JPanel(new BorderLayout());
        JLabel questionLabel = new JLabel(question);
        JLabel answerLabel = new JLabel("Answer: " + answers);
        questionAnswerPanel.add(questionLabel, BorderLayout.NORTH);
        questionAnswerPanel.add(answerLabel, BorderLayout.CENTER);
        add(questionAnswerPanel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        buttonGroup = new ButtonGroup();
        for (String option : options) {
            JRadioButton radioButton = new JRadioButton(option);
            buttonGroup.add(radioButton);
            optionsPanel.add(radioButton);
        }
        add(optionsPanel, BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.black));

    }

    @Override
    public String getAnswer() {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText().split("\\.")[0];
            }
        }
        return "";
    }

    @Override
    public String getVariable() {
        return variable;
    }

    @Override
    public JPanel getQuestionPanel() {
        return this;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getQuestion() {
        return question;
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("MCQuestionPanelForResearchers");
//        frame.setContentPane(new MCQuestionPanelForResearchers("question", "type", "variable", new String[]{"option1", "option2", "option3"}, "answer"));
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }

}
