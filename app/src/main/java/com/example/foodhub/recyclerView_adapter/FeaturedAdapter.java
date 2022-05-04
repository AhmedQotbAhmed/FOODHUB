package com.example.foodhub.recyclerView_adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.foodhub.R;
import com.example.foodhub.ui.FoodDetails;
import com.example.foodhub.ui.Home_Screen;
import com.example.foodhub.ui.VerificationCode;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.Holder> {
    Context context;



    public FeaturedAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Holder holder = new Holder(LayoutInflater.from(context).inflate(R.layout.item_featured_restaurants, parent, false));


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

        public Holder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, FoodDetails.class));
                    Animatoo.animateSlideLeft(context);
                }
            });


        }
    }



}
