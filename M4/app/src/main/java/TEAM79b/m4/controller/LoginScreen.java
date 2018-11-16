package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.List;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;
import TEAM79b.m4.model.LocationContainer;

/**
 * screen for users of any type to login
 */
public class LoginScreen extends AppCompatActivity implements Serializable {

    private EditText loginEmail;
    private EditText loginPass;
    private Button loginSubmit;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        loginEmail = findViewById(R.id.loginEmail);
        loginPass = findViewById(R.id.loginPass);
        loginSubmit = findViewById(R.id.loginSubmit);

        firebaseAuth = FirebaseAuth.getInstance();

        goToWelcome();
    }

    /**
     * login button for users to press once info is typed
     * @param view screen
     */
    public void loginPress(View view) {
        firebaseAuth.signInWithEmailAndPassword(loginEmail.getText().toString(), loginPass.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {FirebaseUser user = firebaseAuth.getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            String userID = user.getEmail();
                            String[] userIDArr = userID.split("\\.");
                            userID = userIDArr[0];
                            mDatabase
                                    .child("users")
                                    .child(userID)
                                    .child("locations")
                                    .getRef()
                                    .addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                         LocationContainer locContainer = LocationContainer.getInstance();
                                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                                GenericTypeIndicator<List<Item>> t = new GenericTypeIndicator<List<Item>>() {};
                                                Location loc = snapshot.getValue(Location.class);
                                                List<Item> itemList = snapshot.child("item_list").getValue(t);
                                                locContainer.addLocation(loc, itemList);
                                                Log.d("HOLAs", itemList.toString());
                                            }
                                            Log.d("HOLAs", Integer.toString(locContainer.getLocationMap().size()));
                                            Log.d("HOLAs", locContainer.getLocationMap().toString());
                                            Log.d("BRUHs", Integer.toString(locContainer.getLocationMap().size()));
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {/*Do Nothing*/}
                                    });
                            Intent intent = new Intent(LoginScreen.this, AppScreen.class);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginScreen.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    /**
     * goes back to welcome screen for a back button on login screen
     */
    private void goToWelcome() {
        Button loginBack = (Button) findViewById(R.id.loginBack);
        loginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginScreen.this, WelcomeScreen.class));
            }
        });
    }
}
