package com.example.mathprojecteitan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Rate extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
private SeekBar sb;
private Button saveRate;
private TextView showRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        showRate=findViewById(R.id.showRate);
        saveRate=findViewById(R.id.saveRate);
        sb=findViewById(R.id.skBar);
        sb.setOnSeekBarChangeListener(this);
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
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
    showRate.setText(i+"");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}