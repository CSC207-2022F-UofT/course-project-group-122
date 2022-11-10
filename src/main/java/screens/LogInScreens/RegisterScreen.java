package screens.LogInScreens;

import actionListeners.RegisterToLogIn;
import actionListeners.RegisterToSignUp;
import org.jetbrains.annotations.NotNull;
import screens.SetButtonAction;
import screens.SetScreenToCenter;
import view.View;

import javax.swing.*;
import java.awt.*;

public class RegisterScreen {
    public JFrame registerScreen = new JFrame();

    public RegisterScreen(@NotNull View view) {

        view.setRegisterScreen(registerScreen);

        SetScreenToCenter toCenter = new SetScreenToCenter(registerScreen);
        registerScreen.setTitle("Register");
        registerScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createPanel(view);

        //registerScreen.setVisible(true);
    }

    private void createPanel(View view) {
        JPanel panel = new JPanel();
        registerScreen.add(panel, BorderLayout.CENTER);

        JLabel header = new JLabel("Would you like to");
        panel.add(header);

        JButton signUp = new JButton("Sign Up");

        SetButtonAction setSignup = new SetButtonAction(signUp, "Sign Up", new RegisterToSignUp(view));
        panel.add(signUp);

        JLabel or = new JLabel("or");
        panel.add(or);

        JButton logIn = new JButton("Log In");
        SetButtonAction setLogIn = new SetButtonAction(logIn, "Log In", new RegisterToLogIn(view));
        panel.add(logIn);

        JLabel questionMark = new JLabel("?");
        panel.add(questionMark);
    }

    public static void main(String[] args) {
        View view = new View();

    }

    public JFrame getRegisterScreen() {
        return registerScreen;

    }
}
