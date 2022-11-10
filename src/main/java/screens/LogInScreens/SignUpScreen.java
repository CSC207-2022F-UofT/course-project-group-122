package screens.LogInScreens;

import actionListeners.SignUpToHome;
import actionListeners.SignUpToRegister;
import org.jetbrains.annotations.NotNull;
import screens.SetButtonAction;
import screens.SetLabelTextPanel;
import screens.SetScreenToCenter;
import view.View;

import javax.swing.*;
import java.awt.*;

public class SignUpScreen {

    public JFrame signUpScreen = new JFrame();

    JTextField username = new JTextField();

    JTextField name = new JTextField();

    public SignUpScreen(@NotNull View view) {
        view.setSignUpScreen(signUpScreen);

        SetScreenToCenter toCenter = new SetScreenToCenter(signUpScreen, new GridLayout(4, 1), 400, 150);
        signUpScreen.setTitle("Sign Up");

        createPanels(view);
    }

    private void createPanels(View view) {
        JLabel signUpMessage = new JLabel("Please enter your new username and name", SwingConstants.CENTER);

        JPanel inputsPanel = new JPanel();
        inputsPanel.setLayout(new GridLayout(2, 1));
        SetLabelTextPanel usernameInfo =
                new SetLabelTextPanel(signUpScreen, inputsPanel, new JLabel("Username", SwingConstants.CENTER), username, 15);
        //JPanel namePanel = new JPanel();
        SetLabelTextPanel nameInfo =
                new SetLabelTextPanel(signUpScreen, inputsPanel, new JLabel("Name", SwingConstants.CENTER), name, 15);

        JPanel signUpButtonsPanel = new JPanel();
        JButton participantSignUp = new JButton("Participant");
        SetButtonAction setParticipantSignUp =
                new SetButtonAction(signUpButtonsPanel, participantSignUp, "Participant", new SignUpToHome(view, username.getText(), name.getText()));
        JButton researcherSignUp = new JButton("Researcher");
        SetButtonAction setResearcherSignUp =
                new SetButtonAction(signUpButtonsPanel, researcherSignUp, "Researcher", new SignUpToHome(view, username.getText(), name.getText()));

        JPanel cancelPanel = new JPanel();
        JButton cancel = new JButton("Cancel");
        SetButtonAction setCancel = new SetButtonAction(cancelPanel, cancel, "Cancel", new SignUpToRegister(view));

        signUpScreen.add(signUpMessage);
        signUpScreen.add(inputsPanel);
        signUpScreen.add(signUpButtonsPanel);
        signUpScreen.add(cancelPanel);
    }

    public JFrame getSignUpScreen() {
        return signUpScreen;
    }

}

