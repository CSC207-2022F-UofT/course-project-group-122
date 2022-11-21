package user_interface_layer.screens.user_answer_questionnaires_screen.questions_panel;

import javax.swing.*;

public interface ParticipantsQuestionPanel{
    String getAnswer();

    String getVariable();

    JPanel getQuestionPanel();

    String getType();

    String getQuestion();

}
