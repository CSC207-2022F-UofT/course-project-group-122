package user_interface_layer.screen_helper_classes;

import javax.swing.*;
import java.awt.*;

/**
 * A helper class that sets the text of a label.
 */
public class SetLabelTextPanel extends JPanel {
    /**
     * Sets the text of a label.
     * @param label The label to set the text of.
     * @param textField The text field to get the text from.
     */
    public SetLabelTextPanel(JLabel label, JTextField textField) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(label);
        add(textField);
    }
}
