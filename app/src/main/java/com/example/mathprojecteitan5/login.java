package com.example.mathprojecteitan5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
private EditText userName;
private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = findViewById(R.id.UserName);
        SharedPreferences sh=getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1=sh.getString("name","");
        userName.setText(s1);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor myEdit= sharedPreferences.edit();
                myEdit.putString("name",userName.getText().toString());
                myEdit.apply();

                Intent intent = new Intent(login.this,MainActivity.class);
                intent.putExtra("username",userName.getText().toString());

                startActivity(intent);
            }
        });



    }





}