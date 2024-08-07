package com.example.mathprojecteitan5.mathproject;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mathprojecteitan5.ACharacter;
import com.example.mathprojecteitan5.R;

import java.util.ArrayList;

public class MyUserAdapter extends RecyclerView.Adapter<MyUserAdapter.MyViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(ACharacter item);

    }
    private ArrayList<ACharacter> characters;
    private OnItemClickListener listener;


    public MyUserAdapter(ArrayList<ACharacter> characters, OnItemClickListener listener) {
        this.characters = characters;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(characters.get(position), listener);
    }


    //@Override
   // public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull List<Object> payloads) {
      //  super.onBindViewHolder(holder, position, payloads);

    //}

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
//        ImageView ivUserImage;
        ImageView characterPic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            characterPic=itemView.findViewById((R.id.character_pic));
//            ivUserImage = itemView.findViewById(R.id.ivUserImg);

        }


    public void bind(final ACharacter item, final OnItemClickListener listener) {
            characterPic.setImageResource(item.getPicture());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
    }

}







}
