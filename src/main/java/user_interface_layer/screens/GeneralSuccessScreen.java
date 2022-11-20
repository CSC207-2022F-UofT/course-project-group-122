package user_interface_layer.screens;

import javax.swing.*;
import java.awt.*;

public class GeneralSuccessScreen {
    public GeneralSuccessScreen(String SuccessMessage) {
        JFrame successFrame = new JFrame();
        successFrame.setLayout(new BorderLayout());
        successFrame.setTitle("Success");
        JLabel successLabel = new JLabel(SuccessMessage, SwingConstants.CENTER);
        successFrame.add(successLabel, BorderLayout.CENTER);
        successFrame.setSize(600, 400);
        successFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        successFrame.setVisible(true);
    }
    }

