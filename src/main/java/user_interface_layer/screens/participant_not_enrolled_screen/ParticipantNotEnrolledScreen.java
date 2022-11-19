package user_interface_layer.screens.participant_not_enrolled_screen;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.SetScreenToCenter;

import javax.swing.*;
import java.awt.*;

public class ParticipantNotEnrolledScreen extends JFrame {

    public ParticipantNotEnrolledScreen(@NotNull ParticipantNotEnrolledInputData data) {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel header = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel userIDLabel = new JLabel(data.getParticipantName() + " (" + data.getParticipantID() + ")");
        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> {
            data.getController().userLogOutController();
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
