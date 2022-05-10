package com.example.foodhub.recyclerView_adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.foodhub.R;

public class SearchFilterAdapter extends RecyclerView.Adapter<SearchFilterAdapter.Holder> {
    Context context;
    int anInt = R.layout.item_food_search;

    public SearchFilterAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Holder holder = new Holder(LayoutInflater.from(context).inflate(R.layout.item_food_search, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (position > 0) {
            holder.textView.setVisibility(View.GONE);
            holder.view.setVisibility(View.VISIBLE);
        }


    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 6;
    }


    public class Holder extends RecyclerView.ViewHolder {

        CardView view;
        TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.CardView);
            textView = itemView.findViewById(R.id.lbl_item1);

        }
    }


}
