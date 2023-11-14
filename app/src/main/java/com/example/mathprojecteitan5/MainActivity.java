package com.example.mathprojecteitan5;

import androidx.appcompat.app.AppCompatActivity;
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
    int userAnswer;
    int num1;
    int num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       intView();
    }

    private void intView(){
     mathExercise=findViewById(R.id.mathExercise);
     mathExercise.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
           //test
         }
     });

     bMltb=findViewById(R.id.bMltb);
     bMltb.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Random r=new Random();
             num1=r.nextInt(10)+1;
             num2=r.nextInt(10)+1;

            firstNum.setText(num1+"");
            secNum.setText(num2+"");

         }
     });

     challenge=findViewById(R.id.challenge);
     challenge.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Random r=new Random();
              num1=r.nextInt(9)+1;
              num2=r.nextInt(90)+10;

             firstNum.setText(num1+"");
             secNum.setText(num2+"");
         }
     });
     xTill20=findViewById(R.id.xTill20);
     xTill20.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Random r=new Random();
              num1=r.nextInt(9)+1;
              num2=r.nextInt(20)+10;

             firstNum.setText(num1+"");
             secNum.setText(num2+"");
         }
     });

     firstNum=findViewById(R.id.firstNum);


     secNum=findViewById(R.id.secNum);


     multiply=findViewById(R.id.multiply1);
     equals=findViewById(R.id.equals);

     answer=findViewById(R.id.answer);


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
             String s = answer.getText().toString();
             if(num1*num2==Integer.valueOf(s))
             {
                 Toast.makeText(MainActivity.this, "well done! you got it right", Toast.LENGTH_SHORT).show();
             }
             else
             {
                 Toast.makeText(MainActivity.this, "you got it wrong, try again!", Toast.LENGTH_SHORT).show();
             }


         }
     });



    }




}