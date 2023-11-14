package com.example.mathprojecteitan5;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Exercise
{
    private int num1;
    private int num2;
    private int counter = 0;
    public int mullBrd()
    {
        Random r = new Random();
        if(counter == 0)
        {
            num1 = r.nextInt(10)+1;
            counter++;
            return num1;
        }
        else
        {
            num2 = r.nextInt(10)+1;
            counter = 0;
            return num2;
        }
    }

    public int X20()
    {
        Random r = new Random();
        if(counter == 0)
        {
            num1 = r.nextInt(9) + 1;
            counter++;
            return num1;
        }
        else
        {
            num2 = r.nextInt(10) + 10;
            counter = 0;
            return num2;
        }
    }

    public int challange()
    {
        Random r = new Random();
        if (counter == 0)
        {
            num1 = r.nextInt(9)+1;
            counter++;
            return num1;
        }
        else
        {
            num2 = r.nextInt(90)+10;
            counter = 0;
            return num2;
        }
    }

    public String answer(EditText answer)
    {
        String ans = answer.getText().toString();
        if(num1 * num2 == Integer.valueOf(ans))
        {
            return "Well Done!!!";
        }
        else
        {
            return "Wrong... try again! (:";
        }
    }

    public int getNum1()
    {
        return num1;
    }
    public int getNum2()
    {
        return num2;
    }
}
