package com.example.sportsnspocialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ClubFoundationPage extends AppCompatActivity {
    private ImageButton button;
    private ImageButton button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_foundation_page);
        System.out.println("We are in onCreate in Main Activity");
        button = (ImageButton) findViewById(R.id.imageButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChat_page();
            }
        });

        button2 = (ImageButton) findViewById(R.id.imageButton);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ openCalendar();}
        });
    }

    public void openChat_page(){
        Intent intent = new Intent(this, Chat_page.class);
        startActivity(intent);
        setContentView(R.layout.activity_chat_page);
    }
    public void openCalendar(){
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
        setContentView(R.layout.activity_calendar);
    }
    public void browser(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/egsathlone/home"));
        startActivity(browserIntent);
    }

    //
}