package user_interface_layer.screens.message_screens;

import user_interface_layer.screen_helper_classes.SetScreenToCenter;

import javax.swing.*;

/**
 * The screen that is displayed when an error occurs.
 */
public class GeneralFailureScreen {

    /**
     * @param failureMessage The message that is displayed.
     */
    public GeneralFailureScreen(String failureMessage) {
        String message = "<html><p>" + failureMessage + "</p></html>";
        JFrame frame = new JFrame("Error");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        JLabel label = new JLabel(message, SwingConstants.CENTER);
        frame.add(label);
        frame.setVisible(true);
        SetScreenToCenter.setCenter(frame);
    }
}
