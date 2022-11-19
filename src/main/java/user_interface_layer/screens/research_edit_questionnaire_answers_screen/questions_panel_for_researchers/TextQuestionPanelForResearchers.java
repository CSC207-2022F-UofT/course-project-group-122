package user_interface_layer.screens.research_edit_questionnaire_answers_screen.questions_panel_for_researchers;

import javax.swing.*;
import java.awt.*;

public class TextQuestionPanelForResearchers extends JPanel implements ResearchersQuestionPanel {
    private final JTextArea answerArea = new JTextArea(3, 20);
    private final String type;
    private final String variable;

    private final String question;
    public TextQuestionPanelForResearchers(String question, String type, String variable, String option, String answer) {
        this.type = type;
        this.variable = variable;
        this.question = question;

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

//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(new TextQuestionPanelForResearchers("What is your name?", "text", "name", "text", "John"));
//        frame.pack();
//        frame.setVisible(true);
//    }
}

