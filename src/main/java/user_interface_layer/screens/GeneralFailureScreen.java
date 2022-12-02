package user_interface_layer.screens;

import javax.swing.*;

/**
 * The screen that is displayed when an error occurs.
 */
public class GeneralFailureScreen {

    /**
     * @param FailureMessage The message that is displayed.
     */
    public GeneralFailureScreen(String FailureMessage) {
        JOptionPane.showMessageDialog(null, FailureMessage);
    }
}
