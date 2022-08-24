package com.example.sportsnspocialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

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