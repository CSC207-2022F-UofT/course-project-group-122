package user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers;

import javax.swing.*;

/**
 * The interface that represents a panel that contains the question and the answer for a question.
 */
public interface ResearchersQuestionPanel {
    /**
     * @return The question's answer.
     */
    String getAnswer();

    /**
     * @return The question's variable.
     */
    String getVariable();

    /**
     * @return The question's panel.
     */
    JPanel getQuestionPanel();

    /**
     * @return The question's type.
     */
    String getType();

    /**
     * @return The question.
     */
    String getQuestion();

}
