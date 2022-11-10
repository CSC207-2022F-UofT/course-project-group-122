package screens;

import javax.swing.*;

public class SetLabelTextPanel {

    public SetLabelTextPanel(JPanel panel, JLabel label, JTextField textField) {
        panel.add(label);
        panel.add(textField);
    }
    public SetLabelTextPanel(JFrame screen, JPanel panel, JLabel label, JTextField textField, int numChar) {
        screen.add(panel);
        panel.add(label);
        textField.setColumns(numChar);
        panel.add(textField);
    }
}
