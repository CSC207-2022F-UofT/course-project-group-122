package screens.LogInInterfaceScreens;

import org.jetbrains.annotations.NotNull;
import screens.SetLabelTextPanel;
import screens.SetScreenToCenter;
import view.ViewModel;

import javax.swing.*;
import java.awt.*;


public class LogInScreen extends JFrame {
    private LogInInterfaceActionListeners actionListeners;


    public LogInScreen(@NotNull ViewModel viewModel) {
        this.actionListeners = new LogInInterfaceActionListeners(viewModel);

        setTitle("Log In");
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField username = new JTextField(20);
        JPanel usernamePanel = new SetLabelTextPanel(new JLabel("Username"), username);
        this.add(usernamePanel);

        JPanel buttonsPanel = new JPanel();
        JButton logIn = new JButton("Log In");
        JButton cancel = new JButton("Cancel");
        logIn.addActionListener(e -> {
            actionListeners.logInUser(username.getText());
        });
        cancel.addActionListener(e -> {
            actionListeners.logInToRegisterDriver();
        });
        buttonsPanel.add(cancel);
        buttonsPanel.add(logIn);
        add(usernamePanel);
        add(buttonsPanel);

        setSize(600, 400);
        SetScreenToCenter s = new SetScreenToCenter(this);
        }


}
