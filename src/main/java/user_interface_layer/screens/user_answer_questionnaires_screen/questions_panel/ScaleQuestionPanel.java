package user_interface_layer.screens.user_answer_questionnaires_screen.questions_panel;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

/**
 * A panel for the scale question.
 */
public class ScaleQuestionPanel extends JPanel implements ParticipantsQuestionPanel {
    /**
     * The type of the question.
     */
    private final String type;
    /**
     * The variable of the question.
     */
    private final String variable;
    /**
     * The group of radio buttons that contain the options.
     */
    private final ButtonGroup buttonGroup = new ButtonGroup();
    /**
     * The question.
     */
    private final String question;

    /**
     * @param question The question.
     * @param type   The type of the question.
     * @param variable The variable of the question.
     * @param bottomLabel The bottom label of the scale.
     * @param topLabel The top label of the scale.
     * @param scale The scale.
     */
    public ScaleQuestionPanel(String question, String type, String variable, String bottomLabel, String topLabel, int scale) {
        this.variable = variable;
        this.type = type;
        this.question = question;
        setLayout(new BorderLayout());

        JLabel questionLabel = new JLabel(question);
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

        add(questionLabel, BorderLayout.NORTH);
        add(optionsScrollPanel, BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
     * @return The answer of the question.
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
     * @return The variable of the question.
     */
    @Override
    public String getVariable() {
        return variable;
    }

    /**
     * @return The panel of the question.
     */
    @Override
    public JPanel getQuestionPanel() {
        return this;
    }

    /**
     * @return The type of the question.
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
