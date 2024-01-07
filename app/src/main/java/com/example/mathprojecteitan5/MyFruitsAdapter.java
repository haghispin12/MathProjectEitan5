package com.example.mathprojecteitan5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyFruitsAdapter extends RecyclerView.Adapter<MyFruitsAdapter.MyViewHolder> {
  public interface OnItemClickListener{
      void onItemClick(Fruit item);

  }
private ArrayList<Fruit> fruits;
  private OnItemClickListener listener;


  public MyFruitsAdapter(ArrayList<Fruit> fruits, OnItemClickListener listener){
      this.fruits=fruits;
      this.listener=listener;
  }

  @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
return new MyViewHolder(view);

  }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }


@Override
    public int getItemCount(){
      return fruits.size();
}

public static class MyViewHolder extends RecyclerView.ViewHolder{
      TextView tvFruitName;
      ImageView ivFruitImage;

      public MyViewHolder (@NonNull View itemView){
          super(itemView);
          tvFruitName=itemView.findViewById(R.id.tvFruitName);
          ivFruitImage=itemView.findViewById(R.id.ivFruitImg);
      }
}










}
