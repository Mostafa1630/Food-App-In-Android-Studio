package com.example.myapplication0.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication0.R;

import java.util.ArrayList;
import java.util.List;

import db.HomeRecyclerview;
import db.HomeRecyclerview2;

public class HomeAdaper extends RecyclerView.Adapter<HomeAdaper.ViewHolder> {
    UpdateVerticalRec updateVerticalRec;

    Activity activity;
    ArrayList<HomeRecyclerview> list;
    boolean checked = true;
    boolean selected = true;
    int row_index = -1;

    public HomeAdaper(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeRecyclerview> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdaper.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.img.setImageResource(list.get(position).getImage());
        holder.txt.setText(list.get(position).getName());

        if (checked) {
            ArrayList<HomeRecyclerview2> arrayList = new ArrayList<>();

            arrayList.add(new HomeRecyclerview2(R.drawable.sandwich1, "3", "55 $", "10:00 - 20:00", "Sandwich"));
            arrayList.add(new HomeRecyclerview2(R.drawable.sandwich2, "4.5", "45 $", "10:00 - 20:00", "Sandwich"));
            arrayList.add(new HomeRecyclerview2(R.drawable.sandwich3, "3", "27 $", "10:00 - 20:00", "Sandwich"));
            arrayList.add(new HomeRecyclerview2(R.drawable.sandwich4, "4.5", "45 $", "10:00 - 20:00", "Sandwich"));

            updateVerticalRec.callback(position, arrayList);
            checked = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList<HomeRecyclerview2> arrayList = new ArrayList<>();
                    row_index = position;
                    notifyDataSetChanged();
                    if (position == 0) {
                        arrayList.add(new HomeRecyclerview2(R.drawable.sandwich1, "3", "55 $", "10:00 - 20:00", "Sandwich"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.sandwich2, "4.5", "45 $", "10:00 - 20:00", "Sandwich"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.sandwich3, "3", "27 $", "10:00 - 20:00", "Sandwich"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.sandwich4, "4.5", "45 $", "10:00 - 20:00", "Sandwich"));

                    } else if (position == 1) {

                        arrayList.add(new HomeRecyclerview2(R.drawable.burger1, "3", "55 $", "10:00 - 20:00", "Burger"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.burger2, "4.5", "45 $", "10:00 - 20:00", "Burger"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.burger4, "3", "27 $", "10:00 - 20:00", "Burger"));

                    } else if (position == 2) {

                        arrayList.add(new HomeRecyclerview2(R.drawable.fries1, "3", "55 $", "10:00 - 20:00", "Fries"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.fries2, "4.5", "45 $", "10:00 - 20:00", "Fries"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.fries3, "3", "27 $", "10:00 - 20:00", "Fries"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.fries4, "4.5", "45 $", "10:00 - 20:00", "Fries"));


                    } else if (position == 3) {

                        arrayList.add(new HomeRecyclerview2(R.drawable.icecream1, "3", "55 $", "10:00 - 20:00", "Icecream"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.icecream2, "4.5", "45 $", "10:00 - 20:00", "Icecream"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.icecream3, "3", "27 $", "10:00 - 20:00", "Icecream"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.icecream4, "4.5", "45 $", "10:00 - 20:00", "Icecream"));


                    } else if (position == 4) {


                        arrayList.add(new HomeRecyclerview2(R.drawable.pizza1, "4.5", "55 $", "10:00 - 20:00", "Pizza"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.pizza2, "3.5", "45 $", "10:00 - 20:00", "Pizza"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.pizza3, "2", "27 $", "10:00 - 20:00", "Pizza"));
                        arrayList.add(new HomeRecyclerview2(R.drawable.pizza4, "1.5", "15 $", "10:00 - 20:00", "Pizza"));


                    }
                    updateVerticalRec.callback(position, arrayList);
                }
            });

            if (selected) {
                if (position == 0) {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);

                    selected = false;
                }
            } else {
                if (position == row_index) {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);

                } else {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);

                }
            }
        }




    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder  extends RecyclerView.ViewHolder{
       ImageView img;
       TextView txt;
       CardView cardView;

public ViewHolder(@NonNull View view){
    super(view);
img=view.findViewById(R.id.card1_img1);
txt=view.findViewById(R.id.card1_txt1);
cardView=view.findViewById(R.id.card_view1);


}
    }
}





