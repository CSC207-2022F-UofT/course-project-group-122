package user_interface_layer.screens.register_screens;

import user_interface_layer.ScreenManager;
import user_interface_layer.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

public class UserRegisterScreen extends JFrame {

    public UserRegisterScreen(ControllerManager controllerManager) {

        setTitle("Register");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel header = new JLabel("Would you like to");
        panel.add(header);
        JButton signUp = new JButton("Sign Up");
        signUp.addActionListener(e -> {
            controllerManager.requestLogInScreen();
                }
        );
        panel.add(signUp);
        JLabel or = new JLabel("or");
        panel.add(or);

        JButton logIn = new JButton("Log In");
        logIn.addActionListener(e -> {
            controllerManager.requestSignUpScreen();
                }
        );
        panel.add(logIn);

        JLabel questionMark = new JLabel("?");
        panel.add(questionMark);

        add(panel, BorderLayout.CENTER);
        pack();
        SetScreenToCenter s = new SetScreenToCenter(this);
}

    public static void main(String[] args) {
        UserRegisterScreen userRegisterScreen = new UserRegisterScreen(new ControllerManager(new ScreenManager()));
        userRegisterScreen.setVisible(true);
    }
}
