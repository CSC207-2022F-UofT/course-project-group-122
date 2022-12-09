package user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers;

import javax.swing.*;
import java.awt.*;

/**
 * The panel that contains the question and the answer for a text question.
 */
public class TextQuestionPanelForResearchers extends JPanel implements ResearchersQuestionPanel {
    /**
     * The text area that contains the answer.
     */
    private final JTextArea answerArea = new JTextArea(3, 20);

    /**
     * The question's type.
     */
    private final String type;

    /**
     * The question's variable.
     */
    private final String variable;

    /**
     * The question.
     */
    private final String question;


    /**
     * @param question The question.
     * @param type   The type of the question.
     * @param variable The variable of the question.
     * @param option The option of the question.
     * @param answer The answer of the question.
     */
    public TextQuestionPanelForResearchers(String question, String type, String variable, String option, String answer) {
        this.type = type;
        this.variable = variable;
        this.question = question;
        this.answerArea.setText(answer);

        setLayout(new BorderLayout());
        JPanel questionAnswerPanel = new JPanel(new BorderLayout());

        JScrollPane prevAnswerScrollPanel = new JScrollPane();
        JTextArea prevAnswerArea = new JTextArea(3, 20);
        prevAnswerArea.setText("Answer: "+ answer);
        prevAnswerArea.setEditable(false);
        prevAnswerScrollPanel.setViewportView(prevAnswerArea);
        JLabel questionLabel = new JLabel(question);
        questionAnswerPanel.add(questionLabel, BorderLayout.NORTH);
        questionAnswerPanel.add(prevAnswerScrollPanel, BorderLayout.CENTER);

        JScrollPane answerScrollPanel = new JScrollPane();
        answerArea.setLineWrap(true);
        answerScrollPanel.setViewportView(answerArea);

        add(questionAnswerPanel, BorderLayout.NORTH);
        add(answerScrollPanel, BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.black));

    }

    /**
     * @return The question's answer.
     */
    @Override
    public String getAnswer() {
        return answerArea.getText();
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

