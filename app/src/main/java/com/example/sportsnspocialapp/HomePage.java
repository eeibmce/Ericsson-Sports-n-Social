package com.example.sportsnspocialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ImageButton btnAddPool = (ImageButton)findViewById(R.id.imageButtonPool);

        btnAddPool.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                openPoolActivity();
            }
        });


    }

    public void openPoolActivity(){
        Intent intent = new Intent(this, PoolActivity.class);
        startActivity(intent);
    }
}