package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
import TEAM79b.m4.model.User;

/**
 * screen for new users to register
 */
public class RegisterScreen extends AppCompatActivity {

    private EditText regEmail;
    private EditText regPass;
    private Button regSubmit;
    private Spinner roleSpinner;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        regEmail = findViewById(R.id.regEmail);
        regPass = findViewById(R.id.regPass);
        regSubmit = findViewById(R.id.regSubmit);
        roleSpinner = findViewById(R.id.roleSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, User.rolesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);

        firebaseAuth = FirebaseAuth.getInstance();

        goToWelcome();
    }

    /**
     * goes back to the welcome screen with a back button
     */
    private void goToWelcome() {
        Button regBack = findViewById(R.id.regBack);
        regBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterScreen.this, WelcomeScreen.class));
            }
        });
    }

    /**
     * button for users to press when their registration info is entered
     * @param view screen
     */
    public void regPress(View view) {
        firebaseAuth.createUserWithEmailAndPassword(regEmail.getText().toString(), regPass.
                getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            LocationContainer locContainer = LocationContainer.getInstance();
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            String[] userIDarr = regEmail.getText().toString().split("\\.");
                            mDatabase.child("users").child(userIDarr[0]).setValue(user);
                            mDatabase.child("users").child(userIDarr[0]).child("role")
                                    .setValue(roleSpinner.getSelectedItem().toString());


                            try {
                                InputStream locationStream = getResources()
                                        .openRawResource(R.raw.locationdata);
                                BufferedReader locationStreamBuffer =
                                        new BufferedReader(new InputStreamReader(locationStream,
                                                StandardCharsets.UTF_8));

                                String line;
                                locationStreamBuffer.readLine();
                                while ((line = locationStreamBuffer.readLine()) != null) {
                                    Log.d("REGISTRATION_SCREEN", line);
                                    String[] tokens = line.split(",");
                                    Location keyEntry = new Location(tokens[1],
                                            Float.parseFloat(tokens[2]),
                                            Float.parseFloat(tokens[3]), tokens[4], tokens[5],
                                            tokens[6], Integer.parseInt(tokens[7]), tokens[8],
                                            tokens[9], tokens[10]);
                                    List<Item> valueEntry = new ArrayList<>();
                                    locContainer.addLocation(keyEntry, valueEntry);
                                }
                                locationStreamBuffer.close();
                            } catch (IOException e) {
                                Log.e("REGISTRATION_SCREEN", "error reading assets", e);
                            }
                            String userID = userIDarr[0];
                            String[] userIDArr = userID.split("\\.");
                            userID = userIDArr[0];
                            Set<Location> locSet = locContainer.getLocationMap().keySet();
                            for (Location l : locSet) {
                                mDatabase.child("users").child(userID).child("locations")
                                        .child(l.toString()).setValue(l);
                                List<Item> tempItemList = locContainer.getLocationMap().get(l);
                                tempItemList.add(new Item("NOW",l, "ITEM_LIST",
                                        "Format of the ITEM_LIST", 0,
                                        "ITEM_LIST"));
                                mDatabase.child("users").child(userID).child("locations")
                                        .child(l.toString()).child("item_list")
                                        .setValue(tempItemList);
                            }

                            startActivity(new Intent(RegisterScreen.this,
                                    LoginScreen.class));
                        } else {
                            Toast.makeText(RegisterScreen.this,
                                    "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

//                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                    @Override
//                    public void onSuccess(AuthResult authResult) {
//                        Toast.makeText(a, "success", Toast.LENGTH_LONG).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(a, "failure", Toast.LENGTH_LONG).show();
//                    }
//                });
        });
    }
}
