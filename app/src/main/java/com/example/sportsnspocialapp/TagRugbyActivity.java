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

public class TagRugbyActivity extends AppCompatActivity {
    Button back;
    private ImageButton button;
    private ImageButton button2;
    String tagRugbyJoinClub;
    Button tagRugbyJoin;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    boolean myTagRugbyClubStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_rugby);

        back = findViewById(R.id.back);


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
        tagRugbyJoin = (Button) findViewById(R.id.checkBoxTagRugby);
        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        tagRugbyJoinClub = "Member";
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
                                                    String verifyTagRugbyMember = document.getString("Tag Rugby Club");

                                                    if (Objects.equals(verifyTagRugbyMember, "Member")) {
                                                        myTagRugbyClubStatus = true;
                                                        tagRugbyJoin.setText("Leave");
                                                        tagRugbyJoin.setBackgroundColor(0xFFFF0000);
                                                    } else {
                                                        myTagRugbyClubStatus = false;
                                                        tagRugbyJoin.setText("Join");
                                                        tagRugbyJoin.setBackgroundColor(Color.parseColor("#249C4F"));
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

        tagRugbyJoin.setOnClickListener(view -> {
            if (myTagRugbyClubStatus == false) {
                myTagRugbyClubStatus = true;
                tagRugbyJoin.setText("Leave");
                tagRugbyJoin.setBackgroundColor(0xFFFF0000);
                Toast.makeText(TagRugbyActivity.this, "You have joined this club!", Toast.LENGTH_LONG).show();
                String UserEmail = fAuth.getCurrentUser().getEmail();
                fStore.collection("users")
                        .whereEqualTo("email", UserEmail)
                        .get()
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    Map<String, Object> user = new HashMap<>();
                                    user.put("clubs", tagRugbyJoinClub);
                                    fStore.collection("users").document(document.getId())
                                            .update("Tag Rugby Club", "Member");
                                }
                            } else {
                                Log.d("[]", "Error getting documents: ", task.getException());
                            }
                        });
            }
            else {
                myTagRugbyClubStatus = false;
                tagRugbyJoin.setText("Join");
                tagRugbyJoin.setBackgroundColor(Color.parseColor("#249C4F"));
                Toast.makeText(TagRugbyActivity.this, "You have left this club!", Toast.LENGTH_LONG).show();
                String UserEmail = fAuth.getCurrentUser().getEmail();
                fStore.collection("users")
                        .whereEqualTo("email", UserEmail)
                        .get()
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    Map<String, Object> user = new HashMap<>();
                                    user.put("clubs", tagRugbyJoinClub);
                                    fStore.collection("users").document(document.getId())
                                            .update("Tag Rugby Club", "Not a Member");
                                }
                            } else {
                                Log.d("[]", "Error getting documents: ", task.getException());
                            }
                        });
            }

        });
    }

    public void openChatPage() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/login/"));
        startActivity(browserIntent);
    }

    public void openCalendar() {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }

    public void browser(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/EricTagRugby"));
        startActivity(browserIntent);
    }

}