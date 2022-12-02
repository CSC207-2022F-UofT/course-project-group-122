package user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

/**
 * The panel that contains the question and the answer for a multiple choice question.
 */
public class MCQuestionPanelForResearchers extends JPanel implements ResearchersQuestionPanel {
    /**
     *  The groups of radio buttons that represent the possible answers.
     */
    private final ButtonGroup buttonGroup;
    /**
     * The question's variable.
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
     * Creates a new panel for a multiple choice question.
     * @param question The question.
     * @param type    The type of the question.
     * @param variable The variable of the question.
     * @param options The options of the question.
     * @param answers The answers of the question.
     */
    public MCQuestionPanelForResearchers(String question,
                                         String type,
                                         String variable,
                                         String[] options,
                                         String answers) {
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
