package com.example.myapplication0.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication0.R;
import com.example.myapplication0.adapters.HomeAdaper;
import com.example.myapplication0.adapters.HomeAdapter2;
import com.example.myapplication0.adapters.UpdateVerticalRec;
import com.example.myapplication0.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

import db.HomeRecyclerview;
import db.HomeRecyclerview2;

public class HomeFragment extends Fragment implements UpdateVerticalRec {
RecyclerView recyclerView1,recyclerView2;
ArrayList<HomeRecyclerview> homeRecyclerviewList;
HomeAdaper homeAdaper;

ArrayList<HomeRecyclerview2>homeRecyclerview2List;
HomeAdapter2 homeAdapter2;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView1=root.findViewById(R.id.recyclerview_home);
        recyclerView2=root.findViewById(R.id.recyclerview_home2);
///////////////////////////////////////////////recyclerview_home
        homeRecyclerviewList=new ArrayList<>();

        homeRecyclerviewList.add(new HomeRecyclerview(R.drawable.sandwich,"Sandwich"));

        homeRecyclerviewList.add(new HomeRecyclerview(R.drawable.hamburger,"HamBurger"));
        homeRecyclerviewList.add(new HomeRecyclerview(R.drawable.fried_potatoes,"Fries"));
        homeRecyclerviewList.add(new HomeRecyclerview(R.drawable.ice_cream,"Ice Cream"));
        homeRecyclerviewList.add(new HomeRecyclerview(R.drawable.pizza,"Pizza"));
        homeAdaper=new HomeAdaper(this,getActivity(),homeRecyclerviewList);
        recyclerView1.setAdapter(homeAdaper);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setNestedScrollingEnabled(false);
        ////////////////////////recyclerview_home2
        homeRecyclerview2List=new ArrayList<>();
        homeAdapter2=new HomeAdapter2(getActivity(),homeRecyclerview2List);

        recyclerView2.setAdapter(homeAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void callback(int position, ArrayList<HomeRecyclerview2> list) {
        homeAdapter2=new HomeAdapter2(getContext(),list);
        recyclerView2.setAdapter(homeAdapter2);
    }
}