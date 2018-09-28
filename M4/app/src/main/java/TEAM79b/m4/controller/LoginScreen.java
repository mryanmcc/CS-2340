package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Login;

public class LoginScreen extends AppCompatActivity {

    private EditText loginEmail;
    private EditText loginPass;
    private Button loginSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPass = (EditText) findViewById(R.id.loginPass);
        loginSubmit = (Button) findViewById(R.id.loginSubmit);

//        goToApp();
    }

    public void loginPress(View view) {
        Login model = Login.getInstance();
        if (model.getUserAccounts().containsKey(loginEmail.getText().toString()) && model.getUserAccounts().get(loginEmail.getText().toString()).equals(loginPass.getText().toString())) {
            startActivity(new Intent(LoginScreen.this, AppScreen.class));
        } else {
            startActivity(new Intent(LoginScreen.this, LoginScreen.class));
        }
    }
//    private void goToApp() {
//        loginSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(LoginScreen.this, AppScreen.class));
//            }
//        });
//    }
}
