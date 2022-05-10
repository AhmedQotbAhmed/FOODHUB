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
import com.example.foodhub.ui.Login;
import com.example.foodhub.ui.RessetPassword;
import com.example.foodhub.ui.RestaurantProfile;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Holder> {
    Context context;



    public PopularAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Holder holder = new Holder(LayoutInflater.from(context).inflate(R.layout.item_popular, parent, false));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, FoodDetails.class));
                Animatoo.animateSlideLeft(context);
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

        public Holder(@NonNull View itemView) {
            super(itemView);


        }
    }



}
