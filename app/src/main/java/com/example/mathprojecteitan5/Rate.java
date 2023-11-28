package com.example.mathprojecteitan5;.

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;

public class Rate extends AppCompatActivity {
private SeekBar sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        sb=findViewById(R.id.skBar)
    }


    Intent inn=new Intent();
    inn.putExtra("rate",sb.getProgress());
    setResult(RESULT_OK,inn);
    finish();
}