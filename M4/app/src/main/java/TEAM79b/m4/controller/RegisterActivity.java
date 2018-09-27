package TEAM79b.m4.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Login;

public class RegisterActivity extends AppCompatActivity {

    private TextView mEmailRegister;
    private TextView mPassRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEmailRegister = (TextView) findViewById(R.id.emailRegister);
        mPassRegister = (TextView) findViewById(R.id.passRegister);

    }

    public void registerPress(View view) {
        Login model = Login.getInstance();
        model.addUser(mEmailRegister.getText().toString(), mPassRegister.getText().toString());
    }

}
