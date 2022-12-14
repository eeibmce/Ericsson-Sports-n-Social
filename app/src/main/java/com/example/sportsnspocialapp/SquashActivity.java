package com.example.sportsnspocialapp;

import androidx.appcompat.app.AppCompatActivity;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;

public class SquashActivity extends AppCompatActivity {
    Button back;
    private ImageButton button;
    private ImageButton button2;
    String squashJoinClub;
    CheckBox squashJoin;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squash);

        back= findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HomePage.class));
            }
        });


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
        squashJoin = (CheckBox) findViewById(R.id.checkBox);
        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        squashJoinClub = "Member";
//
        squashJoin.setOnClickListener(view -> {
            Toast.makeText(SquashActivity.this, "You have joined this club!", Toast.LENGTH_LONG).show();
            String UserEmail = fAuth.getCurrentUser().getEmail();
            fStore.collection("users")
                    .whereEqualTo("email", UserEmail)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Map<String, Object> user = new HashMap<>();
                                user.put("Squash Club", squashJoinClub);
                                fStore.collection("users").document(document.getId())
                                        .update("Squash Club", "Member");
                            }
                        } else {
                            Log.d("[]", "Error getting documents: ", task.getException());
                        }
                    });
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