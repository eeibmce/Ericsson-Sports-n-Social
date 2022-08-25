package com.example.sportsnspocialapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WorkingTableTennis extends AppCompatActivity {

    Button back;
    private ImageButton button;
    private ImageButton button2;
    String tableTennisJoinClub;
    Button tableTennisJoin;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    boolean myTableTennisClubStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabletennis);

        back= findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HomePage.class));
            }
        });

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
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalendar();
            }
        });

        tableTennisJoin = (Button) findViewById(R.id.checkBoxTableTennis);
        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        tableTennisJoinClub = "Tabletennis Club";

        String UserEmail2 = fAuth.getCurrentUser().getEmail();
        fStore.collection("users")
                .whereEqualTo("email", UserEmail2)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {

                            fStore.collection("users").document(document.getId())
                                    .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                            if (task.isSuccessful()) {
                                                DocumentSnapshot document = task.getResult();
                                                if (document.exists()) {
                                                    String verifyGolfMember = document.getString(tableTennisJoinClub);

                                                    if (Objects.equals(verifyGolfMember, "Member")) {
                                                        myTableTennisClubStatus = true;
                                                        tableTennisJoin.setText("Leave");
                                                        tableTennisJoin.setBackgroundColor(0xFFFF0000);
                                                    } else {
                                                        myTableTennisClubStatus = false;
                                                        tableTennisJoin.setText("Join");
                                                        tableTennisJoin.setBackgroundColor(Color.parseColor("#249C4F"));
                                                    }



                                                    Log.d("[lolz]", "DocumentSnapshot data: " + document.getData());
                                                } else {
                                                    Log.d("[]", "No such document");
                                                }
                                            } else {
                                                Log.d("[]", "get failed with ", task.getException());
                                            }
                                        }
                                    });


                        }

                    } else {
                        Log.d("[]", "Error getting documents: ", task.getException());
                    }
                });


//
        tableTennisJoin.setOnClickListener(view -> {
            if (myTableTennisClubStatus == false) {
                myTableTennisClubStatus = true;
                tableTennisJoin.setText("Leave");
                tableTennisJoin.setBackgroundColor(0xFFFF0000);
                Toast.makeText(WorkingTableTennis.this, "You have joined this club!", Toast.LENGTH_LONG).show();
                String UserEmail = fAuth.getCurrentUser().getEmail();
                fStore.collection("users")
                        .whereEqualTo("email", UserEmail)
                        .get()
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    Map<String, Object> user = new HashMap<>();
                                    user.put("clubs", tableTennisJoinClub);
                                    fStore.collection("users").document(document.getId())
                                            .update(tableTennisJoinClub, "Member");
                                }
                            } else {
                                Log.d("[]", "Error getting documents: ", task.getException());
                            }
                        });
            }
            else {
                myTableTennisClubStatus = false;
                tableTennisJoin.setText("Join");
                tableTennisJoin.setBackgroundColor(Color.parseColor("#249C4F"));
                Toast.makeText(WorkingTableTennis.this, "You have left this club!", Toast.LENGTH_LONG).show();
                String UserEmail = fAuth.getCurrentUser().getEmail();
                fStore.collection("users")
                        .whereEqualTo("email", UserEmail)
                        .get()
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    Map<String, Object> user = new HashMap<>();
                                    user.put("clubs", tableTennisJoinClub);
                                    fStore.collection("users").document(document.getId())
                                            .update(tableTennisJoinClub, "Not a Member");
                                }
                            } else {
                                Log.d("[]", "Error getting documents: ", task.getException());
                            }
                        });
            }

        });


    }

    public void openChatPage() {
        Intent intent = new Intent(this, ChatPage.class);
        startActivity(intent);
        setContentView(R.layout.activity_chat_page);
    }

    public void openCalendar() {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
        setContentView(R.layout.activity_calendar);
    }

    public void browser(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://confluence-oss.seli.wh.rnd.internal.ericsson.com/display/SPSOAT/Squash+Club"));
        startActivity(browserIntent);

    }
}