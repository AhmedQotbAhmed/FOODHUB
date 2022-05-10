package com.example.foodhub.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.foodhub.GlobalMethod;
import com.example.foodhub.R;
import com.example.foodhub.recyclerView_adapter.FoodTypesFilterAdapter;
import com.example.foodhub.recyclerView_adapter.SearchFilterAdapter;

public class SearchFood extends GlobalMethod {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_food);
        this.createFoodTypesAdapter(R.id.search_recycler_view
                , new SearchFilterAdapter(this), (new StaggeredGridLayoutManager( 2, StaggeredGridLayoutManager.VERTICAL)));

    }
    public void createFoodTypesAdapter(int id, RecyclerView.Adapter  adapter, RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        recyclerView = findViewById(id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void onClick(View view) {
        toggle(view.getId());
    }


}