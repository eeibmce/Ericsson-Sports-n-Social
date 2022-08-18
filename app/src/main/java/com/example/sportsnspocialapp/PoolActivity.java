package com.example.sportsnspocialapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PoolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool);
    }
    public void openRaffle() {
        Intent intent = new Intent(this, Raffle.class);
        startActivity(intent);
    }
}