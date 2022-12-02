package user_interface_layer.screens.participant_answer_questionnaire_panel.questions_panel;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class ScaleQuestionPanel extends JPanel implements ParticipantsQuestionPanel {
    private final String type;
    private final String variable;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final String question;

    public ScaleQuestionPanel(String question, String type, String variable, String bottomLabel, String topLabel, int scale) {
        this.variable = variable;
        this.type = type;
        this.question = question;
        setLayout(new BorderLayout());

        JLabel questionLabel = new JLabel(question);
        JScrollPane optionsScrollPanel = new JScrollPane();
        JPanel optionsPanel = new JPanel();

        optionsPanel.setLayout(new FlowLayout());
        optionsPanel.add(new JLabel(bottomLabel + " ", SwingConstants.CENTER));
        for (int i = 0; i < scale; i++) {
            JRadioButton button = new JRadioButton(String.valueOf(i));
            buttonGroup.add(button);
            optionsPanel.add(button);
        }
        optionsPanel.add(new JLabel(" "+ topLabel, SwingConstants.CENTER));
        optionsScrollPanel.setViewportView(optionsPanel);

        add(questionLabel, BorderLayout.NORTH);
        add(optionsScrollPanel, BorderLayout.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public String getAnswer() {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
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
