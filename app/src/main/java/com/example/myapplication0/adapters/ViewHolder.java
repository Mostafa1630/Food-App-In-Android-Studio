package com.example.myapplication0.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication0.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView txt;
    CardView cardView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.card1_img1);
        txt = itemView.findViewById(R.id.card1_txt1);
        cardView = itemView.findViewById(R.id.card_view1);
    }
}
