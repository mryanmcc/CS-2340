package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Location;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        goToLogin();
        goToRegister();

        Location model = Location.getInstance();

//        try {
//            InputStream locationStream = getResources().openRawResource(R.raw.locationdata);
//            BufferedReader locationStreamBuffer = new BufferedReader(new InputStreamReader(locationStream, StandardCharsets.UTF_8));
//
//            String line;
//            locationStreamBuffer.readLine(); //get rid of header line
//            while ((line = locationStreamBuffer.readLine()) != null) {
//                Log.d("LoginScreen", line);
//                String[] tokens = line.split(",");
//                int id = Integer.parseInt(tokens[1]);
//                //model.addUser(new String(tokens[NAME_POSITION], tokens[2], id, tokens[3]));
//            }
//            locationStreamBuffer.close();
//        } catch (IOException e) {
//           // Log.e(MainActivity.TAG, "error reading assets", e);
//        }
    }

    private void goToLogin() {
        Button goLogin = (Button) findViewById(R.id.goLogin);
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeScreen.this, LoginScreen.class));
            }
        });
    }

    private void goToRegister() {
        Button goRegister = (Button) findViewById(R.id.goRegister);
        goRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeScreen.this, RegisterScreen.class));
            }
        });
    }


}
