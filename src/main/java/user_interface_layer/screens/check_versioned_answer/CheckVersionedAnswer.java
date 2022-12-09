package user_interface_layer.screens.check_versioned_answer;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_versioned_answer.FetchVersionedAnswerResponseModel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;

import javax.swing.*;
import java.awt.*;

/**
 * The screen where the researcher can check a specific versioned answer of a questionnaire.
 */
public class CheckVersionedAnswer extends JFrame{

    /**
     * @param data The data needed to display the screen.
     */
    public CheckVersionedAnswer(@NotNull FetchVersionedAnswerResponseModel data) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel title = new JLabel("Questionnaire " + data.getQuestionnaireID(), SwingConstants.CENTER);

        JPanel answersPanel = new JPanel();
        answersPanel.setLayout(new BoxLayout(answersPanel, BoxLayout.Y_AXIS));

        setQuestionAnswerPanel(data, answersPanel);

        answersPanel.setPreferredSize(new Dimension(500, 600));
        JScrollPane questionsScrollPanel = new JScrollPane();
        questionsScrollPanel.setViewportView(answersPanel);
        add(title, BorderLayout.NORTH);
        add(questionsScrollPanel, BorderLayout.CENTER);
        pack();
        SetScreenToCenter.setCenter(this);
    }

    /**
     * Creates the panel that contains the answers.
     * @param data The data needed to display the screen.
     * @param answersPanel The panel where the answers will be displayed.
     */
    private static void setQuestionAnswerPanel(@NotNull FetchVersionedAnswerResponseModel data, JPanel answersPanel) {
        for (String[] i : data.getVersionedAnswers()) {
            JPanel subPanel = new JPanel(new BorderLayout());
            subPanel.add(new JLabel(i[0]), BorderLayout.NORTH);
            JTextArea answer = new JTextArea(2,5);
            answer.setText(i[1]);
            answer.setEditable(false);
            answer.setLineWrap(true);
            subPanel.add(answer, BorderLayout.CENTER);
            answersPanel.add(subPanel);
        }
    }

}
