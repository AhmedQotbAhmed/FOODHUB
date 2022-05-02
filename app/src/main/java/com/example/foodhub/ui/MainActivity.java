package com.example.foodhub.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.RatingBar;

import com.example.foodhub.R;

public class MainActivity extends AppCompatActivity {
    RatingBar rt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_details);
//        rt = findViewById(R.id.ratingBar);
//        LayerDrawable stars = (LayerDrawable) rt.getProgressDrawable();
//
//        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
////        String.valueOf(rt.getRating())

    }
}