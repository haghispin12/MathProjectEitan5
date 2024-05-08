package com.example.mathprojecteitan5;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mathprojecteitan5.mathproject.MainViewModel;
import com.example.mathprojecteitan5.mathproject.MyUserAdapter;

public class mainGame extends AppCompatActivity {

    private GameViewModel gameViewModel;
    RecyclerView rcShowCharacters;
    MyGameAdapter myGameAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);



       // public void initCardsAdapter() {
        /*MyUserAdapter myUserAdapter = new MyUserAdapter(gameViewModel.Characters, new MyUserAdapter.OnItemClickListener()) {
            @Override
            public void onItemClick(ACharacter item) {
                Toast.makeText(mainGame.this, item.Name ,Toast.LENGTH_SHORT).show();
            }
        });

        rcShowFruits.setLayoutManager(new LinearLayoutManager(this));
        rcShowFruits.setAdapter(myUsersAdapter);
        rcShowFruits.setHasFixedSize(true);*/

       // }
        rcShowCharacters=findViewById(R.id.rcShowCharacters);

        myGameAdapter = new MyGameAdapter(gameViewModel.Characters, new MyGameAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ACharacter item) {
                Toast.makeText(mainGame.this, item.Name ,Toast.LENGTH_SHORT).show();
            }
        });
        rcShowCharacters.setLayoutManager(new GridLayoutManager(mainGame.this,3));
        rcShowCharacters.setAdapter(myGameAdapter);
        rcShowCharacters.setHasFixedSize(true);

    }



}