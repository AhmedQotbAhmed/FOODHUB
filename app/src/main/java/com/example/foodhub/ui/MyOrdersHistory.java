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

public class MyOrdersHistory extends AppCompatActivity {
GlobalMethod methods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_orders_history);
        methods=new GlobalMethod();

    }

    public void onClick(View view) {
     toggle(view,view.getId());
    }
    public void toggle(View view, int id) {
        Button btn1 = findViewById(R.id.btn_upcoming);
        Button btn2 = findViewById(R.id.btn_history);

        if (id==R.id.btn_upcoming){
            btn1.setBackgroundResource(R.drawable.shape_toggle_1);
            btn1.setTextColor(Color.WHITE);
            btn2.setBackgroundResource(R.drawable.shape_toggle_2);
            btn2.setTextColor(getColor(R.color.orange));
        }
        else
        {
            btn2.setBackgroundResource(R.drawable.shape_toggle_1);
            btn2.setTextColor(Color.WHITE);
            btn1.setBackgroundResource(R.drawable.shape_toggle_2);
            btn1.setTextColor(getColor(R.color.orange));

        }

    }
}