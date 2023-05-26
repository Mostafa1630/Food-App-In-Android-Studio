package com.example.myapplication0.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.myapplication0.R;
import com.example.myapplication0.adapters.FeaturedVerAdapter;
import com.example.myapplication0.adapters.featuredAdapter;

import java.util.ArrayList;
import java.util.List;

import db.FeaturedModel;
import db.FeaturedVerModel;


public class FirstFragment extends Fragment {
List<FeaturedModel> list;
    featuredAdapter featuredAdapter;
    RecyclerView recyclerView;

    List<FeaturedVerModel>  list_v;
    RecyclerView recyclerView2;
    FeaturedVerAdapter featuredVerAdapter;
    public FirstFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View view =inflater.inflate(R.layout.fragment_first, container, false);
//////////////////////horizontal
list=new ArrayList<>();

list.add(new FeaturedModel(R.drawable.fav1,"Feartured 1","descrintion  1"));
list.add(new FeaturedModel(R.drawable.fav2,"Feartured 2","descrintion  2"));
list.add(new FeaturedModel(R.drawable.fav3,"Feartured 3","descrintion  3"));
        featuredAdapter= new featuredAdapter(list);
        recyclerView=view.findViewById(R.id.featured_hor_res);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(featuredAdapter);
//////////////////////vertical
        recyclerView2 = view.findViewById(R.id.featured_ver_res);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        list_v =new ArrayList<>();
        list_v.add(new FeaturedVerModel(R.drawable.ver1,"Featured1","Description1","4.8","10:00 - 8:00"));
        list_v.add(new FeaturedVerModel(R.drawable.ver2,"Featured2","Description2","4.8","10:00 - 8:00"));
        list_v.add(new FeaturedVerModel(R.drawable.ver3,"Featured3","Description3","4.8","10:00 - 8:00"));
        list_v.add(new FeaturedVerModel(R.drawable.ver1,"Featured1","Description1","4.8","10:00 - 8:00"));
        list_v.add(new FeaturedVerModel(R.drawable.ver2,"Featured2","Description2","4.8","10:00 - 8:00"));
        list_v.add(new FeaturedVerModel(R.drawable.ver3,"Featured3","Description3","4.8","10:00 - 8:00"));

        featuredVerAdapter =new FeaturedVerAdapter(list_v);
        recyclerView2.setAdapter(featuredVerAdapter);



        return view ;
    }
}