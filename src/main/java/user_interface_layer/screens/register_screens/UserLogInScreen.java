package user_interface_layer.screens.register_screens;

import user_interface_layer.screen_helper_classes.SetLabelTextPanel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;

/**
 * This class is the screen that displays the screen for a user to log in
 */
public class UserLogInScreen extends JFrame {
    /**
     * This is the constructor for the UserLogInScreen class
     * @param controllerManager The controller manager that handles the actions of the buttons
     */
    public UserLogInScreen(ControllerManager controllerManager) {
        setTitle("Log In");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JTextField username = new JTextField(20);
        JPanel usernamePanel = new SetLabelTextPanel(new JLabel("Username"), username);
        add(usernamePanel);

        JPanel buttonsPanel = new JPanel();
        JButton logIn = new JButton("Log In");
        JButton cancel = new JButton("Cancel");
        logIn.addActionListener(e -> controllerManager.requestLogInUser(username.getText()));
        cancel.addActionListener(e -> controllerManager.requestRegisterScreen());
        buttonsPanel.add(cancel);
        buttonsPanel.add(logIn);
        add(usernamePanel);
        add(buttonsPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        SetScreenToCenter.setCenter(this);
    }
}
