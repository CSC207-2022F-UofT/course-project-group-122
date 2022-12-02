package user_interface_layer.screens.user_answer_questionnaires_screen.questions_panel;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

/**
 * It is the panel that contains the multiple choice question.
 */
public class MCQuestionPanel extends JPanel implements ParticipantsQuestionPanel {
    /**
     * The radio buttons that contain the options.
     */
    private final ButtonGroup buttonGroup;
    /**
     * The variable of the question.
     */
    private final String variable;
    /**
     * The type of the question.
     */
    private final String type;
    /**
     * The question.
     */
    private final String question;

    /**
     * Creates the panel for the multiple choice question.
     * @param question The question.
     * @param type    The type of the question.
     * @param variable The variable of the question.
     * @param options The options of the question.
     */
    public MCQuestionPanel(String question, String type, String variable, String[] options) {
        this.variable = variable;
        this.type = type;
        this.question = question;
        setLayout(new BorderLayout());
        JLabel questionLabel = new JLabel(question);
        add(questionLabel, BorderLayout.NORTH);
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

    /**
     * @return The answer of the question.
     */
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
