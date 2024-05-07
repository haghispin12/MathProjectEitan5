package com.example.mathprojecteitan5;

import androidx.lifecycle.ViewModel;

import com.example.mathprojecteitan5.mathproject.MyUserAdapter;

import java.util.ArrayList;

public class GameViewModel extends ViewModel {
   ArrayList<Character> characters = new ArrayList<>();


    public void setCharacters() {
        characters.add( new Character("Alex", true, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, true, false, true, true, false, true,R.drawable.alex));
        characters.add( new Character("Emily", false, PersonColor.RED, PersonColor.WHITE, PersonColor.BLUE, false, true, true, false, false, false,R.drawable.emily));
        characters.add( new Character("Daniel", true, PersonColor.BALD, PersonColor.WHITE, PersonColor.BROWN, true, false, false, true, true, false,R.drawable.daniel));
        characters.add( new Character("Sophia", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.BROWN, true, true, false, false, false, true));
        characters.add( new Character("Jamal", true, PersonColor.BROWN, PersonColor.BLACK, PersonColor.BROWN, true, true, false, false, false, false));
        characters.add( new Character("Olivia", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, false, false, true, false, false, true));
        characters.add( new Character("Malik", true, PersonColor.BALD, PersonColor.BLACK, PersonColor.BLUE, false, false, false, true, false, false));
        characters.add( new Character("Chloe", false, PersonColor.WHITE, PersonColor.BLACK, PersonColor.BROWN, true, true, false, false, false, false));
        characters.add( new Character("Ethan", true, PersonColor.RED, PersonColor.WHITE, PersonColor.BLUE, true, true, true, false, false, true));
        characters.add( new Character("Ava", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, false, false, false, false, false, false));
        characters.add( new Character("Noah", true, PersonColor.BALD, PersonColor.WHITE, PersonColor.BROWN, true, false, true, true, false, false));
        characters.add( new Character("Mia", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.BLUE, true, true, false, false, false, false,R.drawable.mia));
        characters.add( new Character("Isaiah", true, PersonColor.BROWN, PersonColor.BLACK, PersonColor.BROWN, true, false, true, false, false, false));
        characters.add( new Character("Harper", false, PersonColor.RED, PersonColor.WHITE, PersonColor.GREEN, false, false, true, false, false, false));
        characters.add( new Character("Caleb", true, PersonColor.BROWN, PersonColor.WHITE, PersonColor.BLUE, true, true, false, true, true, true));
        characters.add( new Character("Zoe", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.BROWN, true, true, true, false, false, false));
        characters.add( new Character("Amir", true, PersonColor.BALD, PersonColor.BLACK, PersonColor.GREEN, false, true, true, true, false, false));
        characters.add( new Character("Aria", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.BLUE, false, false, false, false, false, true));
        characters.add( new Character("Lucas", true, PersonColor.RED, PersonColor.WHITE, PersonColor.BROWN, true, false, false, false, false, false));
        characters.add( new Character("Layla", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.GREEN, true, false, false, false, false, false));
        characters.add( new Character("Omar", true, PersonColor.BALD, PersonColor.BLACK, PersonColor.BLUE, false, true, true, true, false, false));
        characters.add( new Character("Lily", false, PersonColor.RED, PersonColor.WHITE, PersonColor.BROWN, true, false, true, false, false, false));
        characters.add( new Character("Mason", true, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, true, true, false, false, false, true));
        characters.add( new Character("Ava", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.BLUE, true, true, false, false, false, false));
    }


}
