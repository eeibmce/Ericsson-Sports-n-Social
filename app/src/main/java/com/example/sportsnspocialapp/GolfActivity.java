package com.example.sportsnspocialapp;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class GolfActivity extends AppCompatActivity {
    String golfJoinClub;
    Button golfJoin;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    private ImageButton button;
    private ImageButton button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golf);
        System.out.println("We are in onCreate in Main Activity");
        TextView scrollingTool = findViewById(R.id.editTextTextMultiLine5);
        scrollingTool.setMovementMethod(new ScrollingMovementMethod());

        button = (ImageButton) findViewById(R.id.imageButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChatPage();
            }
        });
        button2 = (ImageButton) findViewById(R.id.imageButton3);
        button2.setOnClickListener(view -> openCalendar());

        golfJoin = (Button) findViewById(R.id.checkBox);
        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        golfJoinClub = "Golf Club";
//
        golfJoin.setOnClickListener(view -> {
            Toast.makeText(GolfActivity.this, "You have joined this club!", Toast.LENGTH_LONG).show();
            String UserEmail = fAuth.getCurrentUser().getEmail();

            fStore.collection("users")
                    .whereEqualTo("email", UserEmail)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Map<String, Object> user = new HashMap<>();
                                user.put("clubs", golfJoinClub);

                                fStore.collection("users").document(document.getId())
                                        .set(user, SetOptions.merge());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    });

//                DocumentReference documentReference = fStore.collection("userClubs").document(userID);
//                Map<String,Object> userClubs = new HashMap<>();
//
//                userClubs.put("clubs", golfJoinClub);
//
//                documentReference.set(userClubs).addOnSuccessListener((OnSuccessListener) (aVoid) -> {
//                    Log.d("[]", "onSuccess: user Profile is created for " + userID);
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d("[]", "onFailure: " + e);
//                    }
//                });

//                fStore.collection("userClubs").document(userID)
//                        .set(userClubs)
//                        .addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                Log.d("[Success]", "DocumentSnapshot successfully written!");
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Log.w("[Error]", "Error writing document", e);
//                            }
//                        });


        });


    }

    public void openChatPage() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/login/"));
        startActivity(browserIntent);
    }

    public void openCalendar() {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
        setContentView(R.layout.activity_calendar);
    }

    public void browser(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/egsathlone/home"));
        startActivity(browserIntent);

    }

}



