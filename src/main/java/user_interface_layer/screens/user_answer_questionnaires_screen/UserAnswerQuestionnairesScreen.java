package user_interface_layer.screens.user_answer_questionnaires_screen;

import org.jetbrains.annotations.NotNull;
import use_cases.answer_questionnaire_data_request.FetchQuestionnaireDataForAnswerResponseModel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.user_answer_questionnaires_screen.questions_panel.ParticipantsQuestionPanel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * The screen to answer a questionnaire.
 */
public class UserAnswerQuestionnairesScreen extends JFrame {

    /**
     * Constant for the normal type of questionnaire.
     */
    public static final String QUESTIONNAIRE = "Questionnaire";

    /**
     * Constant for the eligibility type of questionnaire.
     */
    public static final String ELIGIBILITY_QUESTIONNAIRE = "Eligibility Questionnaire";

    /**
     * Creates the screen to answer a questionnaire.
     * @param data The data to display.
     * @param type The type of questionnaire.
     * @param controllerManager The controller manager.
     */
    public UserAnswerQuestionnairesScreen(@NotNull FetchQuestionnaireDataForAnswerResponseModel data, String type,
                                          ControllerManager controllerManager) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setTitle("Answer Questionnaire");
        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());

        JLabel questionnaireNameLabel = new JLabel(data.getQuestionnaireID() + ": " + data.getQuestionnaireName(),
                SwingConstants.CENTER);

        JScrollPane descriptionScrollPanel = new JScrollPane();
        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setText(data.getQuestionnaireDescription());
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionScrollPanel.setViewportView(descriptionArea);


        header.add(questionnaireNameLabel, BorderLayout.NORTH);
        header.add(descriptionScrollPanel, BorderLayout.CENTER);


        JPanel questionsPanel = new JPanel();
        List<ParticipantsQuestionPanel> questionPanels = data.getQuestionsPanel();
        questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));

        for (ParticipantsQuestionPanel questionPanel : questionPanels) {
            questionsPanel.add(questionPanel.getQuestionPanel());
        }
        questionsPanel.setPreferredSize(new Dimension(500, 600));
        JScrollPane questionsScrollPanel = new JScrollPane();
        questionsScrollPanel.setViewportView(questionsPanel);

        JPanel submitPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            HashMap<String, String> answers = new HashMap<>();
            for (ParticipantsQuestionPanel questionPanel : questionPanels) {
                if (questionPanel.getAnswer().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please answer all questions");
                    break;
                } else {
                    answers.put(questionPanel.getVariable(),questionPanel.getAnswer());
                }
            }
            if (Objects.equals(type, ELIGIBILITY_QUESTIONNAIRE)) {
                controllerManager.answerEligibilityQuestionnaire(data.getModifierId(), data.getParticipantID(),
                        data.getQuestionnaireID(), data.getStudyID(), answers);
            } else if (Objects.equals(type, QUESTIONNAIRE)) {
                controllerManager.answerQuestionnaire(data.getModifierId(), data.getParticipantID(),
                        data.getQuestionnaireID(), data.getStudyID(), answers);
            }
            dispose();

        });
        submitPanel.add(submitButton);

        add(header, BorderLayout.NORTH);
        add(questionsScrollPanel, BorderLayout.CENTER);
        add(submitPanel, BorderLayout.SOUTH);
        pack();
        SetScreenToCenter.setCenter(this);
    }

}
