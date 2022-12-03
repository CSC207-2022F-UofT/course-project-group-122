package user_interface_layer.screens;

import user_interface_layer.screen_helper_classes.SetScreenToCenter;

import javax.swing.*;

/**
 * The screen that is displayed when an error occurs.
 */
public class GeneralFailureScreen {

    /**
     * @param FailureMessage The message that is displayed.
     */
    public GeneralFailureScreen(String FailureMessage) {
        JFrame frame = new JFrame("Error");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        JLabel label = new JLabel(FailureMessage, SwingConstants.CENTER);
        frame.add(label);
        Timer timer = new Timer(5000, e -> frame.dispose());
        timer.setRepeats(false);
        timer.start();
        frame.setVisible(true);
        SetScreenToCenter.setCenter(frame);
    }
}
