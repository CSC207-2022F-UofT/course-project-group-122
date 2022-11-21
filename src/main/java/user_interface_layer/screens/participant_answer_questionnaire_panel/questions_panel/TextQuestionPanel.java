package user_interface_layer.screens.participant_answer_questionnaire_panel.questions_panel;

import javax.swing.*;
import java.awt.*;

public class TextQuestionPanel extends JPanel implements ParticipantsQuestionPanel {
    private final JTextArea answerArea = new JTextArea(3, 20);
    private final String type;
    private final String variable;

    private final String question;
    public TextQuestionPanel(String question, String type, String variable, String answer) {
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

    @Override
    public String getAnswer() {
        if (answerArea.getText().isEmpty()) {
            return "";
        }
        return answerArea.getText();
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
}

