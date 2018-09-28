package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import TEAM79b.m4.R;

public class BadIdScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_id_screen);

        goToLogin();
    }

    private void goToLogin() {
        Button badBack = (Button) findViewById(R.id.badBack);
        badBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BadIdScreen.this, LoginScreen.class));
            }
        });
    }
}
