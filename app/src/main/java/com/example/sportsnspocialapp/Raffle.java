package com.example.sportsnspocialapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Raffle extends AppCompatActivity {

    List raffleNames = new ArrayList();


    Button enterRaffle;
    TextView tv;
    Button reset;
    Button run;

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raffle);
        enterRaffle =  findViewById(R.id.enterButton);
        tv = findViewById(R.id.textView7);
        reset = findViewById(R.id.resetButton);
        run = findViewById(R.id.runButton);

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
//                displayToast();
            }
        });




    }
//    public  void displayToast() {
//        System.out.println(raffleNames);
//        System.out.println(raffleNames.get(index));
//        Toast.makeText(Raffle.this, "Congratulations " + raffleNames.get(index), Toast.LENGTH_LONG).show();
//
//
//    }
}

