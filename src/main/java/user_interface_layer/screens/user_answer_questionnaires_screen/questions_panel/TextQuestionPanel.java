package user_interface_layer.screens.user_answer_questionnaires_screen.questions_panel;

import javax.swing.*;
import java.awt.*;

/**
 * The panel for the text question.
 */
public class TextQuestionPanel extends JPanel implements ParticipantsQuestionPanel {
    /**
     * The JTextArea of the question.
     */
    private final JTextArea answerArea = new JTextArea(3, 20);
    /**
     * The type of the question.
     */
    private final String type;
    /**
     * The variable of the question.
     */
    private final String variable;

    /**
     * The question.
     */
    private final String question;

    /**
     * Creates the panel for the text question.
     * @param question The question.
     * @param type   The type of the question.
     * @param variable The variable of the question.
     */
    public TextQuestionPanel(String question, String type, String variable) {
        this.type = type;
        this.variable = variable;
        this.question = question;

        setLayout(new BorderLayout());

        JScrollPane answerScrollPanel = new JScrollPane();
        JLabel questionLabel = new JLabel(question);
        answerArea.setLineWrap(true);
        answerScrollPanel.setViewportView(answerArea);

        add(questionLabel, BorderLayout.NORTH);
        add(answerScrollPanel, BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.black));

    }

    /**
     * @return The answer of the question.
     */
    @Override
    public String getAnswer() {
        if (answerArea.getText().isEmpty()) {
            return "";
        }
        return answerArea.getText();
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

