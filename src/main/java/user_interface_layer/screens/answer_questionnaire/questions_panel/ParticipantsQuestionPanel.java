package user_interface_layer.screens.answer_questionnaire.questions_panel;

import javax.swing.*;

public interface ParticipantsQuestionPanel{
    String getAnswer();

    String getVariable();

    JPanel getQuestionPanel();

    String getType();

    String getQuestion();

}
