package com.example.foodhub.recyclerView_adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodhub.R;

import java.util.ArrayList;
import java.util.List;

public class FoodTypesAdapter extends RecyclerView.Adapter<FoodTypesAdapter.Holder> {
    Context context;

    List<CardView> cardViewList = new ArrayList<>();
    List<TextView> textList = new ArrayList<>();


    GestureDetector mGestureDetector;

    public FoodTypesAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Holder holder = new Holder(LayoutInflater.from(context).inflate(R.layout.item_food_type, parent, false));
        cardViewList.add(holder.cardView);
        textList.add(holder.lbl_type_name);
        holder.cardView.setAlpha((float) 0.8);
        if (cardViewList.size() == 1) {
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.orange));
            holder.cardView.setAlpha(1);
            holder.lbl_type_name.setTextColor(Color.parseColor("#FFFFFF"));
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //All card color is set to colorDefault
                set_styleDefault();
                //The selected card is set to colorSelected
                holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.orange));
                holder.cardView.setAlpha(1);
                holder.lbl_type_name.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {


    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    public class Holder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView lbl_type_name;
        ImageView image_type_name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            lbl_type_name = itemView.findViewById(R.id.lbl_type_name);
            image_type_name = itemView.findViewById(R.id.img_type_name);

        }
    }

    void set_styleDefault() {
        for (int i = 0; i < cardViewList.size(); i++) {
            cardViewList.get(i).setCardBackgroundColor(context.getResources().getColor(R.color.white));
            cardViewList.get(i).setAlpha((float) 0.8);
            textList.get(i).setTextColor(Color.parseColor("#000000"));
        }

    }

}
