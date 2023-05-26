package com.example.myapplication0.ui.dailymeal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication0.R;
import com.example.myapplication0.adapters.daiyMailAdapter;
import com.example.myapplication0.databinding.FragmentDailymealBinding;

import java.util.ArrayList;
import java.util.List;

import db.dailyRecyclerview;

public class DailymealFragment extends Fragment {
RecyclerView recyclerView;
    List<dailyRecyclerview> list;
    com.example.myapplication0.adapters.daiyMailAdapter daiyMailAdapter;
    private FragmentDailymealBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDailymealBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        list=new ArrayList<>();
        list.add(new dailyRecyclerview(R.drawable.breakfast,"breakfast","15% off","this breakfast is delcios and special type","breakfast"));
        list.add(new dailyRecyclerview(R.drawable.lunch,"lunch","10% off","this lunch is lunch and special type","lunch"));
        list.add(new dailyRecyclerview(R.drawable.dinner,"Dinner","20% off","this dinner is delcios and special type","Dinner"));
        list.add(new dailyRecyclerview(R.drawable.sweets,"sweets","30% off","this sweets is delcios and special type","sweets"));
        list.add(new dailyRecyclerview(R.drawable.coffe,"coffe","15% off","this coffe is delcios and special type","coffe"));

        daiyMailAdapter=new daiyMailAdapter(getContext(),list);

        recyclerView= root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(daiyMailAdapter);
        daiyMailAdapter.notifyDataSetChanged();

       return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}