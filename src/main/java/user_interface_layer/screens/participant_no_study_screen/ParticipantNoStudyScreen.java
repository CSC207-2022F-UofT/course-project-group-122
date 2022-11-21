package user_interface_layer.screens.participant_no_study_screen;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

public class ParticipantNoStudyScreen extends JFrame {

    public ParticipantNoStudyScreen(@NotNull int participantId, String participantName, ControllerManager controllerManager) {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel header = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel userIDLabel = new JLabel(participantName + " (" + participantId + ")");
        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> {
            controllerManager.userLogOutController();
        });
        header.add(userIDLabel);
        header.add(logOutButton);
        add(header, BorderLayout.NORTH);

        JLabel message = new JLabel("You are not enrolled in a Study", SwingConstants.CENTER);

        add(message, BorderLayout.CENTER);

        setSize(600, 400);
        SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);
    }



}
