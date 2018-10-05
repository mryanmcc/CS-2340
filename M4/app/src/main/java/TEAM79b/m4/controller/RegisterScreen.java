package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Login;
import TEAM79b.m4.model.User;

public class RegisterScreen extends AppCompatActivity {

    private EditText regEmail;
    private EditText regPass;
    private Button regSubmit;
    private Spinner roleSpinner;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        regEmail = (EditText) findViewById(R.id.regEmail);
        regPass = (EditText) findViewById(R.id.regPass);
        regSubmit = (Button) findViewById(R.id.regSubmit);
        roleSpinner = (Spinner) findViewById(R.id.roleSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, User.rolesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);

        goToWelcome();
    }


    private void goToWelcome() {
        Button regBack = (Button) findViewById(R.id.regBack);
        regBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterScreen.this, WelcomeScreen.class));
            }
        });
    }

    public void regPress(View view) {
        Login model = Login.getInstance();
        model.addUser(regEmail.getText().toString(), regPass.getText().toString());
//        user.setEmail(regEmail.getText().toString());
//        user.setPassword(regPass.getText().toString());
//        user.setUserType((String) roleSpinner.getSelectedItem());
        startActivity(new Intent(RegisterScreen.this, AppScreen.class));
    }
}
