package user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

/**
 * The panel that contains the question and the answer for a scale question.
 */
public class ScaleQuestionPanelForResearchers extends JPanel implements ResearchersQuestionPanel {
    /**
     * The question's type.
     */
    private final String type;
    /**
     * The question's variable.
     */
    private final String variable;
    /**
     * The button group that contains the radio buttons that represent the possible answers.
     */
    private final ButtonGroup buttonGroup = new ButtonGroup();
    /**
     * The question.
     */
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

    /**
     * @return The question's answer.
     */
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

    /**
     * @return The question's variable.
     */
    @Override
    public String getVariable() {
        return variable;
    }

    /**
     * @return The question's panel.
     */
    @Override
    public JPanel getQuestionPanel() {
        return this;
    }

    /**
     * @return The question's type.
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * @return The question.
     */
    @Override
    public String getQuestion() {
        return question;
    }

}
