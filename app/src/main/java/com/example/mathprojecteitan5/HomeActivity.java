package com.example.mathprojecteitan5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.UUID;

public class HomeActivity extends AppCompatActivity {

Button startOnline;
Button PlayWithFriends;
Button JoinGame;
EditText enterGameId;
Button SubmitJoin;
UUID uuid;
private FirebaseAuth auth;
private String GameId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GameViewModel gameViewModel;
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);
      startOnline=findViewById(R.id.onlineGame);
      PlayWithFriends=findViewById(R.id.friendsGame);
       JoinGame=findViewById(R.id.joinGame);
        enterGameId=findViewById(R.id.enterID);
        SubmitJoin=findViewById(R.id.SubmitJoin);

      startOnline.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(HomeActivity.this, mainGame.class);
              startActivity(intent);
          }
      });
       GameId=uuid.randomUUID().toString();
      PlayWithFriends.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              GameManager gameManager1= new GameManager(GameId,auth.getCurrentUser().getEmail());
              FirebaseFirestore.getInstance().collection("Games").document().set(gameManager1).addOnSuccessListener(new OnSuccessListener<Void>() {
                  @Override
                  public void onSuccess(Void aVoid) {
                      Toast.makeText(HomeActivity.this,"create game has been successful",Toast.LENGTH_SHORT).show();
                  }

              }).addOnFailureListener(new OnFailureListener() {
                  @Override
                  public void onFailure(@NonNull Exception e) {
                      Toast.makeText(HomeActivity.this,"create game has been failed",Toast.LENGTH_SHORT).show();
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









    }











}