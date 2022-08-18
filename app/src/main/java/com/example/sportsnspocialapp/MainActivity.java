package com.example.sportsnspocialapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.navigation.fragment.findNavController;


public class MainActivity extends AppCompatActivity {
    private Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.fragment_home);

        ImageButton btnAddPool = (ImageButton) findViewById(R.id.imageButtonPool);

        btnAddPool.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openPoolActivity();
            }
        });

        ImageButton btnAddFootball = (ImageButton) findViewById(R.id.imageButtonFootball);

        btnAddFootball.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openFootballActivity();
            }
        });

        ImageButton btnAddGolf = (ImageButton) findViewById(R.id.imageButton2);

        btnAddGolf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openGolfActivity();
            }
        });

        ImageButton btnAddBasketball = (ImageButton) findViewById(R.id.imageButtonBasketball);

        btnAddBasketball.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openBasketballActivity();
            }
        });
    }

    public void openPoolActivity() {
        Intent intent = new Intent(this, PoolActivity.class);
        startActivity(intent);
    }

    public void openGolfActivity() {
        Intent intent = new Intent(this, GolfActivity.class);
        startActivity(intent);
    }

    public void openFootballActivity() {
        Intent intent = new Intent(this, FootballActivity.class);
        startActivity(intent);
    }

    public void openBasketballActivity() {
        Intent intent = new Intent(this, BasketballActivity.class);
        startActivity(intent);
    }

    public void browser(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ericsson.com/en/contact"));
        startActivity(browserIntent);
    }


    public void openChat_page() {
        Intent intent = new Intent(this, Chat_page.class);
        startActivity(intent);
        setContentView(R.layout.activity_chat_page);
    }




}
