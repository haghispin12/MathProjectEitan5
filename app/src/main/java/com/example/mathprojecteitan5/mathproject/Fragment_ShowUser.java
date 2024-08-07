package com.example.mathprojecteitan5.mathproject;

import static android.app.Activity.RESULT_OK;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mathprojecteitan5.R;

import java.util.ArrayList;


public class Fragment_ShowUser extends Fragment {

    private View v;
    private ImageView showPic;
    private TextView username;
    private MainViewModel fragViewModel;
    private TextView scoreFrag;
    private Uri uri;
    private Button addPicture;
    private Button addUser;
    private RecyclerView recyclerView;
    private MyUserAdapter FragMyUserAdapter;
    private MenuItem itemDelete;
    private MenuItem itemEdit;
    private EditText editUser;
    private userName tempUser;
    int flag=0;


    ActivityResultLauncher<Intent> startCamera = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        showPic.setImageURI(uri);
                        fragViewModel.setUri(uri);
                    }
                }
            });
///////////////////////////////////////
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu,menu);
        itemDelete=menu.findItem(R.id.action_delete);
        itemDelete.setVisible(false);
        itemEdit=menu.findItem(R.id.action_edit);
        itemEdit.setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.action_delete:
                fragViewModel.VDelete(tempUser,requireActivity());
                return true;
            case R.id.action_edit:
                flag=1;
                addUser.setText("Update");
                username.setVisibility(View.GONE);
                editUser.setVisibility(View.VISIBLE);

                return true;
        }

        return false;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    /////////////////////////////////////////////////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__show_user, container, false);
        username = v.findViewById(R.id.fragUserName);
        scoreFrag = v.findViewById(R.id.scoreFrag);
        recyclerView = v.findViewById(R.id.rcShowUsers);
        fragViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        username.setText(fragViewModel.getName() + "");
        scoreFrag.setText(fragViewModel.getScore() + "");
        showPic = v.findViewById(R.id.showPic);
        addPicture = v.findViewById(R.id.addPicture);

        editUser = v.findViewById(R.id.editUser);////////////הרגע הוספתי

        addPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();

                values.put(MediaStore.Images.Media.TITLE, "New Picture");

                values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera");

                uri = requireContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

                startCamera.launch(cameraIntent);

            }
        });

        addUser = v.findViewById(R.id.addUser);

        /// לבדוק למה יש לי בעיה עם ה this אולי לא שמתי במקום הנכון
        fragViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        fragViewModel.users.observe(requireActivity(), new Observer<ArrayList<userName>>() {
            @Override
            public void onChanged(ArrayList<userName> array) {

                //createUADP(array);
            }
        });
        fragViewModel.selectAll(requireActivity());
///////////////////////////
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0)
                    fragViewModel.VInsert(requireContext());
                if (flag == 1) {
                    tempUser.setName(editUser.getText().toString());
                    fragViewModel.VUpdate(tempUser, requireActivity());
                    flag = 0;
                    addUser.setText("Add User");
                    username.setText(tempUser.getName().toString());
                    username.setVisibility(View.VISIBLE);
                    editUser.setVisibility(View.GONE);

                }
                //להוסיף פעולת update דרך DbHELPER
                //עשיתי כבר משתנה שישמר ברגע שלוחצים על משתנה כלשהו

            }
        });
        return v;
    }
//
///////////////////////////
//
//        return v;
//    }
//
//        public void createUADP (ArrayList < userName > users) {
//            FragMyUserAdapter = new MyUserAdapter(users, new MyUserAdapter.OnItemClickListener() {
//                @Override
//                public void onItemClick(userName item) { /////////////////////////////
//                    itemDelete.setVisible(true);
//                    itemEdit.setVisible(true);
//                    tempUser = item;
//                    username.setText(tempUser.getName() + "");
//                    scoreFrag.setText(tempUser.getScore() + "");
//                    showPic.setImageBitmap(tempUser.getBitmap());
//                    //להוסיף edit
//                    //להוסיף delete
//
//
//                }
//
//            });
//            recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
//            recyclerView.setAdapter(FragMyUserAdapter);
//            recyclerView.setHasFixedSize(true);
//        }
//    }
//
//
//
}