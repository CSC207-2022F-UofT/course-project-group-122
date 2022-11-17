package UserInterfaceLayer.screens.RegisterScreens;

import UserInterfaceLayer.SetScreenToCenter;
import UserInterfaceLayer.UserRegisterScreenDriver.FetchUserLogInScreenRequest;
import UserInterfaceLayer.UserRegisterScreenDriver.FetchUserSignUpScreenRequest;
import UserInterfaceLayer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

public class UserRegisterScreen extends JFrame {

    private ControllerManager controllerManager;

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
        setSize(600, 400);
        SetScreenToCenter s = new SetScreenToCenter(this);
}}
