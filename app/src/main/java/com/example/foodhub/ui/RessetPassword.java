package com.example.foodhub.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.foodhub.R;

public class RessetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resset_password);
    }
    public void change_password(View view){
        startActivity(new Intent(RessetPassword.this, VerificationCode.class));
        Animatoo.animateSlideLeft(RessetPassword.this);
    }
}