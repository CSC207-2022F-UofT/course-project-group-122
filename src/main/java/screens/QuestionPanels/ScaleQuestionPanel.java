package screens.QuestionPanels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ScaleQuestionPanel extends JPanel implements QuestionPanels {
    private ScaleQuestionInputData data;
    private ButtonGroup buttonGroup;

    public ScaleQuestionPanel(ScaleQuestionInputData data) {
        this.data = data;
        buttonGroup = new ButtonGroup();

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

        buttonGroup = new ButtonGroup();
        optionsPanel.setLayout(new FlowLayout());
        optionsPanel.add(new JLabel(data.getBottomLabel() + " ", SwingConstants.CENTER));
        for (int i : data.getScale()) {
            JRadioButton button = new JRadioButton(String.valueOf(i));
            buttonGroup.add(button);
            optionsPanel.add(button);
        }
        optionsPanel.add(new JLabel(" "+ data.getTopLabel(), SwingConstants.CENTER));
        optionsScrollPanel.setViewportView(optionsPanel);

        add(questionScrollPanel);
        add(optionsScrollPanel);
    }

    public JPanel getQuestionPanel() {
        return this;
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
        return data.getVariable();
    }


}
