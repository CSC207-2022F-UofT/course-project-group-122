package user_interface_layer.screens.participant_no_study_screen;

import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the screen that displays the screen for a participant that is not enrolled in a study
 */
public class ParticipantNoStudyScreen extends JFrame {

    /**
     * This is the constructor for the ParticipantNoStudyScreen class
     * @param participantId The participant id of the participant
     * @param participantName The participant name of the participant
     * @param controllerManager The controller manager that handles the actions of the buttons
     */
    public ParticipantNoStudyScreen(int participantId, String participantName, ControllerManager controllerManager) {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel header = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel userIDLabel = new JLabel(participantName + " (" + participantId + ")");
        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> controllerManager.userLogOutController());
        header.add(userIDLabel);
        header.add(logOutButton);
        add(header, BorderLayout.NORTH);

        JLabel message = new JLabel("You are not enrolled in a Study", SwingConstants.CENTER);

        add(message, BorderLayout.CENTER);

        setSize(600, 400);
        SetScreenToCenter.setCenter(this);
    }
}
