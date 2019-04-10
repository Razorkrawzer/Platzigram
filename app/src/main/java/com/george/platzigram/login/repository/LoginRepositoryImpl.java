package com.george.platzigram.login.repository;

import com.george.platzigram.login.presenter.LoginPresenter;

public class LoginRepositoryImpl implements LoginRepository {

    LoginPresenter presenter;

    public LoginRepositoryImpl(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void signIn(String username, String password) {
        boolean success = false;
        if (success) {
            presenter.loginSuccess();
        } else {
            presenter.loginError("Ocurrio un error");
        }
    }
}
