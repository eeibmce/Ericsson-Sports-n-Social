package com.example.sportsnspocialapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class MyClubs extends AppCompatActivity {

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    TextView mGolfMember, mBadmintonMember, mTagRugbyMember, mSoccerMember, mGAAMember, mSquashMember, mTableTennisMember;
    Button backToIt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_clubs);

        mGAAMember = findViewById(R.id.GAAMember);
        mBadmintonMember = findViewById(R.id.BadmintonMember);
        mGolfMember = findViewById(R.id.GolfMember);
        mTableTennisMember = findViewById(R.id.TableTennisMember);
        mSoccerMember = findViewById(R.id.SoccerMember);
        mSquashMember = findViewById(R.id.SquashMember);
        mTagRugbyMember = findViewById(R.id.TagRugbyMember);
        backToIt = findViewById(R.id.backToIt);

        backToIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
            }
        });

        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

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
                                                DocumentSnapshot value1 = task.getResult();
                                                if (document.exists()) {
                                                    Log.d("", "DocumentSnapshot data: " + document.getData());
                                                    mGAAMember.setText(value1.getString("GAA Club"));
                                                    mGolfMember.setText(value1.getString("Golf Club"));
                                                    mBadmintonMember.setText(value1.getString("Badminton Club"));
                                                    mTableTennisMember.setText(value1.getString("Tabletennis Club"));
                                                    mSoccerMember.setText(value1.getString("Soccer Club"));
                                                    mSquashMember.setText(value1.getString("Squash Club"));
                                                    mTagRugbyMember.setText(value1.getString("Tag Rugby Club"));
                                                } else {
                                                    Log.d("", "No such document");
                                                }
                                            } else {
                                                Log.d("", "get failed with ", task.getException());
                                            }
                                        }
                                    });
                        }
                    } else {
                        Log.d("[/]", "Error getting documents: ", task.getException());
                    }
                });

        String UserEmail = fAuth.getCurrentUser().getEmail();
        fStore.collection("users")
                .whereEqualTo("email", UserEmail)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            fStore.collection("users").document(document.getId())
                                    .addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                                            mGAAMember.setText(value.getString("GAA Club"));
                                            mGolfMember.setText(value.getString("Golf Club"));
                                            mBadmintonMember.setText(value.getString("Badminton Club"));
                                            mTableTennisMember.setText(value.getString("Tabletennis Club"));
                                            mSoccerMember.setText(value.getString("Soccer Club"));
                                            mSquashMember.setText(value.getString("Squash Club"));
                                            mTagRugbyMember.setText(value.getString("Tag Rugby Club"));
                                        }
                                    });
                        }
                    } else {
                        Log.d("[/]", "Error getting documents: ", task.getException());
                    }
                });



    }
}