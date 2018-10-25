package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;
import TEAM79b.m4.model.LocationContainer;

public class AppScreen extends AppCompatActivity {

    private static final String TAG = "MY_APP";

    private Button loadLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_screen);

        loadLocations = (Button) findViewById(R.id.loadLocButton);


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

    public void loadLocations(View view) {
        LocationContainer model = LocationContainer.getInstance();

        try {
            InputStream locationStream = getResources().openRawResource(R.raw.locationdata);
            BufferedReader locationStreamBuffer = new BufferedReader(new InputStreamReader(locationStream, StandardCharsets.UTF_8));

            String line;
            locationStreamBuffer.readLine(); //get rid of header line
            while ((line = locationStreamBuffer.readLine()) != null) {
                Log.d(AppScreen.TAG, line);
                String[] tokens = line.split(",");
                //int id = Integer.parseInt(tokens[0]);
                //List<String> locationDataTemp = Arrays.asList(tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7], tokens[8], tokens[9], tokens[10]);
                Location keyEntry = new Location(tokens[1], Float.parseFloat(tokens[2]), Float.parseFloat(tokens[3]), tokens[4], tokens[5], tokens[6], Integer.parseInt(tokens[7]), tokens[8], tokens[9], tokens[10]);
                List<Item> valueEntry = new ArrayList<>();
                model.addLocation(keyEntry, valueEntry);
                startActivity(new Intent(AppScreen.this, LocationList.class));
                //model.addUser(new String(tokens[NAME_POSITION], tokens[2], id, tokens[3]));
            }
            locationStreamBuffer.close();
        } catch (IOException e) {
           Log.e(AppScreen.TAG, "error reading assets", e);
        }
    }
}
