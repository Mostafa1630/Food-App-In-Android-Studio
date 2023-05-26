package com.example.myapplication0.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication0.DetailedDailyMealActivity;
import com.example.myapplication0.R;

import java.util.List;

import db.dailyRecyclerview;

public class daiyMailAdapter extends RecyclerView.Adapter<daiyMailAdapter.ViewHolder> {
   Context context;
   List<dailyRecyclerview> list;

    public daiyMailAdapter(Context context, List<dailyRecyclerview> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public daiyMailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_meal_fp,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull daiyMailAdapter.ViewHolder holder, int position) {
holder.imageView.setImageResource(list.get(position).getImage());
holder.name.setText(list.get(position).getName());
        holder.decount.setText(list.get(position).getDescount());
        holder.description.setText(list.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //        Toast.makeText(context, "clicked.......", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context , DetailedDailyMealActivity.class);
                intent.putExtra("type",list.get(position).getType());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       ImageView imageView;
       TextView name,decount,description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView2);
            name=itemView.findViewById(R.id.textView2);
            decount=itemView.findViewById(R.id.textView4);
            description=itemView.findViewById(R.id.textView3);


        }
    }
}
