package com.example.sportsnspocialapp;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    Button oponentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        oponentButton = findViewById(R.id.buttonOther);

        Button btnAddUserWin = findViewById(R.id.buttonMe);

        btnAddUserWin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ResultActivity.this, WinnerActivity.class);

                //Carrying inputCode variable

                String userID = getIntent().getStringExtra("userID");
                intent.putExtra("userID", userID);

                String inputCode = getIntent().getStringExtra("inputID");

                intent.putExtra("inputID", inputCode);
                startActivity(intent);
            }
        });

        Button btnAddUserLose = findViewById(R.id.buttonOther);

        btnAddUserLose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ResultActivity.this, LoseActivity.class);
                String inputCode = getIntent().getStringExtra("inputID");

                intent.putExtra("inputID", inputCode);

                startActivity(intent);
            }
        });


        String opponentName = getIntent().getStringExtra("OpponentName");
        System.out.println(opponentName);
        oponentButton.setText(opponentName);




    }






}
