package com.example.mathprojecteitan5;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
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
    private Button MainRate;

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


    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result){
                    int myRate=result.getData().getIntExtra("rate",-1);
                    Toast.makeText(MainActivity.this, "thank you for rating "+myRate+"!", Toast.LENGTH_LONG).show();
                }
            }
    );
     MainRate=findViewById(R.id.MainRate);
     MainRate.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent=new Intent(MainActivity.this, Rate.class);
              activityResultLauncher.launch(intent);
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

             Toast.makeText(MainActivity.this, viewModelMain.answer(answer), Toast.LENGTH_SHORT).show();
         }
     });





    }




}