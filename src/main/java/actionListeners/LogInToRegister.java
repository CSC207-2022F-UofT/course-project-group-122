package actionListeners;

import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInToRegister implements ActionListener {
    private View view;
    public LogInToRegister(View view) {
        this.view = view;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Cancel")) {
            view.disposeCurrentScreen();
            JFrame registerScreen = view.getRegisterScreen();
            view.setCurrentScreen(registerScreen);
            view.setVisibleCurrentScreen();
        }

    }


}
