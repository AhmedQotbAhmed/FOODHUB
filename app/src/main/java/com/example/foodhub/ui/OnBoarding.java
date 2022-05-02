package com.example.foodhub.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import com.example.foodhub.R;
import com.example.foodhub.recyclerView_adapter.IntroViewPagerAdapter;
import com.example.foodhub.model.ScreenItem;

import java.util.ArrayList;
import java.util.List;

public class OnBoarding extends AppCompatActivity {

    IntroViewPagerAdapter pagerAdapter;
    ImageView next;

    Animation btnAnim;

    private ViewPager screenPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding);

        btnAnim = AnimationUtils.loadAnimation(this, R.anim.button_animation);
        next = findViewById(R.id.next);


        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Browse your  menu and order directly", "Our app can send you everywhere, even space. For only $2.99 per month", R.drawable.onp1, R.drawable.ic_point1));
        mList.add(new ScreenItem("Even to space with us! Together", "Our app can send you everywhere, even space. For only $2.99 per month", R.drawable.onp2, R.drawable.ic_point2));
        mList.add(new ScreenItem("Pickup delivery at your door", "Our app can send you everywhere, even space. For only $2.99 per month", R.drawable.onp3, R.drawable.ic_point3));

        // setup viewpager
        screenPager = findViewById(R.id.screen_viewpager);
        pagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(pagerAdapter);
        next.setAnimation(btnAnim);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (screenPager.getCurrentItem() < 2) {
                    screenPager.setCurrentItem((screenPager.getCurrentItem() + 1));
                } else
                    startActivity(new Intent(OnBoarding.this, WelcomeActivity.class));


            }
        });


    }


}
