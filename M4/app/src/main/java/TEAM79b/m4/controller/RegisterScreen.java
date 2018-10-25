package TEAM79b.m4.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Login;
import TEAM79b.m4.model.User;

public class RegisterScreen extends AppCompatActivity {

    private EditText regEmail;
    private EditText regPass;
    private Button regSubmit;
    private Spinner roleSpinner;

    private User user;

    private FirebaseAuth firebaseAuth;

    private final Activity a = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        regEmail = (EditText) findViewById(R.id.regEmail);
        regPass = (EditText) findViewById(R.id.regPass);
        regSubmit = (Button) findViewById(R.id.regSubmit);
        roleSpinner = (Spinner) findViewById(R.id.roleSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, User.rolesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);

        firebaseAuth = FirebaseAuth.getInstance();

        goToWelcome();
    }


    private void goToWelcome() {
        Button regBack = (Button) findViewById(R.id.regBack);
        regBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterScreen.this, WelcomeScreen.class));
            }
        });
    }

    public void regPress(View view) {
        firebaseAuth.createUserWithEmailAndPassword(regEmail.getText().toString(), regPass.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            //user.updateProfile()
                            //User user = User
                                    //pass through from screen to screen
                            startActivity(new Intent(RegisterScreen.this, LoginScreen.class));
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterScreen.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
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
