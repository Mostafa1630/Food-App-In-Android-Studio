package com.example.myapplication0.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication0.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import db.HomeRecyclerview2;

public class HomeAdapter2 extends RecyclerView.Adapter<HomeAdapter2.ViewHolder> {
Context context;

    ArrayList<HomeRecyclerview2> homeAdapter2List;
BottomSheetDialog bottomSheetDialog;
    public HomeAdapter2(Context context, ArrayList<HomeRecyclerview2> homeAdapter2List) {
        this.context = context;
        this.homeAdapter2List = homeAdapter2List;
    }

    @NonNull
    @Override
    public HomeAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeAdapter2.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_home2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter2.ViewHolder holder, int position) {
        final String name=homeAdapter2List.get(position).getName();
        final String price=homeAdapter2List.get(position).getPricing();
        final String rating=homeAdapter2List.get(position).getRating();
        final String timing=homeAdapter2List.get(position).getTiming();
        final int image=homeAdapter2List.get(position).getImage();

        holder.imageView.setImageResource(homeAdapter2List.get(position).getImage());
        holder.name.setText(homeAdapter2List.get(position).getName());
        holder.price.setText(homeAdapter2List.get(position).getPricing());
        holder.rating.setText(homeAdapter2List.get(position).getRating());
        holder.timing.setText(homeAdapter2List.get(position).getTiming());
        holder.ratebar.setRating(Float.parseFloat (homeAdapter2List.get(position).getRating()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog=new BottomSheetDialog(context,R.style.BottomSheetTheme);
View sheetlayout=LayoutInflater.from(context).inflate(R.layout.bottm_sheet_dialog,null);
                sheetlayout.findViewById(R.id.add_to_cart).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "added to cart", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });
                ImageView  imageView=sheetlayout.findViewById(R.id.bottom_img);
                TextView   nam=sheetlayout.findViewById(R.id.bottom_name);
                TextView   timin=sheetlayout.findViewById(R.id.bottom_timing);
                TextView   ratin=sheetlayout.findViewById(R.id.bottom_rating);
                TextView   pric=sheetlayout.findViewById(R.id.bottom_price);
                imageView.setImageResource(image);
                nam.setText(name);
                timin.setText(timing);
                ratin.setText(rating);
                timin.setText(timing);
                pric.setText(price);
                bottomSheetDialog.setContentView(sheetlayout);
                bottomSheetDialog.show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return homeAdapter2List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,timing,rating,price;
RatingBar ratebar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.card2_img1);
            name=itemView.findViewById(R.id.name);
            timing=itemView.findViewById(R.id.timing);
            rating=itemView.findViewById(R.id.rating);
            price=itemView.findViewById(R.id.pricing);

            ratebar=itemView.findViewById(R.id.ratingBar);
        }
    }
}
