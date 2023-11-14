package com.example.mathprojecteitan5;

import android.widget.EditText;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MutableLiveData<Integer> vNum1= new MutableLiveData<>();
    MutableLiveData<Integer> vNum2= new MutableLiveData<>();
    Exercise e2= new Exercise();
    public void mullBrd()
    {
        vNum1.setValue(e2.mullBrd());
        vNum2.setValue(e2.mullBrd());
    }
    public void x20()
    {
        vNum1.setValue(e2.X20());
        vNum2.setValue(e2.X20());

    }
    public void challenge()
    {
        vNum1.setValue(e2.challange());
        vNum2.setValue(e2.challange());

    }

     public String answer (EditText answer) {
       return e2.answer(answer);

     }


}
