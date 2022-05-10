package com.example.foodhub.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.foodhub.GlobalMethod;
import com.example.foodhub.R;

import java.util.zip.Inflater;

public class MyOrdersHistory extends GlobalMethod {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_orders_history);

    }

    public void onClick(View view) {
     toggle(view.getId());

    }

    public void goScreen_(View view) {
        go_screen(OrderDetails.class);
    }
}