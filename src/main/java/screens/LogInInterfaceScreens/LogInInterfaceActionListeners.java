package screens.LogInInterfaceScreens;

import view.ViewModel;

import javax.swing.*;

public class LogInInterfaceActionListeners {
    ViewModel viewModel;
    public LogInInterfaceActionListeners(ViewModel viewModel){
        this.viewModel = viewModel;
    }

    public void registerToSignUpDriver() {
        SignUpScreen signUpScreen = new SignUpScreen(viewModel);
        viewModel.setSignUpScreen(signUpScreen);
        viewModel.getRegisterScreen().setVisible(false);
        viewModel.getSignUpScreen().setVisible(true);


    }

    public void registerToLogInDriver() {
        LogInScreen logInScreen = new LogInScreen(viewModel);
        viewModel.setLogInScreen(logInScreen);
        viewModel.getRegisterScreen().setVisible(false);
        viewModel.getLogInScreen().setVisible(true);
    }

    public void logInUser(String username) {
        viewModel.logInUser(username);
    }

    public void logInToRegisterDriver() {
        viewModel.getLogInScreen().setVisible(false);
        viewModel.getRegisterScreen().setVisible(true);
    }

    public void createUser(String type, String username, String name) {
        viewModel.createUser(type, username, name);
    }

    public void signUpToRegisterDriver() {
        viewModel.getSignUpScreen().setVisible(false);
        viewModel.getRegisterScreen().setVisible(true);
    }
}
