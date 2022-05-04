package com.example.foodhub.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.foodhub.R;

public class Sign_Up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void loin(View view) {
        startActivity(new Intent(Sign_Up.this, Login.class));
        Animatoo.animateSlideLeft(Sign_Up.this);
    }
}