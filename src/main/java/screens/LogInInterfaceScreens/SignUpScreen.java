package screens.LogInInterfaceScreens;

import org.jetbrains.annotations.NotNull;
import screens.SetLabelTextPanel;
import screens.SetScreenToCenter;
import view.ViewModel;

import javax.swing.*;
import java.awt.*;

public class SignUpScreen extends JFrame {
    private LogInInterfaceActionListeners actionListeners;

    public SignUpScreen(@NotNull ViewModel viewModel) {
        this.actionListeners = new LogInInterfaceActionListeners(viewModel);

        setTitle("Sign Up");

        setLayout(new GridLayout(4,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel signUpMessage = new JLabel("Please enter your new username and name", SwingConstants.CENTER);

        JPanel inputsPanel = new JPanel();
        inputsPanel.setLayout(new GridLayout(2, 1));
        JTextField username = new JTextField(20);
        JTextField name = new JTextField(20);
        JPanel usernamePanel = new SetLabelTextPanel(new JLabel("Username",SwingConstants.CENTER), username);
        JPanel namePanel = new SetLabelTextPanel(new JLabel("Name",SwingConstants.CENTER), name);
        inputsPanel.add(usernamePanel);
        inputsPanel.add(namePanel);


        JPanel buttonsPanel = new JPanel();
        JButton participantSignUp = new JButton("Participant");
        JButton researcherSignUp = new JButton("Researcher");
        participantSignUp.addActionListener(e -> {
            actionListeners.createUser("Participant", username.getText(), name.getText());});
        researcherSignUp.addActionListener(e -> {
            actionListeners.createUser("Researcher", username.getText(), name.getText());});
        buttonsPanel.add(participantSignUp);
        buttonsPanel.add(researcherSignUp);
        JPanel cancelPanel = new JPanel();
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> {actionListeners.signUpToRegisterDriver();});
        cancelPanel.add(cancel);

        add(signUpMessage);
        add(inputsPanel);
        add(buttonsPanel);
        add(cancelPanel);

        setSize(600, 400);
        SetScreenToCenter s = new SetScreenToCenter(this);

    }

}

