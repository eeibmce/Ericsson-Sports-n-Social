package com.example.sportsnspocialapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class WinnerActivity extends AppCompatActivity {

    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Intent sentID = getIntent();
        String opponentID = sentID.getStringExtra("inputID");
        System.out.println(opponentID);

        //Opponent Skill Calculation
        db.collection("users").document(opponentID).get().addOnCompleteListener(task -> {

            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    //                        inputCode = editTextCode.getText().toString();
                    System.out.println("******** 4 " + opponentID);
//                    userV.setOponentID(opponentID);
//                    System.out.println(userV.getOponentID());


                    //Reading opponent Skill Rating in database
                    int skillRatingOpponent = document.getLong("Skill Rating").intValue();
                    int skillRatingNewOpp = skillRatingOpponent - 30;

                    //Updating Firestore
                    DocumentReference userOpp = db.collection("users").document(opponentID);
                    userOpp.update("Skill Rating", skillRatingNewOpp).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            System.out.println("Updated");
                        }
                    });



                }
            }
        });


        //User's Skill Rating
//        userID = fAuth.getCurrentUser().getUid();

//        String userID = getIntent().getStringExtra("userID");

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String userID = currentFirebaseUser.getUid().toString();

        db.collection("users").document(userID).get().addOnCompleteListener(task -> {

            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    //                        inputCode = editTextCode.getText().toString();
                    System.out.println("******** 15 " + userID);
//                    userV.setOponentID(opponentID);
//                    System.out.println(userV.getOponentID());


                    //Reading opponent Skill Rating in database
                    int skillRatingUser = document.getLong("Skill Rating").intValue();
                    int skillRatingNewUser = skillRatingUser + 30;

                    //Updating Firestore
                    DocumentReference user = db.collection("users").document(userID);
                    user.update("Skill Rating", skillRatingNewUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            System.out.println("Updated");
                            //Skill Rating Text
                        }
                    });

                    System.out.println(skillRatingNewUser);

                    TextView textSkill = findViewById(R.id.textViewSkillUser);
                    textSkill.setText(String.valueOf(skillRatingNewUser));


                    //Fade Animation
                    TextView textView30 = findViewById(R.id.textView30);

                    Animation fadeOut = new AlphaAnimation(1, 0);
                    fadeOut.setInterpolator(new AccelerateInterpolator());
                    fadeOut.setStartOffset(500);
                    fadeOut.setDuration(1800);

                    textView30.setAnimation(fadeOut);


                    //Button to Finish
                    Button buttonFinish = findViewById(R.id.buttonFinish);

                    buttonFinish.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(WinnerActivity.this, PoolActivity.class);
                            startActivity(intent);
                        }
                    });


                }

            }

        });

    }
    //Makes the back button non functional
    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }
}