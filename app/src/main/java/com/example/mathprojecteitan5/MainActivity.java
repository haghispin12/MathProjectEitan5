package com.example.mathprojecteitan5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mathExercise;
    public Button bMltb;
    public Button challenge;
    public Button xTill20;
    public TextView firstNum;
    public TextView secNum;
    private TextView multiply;
    private TextView equals;
    private EditText answer;
    private Button save;
    private Button saveUsers;
    private Button check;
    private TextView userAnswer;
    public MainViewModel viewModelMain;
    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       intView();

       score=findViewById(R.id.score);
        viewModelMain = new ViewModelProvider(this).get(MainViewModel.class);
        viewModelMain.vNum1.observe(this, new Observer<Integer>() {
            @Override

            public void onChanged(Integer num1) {

                firstNum.setText(num1+"");

            }

        });

        viewModelMain.vScore.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer num2) {
                score.setText("score: "+num2);
            }
        });

        userAnswer=findViewById(R.id.userAnswer);
        String user1=getIntent().getStringExtra("username");
        Toast.makeText(MainActivity.this, "Welcome "+user1, Toast.LENGTH_LONG).show();
        userAnswer.setText(user1+",  ");
        viewModelMain.setUSerName(user1);


        viewModelMain.vNum2.observe(this, new Observer<Integer>() {

            @Override

            public void onChanged(Integer num2) {

                secNum.setText(num2+"");

            }

        });

    }

    private void intView(){

        firstNum=findViewById(R.id.firstNum);


        secNum=findViewById(R.id.secNum);


        multiply=findViewById(R.id.multiply1);
        equals=findViewById(R.id.equals);

        answer=findViewById(R.id.answer);

     bMltb=findViewById(R.id.bMltb);
     bMltb.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             answer.setText("");
            viewModelMain.mullBrd();


         }
     });



     challenge=findViewById(R.id.challenge);
     challenge.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             answer.setText("");
             viewModelMain.challenge();

         }
     });
     xTill20=findViewById(R.id.xTill20);
     xTill20.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             answer.setText("");
             viewModelMain.x20();
         }
     });




     save=findViewById(R.id.save);
    save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });


     saveUsers=findViewById(R.id.showUsers);
     saveUsers.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });

     check=findViewById(R.id.check);
     check.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             Toast.makeText(MainActivity.this, viewModelMain.answer(answer), Toast.LENGTH_LONG).show();
         }
     });


    }




}