package actionListeners;

import org.jetbrains.annotations.NotNull;
import screens.LogInScreens.SignUpScreen;
import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterToSignUp implements ActionListener {
    private View view;
    public RegisterToSignUp(@NotNull View view) {
        this.view = view;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        if (e.getActionCommand().equals("Sign Up")) {
            SignUpScreen signUpScreen = new SignUpScreen(view);
            view.disposeCurrentScreen();
            view.setCurrentScreen(view.getSignUpScreen());
            view.setVisibleCurrentScreen();
        }
    }
}
