package com.example.mathprojecteitan5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Fragment_ShowUser extends Fragment {

    private View v;
    private TextView username;
    private MainViewModel fragViewModel;
    private TextView scoreFrag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment__show_user, container, false);
        username = v.findViewById(R.id.fragUserName);
        scoreFrag=v.findViewById(R.id.scoreFrag);

        fragViewModel=new ViewModelProvider(getActivity()).get(MainViewModel.class);
        username.setText(fragViewModel.getName()+"");
        scoreFrag.setText(fragViewModel.getScore()+"");
        return v;




    }
}