package screens.LogInInterfaceScreens;

import org.jetbrains.annotations.NotNull;
import screens.SetScreenToCenter;
import view.ViewModel;

import javax.swing.*;
import java.awt.*;

public class RegisterScreen extends JFrame {
    private LogInInterfaceActionListeners actionListeners;


    public RegisterScreen(@NotNull ViewModel viewModel) {
        this.actionListeners = new LogInInterfaceActionListeners(viewModel);

        setTitle("Register");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel header = new JLabel("Would you like to");
        panel.add(header);
        JButton signUp = new JButton("Sign Up");
        signUp.addActionListener(e -> {
                    actionListeners.registerToSignUpDriver();
                }
        );
        panel.add(signUp);
        JLabel or = new JLabel("or");
        panel.add(or);

        JButton logIn = new JButton("Log In");
        logIn.addActionListener(e -> {
                    actionListeners.registerToLogInDriver();
                }
        );
        panel.add(logIn);

        JLabel questionMark = new JLabel("?");
        panel.add(questionMark);

        add(panel, BorderLayout.CENTER);
        setSize(600, 400);
        SetScreenToCenter s = new SetScreenToCenter(this);

    }
}
