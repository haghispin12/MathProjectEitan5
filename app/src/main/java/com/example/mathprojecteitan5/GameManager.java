package com.example.mathprojecteitan5;

import androidx.annotation.Keep;

import com.example.mathprojecteitan5.mathproject.Picture;
@Keep
public class GameManager {
     public String GameId;
      public String user1;
     public String user2;
     public int GameStatus;
     public String currentTurn;




    public GameManager(String gameId, String user1) {
        GameId = gameId;
        this.user1 = user1;
        this.user2 = "";
        GameStatus = 0;
        currentTurn="1";
    }




    public void AddToFireStore() {


    }


}

