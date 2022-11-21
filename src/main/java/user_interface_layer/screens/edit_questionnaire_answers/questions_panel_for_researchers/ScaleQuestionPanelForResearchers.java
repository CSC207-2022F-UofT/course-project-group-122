package user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class ScaleQuestionPanelForResearchers extends JPanel implements ResearchersQuestionPanel {
    private final String type;
    private final String variable;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final String question;

    public ScaleQuestionPanelForResearchers(String question, String type, String variable, String bottomLabel, String topLabel, int scale, String answer) {
        this.variable = variable;
        this.type = type;
        this.question = question;
        setLayout(new BorderLayout());
        JPanel questionAnswerPanel = new JPanel(new BorderLayout());
        JLabel questionLabel = new JLabel(question);
        JLabel answerLabel = new JLabel("Answer: " + answer);
        questionAnswerPanel.add(questionLabel, BorderLayout.NORTH);
        questionAnswerPanel.add(answerLabel, BorderLayout.CENTER);

        JScrollPane optionsScrollPanel = new JScrollPane();
        JPanel optionsPanel = new JPanel();

        optionsPanel.setLayout(new FlowLayout());
        optionsPanel.add(new JLabel(bottomLabel + " ", SwingConstants.CENTER));
        for (int i = 0; i < scale; i++) {
            JRadioButton button = new JRadioButton(String.valueOf(i));
            buttonGroup.add(button);
            optionsPanel.add(button);
        }
        optionsPanel.add(new JLabel(" "+ topLabel, SwingConstants.CENTER));
        optionsScrollPanel.setViewportView(optionsPanel);

        add(questionAnswerPanel, BorderLayout.NORTH);
        add(optionsScrollPanel, BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.black));


    }

    @Override
    public String getAnswer() {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
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
//        JFrame frame = new JFrame("ScaleQuestionPanelForResearchers");
//        frame.setContentPane(new ScaleQuestionPanelForResearchers("Question", "Scale", "Variable", "Bottom", "Top", 5, "2").getQuestionPanel());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
