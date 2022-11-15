package screens.AnswerQuestionnaireScreens;

import screens.QuestionPanels.QuestionPanels;
import screens.SetScreenToCenter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class AnswerQuestionnaireScreen extends JFrame {
    private AnswerQuestionnaireInputData data;
    private AnswerQuestionnaireActionListener actionListener;

    public AnswerQuestionnaireScreen(AnswerQuestionnaireInputData data) {
        this.data = data;
        this.actionListener = new AnswerQuestionnaireActionListener(data);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setTitle(String.valueOf(data.getQuestionnaireID()));

        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());

        JLabel questionnaireNameLabel = new JLabel(data.getQuestionnaireName(), SwingConstants.CENTER);
        questionnaireNameLabel.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 16));

        JScrollPane descriptionScrollPanel = new JScrollPane();
        JTextArea descriptionArea = new JTextArea();

        descriptionArea.setColumns(20);
        descriptionArea.setFont(new Font("Helvetica Neue", Font.ITALIC, 13)); // NOI18N
        descriptionArea.setRows(2);
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setText(data.getQuestionnaireDescription());
        descriptionScrollPanel.setViewportView(descriptionArea);

        header.add(questionnaireNameLabel, BorderLayout.NORTH);
        header.add(descriptionScrollPanel, BorderLayout.CENTER);



        JPanel questionsPanel = new JPanel();
        List<QuestionPanels> questionPanels = this.data.getQuestions();
        questionsPanel.setLayout(new GridLayout(questionPanels.size(), 1));

        questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));

        for (QuestionPanels questionPanel : questionPanels) {
            questionsPanel.add(questionPanel.getQuestionPanel());
        }
        questionsPanel.setPreferredSize(new Dimension(500, 600));
        JScrollPane questionsScrollPanel = new JScrollPane(questionsPanel);

        JPanel submitPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            HashMap<String, String> answers = new HashMap<>();
            for (QuestionPanels questionPanel : questionPanels) {
                if (questionPanel.getAnswer().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please answer all questions");
                    break;
                } else {
                    answers.put(questionPanel.getVariable(), questionPanel.getAnswer());
                }
            }
            if (answers.size() == questionPanels.size()) {
                actionListener.submitAnswers(answers);
            }
        });
        submitPanel.add(submitButton);

        add(header, BorderLayout.NORTH);
        add(questionsScrollPanel, BorderLayout.CENTER);
        add(submitPanel, BorderLayout.SOUTH);

        pack();
        SetScreenToCenter s = new SetScreenToCenter(this);

    }



}
