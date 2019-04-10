package com.george.platzigram.login.view;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.george.platzigram.R;
import com.george.platzigram.login.presenter.LoginPresenter;
import com.george.platzigram.login.presenter.LoginPresenterImpl;
import com.george.platzigram.view.ContainerActivity;
import com.george.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private TextInputEditText username, password;
    private Button login;
    private ProgressBar progressBarLogin;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        progressBarLogin = findViewById(R.id.progressbarLogin);
        hideProgressBar();


        presenter = new LoginPresenterImpl(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.equals("") && password.equals("")) {
                    loginError("Ingresa tu usuario y contraseña");
                } else if (username.equals("")) {
                    loginError("Ingresa tu usuario");
                } else if (password.equals("")) {
                    loginError("Ingresa la contraseña");
                } else {
                    presenter.signIn(username.getText().toString(), password.getText().toString());
                }
                goHome();
            }
        });


    }


    @Override
    public void enableInputs() {
        username.setEnabled(true);
        password.setEnabled(true);
        login.setEnabled(true);
    }

    @Override
    public void disableInputs() {
        username.setEnabled(false);
        password.setEnabled(false);
        login.setEnabled(false);
    }

    @Override
    public void showProgressBar() {
        progressBarLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarLogin.setVisibility(View.GONE);
    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this, getString(R.string.login_error) + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goCreateAccount() {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    @Override
    public void goHome() {
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }

    public void goHomeButton(View view) {
        goHome();
    }

    public void goCreateAccountButton(View view) {
        goCreateAccount();
    }


    public void goPlatzi(View view) {

        String url = "https://platzi.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}
