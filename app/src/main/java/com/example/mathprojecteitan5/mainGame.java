package com.example.mathprojecteitan5;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class mainGame extends AppCompatActivity {

    int[] itemsarray = new int[] {
            R.drawable.apple, R.drawable.orange,
            R.drawable.banana, R.drawable.userpic,
            R.drawable.grapes, R.drawable.userpicture,
            R.drawable.lemon, R.drawable.apple,
            R.drawable.fru, R.drawable.userpicture
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.grid_view);

        // create a object of myBaseAdapter
        MyBaseAdapter baseAdapter = new MyBaseAdapter(this, itemsarray);
        gridView.setAdapter(baseAdapter);

        PersonColor hairColor;
        hairColor=PersonColor.brown;

    }
}