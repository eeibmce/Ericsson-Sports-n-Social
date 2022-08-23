package com.example.sportsnspocialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    ImageView menu;
    TextView calender, raffle, profile, tour;
    Button buttonContact;
    ImageButton foot, gaa, bad, golf, tag, squash, tabletennis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        menu = findViewById(R.id.menu);
        calender = findViewById(R.id.calender);
        raffle = findViewById(R.id.raffle);
        profile = findViewById(R.id.Profile);
        tour = findViewById(R.id.Tournament);
        buttonContact = findViewById(R.id.buttonContact);
        foot = findViewById(R.id.imageButtonFootball);
        gaa = findViewById(R.id.imageButtongaa);
        bad = findViewById(R.id.imageButtonBadminton);
        golf = findViewById(R.id.imageButtonGolf);
        squash = findViewById(R.id.imageButtonSquash);
        tag = findViewById(R.id.imageButtontag);
       tabletennis = findViewById(R.id.imageButtontennis);

// start part 1
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calender.getVisibility() == View.GONE) {
                    calender.setVisibility(View.VISIBLE);
                    raffle.setVisibility(View.VISIBLE);
                    profile.setVisibility(View.VISIBLE);
                    tour.setVisibility(View.VISIBLE);
                } else {
                    calender.setVisibility(View.GONE);
                    raffle.setVisibility(View.GONE);
                    profile.setVisibility(View.GONE);
                    tour.setVisibility(View.GONE);
                }

            }
        });
//        end part 1
//        start part 2
        tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TagRugbyActivity.class));

            }
        });
        tabletennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), WorkingTableTennis.class));
    }
});

        squash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SquashActivity.class));

            }
        });

        golf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GolfActivity.class));

            }
        });

        gaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GaaActivity.class));

            }
        });

        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BadmintonActivity.class));

            }
        });

       foot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FootballActivity.class));

            }
        });
// end part 2
//  start part 3
        tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PoolActivity.class));

            }
        });

        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Calendar.class));

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Profile.class));

            }
        });

        raffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Raffle.class));

            }
        });

//        end part 3


//    end
    }
}
