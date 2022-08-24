package com.example.sportsnspocialapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {
    ImageButton mToGolfBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mToGolfBtn = findViewById(R.id.imageButtonGolf);

        mToGolfBtn.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), GolfActivity.class);
            startActivity(i);
        });


        }
    }