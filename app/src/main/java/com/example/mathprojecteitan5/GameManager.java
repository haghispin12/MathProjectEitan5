package com.example.mathprojecteitan5;

import com.example.mathprojecteitan5.mathproject.Picture;

public class GameManager {
    private String GameId;
    private String user1;
    private String user2;
    private boolean GameStatus;


    public GameManager(String gameId, String user1) {
        GameId = gameId;
        this.user1 = user1;
        this.user2 = "";
        GameStatus = false;
    }




    public void AddToFireStore() {


    }


}

