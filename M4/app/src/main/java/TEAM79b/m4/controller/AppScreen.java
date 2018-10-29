package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;
import TEAM79b.m4.model.LocationContainer;

public class AppScreen extends AppCompatActivity implements Serializable {

    private static final String TAG = "MY_APP";
    LocationContainer locContainer = LocationContainer.getInstance();

    private Button loadLocations;

    private DatabaseReference mDatabase;


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
        //FirebaseUser user = (FirebaseUser) getIntent().getSerializableExtra("user");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

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
                //Item dog = new Item("a",keyEntry, "a","a", 3, "a");
                ArrayList<Item> valueEntry = new ArrayList<>();
                //valueEntry.add(dog);
                locContainer.addLocation(keyEntry, valueEntry);
//                Map<Location, List<Item>> locMap = locContainer.getLocationMap();
//                Map<String, List<Item>> locMapForFirebase = new HashMap<>();
//                for (Location key : locMap.keySet()) {
//                    locMapForFirebase.put(key.toString(), locMap.get(key));
//                }
//                mDatabase = FirebaseDatabase.getInstance().getReference();
//                String userID = user.getEmail();
//                String[] userIDArr = userID.split("\\.");
//                userID = userIDArr[0];
//                mDatabase.child("users").child(userID).child("DOG").setValue("HELLO!!!");
//                mDatabase.child("users").child(userID).child("DOGGGGY").setValue(locMapForFirebase);
                //model.addLocation(keyEntry, valueEntry);
                startActivity(new Intent(AppScreen.this, LocationList.class));
                //model.addUser(new String(tokens[NAME_POSITION], tokens[2], id, tokens[3]));
            }
            Set<Location> locSet = locContainer.getLocationMap().keySet();
            mDatabase = FirebaseDatabase.getInstance().getReference();
            String userID = user.getEmail();
            String[] userIDArr = userID.split("\\.");
            userID = userIDArr[0];
            mDatabase.child("users").child(userID).child("DOG").setValue("HELLO-----");
            for (Location l : locSet) {
                List<Item> itemList = locContainer.getLocationMap().get(l);
                mDatabase.child("users").child(userID).child("locations").child(l.toString()).setValue(l);
                mDatabase.child("users").child(userID).child("locations").child(l.toString()).child("item list").setValue(itemList);
                //Log.d("YAPEE", mDatabase.child("users").child(userID).child("locations").child(l.toString()).child("name").);
                //List<Item> itemList = locContainer.getLocationMap().get(l);
            }
//            for (Location l : locSet) {
//                FirebaseDatabase.getInstance().getReference()
//                        .child("users")
//                        .child("locations")
//                        .child(l.toString())
//                        .addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(DataSnapshot dataSnapshot) {
//                                //@SuppressWarnings("unchecked")
//                                //Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
////                                String firstValue = (String) map.get("city");
////                                String secondValue = (String) map.get("name");
////                                String thirdValue = (String) map.get("state");
//                                Log.d("HAHAHA", dataSnapshot.getValue(Location.class).toString());
//                            }
//
//                            @Override
//                            public void onCancelled(DatabaseError databaseError) {/*Do Nothing*/}
//                        });
//            }
            locationStreamBuffer.close();
        } catch (IOException e) {
           Log.e(AppScreen.TAG, "error reading assets", e);
        }
    }
}
