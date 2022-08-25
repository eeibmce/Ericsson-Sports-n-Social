package com.example.sportsnspocialapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.Position;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class Raffle extends AppCompatActivity {

    List raffleNames = new ArrayList();


    Button enterRaffle, raffleBack;
    TextView tv;
    Button reset;
    Button run;
    TextView message;
    private KonfettiView celebrationView;

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raffle);
        raffleBack = findViewById(R.id.back);
        enterRaffle = findViewById(R.id.enterButton);
        tv = findViewById(R.id.textView7);
        reset = findViewById(R.id.resetButton);
        run = findViewById(R.id.runButton);
        message = findViewById(R.id.textView8);
        celebrationView = findViewById(R.id.celebrationView);
        final Shape.DrawableShape[] drawableShape = {null};

        raffleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HomePage.class));
            }
        });

        enterRaffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                raffleNames.add(tv.getText());
                tv.setText("");
//        For this method I want to take what is in the text box and put it in an array
//        and clear the text box once it has been entered
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                raffleNames.clear();
                message.setText(" ");
                //        For this method I want to completely reset the raffle so a new one can be done
                //        I would also like it to reset the congratulations message

            }
        });


        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //For this method I want it to run the raffle
                //and randomly select a name from the array of the names of people who have entered
                //I would also like it to make the below text box visible and display the name of the winner
                //At the same time i would like a temporary animation show up and have a sound effect
                Random random = new Random();
                index = random.nextInt(raffleNames.size());
                System.out.println(raffleNames.get(index));
                TextView message = Raffle.this.findViewById(R.id.textView8);
                message.setVisibility(View.VISIBLE);
                message.setText("CONGRATULATIONS " + raffleNames.get(index) + "! ");


                EmitterConfig emitterConfig = new Emitter(5L, TimeUnit.SECONDS).perSecond(50);
                Party party = new PartyFactory(emitterConfig)
                        .angle(270)
                        .spread(90)
                        .setSpeedBetween(1f, 5f)
                        .timeToLive(2000L)
                        .sizes(new Size(12, 5f, 0.2f))
                        .position(0.0, 0.0, 1.0, 0.0)
                        .build();
                celebrationView.start(party);

                callClick();

            }
        });

    }

    public void callClick() {

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.click_sound);
        mediaPlayer.start();

    }





}