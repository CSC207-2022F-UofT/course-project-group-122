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
        successFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        successFrame.setSize(500, 400);
        SetScreenToCenter.setCenter(successFrame);
//        Timer timer = new Timer(5000, e -> successFrame.dispose());
//        timer.setRepeats(false);
//        timer.start();
        successFrame.setVisible(true);
        successFrame.setVisible(true);
    }
    }

