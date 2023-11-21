package com.example.mathprojecteitan5;

import android.widget.EditText;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private userName userV=new userName();
    int type;
    MutableLiveData<Integer> vNum1= new MutableLiveData<>();
    MutableLiveData<Integer> vNum2= new MutableLiveData<>();
    Exercise e2= new Exercise();
    public void mullBrd()
    {
        type=1;
        vNum1.setValue(e2.mullBrd());
        vNum2.setValue(e2.mullBrd());
    }
    public void x20()
    {
        type=2;
        vNum1.setValue(e2.X20());
        vNum2.setValue(e2.X20());

    }
    public void challenge()
    {
        type=3;
        vNum1.setValue(e2.challange());
        vNum2.setValue(e2.challange());

    }

     public String answer (EditText answer) {
       return e2.answer(answer);

     }
public void setUSerName (String username){
        userV.setName(username);
}


}
