package user_interface_layer.screens;

import user_interface_layer.screen_helper_classes.SetScreenToCenter;

import javax.swing.*;
import java.awt.*;

/**
 * The screen that is displayed when something is successful.
 */
public class GeneralSuccessScreen {
    /**
     * @param SuccessMessage The message that is displayed.
     */
    public GeneralSuccessScreen(String SuccessMessage) {
        JFrame successFrame = new JFrame();
        successFrame.setLayout(new BorderLayout());
        successFrame.setTitle("Success");
        JLabel successLabel = new JLabel(SuccessMessage, SwingConstants.CENTER);
        successFrame.add(successLabel, BorderLayout.CENTER);
        successFrame.setSize(600, 400);
        successFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        successFrame.setSize(500, 400);
        SetScreenToCenter.setCenter(successFrame);
        successFrame.setVisible(true);
    }
    }

