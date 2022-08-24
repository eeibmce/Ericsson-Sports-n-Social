package com.example.sportsnspocialapp;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        String opponentName = getIntent().getStringExtra("OpponentName");
        TextView textOpponent = findViewById(R.id.textViewOpponent);

        //Add name to textview
        textOpponent.setText("with "+opponentName);

        //postDelayed method, Causes the Runnable r (in this case Class B) to be added to the message queue, to be run
        // after the specified amount of time elapses.
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String opponentName = getIntent().getStringExtra("OpponentName");
                //Carrying inputCode variable
                String inputCode = getIntent().getStringExtra("inputID");


                Intent intent = new Intent(GameActivity.this, ResultActivity.class);

                intent.putExtra("OpponentName", opponentName);
                intent.putExtra("inputID", inputCode);
                startActivity(intent);
//                finish();

            }
            //Here after the comma you specify the amount of time you want the screen to be delayed. 5000 is for 5 seconds.
        }, 5000);
    }

    //Override onBackPressed method and give it no functionality. This way when the user clicks the back button he will not go back.
    public void onBackPressed() {

    } }

//    public void openGameActivity() {
//        try {
//            sleep(3000);
//            Intent intent = new Intent(this, HomePage.class);
//            startActivity(intent);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }




//    final ProgressBar progressBar = findViewById(R.id.progressBar);

    // show the progress bar


