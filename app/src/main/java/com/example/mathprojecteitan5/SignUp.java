package com.example.mathprojecteitan5;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import com.example.mathprojecteitan5.mathproject.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText SignEmail;
    private EditText SignPassword;
    private Button SignUpSignUpButton;
    UserGame userGame2=new UserGame();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SignUpSignUpButton=findViewById(R.id.SignUpSignUpButton);
        auth = FirebaseAuth.getInstance();
        SignEmail=findViewById(R.id.SignUpEmail);
        SignPassword=findViewById(R.id.SignUpPassword);

        SignUpSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.createUserWithEmailAndPassword(SignEmail.getText().toString(),SignPassword.getText().toString()).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUp.this,"Registration success.",Toast.LENGTH_SHORT).show();
                            userGame2.setName(SignEmail.getText().toString());
                            Intent intent=new Intent(SignUp.this, HomeActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignUp.this,"Registration failed.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });




    }
}