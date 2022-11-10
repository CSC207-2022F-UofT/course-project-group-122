package actionListeners;

import org.jetbrains.annotations.NotNull;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpToHome implements ActionListener {
    private View view;
    private String username;
    private String name;

    //   public UserCreationController userCreationController;
    public SignUpToHome(View view, String username, String name) {
        this.view = view;
        this.username = username;
        this.name = name;

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        String command = e.getActionCommand(); // This String is either "Participant"  or "Researcher"
        // controller.createUser(username, name, command);

        }
    }

