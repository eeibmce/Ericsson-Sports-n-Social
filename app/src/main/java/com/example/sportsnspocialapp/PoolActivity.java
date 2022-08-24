package com.example.sportsnspocialapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.example.sportsnspocialapp.UserVariables;
import java.util.Map;
import java.util.Objects;

public class PoolActivity extends AppCompatActivity {
    boolean myIDDisplayed = false;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool);



        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String myID = currentFirebaseUser.getUid();



        Button btnAddHost = (Button) findViewById(R.id.buttonPlay);


        btnAddHost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                String code = editTextCode.getText().toString();
//                System.out.println(code);
                UserVariables userV = new UserVariables();

                openSearchActivity();
            }
        });


        //JoinGame Button
        Button btnAddJoinHost = (Button) findViewById(R.id.buttonJoinHost);


        btnAddJoinHost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                String myID = currentFirebaseUser.getUid();
                DocumentReference user = db.collection("users").document(myID);
                user.update("In Game", "true").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        System.out.println("Updated");
                        Intent visitor = new Intent(PoolActivity.this, VisitorActivity.class);
                        startActivity(visitor);
                        //Skill Rating Text
                    }
                });

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

    public void openSearchActivity() {
        EditText editTextCode = findViewById(R.id.editTextInvite);
        System.out.println("******** 1 " + editTextCode.getText().toString());
        String inputCode = editTextCode.getText().toString();
        System.out.println("******** 2 " + editTextCode.getText().toString());
        System.out.println("******** 3 " + inputCode);
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String myID = currentFirebaseUser.getUid().toString();
        if (inputCode.equals(myID))
        {
            //            Toast.makeText(this, "Can't use your own ID", Toast.LENGTH_SHORT).show();
            editTextCode.setError("Can't use your own ID");
        }
        else {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("users").document(inputCode).get().addOnCompleteListener(task -> {

                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        String inGame = document.getString("In Game");

                        System.out.println(inGame);

                        if(Objects.equals(inGame, "true")){


                        UserVariables userV = new UserVariables();
    //                        inputCode = editTextCode.getText().toString();
                        System.out.println("******** 4 " + inputCode);
                            userV.setOponentID(inputCode);
                        System.out.println(userV.getOponentID());


                        //Reading field in database
                        String opponentName = document.getString("fName");



                        //Sending to another class



                        Intent result = new Intent(this, GameActivity.class);
                        String userID = getIntent().getStringExtra("userID");
                        result.putExtra("userID", userID);
                        result.putExtra("OpponentName", opponentName);
                        result.putExtra("inputID", inputCode);
                        startActivity(result);
                        }

                        else {
                            editTextCode.setError("Tell Other User to Click Join Button");
                        }

                    }
                    else {
                        editTextCode.setError("Invalid name");
                    }
                }
            });
        }
    }
}


//        db.collection("users")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d(TAG, document.getId() + " => " + document.getData());
//
//                                String name = document.getData().toString();
//
//                                System.out.println(name);
//                                if (code == document.getId()) {
//                                    System.out.println("Good");
//                                }
//                                else {
//                                    System.out.println("Not in Database");
//                                }

//                        } else {
//                            Log.w(TAG, "Error getting documents.", task.getException());
//                        }



//    Switch onlineSwitch = (Switch) findViewById(R.id.switchOnline);


//    Switch switchOnline = (Switch) findViewById(R.id.switchOnline); // initiate Switch
//
//switchOnline.setTextOn("On"); // displayed text of the Switch whenever it is in checked or on state
//switchOnline.setTextOff("Off");


// Variable text

//        public void onClick(View v) {
//            TextView myAwesomeTextView = (TextView)findViewById(R.id.textView4);
//            Boolean switchState = onlineSwitch.isChecked();
//            if (switchState) {
//                myAwesomeTextView.append("My Awesome Text");
//            }
//            else if(!switchState){
//                myAwesomeTextView.append("");
//            }
//            myAwesomeTextView.append("My Awesome Text");
//        }



