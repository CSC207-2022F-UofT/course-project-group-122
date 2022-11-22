package user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers;

import javax.swing.*;

public interface ResearchersQuestionPanel {
    String getAnswer();

    String getVariable();

    JPanel getQuestionPanel();

    String getType();

    String getQuestion();

}
