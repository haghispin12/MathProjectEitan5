package com.example.mathprojecteitan5;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mathprojecteitan5.mathproject.MyUserAdapter;

import java.util.ArrayList;

public class GameViewModel extends ViewModel {
    ArrayList<ACharacter> Characters;

    public GameViewModel() {
        Characters = new ArrayList<ACharacter>();
        Characters.add(new ACharacter("Alex", true, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, true, false, true, true, false, true, R.drawable.alex));
        Characters.add(new ACharacter("Emily", false, PersonColor.RED, PersonColor.WHITE, PersonColor.BLUE, false, true, true, false, false, false, R.drawable.emily));
        Characters.add(new ACharacter("Daniel", true, PersonColor.BALD, PersonColor.WHITE, PersonColor.BROWN, true, false, false, true, true, false, R.drawable.daniel));
//        Characters.add(new ACharacter("Sophia", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.BROWN, true, true, false, false, false, true));
//        Characters.add(new ACharacter("Jamal", true, PersonColor.BROWN, PersonColor.BLACK, PersonColor.BROWN, true, true, false, false, false, false));
//        Characters.add(new ACharacter("Olivia", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, false, false, true, false, false, true));
//        Characters.add(new ACharacter("Malik", true, PersonColor.BALD, PersonColor.BLACK, PersonColor.BLUE, false, false, false, true, false, false));
//        Characters.add(new ACharacter("Chloe", false, PersonColor.WHITE, PersonColor.BLACK, PersonColor.BROWN, true, true, false, false, false, false));
//        Characters.add(new ACharacter("Ethan", true, PersonColor.RED, PersonColor.WHITE, PersonColor.BLUE, true, true, true, false, false, true));
//        Characters.add(new ACharacter("Ava", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, false, false, false, false, false, false));
//        Characters.add(new ACharacter("Noah", true, PersonColor.BALD, PersonColor.WHITE, PersonColor.BROWN, true, false, true, true, false, false));
//        Characters.add(new ACharacter("Mia", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.BLUE, true, true, false, false, false, false, R.drawable.mia));
//        Characters.add(new ACharacter("Isaiah", true, PersonColor.BROWN, PersonColor.BLACK, PersonColor.BROWN, true, false, true, false, false, false));
//        Characters.add(new ACharacter("Harper", false, PersonColor.RED, PersonColor.WHITE, PersonColor.GREEN, false, false, true, false, false, false));
//        Characters.add(new ACharacter("Caleb", true, PersonColor.BROWN, PersonColor.WHITE, PersonColor.BLUE, true, true, false, true, true, true));
//        Characters.add(new ACharacter("Zoe", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.BROWN, true, true, true, false, false, false));
//        Characters.add(new ACharacter("Amir", true, PersonColor.BALD, PersonColor.BLACK, PersonColor.GREEN, false, true, true, true, false, false));
//        Characters.add(new ACharacter("Aria", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.BLUE, false, false, false, false, false, true));
//        Characters.add(new ACharacter("Lucas", true, PersonColor.RED, PersonColor.WHITE, PersonColor.BROWN, true, false, false, false, false, false));
//        Characters.add(new ACharacter("Layla", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.GREEN, true, false, false, false, false, false));
//        Characters.add(new ACharacter("Omar", true, PersonColor.BALD, PersonColor.BLACK, PersonColor.BLUE, false, true, true, true, false, false));
//        Characters.add(new ACharacter("Lily", false, PersonColor.RED, PersonColor.WHITE, PersonColor.BROWN, true, false, true, false, false, false));
//        Characters.add(new ACharacter("Mason", true, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, true, true, false, false, false, true));
//        Characters.add(new ACharacter("Ava", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.BLUE, true, true, false, false, false, false));
   }






}
