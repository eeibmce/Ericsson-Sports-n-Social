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

public class TagRugbyActivity extends AppCompatActivity {
    Button back;
    private ImageButton button;
    private ImageButton button2;
    String tagRugbyJoinClub;
    CheckBox tagRugbyJoin;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_rugby);

        back = findViewById(R.id.back);
//

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
        tagRugbyJoin = (CheckBox) findViewById(R.id.checkBox);
        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        tagRugbyJoinClub = "Member";
//
        tagRugbyJoin.setOnClickListener(view -> {
            Toast.makeText(TagRugbyActivity.this, "You have joined this club!", Toast.LENGTH_LONG).show();
            String UserEmail = fAuth.getCurrentUser().getEmail();
            fStore.collection("users")
                    .whereEqualTo("email", UserEmail)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Map<String, Object> user = new HashMap<>();
                                user.put("Tag Rugby Club", tagRugbyJoinClub);
                                fStore.collection("users").document(document.getId())
                                        .update("Tag Rugby Club", "Member");
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
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/EricTagRugby"));
        startActivity(browserIntent);

    }

}