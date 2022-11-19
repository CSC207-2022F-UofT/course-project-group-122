package user_interface_layer.screens.research_edit_questionnaire_screen;

import user_interface_layer.ScreenManager;
import user_interface_layer.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.research_edit_questionnaire_screen.questions_panel_for_researchers.ResearchersQuestionPanel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResearcherEditQuestionnaireScreen extends JFrame {

    public ResearcherEditQuestionnaireScreen(ResearcherEditQuestionnaireScreenInputData data) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setTitle("Answer Questionnaire");
        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());

        JLabel questionnaireNameLabel = new JLabel(data.getQuestionnaireID() + ": " + data.getQuestionnaireName(), SwingConstants.CENTER);

        JScrollPane descriptionScrollPanel = new JScrollPane();
        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setText(data.getQuestionnaireDescription());
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionScrollPanel.setViewportView(descriptionArea);


        header.add(questionnaireNameLabel, BorderLayout.NORTH);
        header.add(descriptionScrollPanel, BorderLayout.CENTER);


        JPanel questionsPanel = new JPanel();
        List<ResearchersQuestionPanel> questionPanels = data.getQuestionsPanel();
        questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));

        int counter = 0;
        for (ResearchersQuestionPanel questionPanel : questionPanels) {
            JPanel singular = questionPanel.getQuestionPanel();
            questionsPanel.add(singular);
            counter++;
        }
        questionsPanel.setPreferredSize(new Dimension(500, 600));
        JScrollPane questionsScrollPanel = new JScrollPane();
        questionsScrollPanel.setViewportView(questionsPanel);

        JPanel submitPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            HashMap<String, String[]> answers = new HashMap<>();
            for (ResearchersQuestionPanel questionPanel : questionPanels) {
                if (questionPanel.getAnswer().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please answer all questions");
                    break;
                } else {
                    answers.put(questionPanel.getQuestion(), new String[]{questionPanel.getType(), questionPanel.getVariable(), questionPanel.getAnswer()});
                }
            }
            if (answers.size() == questionPanels.size()) {
                data.getControllerManager().researcherEditAnswerRequest(data.getResearcherID(), data.getQuestionnaireID(), data.getStudyID(),answers);
            }else{
                JOptionPane.showMessageDialog(null, "Please answer all questions");
            }
        });
        submitPanel.add(submitButton);

        add(header, BorderLayout.NORTH);
        add(questionsScrollPanel, BorderLayout.CENTER);
        add(submitPanel, BorderLayout.SOUTH);
        setSize(600, 600);
        SetScreenToCenter s = new SetScreenToCenter(this);

    }

    public static void main(String[] args) {
        Map<String, String[]> questions = new HashMap<>();
        questions.put("What is your name?", new String[]{"Text", "name", "helllo","Anna"});
        questions.put("What is your ABC?", new String[]{"MC", "abc", "A,B,C,D","D"});
        ResearcherEditQuestionnaireScreenInputData data = new ResearcherEditQuestionnaireScreenInputData(
                1,
                44,
                55,
                "This is questionnaire 1",
                "This is the description of questionnaire 1",questions
                , new ControllerManager(new ScreenManager()));
        ResearcherEditQuestionnaireScreen panel = new ResearcherEditQuestionnaireScreen(data);
        panel.setVisible(true);
    }


}
