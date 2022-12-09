package user_interface_layer.screens.edit_questionnaire_answers;

import org.jetbrains.annotations.NotNull;
import use_cases.questionnaire_answer_data_for_editing_request.ResearcherEditQuestionnaireScreenAnswersInputData;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers.ResearchersQuestionPanel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

/**
 * The screen that allows the researcher to edit the answers to a questionnaire.
 */
public class EditQuestionnaireAnswers extends JFrame {

    /**
     * The constructor of the screen.
     * @param data The input data.
     * @param controllerManager The controller manager.
     */
    public EditQuestionnaireAnswers(@NotNull ResearcherEditQuestionnaireScreenAnswersInputData data, ControllerManager controllerManager) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setTitle("Edit Answer Questionnaire");
        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());

        JLabel questionnaireNameLabel = new JLabel(data.getAnswerId() + ": " + data.getQuestionnaireName(), SwingConstants.CENTER);

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

        for (ResearchersQuestionPanel questionPanel : questionPanels) {
            JPanel singular = questionPanel.getQuestionPanel();
            questionsPanel.add(singular);
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
            if (answers.size() == questionPanels.size() && !reasonForModification.getText().equals("")) {
                controllerManager.researcherEditAnswer(data.getResearcherID(),data.getParticipantID(), data.getAnswerId(), data.getStudyID(),answers, reasonForModification.getText());
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Please answer all questions");
            }
        });
        submitPanel.add(submitButton);

        add(header, BorderLayout.NORTH);
        add(questionsScrollPanel, BorderLayout.CENTER);
        add(submitPanel, BorderLayout.SOUTH);
        setSize(600, 600);
        SetScreenToCenter.setCenter(this);

    }
}
