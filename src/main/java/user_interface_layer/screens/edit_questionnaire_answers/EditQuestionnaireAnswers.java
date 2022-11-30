package user_interface_layer.screens.edit_questionnaire_answers;

import use_cases.questionnaire_answer_data_for_editing_request.ResearcherEditQuestionnaireScreenAnswersInputData;
import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers.ResearchersQuestionPanel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditQuestionnaireAnswers extends JFrame {

    public EditQuestionnaireAnswers(ResearcherEditQuestionnaireScreenAnswersInputData data, ControllerManager controllerManager) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setTitle("Edit Answer Questionnaire");
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

        JScrollPane scrollPane2 = new JScrollPane();
        JTextArea reasonForModification = new JTextArea(3, 5);
        reasonForModification.setLineWrap(true);
        scrollPane2.setViewportView(reasonForModification);
        JPanel reasonForModificationPanel = new JPanel(new GridLayout(2, 1));
        JLabel reasonForModificationLabel = new JLabel("Reason for Modification: ", SwingConstants.CENTER);
        reasonForModificationPanel.add(reasonForModificationLabel);
        reasonForModificationPanel.add(scrollPane2);
        questionsPanel.add(reasonForModificationPanel);


        JPanel submitPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            HashMap<String, String> answers = new HashMap<>();
            for (ResearchersQuestionPanel questionPanel : questionPanels) {
                if (questionPanel.getAnswer().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please answer all questions");
                    break;
                } else {
                    answers.put(questionPanel.getVariable(), questionPanel.getAnswer());
                }
            }
            if (answers.size() == questionPanels.size()) {
//                controllerManager.researcherEditAnswerRequest(data.getResearcherID(), data.getQuestionnaireID(), data.getStudyID(),answers, reasonForModification.getText());
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
        ResearcherEditQuestionnaireScreenAnswersInputData data = new ResearcherEditQuestionnaireScreenAnswersInputData(
                1,
                44,
                55,
                "This is questionnaire 1",
                "This is the description of questionnaire 1",questions);
        EditQuestionnaireAnswers panel = new EditQuestionnaireAnswers(data, new ControllerManager(new ScreenManager()));
        panel.setVisible(true);
    }


}
