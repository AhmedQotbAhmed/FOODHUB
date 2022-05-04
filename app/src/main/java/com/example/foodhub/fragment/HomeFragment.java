package com.example.foodhub.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.example.foodhub.GlobalMethod;
import com.example.foodhub.R;
import com.example.foodhub.recyclerView_adapter.FeaturedAdapter;
import com.example.foodhub.recyclerView_adapter.FoodTypesAdapter;
import com.example.foodhub.recyclerView_adapter.PopularAdapter;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;


public class HomeFragment extends Fragment implements View.OnClickListener {


    GlobalMethod globalMethod = new GlobalMethod();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    ResideMenu resideMenu;
    ImageButton menu;

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
        resideMenu = new ResideMenu(view.getContext());
        resideMenu.attachToActivity(getActivity());


        // create menu items;
        int titles[] = {R.string.Eljad_Eendaz,R.string.My_Orders, R.string.My_Profile, R.string.Delivery_Address, R.string.Payment_Methods, R.string.Contact_Us,R.string.Settings,R.string.Helps_FAQs};
        int icon[] = { R.drawable.profile_image,R.drawable.ic_my_orders, R.drawable.ic_my_profile, R.drawable.ic_delivery_address,
                R.drawable.ic_payment_methods, R.drawable.ic_contact_us, R.drawable.ic_settings, R.drawable.ic_helps};

        for (int i = 0; i < titles.length; i++) {

            ResideMenuItem item = new ResideMenuItem(getContext(), icon[i], titles[i]);
            item.setOnClickListener(this);
            resideMenu.addMenuItem(item, ResideMenu.DIRECTION_LEFT);

        }


        resideMenu.setScaleValue((float) 0.55);
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_LEFT);
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
;


        return view;
    }



    @Override
    public void onClick(View view) {

    }
}