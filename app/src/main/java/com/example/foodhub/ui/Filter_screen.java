package com.example.foodhub.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.foodhub.GlobalMethod;
import com.example.foodhub.R;
import com.example.foodhub.recyclerView_adapter.FoodTypesAdapter;
import com.example.foodhub.recyclerView_adapter.FoodTypesFilterAdapter;
import com.example.foodhub.recyclerView_adapter.ShotyByFoodAdapter;

public class Filter_screen extends GlobalMethod {
    TextView lastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_screen);

        createFoodTypesAdapter(R.id.food_type_recycler_view
                , new FoodTypesFilterAdapter(this), (new GridLayoutManager(this, 3)));
        createFoodTypesAdapter(R.id.short_by_recycler_view
                , new ShotyByFoodAdapter(this), (new GridLayoutManager(this, 3)));

        lastView = findViewById(R.id.lbl_rate1);
        set_style((TextView) lastView, R.drawable.shape_toggle_1, R.color.white, R.drawable.ic_stare_rated);


    }

    public void toggle_rate(View view) {
        set_style((TextView) view, R.drawable.shape_toggle_1, R.color.white, R.drawable.ic_stare_rated);
        set_style((TextView) lastView, R.drawable.shape_buttom_light, R.color.title_color, R.drawable.ic_star_rate);
        lastView = ((TextView) view);
    }

    void set_style(TextView textView, int shape, int textColor, int Drawable) {
        textView.setBackgroundResource(shape);
        textView.setTextColor(getColor(textColor));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, Drawable, 0);
    }
}