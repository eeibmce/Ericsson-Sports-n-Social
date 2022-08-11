package com.example.sportsnspocialapp;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

//    //Variables
//    Animation topAnim, bottomAnim;
//    ImageView imageView3;
//    TextView textView, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

//        //Animations
//        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
//        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
//
//        //Hooks
//        imageView3 = findViewById(R.id.imageView3);
//        textView = findViewById(R.id.textView);
//        textView2 = findViewById(R.id.textView2);
//
//        imageView3.setAnimation(topAnim);
//        textView.setAnimation(bottomAnim);
//        textView2.setAnimation(bottomAnim);

    }
}