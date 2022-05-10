package com.example.foodhub.fragment;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.foodhub.GlobalMethod;
import com.example.foodhub.R;
import com.example.foodhub.recyclerView_adapter.FeaturedAdapter;
import com.example.foodhub.recyclerView_adapter.FoodTypesAdapter;
import com.example.foodhub.recyclerView_adapter.PopularAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import com.ksudev.slidingrootnavigation.SlidingRootNavBuilder;

public class HomeFragment extends Fragment  {


    GlobalMethod globalMethod = new GlobalMethod();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    ImageButton menu;
    Toolbar toolbar;

    TextView lbl_profile;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        globalMethod.createFoodTypesAdapter(view, R.id.food_type_recycler_view, new FoodTypesAdapter(getContext()));
        globalMethod.createFoodTypesAdapter(view, R.id.featured_recycler_view, new FeaturedAdapter(getContext()));
        globalMethod.createFoodTypesAdapter(view, R.id.popular_recycler_view, new PopularAdapter(getContext()));
        menu = view.findViewById(R.id.navigation_btn);

        // attach to current activity;
//        resideMenu = new ResideMenu(view.getContext());
//        resideMenu.attachToActivity(getActivity());
        toolbar = view.findViewById(R.id.toolbar);



//        toolbar.setLogo(R.drawable.profile);
         lbl_profile = view.findViewById(R.id.lbl_profile);

         new SlidingRootNavBuilder(getActivity())
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        toolbar.setNavigationIcon(R.drawable.ic_menu);
        return view;
    }



}