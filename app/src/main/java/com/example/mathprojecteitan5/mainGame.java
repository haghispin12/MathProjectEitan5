package com.example.mathprojecteitan5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
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
    Button questionButton;
    Button choseButton;
    ACharacter secretCharacter;
    boolean flagSelected=false;
    ImageView selectedPic;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        rcShowCharacters=findViewById(R.id.rcShowCharacters);
        questionButton=findViewById(R.id.questionButton);
        choseButton=findViewById(R.id.choseButton);
        selectedPic=findViewById(R.id.selectedPic);
        spinner =(Spinner) findViewById(R.id.questions_spinner);

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

        myGameAdapter = new MyGameAdapter(gameViewModel.getCharacters(), new MyGameAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ACharacter item) {
              //
                if(flagSelected==false){
                secretCharacter=item;
                    choseButton.setVisibility(View.GONE);
                    selectedPic.setImageResource(secretCharacter.getPicture());
                    selectedPic.setVisibility(View.VISIBLE);
                    flagSelected=true;
                    Toast.makeText(mainGame.this, "Selected character is "+item.Name ,Toast.LENGTH_SHORT).show();

                }
            }



        });

        questionButton.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View view) {

             }
            });

// Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.questions_array,
                android.R.layout.simple_spinner_item
        );
// Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        rcShowCharacters.setLayoutManager(new GridLayoutManager(mainGame.this,4));
        rcShowCharacters.setAdapter(myGameAdapter);
        rcShowCharacters.setHasFixedSize(true);

    }



}