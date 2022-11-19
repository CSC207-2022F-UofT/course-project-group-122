package user_interface_layer.screens.check_questionnaire_versioned_answer_screen;

import user_interface_layer.SetScreenToCenter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CheckQuestionnaireVersionedAnswerScreen extends JFrame{

    public CheckQuestionnaireVersionedAnswerScreen(CheckQuestionnaireVersionedAnswerInputData data) {
        JLabel title = new JLabel("Questionnaire " + data.getQuestionnaireID(), SwingConstants.CENTER);

        JPanel answersPanel = new JPanel();
        answersPanel.setLayout(new BoxLayout(answersPanel, BoxLayout.Y_AXIS));

        for (String[] i : data.getVersionedAnswers()) {
            JPanel subPanel = new JPanel(new BorderLayout());
            subPanel.add(new JLabel(i[0]), BorderLayout.NORTH);
            JTextArea answer = new JTextArea(2,20);
            answer.setText(i[1]);
            answer.setEditable(false);
            answer.setLineWrap(true);
            subPanel.add(answer, BorderLayout.CENTER);
            answersPanel.add(subPanel);
        }
        answersPanel.setPreferredSize(new Dimension(500, 600));
        JScrollPane questionsScrollPanel = new JScrollPane();
        questionsScrollPanel.setViewportView(answersPanel);
        add(title, BorderLayout.NORTH);
        add(questionsScrollPanel, BorderLayout.CENTER);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        SetScreenToCenter s = new SetScreenToCenter(this);
    }

    public static void main(String[] args) {
        List<String[]> test = new ArrayList<>();
        test.add(new String[]{"What is your name?","John"});
        test.add(new String[]{"What is your age?","20"});
        test.add(new String[]{"What is your favorite color?","jrgsjgjgjkghjghsjkfdghskjfhgsjkfghsjkfghsfghskfjghsfjghsjf"});


        CheckQuestionnaireVersionedAnswerInputData data = new CheckQuestionnaireVersionedAnswerInputData(34, 23, test);
        CheckQuestionnaireVersionedAnswerScreen screen = new CheckQuestionnaireVersionedAnswerScreen(data);
        screen.setVisible(true);
    }

}
