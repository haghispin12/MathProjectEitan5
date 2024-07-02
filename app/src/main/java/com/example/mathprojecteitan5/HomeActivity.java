package com.example.mathprojecteitan5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class HomeActivity extends AppCompatActivity {

    Button startOnline;
    Button PlayWithFriends;
    Button JoinGame;
    EditText enterGameId;
    Button SubmitJoin;
    UUID uuid;
    EditText showCode;
    private FirebaseAuth auth;
    private String GameId;
    String gameDocId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GameViewModel gameViewModel;
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);
        startOnline = findViewById(R.id.onlineGame);
        PlayWithFriends = findViewById(R.id.friendsGame);
        JoinGame = findViewById(R.id.joinGame);
        enterGameId = findViewById(R.id.enterID);
        SubmitJoin = findViewById(R.id.SubmitJoin);
        auth = FirebaseAuth.getInstance();
        showCode = findViewById(R.id.showCode);
        CollectionReference collectionRef = FirebaseFirestore.getInstance().collection("Games");
//        DocumentReference documentRef=collectionRef.document("GameStatus");


        startOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, mainGame.class);
                startActivity(intent);
            }
        });
        GameId = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        PlayWithFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameManager gameManager1 = new GameManager(GameId, auth.getCurrentUser().getEmail());
                FirebaseFirestore.getInstance().collection("Games").add(gameManager1).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(HomeActivity.this, "create game has been successful", Toast.LENGTH_SHORT).show();
                        gameDocId = documentReference.getId();
                        showCode.setVisibility(View.VISIBLE);
                        showCode.setText("your code is: " + GameId);

                        DocumentReference documentRef1 = FirebaseFirestore.getInstance().collection("Games").document(gameDocId);
                        documentRef1.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                            @Override
                            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                                if (error != null) {
                                    Log.w("FireStore", "fail", error);
                                    return;
                                }
                                if (value != null && value.exists()) {
                                    long statusValue = value.getLong("GameStatus");
                                    if (1 == statusValue) {
                                        Intent intent = new Intent(HomeActivity.this, mainGame.class);
                                        intent.putExtra("turn", "1");
                                        intent.putExtra("player", "1");
                                        intent.putExtra("GameId", GameId);
                                        startActivity(intent);
                                    }
                                }
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(HomeActivity.this, "create game has been failed", Toast.LENGTH_SHORT).show();
                    }
                });


            }

        });


        JoinGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterGameId.setVisibility(View.VISIBLE);
                SubmitJoin.setVisibility(View.VISIBLE);
            }
        });

        SubmitJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = enterGameId.getText().toString();
                FirebaseFirestore.getInstance().collection("Games").whereEqualTo("GameId", code).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String gameId = "";
                        for (DocumentSnapshot dc : queryDocumentSnapshots) {
                            gameId = dc.getId();
                            Map<String, Object> updates = new HashMap<>();
                            updates.put("user2", auth.getCurrentUser().getEmail());
                            updates.put("currentTurn", "1");
                            updates.put("GameStatus", 1);

                            FirebaseFirestore.getInstance().collection("Games").document(gameId).update(updates).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(HomeActivity.this, "worked", Toast.LENGTH_SHORT).show();
                                }


                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(HomeActivity.this, "failed", Toast.LENGTH_SHORT).show();
                                }
                            });


                        }

                        Intent intent = new Intent(HomeActivity.this, mainGame.class);
                        intent.putExtra("turn", "2");
                        intent.putExtra("player", "2");
                        intent.putExtra("GameId", GameId);


                        startActivity(intent);
                    }
                });
            }

        });
    }
}