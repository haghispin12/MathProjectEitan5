package com.example.mathprojecteitan5.mathproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.EditText;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    userName userV=new userName();
    int type;
    MutableLiveData<Integer> vNum1= new MutableLiveData<>();
    MutableLiveData<Integer> vNum2= new MutableLiveData<>();
    MutableLiveData<Integer> vScore= new MutableLiveData<>();
    MutableLiveData<ArrayList<userName>> users=new MutableLiveData<>();
    //DBHelper VDB;
    Exercise e2= new Exercise();



    public void mullBrd()
    {
        type=5;
        vNum1.setValue(e2.mullBrd());
        vNum2.setValue(e2.mullBrd());
    }
    public void x20()
    {
        type=10;
        vNum1.setValue(e2.X20());
        vNum2.setValue(e2.X20());

    }
    public void challenge()
    {
        type=20;
        vNum1.setValue(e2.challange());
        vNum2.setValue(e2.challange());

    }

     public String answer (EditText answer) {
       String tmpAns=e2.answer(answer);
       if(tmpAns.equals("Well Done!!!")) {
           userV.Cscore(type);
           vScore.setValue(userV.getScore());
       }
            return tmpAns;
     }

     public void VInsert (Context context){
        DBHelper VDB=new DBHelper(context);
        userV.setId( VDB.insert(userV,context));
        selectAll(context);
     }

     public void VUpdate(userName tempUser, Context context){
        DBHelper VDB=new DBHelper(context);
        VDB.update(tempUser);
        selectAll(context);

     }

     public void VDelete(userName tempUser, Context context){
        DBHelper VDB=new DBHelper(context);
        VDB.deleteById(tempUser.getId());
        selectAll(context);
     }

     public String getName(){
        return userV.getName();
     }

     public int getScore(){
        return userV.getScore();
     }
public void setUSerName (String username){
        userV.setName(username);
}

public void setRate(int rate){
        userV.setRate(rate);
}

public void setUri(Uri uri){
        userV.setUri(uri);
}

public Uri getUri(){return userV.getUri();}

public Bitmap getBitMap(){
        return userV.getBitmap();
}

public void selectAll (Context context)
{
   DBHelper VDB = new DBHelper(context);
    ArrayList<userName> users = VDB.selectAll();
    this.users.setValue(users);
}




}
