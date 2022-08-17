package com.example.sportsnspocialapp;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle; 
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
//import androidx.navigation.fragment.findNavController;


public class ClubFoundationPage extends AppCompatActivity {

    private ImageButton button;
    private ImageButton button2;

    //ImageButton btnAdd = (ImageButton)findViewById(R.id.imageButton2);
 

//    //Variables
//    Animation topAnim, bottomAnim;
//    ImageView imageView3;
//    TextView textView, textView2;
 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_foundation_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_club_foundation_page);

//        //Animations
//        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
//        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
//
//        //Hooks
//        imageView3 = findViewById(R.id.imageView3);
//        textView = findViewById(R.id.textView);
//        textView2 = findViewById(R.id.textView2);
//
//        imageView3.setAnimation(topAnim);
//        textView.setAnimation(bottomAnim);
//        textView2.setAnimation(bottomAnim);

        setContentView(R.layout.fragment_home);

//        Button contact = (Button) findViewById(R.id.button);
//        String linkText = "<a href='https://www.ericsson.com/en/contact'>Contact Us</a>";
//        contact.setText(Html.fromHtml(linkText));
//        contact.setMovementMethod(LinkMovementMethod.getInstance());
//

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

    public void openPoolActivity(){
        Intent intent = new Intent(this, PoolActivity.class);
        startActivity(intent);
    }
    public void openGolfActivity(){
        Intent intent = new Intent(this, GolfActivity.class);
        startActivity(intent);
    }

    public void openFootballActivity(){
        Intent intent = new Intent(this, FootballActivity.class);
        startActivity(intent);
    }

    public void openBasketballActivity(){
        Intent intent = new Intent(this, BasketballActivity.class);
        startActivity(intent);
    }

//    public void browser(View view){
//            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ericsson.com/en/contact"));
//            startActivity(browserIntent);
//
//
//
//        setContentView(R.layout.activity_club_foundation_page);
//        System.out.println("We are in onCreate in Main Activity");
//        button = (ImageButton) findViewById(R.id.imageButton2);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openChat_page();
//            }
//        });
//
//        button2 = (ImageButton) findViewById(R.id.imageButton);
//        button2.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){ openCalendar();}
//        });
//    }

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
