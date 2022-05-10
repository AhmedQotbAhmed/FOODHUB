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

public class FoodTypesFilterAdapter extends RecyclerView.Adapter<FoodTypesFilterAdapter.Holder> {
    Context context;


    Holder lastHolder = null;



    public FoodTypesFilterAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Holder holder = new Holder(LayoutInflater.from(context).inflate(R.layout.item_food_type_filter, parent, false));

        holder.cardView.setAlpha((float) 0.8);


        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (lastHolder != null)
                    set_styleColor(lastHolder, "#000000", (float) 0.8, R.color.white);
                set_styleColor(holder, "#FFFFFF", (float) 1, R.color.orange);
                lastHolder = holder;
                YoYo.with(Techniques.FadeInUp)
                        .duration(500)
                        .playOn(holder.cardView);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (position == 0) {
            set_styleColor(holder, "#FFFFFF", (float) 1, R.color.orange);
            lastHolder = holder;
        }

    }

    void set_styleColor(Holder holder, String textColor, float alpha, int BackgroundColor) {
        holder.cardView.setCardBackgroundColor(context.getResources().getColor(BackgroundColor));
        holder.lbl_type_name.setTextColor(Color.parseColor(textColor));
        holder.cardView.setAlpha((float) alpha);

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


}
