package use_cases.user_login;

import entities.User;

interface UserLoginOutputBoundary {
    void onUserSignUpFailure(String s);

    void onUserSignUpSuccess(User newUser, String userType);

    void onUserLoginSuccess(User user);

    void onUserLoginFailure(String s);
}
