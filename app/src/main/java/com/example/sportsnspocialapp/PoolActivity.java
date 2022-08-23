package com.example.sportsnspocialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PoolActivity extends AppCompatActivity  {
    boolean myIDDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool);

        EditText editTextCode = (EditText) findViewById(R.id.editTextInvite);

        Button btnAddInvite = (Button) findViewById(R.id.buttonShare);

        btnAddInvite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                openInviteActivity();
            }
        });

        Button btnID = (Button) findViewById(R.id.buttonID);

        btnID.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                btnID.setText("Show ID");

                if (myIDDisplayed == true) {
                    myIDDisplayed = false;
                    btnID.setText("Show ID");
                } else {
                    myIDDisplayed = true;
                    btnID.setText("My ID");
                }


            }
        });

        Button btnAddPlay = (Button) findViewById(R.id.buttonPlay);

        btnAddPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(PoolActivity.this, "Clickfghfghff", Toast.LENGTH_LONG).show();
                System.out.println("hfghfghfghfhf");
            }
        });


   }

    public void openInviteActivity(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        String shareBody = "Your Body here";
        String shareSub = "Your subject here";
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
        shareIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
        startActivity(Intent.createChooser(shareIntent, "Share Using"));
    }


//    Switch onlineSwitch = (Switch) findViewById(R.id.switchOnline);


//    Switch switchOnline = (Switch) findViewById(R.id.switchOnline); // initiate Switch
//
//switchOnline.setTextOn("On"); // displayed text of the Switch whenever it is in checked or on state
//switchOnline.setTextOff("Off");


    // Variable text

//        public void onClick(View v) {
//            TextView myAwesomeTextView = (TextView)findViewById(R.id.textView4);
//            Boolean switchState = onlineSwitch.isChecked();
//            if (switchState) {
//                myAwesomeTextView.append("My Awesome Text");
//            }
//            else if(!switchState){
//                myAwesomeTextView.append("");
//            }
//            myAwesomeTextView.append("My Awesome Text");
//        }
    }


