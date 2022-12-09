package user_interface_layer.screens.user_answer_questionnaires_screen.questions_panel;

import javax.swing.*;

/**
 * The interface that the questionnaire panels must implement.
 */
public interface ParticipantsQuestionPanel{
    /**
     * @return The answer of the question.
     */
    String getAnswer();

    /**
     * @return The variable of the question.
     */
    String getVariable();

    /**
     * @return The panel of the question.
     */
    JPanel getQuestionPanel();

    /**
     * @return The type of the question.
     */
    String getType();

    /**
     * @return The question.
     */
    String getQuestion();

}
