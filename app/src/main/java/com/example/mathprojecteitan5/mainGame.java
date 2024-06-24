package com.example.mathprojecteitan5;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

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
    FirebaseAuth auth;
    TextView turn;


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
        auth=FirebaseAuth.getInstance();
        turn=findViewById(R.id.turn);


        Request request1= new Request("id",auth.getCurrentUser().getEmail());
        FirebaseFirestore.getInstance().collection("Requests").document().set(request1).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(mainGame.this,"added user",Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(mainGame.this,"failed",Toast.LENGTH_SHORT).show();
            }
        });

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
                    spinner.setVisibility(View.VISIBLE);
                    Toast.makeText(mainGame.this, "Selected character is "+item.getName() ,Toast.LENGTH_SHORT).show();
                    turn.setVisibility(View.VISIBLE);

                }
            }

        });


        //gameViewModel.myCharacters.observe(new );

        gameViewModel.myCharacters.observe(this, new Observer<ArrayList<ACharacter>>() {
                    @Override
                    public void onChanged(ArrayList<ACharacter> aCharacters) {
                        myGameAdapter.refreshArray(aCharacters);
                        //
                        myGameAdapter.notifyDataSetChanged();
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
               if(pos==1){
                   if(secretCharacter.getHairColor()==PersonColor.YELLOW)
                       Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                   else if(secretCharacter.getHairColor()!=PersonColor.YELLOW) {
                       Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                       final Handler handler = new Handler();
                       handler.postDelayed(new Runnable() {
                           @Override
                           public void run() {
                               gameViewModel.flipBlondes();
                           }
                       }, 2000);
                   }


               }
                if(pos==2){
                    if(secretCharacter.getHairColor()==PersonColor.RED)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();

                }
                if(pos==3){
                    if(secretCharacter.getHairColor()==PersonColor.BROWN)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else if(secretCharacter.getHairColor()!=PersonColor.BROWN) {
                        Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                gameViewModel.flipBrownHair();
                            }
                        }, 2000);
                    }


                }


                if(pos==4){
                    if(secretCharacter.getEyeColor()==PersonColor.BLUE)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==5){
                    if(secretCharacter.getEyeColor()==PersonColor.GREEN)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==6){
                    if(secretCharacter.getEyeColor()==PersonColor.BROWN)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==7){
                    if(secretCharacter.getSkinColor()==PersonColor.WHITE)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==8){
                    if(secretCharacter.getSkinColor()==PersonColor.BLACK)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==9){
                    if(secretCharacter.isBigNose()==true)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==10){
                    if(secretCharacter.isWearingHat()==true)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==11){
                    if(secretCharacter.isHasGlasses()==true)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==12){
                    if(secretCharacter.isHasBeard()==true)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==13){
                    if(secretCharacter.isHasMoustache()==true)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==14){
                    if(secretCharacter.isMale()==true)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==15){
                    if(secretCharacter.isLongHair()==true)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==16){
                    if(secretCharacter.isLongHair()==false)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
                if(pos==17){
                    if(secretCharacter.getHairColor()==PersonColor.BALD)
                        Toast.makeText(mainGame.this, "YES" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mainGame.this, "No" ,Toast.LENGTH_SHORT).show();
                }
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