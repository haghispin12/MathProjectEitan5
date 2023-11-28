package com.example.mathprojecteitan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Rate extends AppCompatActivity {
private SeekBar sb;
private Button saveRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        saveRate=findViewById(R.id.saveRate);
        sb=findViewById(R.id.skBar);
                main();
    }

    public void main () {


        saveRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inn = new Intent();
                inn.putExtra("rate", sb.getProgress());
                setResult(RESULT_OK, inn);
                finish();
            }
        });

    }
}