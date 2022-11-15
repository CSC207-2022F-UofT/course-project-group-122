package screens.QuestionPanels;

import javax.swing.*;
import java.awt.*;

public class TextQuestionPanel extends JPanel implements QuestionPanels{
    private final TextQuestionInputData data;
    private JTextArea answerArea;

    public TextQuestionPanel(TextQuestionInputData data) {
        this.data = data;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JScrollPane questionScrollPanel = new JScrollPane();
        JTextArea questionArea = new JTextArea();
        JScrollPane answerScrollPanel = new JScrollPane();

        questionArea.setColumns(20);
        questionArea.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        questionArea.setRows(2);
        questionArea.setEditable(false);
        questionArea.setLineWrap(true);
        questionArea.setText(data.getQuestion());
        questionScrollPanel.setViewportView(questionArea);

        answerArea = new JTextArea();
        answerArea.setColumns(20);
        answerArea.setRows(5);
        answerArea.setLineWrap(true);
        answerScrollPanel.setViewportView(answerArea);

        add(questionScrollPanel);
        add(answerScrollPanel);

    }


    @Override
    public JPanel getQuestionPanel() {
        return this;
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
        return data.getVariable();
    }
}
