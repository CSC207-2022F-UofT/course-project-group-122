package actionListeners;

import org.jetbrains.annotations.NotNull;
import screens.LogInScreens.LogInScreen;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterToLogIn implements ActionListener {
        private View view;
        public RegisterToLogIn(@NotNull View view) {
            this.view = view;
        }
        /**
        * Invoked when an action occurs.
        *
        * @param e the event to be processed
        */
        @Override
        public void actionPerformed(@NotNull ActionEvent e) {
                if (e.getActionCommand().equals("Log In")) {
                        view.disposeCurrentScreen();
                        LogInScreen logInScreen = new LogInScreen(view);
                        view.setCurrentScreen(view.getLogInScreen());
                        view.setVisibleCurrentScreen();
                }
        }
}
