package com.example.mathprojecteitan5.mathproject;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mathprojecteitan5.R;

import java.util.ArrayList;

public class MyUserAdapter extends RecyclerView.Adapter<MyUserAdapter.MyViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(userName item);

    }

    private ArrayList<userName> users;
    private OnItemClickListener listener;


    public MyUserAdapter(ArrayList<userName> users, OnItemClickListener listener) {
        this.users = users;
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
        holder.bind(users.get(position), listener);
    }


    //@Override
   // public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull List<Object> payloads) {
      //  super.onBindViewHolder(holder, position, payloads);

    //}

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName;
        ImageView ivUserImage;
        TextView tvRate;
        TextView tvScore;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            ivUserImage = itemView.findViewById(R.id.ivUserImg);
            tvRate=itemView.findViewById(R.id.tvRate);
            tvScore=itemView.findViewById(R.id.tvScore);
        }


    public void bind(final userName item, final OnItemClickListener
            listener) {

        tvUserName.setText(item.getName()+"");
        Bitmap bitmap=(item.getBitmap());
        if(bitmap==null){
            ivUserImage.setImageResource(R.drawable.userpic);
        }
        else
            ivUserImage.setImageBitmap(bitmap);

        tvScore.setText(item.getScore()+"");
        tvRate.setText(item.getRate()+"");
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
    }

}







}
