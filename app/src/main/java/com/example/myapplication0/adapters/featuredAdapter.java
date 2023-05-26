package com.example.myapplication0.adapters;

import android.content.pm.FeatureInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication0.R;

import java.util.List;

import db.FeaturedModel;

public class featuredAdapter extends RecyclerView.Adapter<featuredAdapter.ViewHolder> {


    List<FeaturedModel> list;
    public  featuredAdapter(List<FeaturedModel>list){
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_hor_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.image.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDesc());

        }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name,desc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image =itemView.findViewById(R.id.featured_img);
            name =itemView.findViewById(R.id.featured_name);
            desc = itemView.findViewById(R.id.featured_des);

        }
    }
}
