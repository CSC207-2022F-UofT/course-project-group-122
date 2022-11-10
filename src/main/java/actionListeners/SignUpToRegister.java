package actionListeners;

import org.jetbrains.annotations.NotNull;
import screens.LogInScreens.RegisterScreen;
import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpToRegister implements ActionListener {
    View view;

    //    public UserCreationController userCreationController;

    public SignUpToRegister(View view) {
        this.view = view;
    }

    /**
     * Invoked when an action occurs.
     * Assumes that if cancel is not the action command, then it is then it calls the UserCreationController
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        if (e.getActionCommand().equals("Cancel")) {
            view.disposeCurrentScreen();
            JFrame registerScreen = view.getRegisterScreen();
            view.setCurrentScreen(registerScreen);
            view.setVisibleCurrentScreen();
        }


    }
}
