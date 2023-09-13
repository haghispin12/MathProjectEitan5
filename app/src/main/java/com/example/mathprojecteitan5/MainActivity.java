package com.example.mathprojecteitan5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mathExercise;
    private Button bMltb;
    private Button challenge;
    private Button xTill20;
    private TextView firstNum;
    private TextView secNum;
    private TextView multiply;
    private TextView equals;
    private EditText answer;
    private Button save;
    private Button saveUsers;
    private Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void intView(){
     mathExercise=findViewById(R.id.mathExercise);
     bMltb=findViewById(R.id.bMltb);
     challenge=findViewById(R.id.challenge);
     xTill20=findViewById(R.id.xTill20);
     firstNum=findViewById(R.id.firstNum);
     secNum=findViewById(R.id.secNum);
     multiply=findViewById(R.id.multiply1);
     equals=findViewById(R.id.equals);
     answer=findViewById(R.id.answer);
     save=findViewById(R.id.save);
     saveUsers=findViewById(R.id.showUsers);
     check=findViewById(R.id.check);

    }




}