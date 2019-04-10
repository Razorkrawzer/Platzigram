package com.george.platzigram.login.interactor;

import com.george.platzigram.login.presenter.LoginPresenter;
import com.george.platzigram.login.repository.LoginRepository;
import com.george.platzigram.login.repository.LoginRepositoryImpl;

public class LoginInteractorImpl implements LoginInteractor {

    private LoginPresenter presenter;
    private LoginRepository repository;

    public LoginInteractorImpl(LoginPresenter presenter) {
        this.presenter = presenter;
        repository = new LoginRepositoryImpl(presenter);
    }

    @Override
    public void signIn(String username, String password) {
        repository.signIn(username, password);
    }
}
