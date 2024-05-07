package com.example.mathprojecteitan5;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.mathprojecteitan5.mathproject.MainViewModel;
import com.example.mathprojecteitan5.mathproject.MyUserAdapter;

public class mainGame extends AppCompatActivity {

    private GameViewModel gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.grid_view);

        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);


    }

    public void initCardsAdapter()
    {
        /*MyUserAdapter myUserAdapter = new MyUserAdapter(gameViewModel.Characters, new MyUserAdapter.OnItemClickListener()) {
            @Override
            public void onItemClick(ACharacter item) {
                Toast.makeText(mainGame.this, item.Name ,Toast.LENGTH_SHORT).show();
            }
        });

        rcShowFruits.setLayoutManager(new LinearLayoutManager(this));
        rcShowFruits.setAdapter(myUsersAdapter);
        rcShowFruits.setHasFixedSize(true);*/

        MyUserAdapter my = new MyUserAdapter(gameViewModel.Characters, new MyUserAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ACharacter item) {
                Toast.makeText(mainGame.this, item.Name ,Toast.LENGTH_SHORT).show();
            }
        });
        rcShow.setLayoutManager(new LinearLayoutManager(this));
        rcShowFruits.setAdapter(myUsersAdapter);
        rcShowFruits.setHasFixedSize(true);
    }
}