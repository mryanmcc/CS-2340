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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Login;

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

        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPass = (EditText) findViewById(R.id.loginPass);
        loginSubmit = (Button) findViewById(R.id.loginSubmit);

        firebaseAuth = FirebaseAuth.getInstance();

        goToWelcome();
    }

    public void loginPress(View view) {
        firebaseAuth.signInWithEmailAndPassword(loginEmail.getText().toString(), loginPass.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Intent intent = new Intent(LoginScreen.this, AppScreen.class);
                            intent.putExtra("user", user);
                            startActivity(intent);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginScreen.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });

//        Login model = Login.getInstance();
//        if (model.getUserAccounts().containsKey(loginEmail.getText().toString()) && model.getUserAccounts().get(loginEmail.getText().toString()).equals(loginPass.getText().toString())) {
//            startActivity(new Intent(LoginScreen.this, AppScreen.class));
//        } else {
//            startActivity(new Intent(LoginScreen.this, BadIdScreen.class));
//        }
    }

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
