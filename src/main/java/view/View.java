package view;

import screens.LogInScreens.RegisterScreen;

import javax.swing.*;

public class View {
    public JFrame currentScreen;
    public JFrame registerScreen;
    public JFrame logInScreen;
    public JFrame signUpScreen;
    public JFrame participantNotEnrolledScreen;

    public View() {
        RegisterScreen registerScreen = new RegisterScreen(this);
        this.registerScreen = registerScreen.registerScreen;
        this.currentScreen = this.registerScreen;
        this.currentScreen.setVisible(true);
    }

    public View(JFrame registerScreen) {
        this.currentScreen = registerScreen;
        this.registerScreen = registerScreen;
    }
    //////////////////////   EDIT CURRENT SCREEN   //////////////////////

    public void setVisibleCurrentScreen() {
        this.currentScreen.setVisible(true);
    }

    public void disposeCurrentScreen() {
        this.currentScreen.dispose();
    }

    public void setNotVisibleCurrentScreen() {
        this.currentScreen.setVisible(false);
    }
    //////////////////////   GETTERS AND SETTERS   //////////////////////

    public JFrame getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(JFrame currentScreen) {
        this.currentScreen = currentScreen;
    }

    public JFrame getRegisterScreen() {
        return registerScreen;
    }

    public void setRegisterScreen(JFrame registerScreen) {
        this.registerScreen = registerScreen;
    }

    public JFrame getLogInScreen() {
        return logInScreen;
    }

    public void setLogInScreen(JFrame loginScreen) {
        this.logInScreen = loginScreen;
    }

    public JFrame getSignUpScreen() {
        return signUpScreen;
    }

    public void setSignUpScreen(JFrame signUpScreen) {
        this.signUpScreen = signUpScreen;
    }

    public JFrame getParticipantNotEnrolledScreen() {
        return participantNotEnrolledScreen;
    }

    public void setParticipantNotEnrolledScreen(JFrame participantNotEnrolledScreen) {
        this.participantNotEnrolledScreen = participantNotEnrolledScreen;
    }


}
