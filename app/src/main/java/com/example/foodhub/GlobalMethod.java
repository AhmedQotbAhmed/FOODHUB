package com.example.foodhub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GlobalMethod extends AppCompatActivity {


    public  void go_screen(Class screen){
        Intent i = new Intent(this,screen);
        startActivity(i);
    }


    public   void setText(int id,String txt){
        TextView lbl = findViewById(id);
        lbl.setText(txt);
    }


    public   void remove_view(int ... ids){
        for (int id : ids)
            findViewById(id).setVisibility(View.INVISIBLE);
    }
    public   void createFoodTypesAdapter(View view, int id, RecyclerView.Adapter  adapter){
         RecyclerView recyclerView;
        recyclerView = view.findViewById(id);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }

}
