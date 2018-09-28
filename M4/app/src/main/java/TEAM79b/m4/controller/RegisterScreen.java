package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Login;

public class RegisterScreen extends AppCompatActivity {

    private EditText regEmail;
    private EditText regPass;
    private Button regSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        regEmail = (EditText) findViewById(R.id.regEmail);
        regPass = (EditText) findViewById(R.id.regPass);
        regSubmit = (Button) findViewById(R.id.regSubmit);

        //goToApp();
    }

//    private void goToApp() {
//        regSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(RegisterScreen.this, AppScreen.class));
//            }
//        });
//    }

    public void regPress(View view) {
        Login model = Login.getInstance();
        model.addUser(regEmail.getText().toString(), regPass.getText().toString());
        startActivity(new Intent(RegisterScreen.this, AppScreen.class));
    }
}
