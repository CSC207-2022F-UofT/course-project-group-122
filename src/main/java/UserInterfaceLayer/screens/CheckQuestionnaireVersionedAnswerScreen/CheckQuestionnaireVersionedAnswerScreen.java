package UserInterfaceLayer.screens.CheckQuestionnaireVersionedAnswerScreen;

import UserInterfaceLayer.SetScreenToCenter;
import UserInterfaceLayer.TestScreens;
import UserInterfaceLayer.screens.CheckQuestionnaireScreen.CheckQuestionnaireInputData;

import javax.swing.*;
import java.awt.*;

public class CheckQuestionnaireVersionedAnswerScreen extends JFrame{

    public CheckQuestionnaireVersionedAnswerScreen(CheckQuestionnaireInputData data) {
        JScrollPane answerScroll = new JScrollPane();
        JPanel answers = new JPanel();
        setLayout(new BoxLayout(answers, BoxLayout.Y_AXIS));
        for (String[] i : data.getFormattedQuestions()){
            JPanel sub = new JPanel(new GridLayout(2,1));
            JLabel question = new JLabel(i[0]);
            JScrollPane subScroll = new JScrollPane();
            JTextArea answer = new JTextArea(3,20);
            subScroll.setViewportView(answer);
            sub.add(question);
            sub.add(subScroll);
        }
        answers.setPreferredSize(new Dimension(500, 600));
        answerScroll.setViewportView(answers);
        add(answerScroll);
        pack();
        SetScreenToCenter s = new SetScreenToCenter(this);
    }
}
