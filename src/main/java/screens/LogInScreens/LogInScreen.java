package screens.LogInScreens;

import actionListeners.LogInToHome;
import actionListeners.LogInToRegister;
import org.jetbrains.annotations.NotNull;
import screens.SetLabelTextPanel;
import screens.SetScreenToCenter;
import screens.SetButtonAction;
import view.View;

import javax.swing.*;
import java.awt.*;


public class LogInScreen {
    JFrame logInScreen = new JFrame();
    JTextField username = new JTextField();
    View view;

    public LogInScreen(@NotNull View view) {
        view.setLogInScreen(logInScreen);
        SetScreenToCenter toCenter = new SetScreenToCenter(logInScreen, new GridLayout(2,1), 400, 100);
        this.view = view;

        logInScreen.setTitle("Log In");

        createPanels(view);

      //logInScreen.setVisible(true);

    }

    private void createPanels(View view) {
        SetLabelTextPanel usernameInfo =
                new SetLabelTextPanel(logInScreen, new JPanel(), new JLabel("Username"), username, 15);

        JPanel panel = new JPanel();
        logInScreen.add(panel);

        JButton logIn = new JButton("Log In");
        JButton cancel = new JButton("Cancel");
        SetButtonAction setLogIn = new SetButtonAction(panel, logIn, "Log In", new LogInToHome(view,username.getText()));
        SetButtonAction setCancel = new SetButtonAction(panel, cancel, "Cancel", new LogInToRegister(view));
    }
    public JFrame getLogInScreen() {
        return logInScreen;
    }

    public static void main(String[] args) {
        LogInScreen test = new LogInScreen(new View());
    }


}
