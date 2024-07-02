package com.example.mathprojecteitan5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    int pTurn;
    String player;
    String GameId;
    String secretChar1;
    String secretChar2;
    String currentTurn;
    Button takeGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        Intent intent = getIntent();
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        rcShowCharacters = findViewById(R.id.rcShowCharacters);
        questionButton = findViewById(R.id.questionButton);
        choseButton = findViewById(R.id.choseButton);
        selectedPic = findViewById(R.id.selectedPic);
        takeGuess = findViewById(R.id.takeAguess);
        spinner = (Spinner) findViewById(R.id.questions_spinner);
        auth = FirebaseAuth.getInstance();
        turn = findViewById(R.id.turn);
        pTurn=intent.getIntExtra("turn",0);
        player = intent.getStringExtra("player");
        GameId = intent.getStringExtra("GameId");
        String gameDocId = getIntent().getStringExtra("gameDocId");
        gameViewModel.setGameCode(GameId);
        gameViewModel.setGameDocId(gameDocId);
        CollectionReference collectionRefRequest = FirebaseFirestore.getInstance().collection("Requests");
        CollectionReference collectionRefGame = FirebaseFirestore.getInstance().collection("Games");
        DocumentReference documentRefP1 = collectionRefRequest.document("characterP1");
        DocumentReference documentRefP2 = collectionRefRequest.document("characterP2");

        Request request1 = new Request(GameId, auth.getCurrentUser().getEmail());
        FirebaseFirestore.getInstance().collection("Requests").document().set(request1).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(mainGame.this, "added user", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(mainGame.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });

        doTurn();/////////קורא לפעולה שבודקת של מי התור ומאפשרת לשחק- פעולה חשובה!

//            gameViewModel.isPlayerTurn(pTurn, new GameViewModel.Callback<Boolean>() {
//                @Override
//                public void onResult(Boolean isTurn) {
//                    if (isTurn) {
//                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
//                        init();
//                    } else {
//                        init();
//                        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
//                                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
//                    }
//                }
//            });



    }


        public void init(){
        myGameAdapter = new MyGameAdapter(gameViewModel.getCharacters(), new MyGameAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ACharacter item) {
              //
                if(flagSelected==false){
                secretCharacter=item;
                    choseButton.setVisibility(View.GONE);
                    selectedPic.setImageResource(secretCharacter.getPicture());
                    selectedPic.setVisibility(View.VISIBLE);
                    takeGuess.setVisibility(View.VISIBLE);
                    flagSelected=true;

                    if (player.equals("1")) {
                        updateCharacterInRequest("character1", item.getName());
                    } else if (player.equals("2")) {
                        updateCharacterInRequest("character2", item.getName());
                    }
                    fetchSecretCharactersAndDoSomething();
                    fetchCurrentTurn();

                    spinner.setVisibility(View.VISIBLE);
                    Toast.makeText(mainGame.this, "Selected character is "+item.getName() ,Toast.LENGTH_SHORT).show();
                    turn.setVisibility(View.VISIBLE);

                }
            }

        });

        gameViewModel.flagChanged.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                doTurn();
            }
        });
        gameViewModel.myCharacters.observe(this, new Observer<ArrayList<ACharacter>>() {
                    @Override
                    public void onChanged(ArrayList<ACharacter> aCharacters) {
                        myGameAdapter.refreshArray(aCharacters);
                        //
                        myGameAdapter.notifyDataSetChanged();
                    }
                });
            CollectionReference collectionRefGame = FirebaseFirestore.getInstance().collection("Games");
        collectionRefGame.whereEqualTo("GameId",GameId).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot dc : queryDocumentSnapshots) {
                    Map<String, Object> updates = new HashMap<>();
                    currentTurn = dc.getString("currentTurn");

                }
            }
        });

        takeGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mainGame.this, "congrats-you won", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(mainGame.this, HomeActivity.class) ;
                startActivity(intent);

            }
        });
////////////////////////////////////////////////////////////////שמתי את זה פה במקום בonclick


//////////////////////////////////////שמתי את זה פה במקום בonlclick/////////////

// Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.questions_array,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                ////הסבר למה שקורה פה: אם התור הוא של משתמש 2 אז הדמות הסודית היא הדמות של משתמש 1 והפוך. למעלה דליתי את המידע בפעולות מהפייר סטור. אני משתמש בפעולה שלוקחת את השם של הדמות הסודית ובכך היא מוצאת את הדמות במערך ומציבה אותה במשתנה secret character
                       if (currentTurn == null) {
                      // Handle the case where currentTurn is not yet fetched
                      Log.w("Spinner", "Current turn is not yet fetched");
                         currentTurn="2";
                        }

                        if (currentTurn.equals("2")) {///לפנות לturn בפייר סטור ולשאול אם הוא שווה ל1 או 2
                            secretCharacter = gameViewModel.getSecretChar(secretChar1);///לבקש את הדמות של המשתמש ה1 מהפייר סטור
                        }
                        else if (currentTurn.equals("1")) {///לפנות לturn בפייר סטור ולשאול אם הוא שווה ל1 או 2
                            secretCharacter = gameViewModel.getSecretChar(secretChar2);///לבקש את השם של הדמות של המשתמש ה2 מהפייר סטור
                        }


                        if (pos == 1) {
                            if (secretCharacter.getHairColor() == PersonColor.YELLOW) {
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipExceptBlondes();
                                    }
                                }, 2000);
                            }
                            else if (secretCharacter.getHairColor() != PersonColor.YELLOW) {
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipBlondes();
                                    }
                                }, 2000);
                            }
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 2) {
                            if (secretCharacter.getHairColor() == PersonColor.RED) {
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipExceptRedHair();
                                    }
                                }, 2000);
                            }
                            else {
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipRedHair();
                                    }
                                }, 2000);
                            }
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 3) {
                            if (secretCharacter.getHairColor() == PersonColor.BROWN) {
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipExceptBrownHair();
                                    }
                                }, 2000);
                            }

                            else  {
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipBrownHair();
                                    }
                                }, 2000);
                            }
                            gameViewModel.finishMyTurn();

                        }

                        if (pos == 4) {
                            if (secretCharacter.getEyeColor() == PersonColor.BLUE){
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipExceptBlueEyes();
                                    }
                                }, 2000);

                                }
                            else {
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipBlueEyes();
                                    }
                                }, 2000);
                            }
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 5) {
                            if (secretCharacter.getEyeColor() == PersonColor.GREEN) {
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipExceptGreenEyes();
                                    }
                                }, 2000);

                            }
                            else {
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipGreenEyes();
                                    }
                                }, 2000);
                            }
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 6) {
                            if (secretCharacter.getEyeColor() == PersonColor.BROWN) {
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipExceptBrownEyes();
                                    }
                                }, 2000);
                            }
                            else {
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipBrownEyes();
                                    }
                                }, 2000);
                            }
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 7) {
                            if (secretCharacter.getSkinColor() == PersonColor.WHITE) {
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipBlackSkinEyes();
                                    }
                                }, 2000);
                            }
                            else {
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipWhiteSkinEyes();
                                    }
                                }, 2000);
                            }
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 8) {
                            if (secretCharacter.getSkinColor() == PersonColor.BLACK) {
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipWhiteSkinEyes();
                                    }
                                }, 2000);
                            }
                            else {
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipBlackSkinEyes();
                                    }
                                }, 2000);
                            }
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 9) {
                            if (secretCharacter.isBigNose() == true)
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 10) {
                            if (secretCharacter.isWearingHat() == true)
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 11) {
                            if (secretCharacter.isHasGlasses() == true) {
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipExceptGlasses();
                                    }
                                }, 2000);
                            }
                            else {
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipGlasses();
                                    }
                                }, 2000);
                            }
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 12) {
                            if (secretCharacter.isHasBeard() == true)
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 13) {
                            if (secretCharacter.isHasMoustache() == true)
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 14) {
                            if (secretCharacter.isMale() == true) {
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipExceptMale();
                                    }
                                }, 2000);
                            }

                            else {
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipMale();
                                    }
                                }, 2000);
                            }
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 15) {
                            if (secretCharacter.isLongHair() == true) {
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipExceptLongHair();
                                    }
                                }, 2000);
                            }

                            else {
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameViewModel.flipLongHair();
                                    }
                                }, 2000);
                            }
                            gameViewModel.finishMyTurn();

                        }
                        if (pos == 16) {
                            if (secretCharacter.isLongHair() == false)
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                        }
                        if (pos == 17) {
                            if (secretCharacter.getHairColor() == PersonColor.BALD)
                                Toast.makeText(mainGame.this, "YES", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(mainGame.this, "No", Toast.LENGTH_SHORT).show();
                        }
                gameViewModel.finishMyTurn();

            }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {


                    }
                });

                rcShowCharacters.setLayoutManager(new GridLayoutManager(mainGame.this, 4));
                rcShowCharacters.setAdapter(myGameAdapter);
                rcShowCharacters.setHasFixedSize(true);

            }

    public void updateCharacterInRequest (String characterField, String characterName) {
        FirebaseFirestore.getInstance().collection("Requests").whereEqualTo("idGame", GameId).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot dc : queryDocumentSnapshots) {
                            String gameId = dc.getId();
                            Map<String, Object> updates = new HashMap<>();
                            updates.put(characterField, characterName);
                            FirebaseFirestore.getInstance().collection("Requests").document(gameId).update(updates)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            // Character updated successfully
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            // Handle the error
                                        }
                                    });
                        }
                    }
                });
    }



    ////////////////////////////////////


    private void fetchSecretCharactersAndDoSomething() {
        CollectionReference collectionRefRequest = FirebaseFirestore.getInstance().collection("Requests");
        collectionRefRequest.whereEqualTo("idGame", GameId).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot dc : queryDocumentSnapshots) {
                            secretChar1 = dc.getString("character1");
                            secretChar2 = dc.getString("character2");

                            // Now you can use secretChar1 and secretChar2
                        }
                    }
                });
    }

    public void doTurn(){

        gameViewModel.isPlayerTurn(pTurn, new GameViewModel.Callback<Boolean>() {
            @Override
            public void onResult(Boolean isTurn) {
                if (isTurn) {
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    init();
                } else {
                    init();
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                }
            }
        });

    }

    private void fetchCurrentTurn() {
        CollectionReference collectionRefGame = FirebaseFirestore.getInstance().collection("Games");
        collectionRefGame.whereEqualTo("GameId", GameId).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot dc : queryDocumentSnapshots) {
                            currentTurn = dc.getString("currentTurn");

                            // Now you can use currentTurn
                            //handleCurrentTurn();
                        }
                    }
                });
    }

}