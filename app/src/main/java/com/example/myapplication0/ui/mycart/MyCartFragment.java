package com.example.myapplication0.ui.mycart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication0.R;
import com.example.myapplication0.adapters.MyCartAdapter;
import com.example.myapplication0.databinding.FragmentMycartBinding;

import java.util.ArrayList;
import java.util.List;

import db.MyCartModel;

public class MyCartFragment extends Fragment {


    List<MyCartModel>list;
    MyCartAdapter myCartAdapter;
    RecyclerView recyclerView;

    private FragmentMycartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMycartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        list=new ArrayList<>();

        list.add(new MyCartModel(R.drawable.s1,"order 1","25","3.5"));

        list.add(new MyCartModel(R.drawable.s2,"order 1","25","5"));
        list.add(new MyCartModel(R.drawable.fav2,"order 1","25","4.5"));
        list.add(new MyCartModel(R.drawable.s4,"order 1","25","2.5"));
        myCartAdapter=new MyCartAdapter(list);
        recyclerView=root.findViewById(R.id.mycart_rec);
        recyclerView.setAdapter(myCartAdapter);
         recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        myCartAdapter.notifyDataSetChanged();
        return  root;
    }
}