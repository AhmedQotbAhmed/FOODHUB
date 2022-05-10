package com.example.foodhub.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.foodhub.GlobalMethod;
import com.example.foodhub.R;

public class FoodDetails extends GlobalMethod {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_details);
    }
}