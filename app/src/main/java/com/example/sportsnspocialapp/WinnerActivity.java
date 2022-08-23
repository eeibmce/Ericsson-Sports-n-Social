package com.example.sportsnspocialapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
                    //Own Skill Calculation


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
                    int skillRatingOpponent = document.getLong("Skill Rating").intValue();
                    int skillRatingNewOpp = skillRatingOpponent + 30;

                    //Updating Firestore
                    DocumentReference user = db.collection("users").document(userID);
                    user.update("Skill Rating", skillRatingNewOpp).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            System.out.println("Updated");
                        }
                    });
                    //Own Skill Calculation


                }
            }
        });
    }
}