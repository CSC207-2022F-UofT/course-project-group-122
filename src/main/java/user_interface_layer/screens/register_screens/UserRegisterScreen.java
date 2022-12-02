package user_interface_layer.screens.register_screens;

import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the screen that displays the screen for a user to register
 */
public class UserRegisterScreen extends JFrame {

    /**
     * This is the constructor for the UserRegisterScreen class
     * @param controllerManager The controller manager that handles the actions of the buttons
     */
    public UserRegisterScreen(ControllerManager controllerManager) {

        setTitle("Register");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel header = new JLabel("Would you like to");
        panel.add(header);
        JButton signUp = new JButton("Sign Up");
        signUp.addActionListener(e -> controllerManager.requestSignUpScreen()
        );
        panel.add(signUp);
        JLabel or = new JLabel("or");
        panel.add(or);

        JButton logIn = new JButton("Log In");
        logIn.addActionListener(e -> controllerManager.requestLogInScreen()
        );
        panel.add(logIn);

        JLabel questionMark = new JLabel("?");
        panel.add(questionMark);

        add(panel, BorderLayout.CENTER);
        pack();
        SetScreenToCenter.setCenter(this);
    }
}
