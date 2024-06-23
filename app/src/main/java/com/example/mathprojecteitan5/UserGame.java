package com.example.mathprojecteitan5;

import com.example.mathprojecteitan5.mathproject.Picture;

public class UserGame {
    private String name;
    private int id;
    private int score;
    private String question;
    private boolean answer;
    private ACharacter selectedPic;
    private int currentDown;
    private int currentUp;


    public UserGame() {
        this.name = "name";
        this.score = 0;
        this.currentDown = 0;
        this.currentUp = 24;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ACharacter getSelectedPic() {
        return selectedPic;
    }

    public void setSelectedPic(ACharacter selectedPic) {
        this.selectedPic = selectedPic;
    }

    public int getCurrentDown() {
        return currentDown;
    }

    public void setCurrentDown(int currentDown) {
        this.currentDown = currentDown;
    }

    public int getCurrentUp() {
        return currentUp;
    }

    public void setCurrentUp(int currentUp) {
        this.currentUp = currentUp;
    }


}
