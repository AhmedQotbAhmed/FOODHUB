package com.example.foodhub.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodhub.GlobalMethod;
import com.example.foodhub.R;
import com.example.foodhub.recyclerView_adapter.FeaturedAdapter;
import com.example.foodhub.recyclerView_adapter.Featured_itemAdapter;
import com.example.foodhub.recyclerView_adapter.FoodTypesAdapter;
import com.example.foodhub.recyclerView_adapter.PopularAdapter;

public class RestaurantProfile extends GlobalMethod {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_profile);

      createFoodTypesAdapter( R.id.featured_recycler_view, new Featured_itemAdapter(this),new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        createFoodTypesAdapter( R.id.popular_recycler_view, new PopularAdapter(this),new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }
}