package com.example.foodhub;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.foodhub.ui.Filter_screen;

public class GlobalMethod extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public  void go_screen( Class screen){
        Intent i = new Intent(this,screen);
        startActivity(i);
        Animatoo.animateZoom(this);
    }
    public void filter(View view) {
        go_screen(Filter_screen.class);
    }

    public   void setText(int id,String txt){
        TextView lbl = findViewById(id);
        lbl.setText(txt);
    }


    public   void remove_view(int ... ids){
        for (int id : ids)
            findViewById(id).setVisibility(View.INVISIBLE);
    }

    public void createFoodTypesAdapter(View view,int id, RecyclerView.Adapter  adapter) {
        RecyclerView recyclerView;
        recyclerView = view.findViewById(id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }
    public void createFoodTypesAdapter(int id, RecyclerView.Adapter  adapter, RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        recyclerView = findViewById(id);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    public void toggle( int id) {
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


    public void back(View view) {
        finish();
    }


}
