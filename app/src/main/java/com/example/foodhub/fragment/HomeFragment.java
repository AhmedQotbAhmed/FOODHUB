package com.example.foodhub.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodhub.GlobalMethod;
import com.example.foodhub.R;
import com.example.foodhub.recyclerView_adapter.FeaturedAdapter;
import com.example.foodhub.recyclerView_adapter.FoodTypesAdapter;
import com.example.foodhub.recyclerView_adapter.PopularAdapter;


public class HomeFragment extends Fragment {


    GlobalMethod globalMethod = new GlobalMethod();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        globalMethod.createFoodTypesAdapter(view, R.id.food_type_recycler_view, new FoodTypesAdapter(getContext()));
        globalMethod.createFoodTypesAdapter(view, R.id.featured_recycler_view, new FeaturedAdapter(getContext()));
        globalMethod.createFoodTypesAdapter(view, R.id.popular_recycler_view, new PopularAdapter(getContext()));


        return view;
    }


}