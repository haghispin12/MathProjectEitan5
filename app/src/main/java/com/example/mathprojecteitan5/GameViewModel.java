package com.example.mathprojecteitan5;

import androidx.lifecycle.ViewModel;

public class GameViewModel extends ViewModel {
    Character[] characters = new Character[24];


    public void setCharacters() {
        characters[0] = new Character("Alex", true, PersonColor.brown, PersonColor.white, PersonColor.green, true, false, true, true, false, true);
        characters[1] = new Character("Emily", false, PersonColor.red, PersonColor.white, PersonColor.blue, false, true, true, false, false, false);
        characters[2] = new Character("Daniel", true, PersonColor.bald, PersonColor.white, PersonColor.brown, true, false, false, true, true, false);
        characters[3] = new Character("Sophia", false, PersonColor.yellow, PersonColor.white, PersonColor.brown, true, true, false, false, false, true);
        characters[4] = new Character("Jamal", true, PersonColor.brown, PersonColor.BLACK, PersonColor.BROWN, true, true, false, false, false, false);
        characters[5] = new Character("Olivia", false, PersonColor.brown, PersonColor.WHITE, PersonColor.GREEN, false, false, true, false, false, true);
        characters[6] = new Character("Malik", true, PersonColor.bald, PersonColor.BLACK, PersonColor.BLUE, false, false, false, true, false, false);
        characters[7] = new Character("Chloe", false, PersonColor.white, PersonColor.BLACK, PersonColor.BROWN, true, true, false, false, false, false);
        characters[8] = new Character("Ethan", true, PersonColor.red, PersonColor.WHITE, PersonColor.BLUE, true, true, true, false, false, true);
        characters[9] = new Character("Ava", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, false, false, false, false, false, false);
        characters[10] = new Character("Noah", true, PersonColor.NONE, PersonColor.WHITE, PersonColor.BROWN, true, false, true, true, false, false);
        characters[11] = new Character("Mia", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.BLUE, true, true, false, false, false, false);
        characters[12] = new Character("Isaiah", true, PersonColor.BROWN, PersonColor.BLACK, PersonColor.BROWN, true, false, true, false, false, false);
        characters[13] = new Character("Harper", false, PersonColor.RED, PersonColor.WHITE, PersonColor.GREEN, false, false, true, false, false, false);
        characters[14] = new Character("Caleb", true, PersonColor.BROWN, PersonColor.WHITE, PersonColor.BLUE, true, true, false, true, true, true);
        characters[15] = new Character("Zoe", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.BROWN, true, true, true, false, false, false);
        characters[16] = new Character("Amir", true, PersonColor.NONE, PersonColor.BLACK, PersonColor.GREEN, false, true, true, true, false, false);
        characters[17] = new Character("Aria", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.BLUE, false, false, false, false, false, true);
        characters[18] = new Character("Lucas", true, PersonColor.RED, PersonColor.WHITE, PersonColor.BROWN, true, false, false, false, false, false);
        characters[19] = new Character("Layla", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.GREEN, true, false, false, false, false, false);
        characters[20] = new Character("Omar", true, PersonColor.NONE, PersonColor.BLACK, PersonColor.BLUE, false, true, true, true, false, false);
        characters[21] = new Character("Lily", false, PersonColor.RED, PersonColor.WHITE, PersonColor.BROWN, true, false, true, false, false, false);
        characters[22] = new Character("Mason", true, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, true, true, false, false, false, true);
        characters[23] = new Character("Ava", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.BLUE, true, true, false, false, false, false);
    }



}
