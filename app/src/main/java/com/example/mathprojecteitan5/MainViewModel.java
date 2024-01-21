package com.example.mathprojecteitan5;

import android.content.Context;
import android.widget.EditText;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private userName userV=new userName();
    int type;
    MutableLiveData<Integer> vNum1= new MutableLiveData<>();
    MutableLiveData<Integer> vNum2= new MutableLiveData<>();
    MutableLiveData<Integer> vScore= new MutableLiveData<>();
    DBHelper VDB;
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
        VDB=new DBHelper(context);
        VDB.insert(userV,context);

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


}
