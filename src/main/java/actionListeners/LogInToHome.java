package actionListeners;

import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInToHome implements ActionListener {

    //    public UserLogInController userLogInController;

    private View view;
    private String username;
    public LogInToHome(View view, String username) {
        this.view = view;
        this.username = username;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // This String is either "Participant"  or "Researcher"
        // controller.logInUser(username, command);

    }
}
