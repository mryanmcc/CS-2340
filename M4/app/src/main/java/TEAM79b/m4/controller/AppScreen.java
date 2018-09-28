package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import TEAM79b.m4.R;

public class AppScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_screen);

        goToWelcome();
    }

    private void goToWelcome() {
        Button goWelcome = (Button) findViewById(R.id.goWelcome);
        goWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AppScreen.this, WelcomeScreen.class));
            }
        });
    }
}
