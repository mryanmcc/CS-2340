package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;
import TEAM79b.m4.model.LocationContainer;

/**
 * welcome screen when users first open the app
 */
public class WelcomeScreen extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private LocationContainer locContainer = LocationContainer.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        try {
            mDatabase
                    .child("locations")
                    .getRef();
        } catch (NullPointerException ne) {
            mDatabase = FirebaseDatabase.getInstance().getReference();
            try {
                InputStream locationStream = getResources().openRawResource(R.raw.locationdata);
                BufferedReader locationStreamBuffer = new BufferedReader(new InputStreamReader(locationStream, StandardCharsets.UTF_8));

                String line;
                locationStreamBuffer.readLine(); //get rid of header line
                while ((line = locationStreamBuffer.readLine()) != null) {
                    Log.d("REGISTRATION_SCREEN", line);
                    String[] tokens = line.split(",");
                    Location keyEntry = new Location(tokens[1], Float.parseFloat(tokens[2]), Float.parseFloat(tokens[3]), tokens[4], tokens[5], tokens[6], Integer.parseInt(tokens[7]), tokens[8], tokens[9], tokens[10]);
                    ArrayList<Item> valueEntry = new ArrayList<>();
                    Item tempItem = new Item("NOW", keyEntry, "ITEM_LIST", "Format of the ITEM_LIST", 0, "ITEM_LIST");
                    locContainer.addLocation(keyEntry, valueEntry);
                }
                locationStreamBuffer.close();
            } catch (IOException e) {
                Log.e("REGISTRATION_SCREEN", "error reading assets", e);
            }
            Set<Location> locSet = locContainer.getLocationMap().keySet();
            for (Location l : locSet) {
                mDatabase.child("locations").child(l.toString()).setValue(l);
                List<Item> tempItemList = locContainer.getLocationMap().get(l);
                tempItemList.add(new Item("NOW", l, "ITEM_LIST", "Format of the ITEM_LIST", 0, "ITEM_LIST"));
                mDatabase.child("locations").child(l.toString()).child("item_list").setValue(tempItemList);
            }
        }
        goToLogin();
        goToRegister();
    }

    /**
     * takes users to the login screen
     */
    private void goToLogin() {
        Button goLogin = findViewById(R.id.goLogin);
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeScreen.this, LoginScreen.class));
            }
        });
    }

    /**
     * takes users to the registration screen
     */
    private void goToRegister() {
        Button goRegister = findViewById(R.id.goRegister);
        goRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeScreen.this, RegisterScreen.class));
            }
        });
    }


}
