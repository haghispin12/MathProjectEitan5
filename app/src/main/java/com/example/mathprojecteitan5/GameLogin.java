package com.example.mathprojecteitan5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class GameLogin extends AppCompatActivity {
private EditText GameEmail;
private EditText GamePassword;
private Button GameSubmit;
private Button SignUpButton;
private FirebaseAuth auth;
String email;
String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_login);

        GameEmail=findViewById(R.id.GameEmail);
        GamePassword=findViewById(R.id.GamePassword);
        GameSubmit=findViewById(R.id.GameSubmit);
        SignUpButton=findViewById(R.id.signUpButton);
        FirebaseApp.initializeApp(this);

       //auth = FirebaseAuth.getInstance();
//        if(auth.getCurrentUser()!=null){/
//        }
        //do something


        GameSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(GameEmail.getText().toString(),GamePassword.getText().toString()).addOnCompleteListener(GameLogin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(GameLogin.this,"Authentication success.",Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(GameLogin.this,"Authentication failed.",Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });







    }
}