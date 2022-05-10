package com.example.foodhub.ui;

import android.os.Bundle;
import android.view.View;

import com.example.foodhub.GlobalMethod;
import com.example.foodhub.R;

public class Delivery_Address extends GlobalMethod {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_address);
    }

    public void goScreen_(View view) {
        go_screen(NewAddress.class);
    }
}