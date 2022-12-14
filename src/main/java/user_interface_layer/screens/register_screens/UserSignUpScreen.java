package user_interface_layer.screens.register_screens;

import user_interface_layer.screen_helper_classes.SetLabelTextPanel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the screen that displays the screen for a user to register
 */
public class UserSignUpScreen extends JFrame {
    /**
     * This is the constructor for the UserSignUpScreen class
     * @param controllerManager The controller manager that handles the actions of the buttons
     */
    public UserSignUpScreen(ControllerManager controllerManager) {
        setTitle("Sign Up");

        setLayout(new GridLayout(4, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel signUpMessage = new JLabel("Please enter your new username and name", SwingConstants.CENTER);

        JPanel inputsPanel = new JPanel();
        inputsPanel.setLayout(new GridLayout(2, 1));
        JTextField username = new JTextField(20);
        JTextField name = new JTextField(20);
        JPanel usernamePanel = new SetLabelTextPanel(new JLabel("Username", SwingConstants.CENTER), username);
        JPanel namePanel = new SetLabelTextPanel(new JLabel("Name", SwingConstants.CENTER), name);
        inputsPanel.add(usernamePanel);
        inputsPanel.add(namePanel);


        JPanel buttonsPanel = new JPanel();
        JButton participantSignUp = new JButton("Participant");
        JButton researcherSignUp = new JButton("Researcher");
        participantSignUp.addActionListener(e -> controllerManager.requestCreateUser(
                "Participant", username.getText(), name.getText()));
        researcherSignUp.addActionListener(e -> controllerManager.requestCreateUser(
                "Researcher", username.getText(), name.getText()));
        buttonsPanel.add(participantSignUp);
        buttonsPanel.add(researcherSignUp);
        JPanel cancelPanel = new JPanel();
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> controllerManager.requestRegisterScreen());
        cancelPanel.add(cancel);

        add(signUpMessage);
        add(inputsPanel);
        add(buttonsPanel);
        add(cancelPanel);

        setSize(600, 400);
        SetScreenToCenter.setCenter(this);


    }
}
