package screens.QuestionPanels;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class MCQuestionPanel extends JPanel implements QuestionPanels {
    private MCQuestionInputData data;
    private ButtonGroup buttonGroup;

    public MCQuestionPanel(MCQuestionInputData data) {
        this.data = data;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JScrollPane questionScrollPanel = new JScrollPane();
        JTextArea questionArea = new JTextArea();
        JScrollPane optionsScrollPanel = new JScrollPane();
        JPanel optionsPanel = new JPanel();

        questionArea.setColumns(20);
        questionArea.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        questionArea.setRows(2);
        questionArea.setEditable(false);
        questionArea.setLineWrap(true);
        questionArea.setText(data.getQuestion());
        questionScrollPanel.setViewportView(questionArea);


        ButtonGroup group = new ButtonGroup();
        this.buttonGroup = group;
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        for (String i : data.getOptions()) {
            JRadioButton radioButton = new JRadioButton(i);
            group.add(radioButton);
            optionsPanel.add(radioButton);
        }
        optionsScrollPanel.setViewportView(optionsPanel);

        add(questionScrollPanel);
        add(optionsScrollPanel);

    }

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
        return data.getVariable();
    }

    @Override
    public Component getQuestionPanel() {
        return this;
    }


}