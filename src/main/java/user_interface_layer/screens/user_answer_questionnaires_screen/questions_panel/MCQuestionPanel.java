package user_interface_layer.screens.user_answer_questionnaires_screen.questions_panel;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class MCQuestionPanel extends JPanel implements ParticipantsQuestionPanel {
    private final ButtonGroup buttonGroup;
    private final String variable;
    private final String type;
    private final String question;
    public MCQuestionPanel(String question, String type, String variable, String[] options) {
        this.variable = variable;
        this.type = type;
        this.question = question;
        setLayout(new BorderLayout());
        JLabel questionLabel = new JLabel(question);
        add(questionLabel, BorderLayout.NORTH);
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        buttonGroup = new ButtonGroup();
        for (String option : options) {
            JRadioButton radioButton = new JRadioButton(option);
            buttonGroup.add(radioButton);
            optionsPanel.add(radioButton);
        }
        add(optionsPanel, BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public String getAnswer() {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText().split("\\.")[0];
            }
        }
        return "";
    }

    @Override
    public String getVariable() {
        return variable;
    }

    @Override
    public JPanel getQuestionPanel() {
        return this;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getQuestion() {
        return question;
    }

}
