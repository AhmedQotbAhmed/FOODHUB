package com.example.foodhub.ui;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodhub.GlobalMethod;
import com.example.foodhub.R;

public class Review_R_Activity extends GlobalMethod {
    RatingBar rt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_food);

        rt = findViewById(R.id.ratingBar);

        LayerDrawable stars = (LayerDrawable) rt.getProgressDrawable();

        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
//        String.valueOf(rt.getRating())

    }
}