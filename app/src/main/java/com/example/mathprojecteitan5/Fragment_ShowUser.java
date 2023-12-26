package com.example.mathprojecteitan5;

import static android.app.Activity.RESULT_OK;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Fragment_ShowUser extends Fragment {

    private View v;
    private ImageView showPic;
    private TextView username;
    private MainViewModel fragViewModel;
    private TextView scoreFrag;
    private Uri uri;
    private Button addPicture;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__show_user, container, false);
        username = v.findViewById(R.id.fragUserName);
        scoreFrag = v.findViewById(R.id.scoreFrag);

        fragViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        username.setText(fragViewModel.getName() + "");
        scoreFrag.setText(fragViewModel.getScore() + "");
        showPic=v.findViewById(R.id.showPic);

        addPicture=v.findViewById(R.id.addPicture);
        addPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();

                values.put(MediaStore.Images.Media.TITLE, "New Picture");

                values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera");

                uri =
                        requireContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

                startCamera.launch(cameraIntent);


            }
        });

        return v;
    }




    ActivityResultLauncher<Intent> startCamera = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        showPic.setImageURI(uri);
                    }
                }
            });


}