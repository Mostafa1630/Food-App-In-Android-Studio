package com.example.myapplication0.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication0.DetailedDailyMealActivity;
import com.example.myapplication0.R;

import java.util.List;

import db.DetailedDailyModel;

public class DetailedDailyAdapters extends RecyclerView.Adapter<DetailedDailyAdapters.VeiwHolder> {

    List<DetailedDailyModel> list;
Context context;
    public DetailedDailyAdapters(List<DetailedDailyModel> list,Context context) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public VeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VeiwHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detailed_daily_meal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VeiwHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.price.setText(list.get(position).getPrice());
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());
        holder.rating.setText(list.get(position).getRating());
        holder.timing.setText(list.get(position).getTiming());
        Toast.makeText(context, "clicked......."+position, Toast.LENGTH_SHORT).show();



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VeiwHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name,rating,price,timing,description;
        public VeiwHolder(@NonNull View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.detailed_img);
            price = itemView.findViewById(R.id.detailed_price);
            name = itemView.findViewById(R.id.detailed_name);
            description = itemView.findViewById(R.id.detailed_description);
            rating = itemView.findViewById(R.id.detailed_rating);
            timing = itemView.findViewById(R.id.detailed_timing);

        }
    }

}
