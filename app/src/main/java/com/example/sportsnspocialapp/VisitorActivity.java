package com.example.sportsnspocialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class VisitorActivity extends AppCompatActivity {

    boolean myIDDisplayed = false;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor);

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String myID = currentFirebaseUser.getUid();


        EditText editTextCode = (EditText) findViewById(R.id.editTextInvite);

        Button btnAddInvite = (Button) findViewById(R.id.buttonShare);

        btnAddInvite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                openInviteActivity();
            }
        });

        Button btnID = (Button) findViewById(R.id.buttonID);

        btnID.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {



                btnID.setText("Show ID");

                if (myIDDisplayed == true) {
                    myIDDisplayed = false;
                    btnID.setText("Show ID");
                } else {
                    myIDDisplayed = true;
                    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                    String myID = currentFirebaseUser.getUid();
                    btnID.setText(myID);
                }


            }
        });

        Button btnReturn = findViewById(R.id.buttonLeave);

        btnReturn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                String myID = currentFirebaseUser.getUid();
                DocumentReference user = db.collection("users").document(myID);
                user.update("In Game", "false").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        System.out.println("Updated");

                        Intent leave = new Intent(VisitorActivity.this, PoolActivity.class);
                        startActivity(leave);
                        //Skill Rating Text
                    }
                });

            }

    });


        //Displaying Name on top of screen
        TextView txtName = findViewById(R.id.textViewNameVisitor);
        String userID = getIntent().getStringExtra("userName");


        db.collection("users").document(myID).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    String myName = document.getString("fName");
                    System.out.println(myName);
                    txtName.setText(myName);

                }
            }
        });



    }

    public void openInviteActivity() {
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String myID = currentFirebaseUser.getUid();

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        String shareBody = myID;
        String shareSub = "My Ericsson Pool ID";
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(shareIntent, "Share Using"));
    }



    @Override
    public void onBackPressed() {

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String myID = currentFirebaseUser.getUid();
        DocumentReference user = db.collection("users").document(myID);
        user.update("In Game", "false").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                System.out.println("Updated");

                Intent leave = new Intent(VisitorActivity.this, PoolActivity.class);
                startActivity(leave);
                //Skill Rating Text
            }
        });

        Intent leave = new Intent(VisitorActivity.this, PoolActivity.class);
        // Do Here what ever you want do on back press;
    }
}