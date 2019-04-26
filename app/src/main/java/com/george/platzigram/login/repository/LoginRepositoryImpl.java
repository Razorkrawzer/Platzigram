package com.george.platzigram.login.repository;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.george.platzigram.login.presenter.LoginPresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginRepositoryImpl implements LoginRepository {

    LoginPresenter presenter;


    public LoginRepositoryImpl(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void signIn(String username, String password, Activity activity, FirebaseAuth firebaseAuth) {

        firebaseAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            presenter.loginSuccess();
                        } else {
                            presenter.loginError("Ocurrio un error");
                        }
                    }
                });

     /*   boolean success = false;
        if (success) {
            presenter.loginSuccess();
        } else {
            presenter.loginError("Ocurrio un error");
        }*/
    }
}
