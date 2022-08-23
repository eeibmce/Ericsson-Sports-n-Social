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

    Button enterRaffle = (Button) findViewById(R.id.enterButton);
    TextView tv = (TextView) findViewById(R.id.textView7);
    Button reset = (Button) findViewById(R.id.resetButton);
    Button run = (Button) findViewById(R.id.runButton);
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raffle);


    }

    public void addNameToArray(View view){
        raffleNames.add(tv.getText());
        tv.setText("");
//        For this method I want to take what is in the text box and put it in an array
//        and clear the text box once it has been entered
    }
    public void reset(View view){
        raffleNames.clear();
//        For this method I want to completely reset the raffle so a new one can be done
    }
    public void run(View view)
    {
        //For this method I want it to run the raffle
        //and randomly select a name from the array of the names of people who have entered
        Random random = new Random();
        int index = random.nextInt(raffleNames.size());
        System.out.println(raffleNames.get(index));
        displayToast();

    }
    public void displayToast() {
        Toast.makeText(Raffle.this, "Congratulations " + raffleNames.get(index), Toast.LENGTH_LONG);
    }

}