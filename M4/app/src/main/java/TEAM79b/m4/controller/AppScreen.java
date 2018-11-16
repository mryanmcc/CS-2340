package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;

import TEAM79b.m4.R;

/**
 * Main App Screen after login
 */
public class AppScreen extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_screen);

    }

    /**
     * Go back to welcome screen
     * @param view screen
     */
    public void goToWelcome(View view) {
        startActivity(new Intent(AppScreen.this, WelcomeScreen.class));
    }

    /**
     * goes to the location list screen, which loads the locations from the model
     * @param view screen
     */
    public void loadLocations(View view) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        startActivity(new Intent(AppScreen.this, LocationListScreen.class));
    }

    /**
     * goes to the item search screen
     * @param view screen
     */
    public void goToSearch(View view) {
        startActivity(new Intent(AppScreen.this, SearchScreen.class));
    }
}
