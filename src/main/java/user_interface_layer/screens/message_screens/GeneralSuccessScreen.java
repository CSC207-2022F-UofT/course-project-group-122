package user_interface_layer.screens.message_screens;

import user_interface_layer.screen_helper_classes.SetScreenToCenter;

import javax.swing.*;
import java.awt.*;

/**
 * The screen that is displayed when something is successful.
 */
public class GeneralSuccessScreen {
    /**
     * @param successMessage The message that is displayed.
     */
    public GeneralSuccessScreen(String successMessage) {
        String message = "<html><p>" + successMessage + "</p></html>";
        JFrame successFrame = new JFrame();
        successFrame.setLayout(new BorderLayout());
        successFrame.setTitle("Success");
        JLabel successLabel = new JLabel(message, SwingConstants.CENTER);
        successFrame.add(successLabel, BorderLayout.CENTER);
        successFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        successFrame.setSize(500, 400);
        SetScreenToCenter.setCenter(successFrame);
        successFrame.setVisible(true);
        successFrame.setVisible(true);
    }
    }

