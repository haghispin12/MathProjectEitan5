package com.example.mathprojecteitan5;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mathprojecteitan5.mathproject.MyUserAdapter;
import com.example.mathprojecteitan5.mathproject.userName;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Closeable;
import java.util.ArrayList;

public class GameViewModel extends ViewModel {
    private ArrayList<ACharacter> Characters;
    MutableLiveData<ArrayList<ACharacter>> myCharacters=new MutableLiveData<>();
    UserGame userGame;
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    FirebaseAuth auth=FirebaseAuth.getInstance();
    String documentPath="";
    DocumentReference docRef=db.collection("Games").document();

    public GameViewModel() {
        Characters = new ArrayList<ACharacter>();
        Characters.add(new ACharacter("Alex", true, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, true, false, true, true, false, true, R.drawable.alex));
        Characters.add(new ACharacter("Emily", false, PersonColor.RED, PersonColor.WHITE, PersonColor.BLUE, false, true, true, false, false, false, R.drawable.emily));
        Characters.add(new ACharacter("Daniel", true, PersonColor.BALD, PersonColor.WHITE, PersonColor.BROWN, true, false, false, true, true, false, R.drawable.daniel));
        Characters.add(new ACharacter("Sophia", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.BROWN, true, true, false, false, false, true,R.drawable.sophia));
        Characters.add(new ACharacter("Jamal", true, PersonColor.BROWN, PersonColor.BLACK, PersonColor.BROWN, true, true, false, false, false, false,R.drawable.jamal));
       Characters.add(new ACharacter("Olivia", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, false, false, true, false, false, true,R.drawable.olivia));
        Characters.add(new ACharacter("Malik", true, PersonColor.BALD, PersonColor.BLACK, PersonColor.BLUE, false, false, false, true, false, false,R.drawable.malik));
        Characters.add(new ACharacter("Chloe", false, PersonColor.WHITE, PersonColor.BLACK, PersonColor.BROWN, true, true, false, false, false, false,R.drawable.chloe));
        Characters.add(new ACharacter("Ethan", true, PersonColor.RED, PersonColor.WHITE, PersonColor.BLUE, true, true, true, false, false, true,R.drawable.ethan));
       Characters.add(new ACharacter("Ava", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, false, false, false, false, false, false,R.drawable.ava));
        Characters.add(new ACharacter("Noah", true, PersonColor.BALD, PersonColor.WHITE, PersonColor.BROWN, true, false, true, true, false, false,R.drawable.noah));
        Characters.add(new ACharacter("Mia", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.BLUE, true, true, false, false, false, false, R.drawable.mia));
        Characters.add(new ACharacter("Isaiah", true, PersonColor.BROWN, PersonColor.BLACK, PersonColor.BROWN, true, false, true, false, false, false,R.drawable.isaiah));
        Characters.add(new ACharacter("Zoe", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.BROWN, true, true, true, false, false, false,R.drawable.zoe));
        Characters.add(new ACharacter("Caleb", true, PersonColor.BROWN, PersonColor.WHITE, PersonColor.BLUE, true, true, false, true, true, true,R.drawable.caleb));
        Characters.add(new ACharacter("Harper", false, PersonColor.RED, PersonColor.WHITE, PersonColor.GREEN, false, false, true, false, false, false,R.drawable.harper));
        Characters.add(new ACharacter("Amir", true, PersonColor.BALD, PersonColor.BLACK, PersonColor.GREEN, false, true, true, true, false, false,R.drawable.amir));
        Characters.add(new ACharacter("Aria", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.BLUE, false, false, false, false, false, true,R.drawable.aria));
        Characters.add(new ACharacter("Lucas", true, PersonColor.RED, PersonColor.WHITE, PersonColor.BROWN, true, false, false, false, false, false,R.drawable.lucas));
        Characters.add(new ACharacter("Layla", false, PersonColor.YELLOW, PersonColor.WHITE, PersonColor.GREEN, true, false, false, false, false, false,R.drawable.layla));
        Characters.add(new ACharacter("Omar", true, PersonColor.WHITE, PersonColor.BLACK, PersonColor.BLUE, false, true, true, true, false, false,R.drawable.omar));
        Characters.add(new ACharacter("Lily", false, PersonColor.RED, PersonColor.WHITE, PersonColor.BROWN, true, false, true, false, false, false,R.drawable.lily));
       Characters.add(new ACharacter("Mason", true, PersonColor.BROWN, PersonColor.WHITE, PersonColor.GREEN, true, false, false, false, false, false,R.drawable.mason));
       Characters.add(new ACharacter("Eden", false, PersonColor.BROWN, PersonColor.WHITE, PersonColor.BLUE, true, true, false, false, false, false,R.drawable.eden));
      myCharacters.setValue(Characters);
        this.userGame =new UserGame();

    }





    public ACharacter getSecretChar (String name){
        for(int i=0;i<Characters.size();i++){
            if(Characters.get(i).getName().equals(name))
                return Characters.get(i);
        }
        return Characters.get(1);
    }
    public ArrayList<ACharacter> getCharacters() {
        return Characters;
    }


public void flipBlondes(){
        for(int i=0;i<Characters.size();i++)
    {

       if (Characters.get(i).getHairColor()==PersonColor.YELLOW)
           Characters.get(i).setPicture(R.drawable.backgroundblue);
    }
        myCharacters.setValue(Characters);
}

    public void flipExceptBlondes(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getHairColor()!=PersonColor.YELLOW)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }

    public void flipBrownHair(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getHairColor()==PersonColor.BROWN)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }

    public void flipExceptBrownHair(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getHairColor()!=PersonColor.BROWN)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }

    public void flipWhiteHair(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getHairColor()==PersonColor.WHITE)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }
    public void flipExceptWhiteHair(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getHairColor()!=PersonColor.WHITE)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }
    public void flipRedHair(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getHairColor()==PersonColor.RED)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }

    public void flipExceptRedHair(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getHairColor()!=PersonColor.RED)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }
    public void flipBlueEyes(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getEyeColor()==PersonColor.BLUE)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }

    public void flipExceptBlueEyes(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getEyeColor()!=PersonColor.BLUE)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }

    public void flipGreenEyes(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getEyeColor()==PersonColor.GREEN)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }

    public void flipExceptGreenEyes(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getEyeColor()!=PersonColor.GREEN)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }


    public void flipBrownEyes(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getEyeColor()==PersonColor.BROWN)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }

    public void flipExceptBrownEyes(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getEyeColor()!=PersonColor.BROWN)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }

    public void flipBlackSkinEyes(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getSkinColor()==PersonColor.BLACK)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }
    public void flipWhiteSkinEyes(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).getSkinColor()==PersonColor.WHITE)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }

    public void flipGlasses(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).isHasGlasses()==true)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }
    public void flipExceptGlasses(){
        for(int i=0;i<Characters.size();i++)
        {

            if (Characters.get(i).isHasGlasses()==false)
                Characters.get(i).setPicture(R.drawable.backgroundblue);
        }
        myCharacters.setValue(Characters);
    }
    public UserGame getUserGame() {
        return userGame;
    }

    public void setUserGame(UserGame userGame) {
        this.userGame = userGame;
    }
}
