package com.example.sportsnspocialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle; 
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import androidx.navigation.fragment.findNavController;


public class MainActivity extends AppCompatActivity {
    //ImageButton btnAdd = (ImageButton)findViewById(R.id.imageButton2);
 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.fragment_home);



        ImageButton button = (ImageButton) findViewById(R.id.imageButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChat_page();
            }
        });


//        Button contact = (Button) findViewById(R.id.button);
//        String linkText = "<a href='https://www.ericsson.com/en/contact'>Contact Us</a>";
//        contact.setText(Html.fromHtml(linkText));
//        contact.setMovementMethod(LinkMovementMethod.getInstance());
//



        ImageButton btnAddFootball = (ImageButton)findViewById(R.id.imageButtonFootball);

        btnAddFootball.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openFootballActivity();
            }
        });

        ImageButton btnAddGolf = (ImageButton)findViewById(R.id.imageButton2);

        btnAddGolf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openGolfActivity();
            }
        });

        ImageButton btnAddBasketball = (ImageButton)findViewById(R.id.imageButtonBasketball);

        btnAddBasketball.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openBasketballActivity();
            }
        });
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



    public void openChat_page(){
        Intent intent = new Intent(this, Chat_page.class);
        startActivity(intent);
        setContentView(R.layout.activity_chat_page);
    }
    public void browser(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/egsathlone/home"));
        startActivity(browserIntent);
    }

} 
