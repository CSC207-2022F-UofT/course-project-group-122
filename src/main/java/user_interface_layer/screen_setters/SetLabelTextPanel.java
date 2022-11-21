package user_interface_layer.screen_setters;

import javax.swing.*;
import java.awt.*;

public class SetLabelTextPanel extends JPanel {
    public SetLabelTextPanel(JLabel label, JTextField textField) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(label);
        add(textField);
    }
}
