package user_interface_layer.screens.participant_answer_questionnaire_panel.questions_panel;

import javax.swing.*;

public interface ParticipantsQuestionPanel{
    String getAnswer();

    String getVariable();

    JPanel getQuestionPanel();

    String getType();

    String getQuestion();

}
