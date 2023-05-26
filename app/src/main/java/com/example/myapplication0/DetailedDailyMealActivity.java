package com.example.myapplication0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.myapplication0.adapters.DetailedDailyAdapters;

import java.util.ArrayList;
import java.util.List;

import db.DetailedDailyModel;


public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel> detailedDailyModels;
    DetailedDailyAdapters dailyAdapters;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daiteled_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_imgs);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModels = new ArrayList<>();
        dailyAdapters = new DetailedDailyAdapters(detailedDailyModels,this);
        recyclerView.setAdapter(dailyAdapters);

        if(type != null && type.equalsIgnoreCase("breakfast")){
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fav1,"Breakfast","description","4.4","40","10 to 9","typee 1"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fav2,"Breakfast","description","4.4","40","10 to 9","type 2"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fav3,"Breakfast","description","4.4","40","10 to 9","type 3"));
            dailyAdapters.notifyDataSetChanged();

        }



        if(type != null && type.equalsIgnoreCase("sweets")){

            imageView.setImageResource(R.drawable.sweets);
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.s1,"sweet","description","4.4","40","10am to 9pm","type 1"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.s2,"sweet","description","4.4","40","10am to 9pm","type 2"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.s3,"sweet","description","4.4","40","10am to 9pm","type 3"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.s4,"sweet","description","4.4","40","10am to 9pm","type 4"));
            dailyAdapters.notifyDataSetChanged();

        }

    }
}